package com.gathin.tvhome;
import android.content.*;
import android.content.res.AssetFileDescriptor;
import android.graphics.*;
import android.media.MediaPlayer;
import android.view.*;
import android.widget.*;
import org.json.*;
import java.io.*;
import java.util.*;

/** Local backgrounds only: no wake locks, services, receivers or network. */
final class ChallengerBackdrop {
    static final String PREFS="challenger_background", KEY="mode";
    static final String[] MODES={"video3","flow","static"};
    static final String[] LABELS={"Opción 3 · placa electrónica","Digital y microchips · corriente suave","Digital y microchips · imagen estática"};
    final Context context;final FrameLayout layer;final ImageView image;final String mode;
    SurfaceView surface;MediaPlayer player;CurrentView current;Bitmap bitmap;boolean active,closed;
    ChallengerBackdrop(Context context,FrameLayout root,Config config){
        this.context=context;mode=context.getSharedPreferences(PREFS,0).getString(KEY,"video3");
        layer=new FrameLayout(context);layer.setFocusable(false);layer.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);root.addView(layer,0,new FrameLayout.LayoutParams(-1,-1));
        image=new ImageView(context);image.setScaleType(ImageView.ScaleType.CENTER_CROP);layer.addView(image,new FrameLayout.LayoutParams(-1,-1));loadImage();
        if(mode.equals("video3")){
            surface=new SurfaceView(context);layer.addView(surface,0,new FrameLayout.LayoutParams(-1,-1));surface.getHolder().addCallback(new SurfaceHolder.Callback(){
                public void surfaceCreated(SurfaceHolder h){play();}public void surfaceChanged(SurfaceHolder h,int f,int w,int height){}public void surfaceDestroyed(SurfaceHolder h){release();}
            });
        }else if(mode.equals("flow")){current=new CurrentView(context);layer.addView(current,new FrameLayout.LayoutParams(-1,-1));}
        View dim=new View(context);dim.setBackgroundColor(0x4D000000);layer.addView(dim,new FrameLayout.LayoutParams(-1,-1));
    }
    private void loadImage(){if(bitmap!=null)return;try(InputStream in=context.getAssets().open(mode.equals("video3")?"video3-poster.jpg":"digital.png")){bitmap=BitmapFactory.decodeStream(in);image.setImageBitmap(bitmap);}catch(IOException ignored){layer.setBackgroundColor(0xFF071421);}}
    private void play(){
        if(!active||closed||player!=null||surface==null||!surface.getHolder().getSurface().isValid())return;
        try(AssetFileDescriptor fd=context.getAssets().openFd("video3.mp4")){
            player=new MediaPlayer();player.setDataSource(fd.getFileDescriptor(),fd.getStartOffset(),fd.getLength());player.setDisplay(surface.getHolder());
            player.setOnPreparedListener(mp->{if(!active||closed){release();return;}mp.setLooping(true);mp.setVolume(0,0);mp.start();image.setVisibility(View.GONE);});
            player.setOnErrorListener((mp,what,extra)->{release();image.setVisibility(View.VISIBLE);return true;});player.prepareAsync();
        }catch(IOException|RuntimeException ex){release();image.setVisibility(View.VISIBLE);}
    }
    private void release(){if(player!=null){player.setOnPreparedListener(null);player.setOnErrorListener(null);player.release();player=null;}}
    void start(){if(closed)return;active=true;loadImage();if(current!=null)current.setActive(true);play();}
    void stop(){active=false;release();image.setVisibility(View.VISIBLE);if(current!=null)current.setActive(false);}
    void update(){}
    void close(){stop();closed=true;image.setImageDrawable(null);bitmap=null;}
    void releaseForMemoryPressure(){if(!active){image.setImageDrawable(null);bitmap=null;}}
    static String label(Context c){String selected=c.getSharedPreferences(PREFS,0).getString(KEY,"video3");for(int i=0;i<MODES.length;i++)if(MODES[i].equals(selected))return LABELS[i];return LABELS[0];}
    static void choose(android.app.Activity activity,Runnable changed){String selected=activity.getSharedPreferences(PREFS,0).getString(KEY,"video3");int checked=0;for(int i=0;i<MODES.length;i++)if(MODES[i].equals(selected))checked=i;new android.app.AlertDialog.Builder(activity).setTitle("Fondo de inicio").setSingleChoiceItems(LABELS,checked,(dialog,which)->{activity.getSharedPreferences(PREFS,0).edit().putString(KEY,MODES[which]).apply();dialog.dismiss();changed.run();}).setNegativeButton(android.R.string.cancel,null).show();}
    private static final class CurrentView extends View {
        final Paint paint=new Paint(3);final ArrayList<PathMeasure> paths=new ArrayList<>();final float[] point=new float[2];boolean active;
        final Runnable tick=()->{if(active){invalidate();schedule();}};
        CurrentView(Context c){super(c);setFocusable(false);try(InputStream in=c.getAssets().open("tracks.json")){ByteArrayOutputStream b=new ByteArrayOutputStream();byte[] buffer=new byte[4096];int n;while((n=in.read(buffer))>0)b.write(buffer,0,n);JSONArray all=new JSONArray(b.toString("UTF-8"));for(int i=0;i<all.length();i+=7){JSONArray points=all.getJSONArray(i);Path p=new Path();for(int j=0;j<points.length();j++){JSONArray xy=points.getJSONArray(j);float x=(float)xy.getDouble(0),y=(float)xy.getDouble(1);if(j==0)p.moveTo(x,y);else p.lineTo(x,y);}paths.add(new PathMeasure(p,false));}}catch(Exception ignored){paths.clear();}}
        void setActive(boolean value){active=value;removeCallbacks(tick);if(active){invalidate();schedule();}}void schedule(){postDelayed(tick,67);}
        @Override protected void onDraw(Canvas c){c.save();c.scale(getWidth()/1440f,getHeight()/810f);float seconds=android.os.SystemClock.elapsedRealtime()/1000f;for(int i=0;i<paths.size();i++){PathMeasure p=paths.get(i);float len=p.getLength();if(len<=0)continue;for(int tail=5;tail>=0;tail--){p.getPosTan(((seconds*45+i*23-tail*4)%len+len)%len,point,null);paint.setColor(Color.argb(210-tail*30,100,220,249));c.drawCircle(point[0],point[1],tail==0?3.4f:2.1f,paint);}}c.restore();}
    }
}
