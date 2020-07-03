package com.example.animationlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        layout1=findViewById(R.id.layout);
        AnimationDrawable anime= (AnimationDrawable) layout1.getBackground();
            anime.setEnterFadeDuration(2000);
            anime.setExitFadeDuration(3000);
            anime.start();



    }
}
