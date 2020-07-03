package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageView;
    private Random random=new Random();
    int lastdirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spin();
            }
        });

    }

    public void spin()
    {
        int newdirection=random.nextInt(36000)+36000;
        float pivoitX=imageView.getWidth()/2;
        float pivoitY=imageView.getHeight()/2;
        Animation rotate= new RotateAnimation(lastdirection,newdirection,pivoitX,pivoitY);
        rotate.setDuration(3000);
        rotate.setFillAfter(true);
        lastdirection=newdirection;
        imageView.startAnimation(rotate);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
              //  button.setBackgroundColor(Color.parseColor("#c1c1c1"));
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            button.setEnabled(true);
            }
        });
    }


}
