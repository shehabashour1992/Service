package com.example.nh.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.IOException;

public class musicPlayerService extends Service{
    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player=new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            player.setDataSource("http://ms16.sm3na.com/137/Sm3na_com_47356.mp3");
            player.prepare();
            player.start();
            } catch (IOException e)
            {
            Toast.makeText(musicPlayerService.this, "cant play this song", Toast.LENGTH_LONG).show();
            }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }
}
