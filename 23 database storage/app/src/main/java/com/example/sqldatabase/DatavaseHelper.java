package com.example.sqldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatavaseHelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME="MYStudent.DB";
    public  final static String TABLE_NAME="mystudent_table";
    public  final static  String COL1="ID";
    public  final  static String COL2="NAME";
    public  final static String COL3="EMAIL";
    public  final static  String COL4="COURSE_COUNT";



    public DatavaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                         + TABLE_NAME+
                        " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " NAME TEXT ," +
                        " EMAIL TEXT ," +
                        " COURSE_COUNT INT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public  boolean insertdata(String name,String email,String coursecount )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COL2,name);
        contentValues.put(COL3,email);
        contentValues.put(COL4,coursecount);

        long result=db.insert(TABLE_NAME ,null,contentValues);
            if(result == -1)
                return false;
            else
                return true;

    }

    public  boolean updatedata(String id,String name,String email,String coursecount )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,name);
        contentValues.put(COL3,email);
        contentValues.put(COL4,coursecount);
        db.update(TABLE_NAME,contentValues," id=? ",new String[]{id});
        return  true;

    }

    public Cursor getdata(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT *FROM " + TABLE_NAME + " WHERE  ID='" + id + "'";
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }

    public  Integer deletedata(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID=? ",new String[]{id});
    }

    public  Cursor getalldata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT *FROM " + TABLE_NAME,null);
        return cursor;
    }
}
