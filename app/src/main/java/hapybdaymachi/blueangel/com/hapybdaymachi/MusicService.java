package hapybdaymachi.blueangel.com.hapybdaymachi;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by Ashith VL on 12/20/2016.
 */

public class MusicService extends Service {
    MediaPlayer myPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myPlayer = MediaPlayer.create(this, R.raw.nap);
        myPlayer.setLooping(true); // Set looping
        myPlayer.setVolume(100, 100);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        String clas = intent.getStringExtra("clas");
        int song = intent.getIntExtra("position",-1);
        if(clas.equals("hapybdaymachi.blueangel.com.hapybdaymachi.SecondActivity")){
            myPlayer.start();
        }else{
            myPlayer = MediaPlayer.create(this, song);
            myPlayer.setLooping(false); // Set looping
            myPlayer.setVolume(100, 100);
            myPlayer.start();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        myPlayer.stop();
        myPlayer.release();
        myPlayer = null;
    }

}