package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer m1;
    private TextView mnumber,done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m1=MediaPlayer.create(this,R.raw.five);
        mnumber=findViewById(R.id.mnumber);
        done=findViewById(R.id.done);

        new CountDownTimer(10000,1000)
        {
            @Override
            public void onFinish() {

                done.setText("Done!!!");
                m1.start();

            }

            @Override
            public void onTick(long l) {

                mnumber.setText("Time" + String.valueOf(l/1000));

            }
        }.start();
    }
}
