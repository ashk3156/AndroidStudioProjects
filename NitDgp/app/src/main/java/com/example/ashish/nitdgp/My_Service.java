package com.example.ashish.nitdgp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.widget.Toast;

public class My_Service extends Service {
    MediaPlayer sound;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        playAMediafile();
        return super.onStartCommand(intent, flags, startId);
    }*/
    public void playAMediafile(){
        //Toast.makeText((My_Service.this,"from service",Toast.LENGTH_SHORT).show();
        sound=MediaPlayer.create(My_Service.this,R.raw.s);
        //Toast.makeText((My_Service.this,"from service",Toast.LENGTH_SHORT).show();
    }


}
d