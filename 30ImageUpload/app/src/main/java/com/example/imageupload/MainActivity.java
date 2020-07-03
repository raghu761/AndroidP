package com.example.imageupload;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;
    ProgressDialog progressDialog;
    StorageReference mStorage;
    final static  int GALLERY=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    button=findViewById(R.id.button);
    imageView=findViewById(R.id.imageView);
    progressDialog =new ProgressDialog(this);
    mStorage= FirebaseStorage.getInstance().getReference();

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setType("image/*");
            startActivityForResult(intent,GALLERY);
        }
    });

    }


    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);

        if(GALLERY==4)
        {
            progressDialog.setMessage("uploading ....\n");
            Uri uri=data.getData();
            imageView.setImageURI(uri);
            progressDialog.show();

            StorageReference filename=mStorage.child("photos/"+uri.getLastPathSegment()+".png");
            filename.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Toast.makeText(MainActivity.this,"upload complete ",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this,"upload failed",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
