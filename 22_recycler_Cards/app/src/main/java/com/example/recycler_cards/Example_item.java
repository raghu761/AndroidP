package com.example.recycler_cards;

public class Example_item {

    private int mImageResouce;
    private String mtext;

    public  Example_item(int imageResource , String text)
    {
        mImageResouce=imageResource;
        mtext=text;
    }

    public int getmImageResouce() {
        return mImageResouce;
    }

    public String getMtext() {
        return mtext;
    }
}
