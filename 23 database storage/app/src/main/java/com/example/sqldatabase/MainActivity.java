package com.example.sqldatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatavaseHelper Mydb;
    EditText editTextId, editTextName,editTextEmail,editTextCC;
    Button buttonAdd,buttonGetData,buttonUpdate,buttonDelete,buttonViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Mydb=new DatavaseHelper(this);
        editTextId=findViewById(R.id.editText_id);
        editTextName=findViewById(R.id.editText_name);
        editTextEmail=findViewById(R.id.editText_email);
        editTextCC=findViewById(R.id.editText_CC);

        buttonAdd=findViewById(R.id.button_add);
        buttonGetData=findViewById(R.id.button_view);
        buttonUpdate=findViewById(R.id.button_update);
        buttonDelete=findViewById(R.id.button_delete);
        buttonViewAll=findViewById(R.id.button_viewAll);

        //showMessage("raghu","the king" );
        addData();
        getdata();
        viewAll();
        updateData();
        delete();

    }

        private void addData()
        {
            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                   boolean isInserted= Mydb.insertdata(editTextName.getText().toString(),editTextEmail.getText().toString(),editTextCC.getText().toString());

                   if(isInserted == true)
                       Toast.makeText(MainActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                   else
                        Toast.makeText(MainActivity.this,"Something went Wrong",Toast.LENGTH_SHORT).show();


                }

            });
        }

        private void getdata()
        {
            buttonGetData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id=editTextId.getText().toString();
                   if(id.equals(String.valueOf(""))) {
                       editTextId.setError("Enter id");
                        return;
                   }

                    Cursor cursor=Mydb.getdata(id);
                    String data=null;

                    if(cursor.moveToNext())
                    {
                        data="ID: " + cursor.getString(0) + "\n"+
                                "NAME: " + cursor.getString(1) + "\n"+
                                "EMAIL: " + cursor.getString(2) + "\n"+
                                "COURSE_COUNT: " + cursor.getString(3) + "\n";
                    }

                    showMessage("Data :",data);


                }
            });
        }

        private void viewAll()
        {
            buttonViewAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cursor cursor=Mydb.getalldata();

                    if(cursor.getCount()==0)
                    {
                        showMessage("Error","Invalid data base not found");
                        return;
                    }

                    StringBuffer buffer=new StringBuffer();

                    while (cursor.moveToNext())
                    {
                     //   String data;
//                        data="ID "+ cursor.getString(0) + "\n" +
//                                "NAME "+ cursor.getString(1) + "\n" +
//                                "EMAIL "+ cursor.getString(2) + "\n" +
//                                "COURCE_COUNT" + cursor.getString(3) + "\n" +


                        buffer.append("ID ").append(cursor.getString(0)).append("\n");
                        buffer.append("NAME ").append(cursor.getString(1)).append("\n");
                        buffer.append("EMAIL ").append(cursor.getString(2)).append("\n");
                        buffer.append("COURCE_COUNT").append(cursor.getString(3)).append("\n");

                    }

                    showMessage("ALL DATA ",buffer.toString());


                }
            });
        }


        private void updateData()
        {
            buttonUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isUpdate=Mydb.updatedata(editTextId.getText().toString(),
                            editTextName.getText().toString(),
                            editTextEmail.getText().toString(),
                            editTextCC.getText().toString()
                    );

                    if(isUpdate==true)
                    {
                        Toast.makeText(MainActivity.this,"UPDATAED SUCCESFULLY ",Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"OPPS!!!",Toast.LENGTH_SHORT).show();
                    }


                }
            });
        }


        private void delete()
        {
            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Integer deleterow=Mydb.deletedata(editTextId.getText().toString());

                    if(deleterow>0)
                    {
                        Toast.makeText(MainActivity.this,"DELETED SUCCESSFULLY ",Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"ERROR WHILE DELETING ", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }



    private void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
