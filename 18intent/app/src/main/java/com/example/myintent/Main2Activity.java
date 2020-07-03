package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView=findViewById(R.id.textView);
        String myvalue=getIntent().getStringExtra("name");
        textView.setText(myvalue);
    }

    public void screentwo(View view)
    {
        Intent intent;
        intent = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
    }
}
