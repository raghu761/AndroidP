package com.example.recycler_cards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.BaseBundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  ArrayList<Example_item> list;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;
    private Button buttonAdd,buttonDelete;
    private EditText editTextAdd,editTextDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=new ArrayList<>();

        list.add(new Example_item(R.drawable.node,"this is node js"));
        list.add(new Example_item(R.drawable.oner,"this is node js"));
        list.add(new Example_item(R.drawable.twor,"this is node js"));
        list.add(new Example_item(R.drawable.threer,"this is node js"));
        list.add(new Example_item(R.drawable.fourr,"this is node js"));
        list.add(new Example_item(R.drawable.fiver,"this is node js"));
        list.add(new Example_item(R.drawable.sixr,"this is node js"));
        //list.add(new Example_item(R.drawable.,"this is node js"));

        recyclerView=findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(this);
        adapter=new Example_adaptor(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        buttonAdd=findViewById(R.id.buttonadd);
        buttonDelete=findViewById(R.id.buttondelete);
        editTextAdd=findViewById(R.id.edittextadd);
        editTextDelete=findViewById(R.id.edittextdelete);

            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=Integer.parseInt( editTextAdd.getText().toString());
                    addCard(position);
                }
            });


            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int positon=Integer.parseInt(editTextDelete.getText().toString());
                    deleteCard(positon);
                }
            });


    }



    public void addCard(int position)
    {
        list.add(position,new Example_item(R.drawable.node,"new node added"));
        adapter.notifyItemInserted(position);

    }

    public  void deleteCard(int position)
    {
        list.remove(position);
        adapter.notifyItemRemoved(position);

    }


}
