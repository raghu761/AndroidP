package com.example.game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {



    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference rootref=db.getReference();
    DatabaseReference gamreref=rootref.child("game");


    TextView t1;
    Button rock,paper,sissor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   rootref.setValue("raghunath is cool");
        t1=findViewById(R.id.rockpapersissor);
        rock=findViewById(R.id.rock);
        paper=findViewById(R.id.paper);
        sissor=findViewById(R.id.scissor);

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamreref.setValue("rock");
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamreref.setValue("paper");
            }
        });

        sissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamreref.setValue("scissor");
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

    gamreref.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String text=dataSnapshot.getValue().toString();
            t1.setText(text);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    }
}
