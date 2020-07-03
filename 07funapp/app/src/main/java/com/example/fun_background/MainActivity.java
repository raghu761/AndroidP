package com.example.fun_background;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private ImageButton image1;
    private ConstraintLayout layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1=findViewById(R.id.imageButton);
        layout1=findViewById(R.id.layout);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random=new Random();

                int mycolor= Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
                layout1.setBackgroundColor(mycolor);
            }
        });
    }
}
