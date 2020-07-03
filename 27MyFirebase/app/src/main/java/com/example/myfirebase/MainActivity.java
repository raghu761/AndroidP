package com.example.myfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    EditText email;
    EditText password;
    //Button button;

    private FirebaseAuth mAuth;


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
       // updateUI(currentUser);
        Toast.makeText(this,"Already in ",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);


    }


    public  void onRegister(View view)
    {
       final String myEmail=email.getText().toString();
       final String myPass=password.getText().toString();

        mAuth.createUserWithEmailAndPassword(myEmail, myPass)
                .addOnCompleteListener(/*MainActivity.this,*/ new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                            Log.i("TAG", "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);

                            Toast.makeText(MainActivity.this, "Done with Aunthetication", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
//                            Log.i("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                           // updateUI(null);
                        }

                        // ...
                    }
                });
    }
}
