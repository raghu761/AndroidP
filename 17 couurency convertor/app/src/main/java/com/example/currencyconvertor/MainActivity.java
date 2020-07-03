package com.example.currencyconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button euro,pound,dollar,yen,dinar,bitcoin,rubel,ausdoller,candoller;
    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euro=findViewById(R.id.euro);
        pound=findViewById(R.id.pound);
        dollar=findViewById(R.id.dollar);
        yen=findViewById(R.id.yen);
        dinar=findViewById(R.id.dinar);
        bitcoin=findViewById(R.id.bitcoin);
        rubel=findViewById(R.id.rubel);
        ausdoller=findViewById(R.id.ausdollar);
        candoller=findViewById(R.id.candollar);

        editText=findViewById(R.id.editText2);
        textView=findViewById(R.id.textView);

        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String z=editText.getText().toString();

                if(TextUtils.isEmpty(z))
                {
                    editText.setError("Invalid !!!");
                }
                else{

                    double n,k;
                    n=Double.parseDouble(z);
                    textView.setText(null);
                    k=n*0.012;
                    textView.setText(""+k);
                }


            }
        });



        dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String z=editText.getText().toString();

                if(TextUtils.isEmpty(z))
                {
                    editText.setError("Invalid !!!");
                }
                else{

                    double n,k;
                    n=Double.parseDouble(z);
                    textView.setText(null);
                    k=n*70;
                    textView.setText(""+k);
                }


            }
        });


        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String z=editText.getText().toString();

                if(TextUtils.isEmpty(z))
                {
                    editText.setError("Invalid !!!");
                }
                else{

                    double n,k;
                    n=Double.parseDouble(z);
                    textView.setText(null);
                    k=n*0.012;
                    textView.setText(""+k);
                }


            }
        });



        yen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String z=editText.getText().toString();

                if(TextUtils.isEmpty(z))
                {
                    editText.setError("Invalid !!!");
                }
                else{

                    double n,k;
                    n=Double.parseDouble(z);
                    textView.setText(null);
                    k=n*0.012;
                    textView.setText(""+k);
                }


            }
        });



        dinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String z=editText.getText().toString();

                if(TextUtils.isEmpty(z))
                {
                    editText.setError("Invalid !!!");
                }
                else{

                    double n,k;
                    n=Double.parseDouble(z);
                    textView.setText(null);
                    k=n*0.012;
                    textView.setText(""+k);
                }


            }
        });



        bitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String z=editText.getText().toString();

                if(TextUtils.isEmpty(z))
                {
                    editText.setError("Invalid !!!");
                }
                else{

                    double n,k;
                    n=Double.parseDouble(z);
                    textView.setText(null);
                    k=n*0.012;
                    textView.setText(""+k);
                }


            }
        });



        rubel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String z=editText.getText().toString();

                if(TextUtils.isEmpty(z))
                {
                    editText.setError("Invalid !!!");
                }
                else{

                    double n,k;
                    n=Double.parseDouble(z);
                    textView.setText(null);
                    k=n*0.012;
                    textView.setText(""+k);
                }


            }
        });



        ausdoller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String z=editText.getText().toString();

                if(TextUtils.isEmpty(z))
                {
                    editText.setError("Invalid !!!");
                }
                else{

                    double n,k;
                    n=Double.parseDouble(z);
                    textView.setText(null);
                    k=n*0.012;
                    textView.setText(""+k);
                }


            }
        });


        candoller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String z=editText.getText().toString();

                if(TextUtils.isEmpty(z))
                {
                    editText.setError("Invalid !!!");
                }
                else{

                    double n,k;
                    n=Double.parseDouble(z);
                    textView.setText(null);
                    k=n*0.012;
                    textView.setText(""+k);
                }


            }
        });




    }
}
