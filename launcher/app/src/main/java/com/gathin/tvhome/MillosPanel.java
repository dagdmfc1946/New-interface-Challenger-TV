package com.gathin.tvhome;
import android.content.*;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.net.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.*;

/** Public agenda cache; no polling loop or permanent service. */
final class MillosPanel {
    static final String URL="https://clubmillonariosgc.datafactory.la/html/v3/htmlCenter/data/deportes/futbol/todos/pages/es/agenda.html";
    final TextView text;final SharedPreferences cache;final ExecutorService worker=Executors.newSingleThreadExecutor();
    boolean active,closed;volatile boolean loading;
    MillosPanel(Context context,FrameLayout root){cache=context.getSharedPreferences("millos_cache",0);float dp=context.getResources().getDisplayMetrics().density;
        LinearLayout panel=new LinearLayout(context);panel.setOrientation(LinearLayout.HORIZONTAL);panel.setGravity(Gravity.CENTER_VERTICAL);panel.setFocusable(false);panel.setPadding((int)(14*dp),(int)(8*dp),(int)(14*dp),(int)(8*dp));
        text=new TextView(context);text.setTextColor(Color.WHITE);text.setTextSize(14);text.setFocusable(false);text.setMaxLines(6);text.setShadowLayer(2*dp,0,dp,Color.BLACK);
        panel.addView(text,new LinearLayout.LayoutParams(0,-2,1));
        ImageView crest=new ImageView(context);crest.setImageResource(R.drawable.millonarios_crest);crest.setScaleType(ImageView.ScaleType.FIT_CENTER);crest.setFocusable(false);crest.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
        LinearLayout.LayoutParams logo=new LinearLayout.LayoutParams((int)(68*dp),(int)(68*dp));logo.leftMargin=(int)(4*dp);logo.rightMargin=(int)(16*dp);panel.addView(crest,logo);
        GradientDrawable bg=new GradientDrawable();bg.setColor(0xDF10273D);bg.setCornerRadius(12*dp);panel.setBackground(bg);
        FrameLayout.LayoutParams p=new FrameLayout.LayoutParams((int)(330*dp),(int)(86*dp),Gravity.TOP|Gravity.END);p.topMargin=(int)(96*dp);p.rightMargin=(int)(58*dp);root.addView(panel,p);render();}
    void start(){active=true;render();long last=cache.getLong("attempt",0),ttl=cache.getBoolean("ok",false)?6*3600000L:30*60000L;if(loading||System.currentTimeMillis()-last<ttl)return;loading=true;cache.edit().putLong("attempt",System.currentTimeMillis()).apply();worker.execute(()->{
        HttpURLConnection c=null;boolean ok=false;try{
            c=(HttpURLConnection)new java.net.URL(URL).openConnection();c.setConnectTimeout(8000);c.setReadTimeout(8000);c.setInstanceFollowRedirects(false);c.setRequestProperty("User-Agent","ChallengerHome/1.0");if(c.getResponseCode()!=200)throw new IOException("agenda unavailable");
            ByteArrayOutputStream bytes=new ByteArrayOutputStream();try(InputStream in=c.getInputStream()){byte[] buffer=new byte[8192];int n;while((n=in.read(buffer))!=-1){if(bytes.size()+n>1_000_000)throw new IOException("agenda too large");bytes.write(buffer,0,n);}}
            MillosFixtureParser.Fixture f=MillosFixtureParser.next(bytes.toString("UTF-8"),Instant.now());if(f!=null){cache.edit().putString("match",f.home+" vs. "+f.away).putString("competition",f.competition).putLong("kickoff",f.kickoff.toEpochMilli()).putLong("updated",System.currentTimeMillis()).apply();ok=true;}
        }catch(IOException|RuntimeException ignored){/* keep cache, show update status */}finally{if(c!=null)c.disconnect();cache.edit().putBoolean("ok",ok).apply();loading=false;text.post(()->{if(active&&!closed)render();});}
    });}
    void render(){long time=cache.getLong("kickoff",0);String body="MILLONARIOS FC\nPróximo partido\nProgramación por confirmar";if(time>System.currentTimeMillis()){String date=DateTimeFormatter.ofPattern("EEE d MMM · HH:mm",new Locale("es","CO")).withZone(ZoneId.of("America/Bogota")).format(Instant.ofEpochMilli(time));body="MILLONARIOS FC\n"+cache.getString("match","")+"\n"+date+" · COL\n"+cache.getString("competition","")+" · "+(cache.getBoolean("ok",false)?"Agenda del club":"Dato guardado; sin actualizar");SpannableString styled=new SpannableString(body);styled.setSpan(new RelativeSizeSpan(0.74f),body.lastIndexOf('\n')+1,body.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);styled.setSpan(new ForegroundColorSpan(0xFFCBD9E6),body.lastIndexOf('\n')+1,body.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);text.setText(styled);}else text.setText(body);}
    void stop(){active=false;}void close(){active=false;closed=true;worker.shutdownNow();}
}
