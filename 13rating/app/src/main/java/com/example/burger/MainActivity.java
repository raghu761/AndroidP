package com.example.burger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        private RatingBar ratingBar;
        private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        ratingBar=findViewById(R.id.ratingBar);


    }



    public void submit(View view) {

        float x = ratingBar.getRating();

        if (x <= 2) {
            textView.setText("WE will try to improve thanks for the rating " + x);
        } else if (x > 2 && x < 4) {
            textView.setText("WE will soon make u to do 5 " + x);

        } else {
            textView.setText("thanks for the rating" + x);
        }
    }
}
