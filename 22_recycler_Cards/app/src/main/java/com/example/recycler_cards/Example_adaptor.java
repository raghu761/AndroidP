package com.example.recycler_cards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Example_adaptor extends RecyclerView.Adapter<Example_adaptor.ExampleViewHolder> {

    private ArrayList<Example_item> mExampleList;

    //1
    public static class ExampleViewHolder  extends RecyclerView.ViewHolder{


        //4
        private ImageView imageView;
        private TextView textView;

        //2
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            //4
            imageView =itemView.findViewById(R.id.imageView);
            textView =itemView.findViewById(R.id.textView);

        }
    }

    //6.1
    public Example_adaptor(ArrayList<Example_item> examplelist){

        mExampleList=examplelist;
    }

    //3
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //5
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder exampleViewHolder=new ExampleViewHolder(view);
        return exampleViewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Example_item currentItem=mExampleList.get(position);
        holder.imageView.setImageResource(currentItem.getmImageResouce());
        holder.textView.setText(currentItem.getMtext());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }



}
