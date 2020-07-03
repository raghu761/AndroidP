package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
    }

    public void screenone(View view)
    {
        String value=editText.getText().toString();
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("name",value);
        startActivity(intent);
    }
}
