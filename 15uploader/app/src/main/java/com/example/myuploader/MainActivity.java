package com.example.myuploader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import static android.view.View.INVISIBLE;

public class MainActivity extends AppCompatActivity {
        private ProgressBar progressBar,progressBarHorizonatal;
        private Button start,end,upload;
        private  int progress=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.progressBar);
        progressBarHorizonatal=findViewById(R.id.progressBar2);
        start=findViewById(R.id.start);
        end=findViewById(R.id.end);
        upload=findViewById(R.id.button3);

        progressBar.setVisibility(INVISIBLE);

    }

    public  void start(View view)
    {
        progressBar.setVisibility(View.VISIBLE);
    }
    public  void end(View view)
    {
        progressBar.setVisibility(INVISIBLE);
    }

    public  void upload(View view)
    {
        fakeupload(progress);
    }


    public  void fakeupload(final int x)
    {
        progressBarHorizonatal.setProgress(x);

        final Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            fakeupload(x+10);
            }



        });

        thread.start();

    }
}
