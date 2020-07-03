package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference rootref=db.getReference();
    DatabaseReference userRef=rootref.child("Users");

    EditText email,username,name;
    Button button,button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email);
        username=findViewById(R.id.username);
        name=findViewById(R.id.name);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myUsername=username.getText().toString().trim();
                String myName=name.getText().toString().trim();
                String myemail=email.getText().toString().trim();

                HashMap<String,String> userMap=new HashMap<String, String>();
                userMap.put("username",myUsername);
                userMap.put("name",myName);
                userMap.put("email",myemail);

                userRef.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                            Toast.makeText(MainActivity.this,"Succesfull",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this," not Succesfull",Toast.LENGTH_SHORT).show();


                    }
                });
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);

            }
        });

    }
}
