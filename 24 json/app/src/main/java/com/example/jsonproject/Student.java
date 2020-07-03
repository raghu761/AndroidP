package com.example.jsonproject;

import com.google.gson.annotations.SerializedName;

public class Student {
    private String name;
    private  String course_count;
    private  String email;
    @SerializedName("course")
    private  Course mCourse;

    public Student(String name, String course_count, String email,Course course) {
        this.name = name;
        this.course_count = course_count;
        this.email = email;
        this.mCourse=course;
    }
}
