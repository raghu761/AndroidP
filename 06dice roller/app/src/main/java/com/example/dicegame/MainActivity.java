package com.example.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageviewdicy;
    private Random myRandomNumber=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageviewdicy=findViewById(R.id.imageView);
        imageviewdicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollMyDice();
            }
        });



    }


    public void rollMyDice()
    {
        int myRanNumber=myRandomNumber.nextInt(6) + 1;

        switch (myRanNumber)
        {
            case 1:
                imageviewdicy.setImageResource(R.drawable.dice1);
                break;

            case 2:
                imageviewdicy.setImageResource(R.drawable.dice2);
                  break;

            case 3:
                imageviewdicy.setImageResource(R.drawable.dice3);
                break;

            case 4:
                imageviewdicy.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageviewdicy.setImageResource(R.drawable.dice5);
                break;

            case 6:
                imageviewdicy.setImageResource(R.drawable.dice6);
                break;

        }
    }




}
