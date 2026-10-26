"""Read-only performance snapshots plus app launches; raw evidence stays in private/."""
import argparse,datetime,json,re,statistics,subprocess,time
from pathlib import Path
APPS=[('YouTube','com.google.android.youtube.tv'),('Netflix','com.netflix.ninja'),('Xuper','com.android.mgstv'),('HBO Max','com.wbd.stream'),('YouTube Music','com.google.android.youtube.tvmusic'),('Prime Video','com.amazon.amazonvideo.livingroom')]
HOME='local.challenger.home'
def main():
 p=argparse.ArgumentParser();p.add_argument('--serial',required=True);p.add_argument('--adb',default='adb');p.add_argument('--out',default='private/mediciones-apps-'+datetime.datetime.now().strftime('%Y%m%d-%H%M%S'));a=p.parse_args();out=Path(a.out);out.mkdir(parents=True,exist_ok=False)
 base=[a.adb,'-s',a.serial];results=[]
 def sh(cmd):
  r=subprocess.run(base+['shell',cmd],capture_output=True,text=True,encoding='utf-8',errors='replace',timeout=60)
  if r.returncode:raise RuntimeError('ADB operation failed')
  return r.stdout
 def foreground():
  raw=sh('dumpsys activity activities')
  line=next((l for l in raw.splitlines() if 'mResumedActivity:' in l or 'topResumedActivity=' in l),'')
  m=re.search(r'\bu\d+\s+([\w.]+)/',line)
  return m.group(1) if m else None
 def home():
  start=time.monotonic();sh('input keyevent KEYCODE_HOME')
  for _ in range(35):
   if foreground()==HOME:return round(time.monotonic()-start,3)
   time.sleep(.2)
  raise RuntimeError('HOME no confirmado; no continuar ensayos')
 def snap():
  cpu=list(map(int,sh('cat /proc/stat').splitlines()[0].split()[1:9]));pids=sh('pidof '+HOME).split();ticks=None
  if pids:
   f=sh('cat /proc/'+pids[0]+'/stat').rsplit(')',1)[1].split();ticks=int(f[11])+int(f[12])
  return cpu,pids,ticks
 def metric(before,after):
  d=[y-x for x,y in zip(before[0],after[0])];total=sum(d)
  return {'device_cpu_pct':round(100*(total-d[3]-d[4])/total,2),'launcher_cpu_pct_all_cores':round(100*(after[2]-before[2])/total,3) if before[1]==after[1] and before[2] is not None and after[2] is not None else None}
 try:
  for label,pkg in APPS:
   component=sh('cmd package resolve-activity --brief -a android.intent.action.MAIN -c android.intent.category.LEANBACK_LAUNCHER -p '+pkg).strip().splitlines()[-1]
   if not re.fullmatch(r'[\w.]+/[\w.$]+',component):raise RuntimeError('No launch component for '+label)
   cold=sh('am start -W -S -n '+component);(out/(pkg+'-cold.txt')).write_text(cold,encoding='utf-8');time.sleep(10)
   samples=[]
   for _ in range(2):
    b=snap();time.sleep(5);samples.append(metric(b,snap()))
   fg=foreground();memory=sh('dumpsys meminfo '+pkg);(out/(pkg+'-memory.txt')).write_text(memory,encoding='utf-8');pss=sum(map(int,re.findall(r'TOTAL PSS:\s*(\d+)',memory))) or None
   media=sh('dumpsys media.player');(out/(pkg+'-media.txt')).write_text(media,encoding='utf-8');pid=sh('pidof '+HOME).split();home_video_active=bool(pid and re.search(r'pid\('+re.escape(pid[0])+r'\)',media))
   ret=home();time.sleep(1);warm=sh('am start -W -n '+component);(out/(pkg+'-warm.txt')).write_text(warm,encoding='utf-8');time.sleep(2);ret2=home()
   def value(raw,key):
    m=re.search(r'^'+key+r':\s*(.+)$',raw,re.M);return m.group(1).strip() if m else None
   result={'app':label,'cold_total_ms':value(cold,'TotalTime'),'cold_state':value(cold,'LaunchState'),'cold_status':value(cold,'Status'),'warm_total_ms':value(warm,'TotalTime'),'warm_state':value(warm,'LaunchState'),'device_cpu_median_pct':statistics.median(x['device_cpu_pct'] for x in samples),'launcher_background_cpu_max_pct':max((x['launcher_cpu_pct_all_cores'] for x in samples if x['launcher_cpu_pct_all_cores'] is not None),default=None),'pss_kib':pss,'app_foreground_confirmed':fg==pkg,'launcher_video_active_while_app_visible':home_video_active,'home_returns_seconds':[ret,ret2],'samples':samples}
   results.append(result);(out/'summary.json').write_text(json.dumps(results,ensure_ascii=False,indent=2),encoding='utf-8');print(json.dumps(result,ensure_ascii=False),flush=True)
 finally:
  sh('input keyevent KEYCODE_HOME')
if __name__=='__main__':main()
