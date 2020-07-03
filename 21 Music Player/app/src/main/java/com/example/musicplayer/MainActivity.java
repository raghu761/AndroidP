package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    ConstraintLayout layout;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer=MediaPlayer.create(this,R.raw.testaudio);

        radioGroup=findViewById(R.id.radiogroup);
        layout=findViewById(R.id.layout);

        //get the context from the audio manager and set the max and min value
        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int myMaxVolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int myCurrentVolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


        //set the seek bar for the volume button

        SeekBar seekBar=findViewById(R.id.seekBar);
        seekBar.setMax(myMaxVolume);
        seekBar.setProgress(myCurrentVolume);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar seekBar1=findViewById(R.id.seekBar2);
        seekBar1.setMax(mediaPlayer.getDuration());

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar1.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 000,500);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.daymode:
                        layout.setBackgroundColor(Color.parseColor("#2B2B52"));
                        break;

                    case R.id.nightmode:
                        layout.setBackgroundColor(Color.parseColor("#586776"));
                        break;

                    case R.id.defaultmode:
                        layout.setBackgroundColor(Color.parseColor("#74B9FF"));
                }
            }
        });

    }


    public void myplay(View view)
    {
            mediaPlayer.start();
    }

    public void  mypause(View view)
    {
        mediaPlayer.pause();
    }



}
