package com.example.jsonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson=new Gson();
//        Student student=new Student("raghunath","4","raghu@gmail.com");
//        String json=gson.toJson(student);

//        String json="{\"course_count\":\"4\",\"email\":\"raghu@gmail.com\",\"name\":\"raghunath\"}";
//        Student student=gson.fromJson(json,Student.class);
//
//        Log.d("test" ,student.toString());


//        Course course=new Course("java ","by raghunath");
//
//        Student student=new Student("raghunath ","1","rab.com",course );
//
//        String json=gson.toJson(student);
//
//        Log.d("test",json);




        String json="{\"course_count\":\"1\",\"email\":\"rab.com\",\"course\":{\"description\":\"by raghunath\",\"name\":\"java \"},\"name\":\"raghunath \"}";
        Student student=gson.fromJson(json,Student.class);
        Log.d("test",student.toString());



    }
}
