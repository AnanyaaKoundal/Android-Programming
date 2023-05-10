package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper{
    public DBhelper(@Nullable Context context){
        super(context, "userDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table appform(name TEXT primary key, age TEXT , mobile TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int i, int i1){
        db.execSQL("drop Table if exists appform");
    }

    public boolean insertdata(String n, String a, String p){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("Name",n);
        cv.put("Age",a);
        cv.put("Mobile",p);
        long res= db.insert("appform", null, cv);
        if(res==-1){
            return false;
        }else{
            return true;
        }
    }

    public boolean updatedata(String n, String a, String p){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("Age",a);
        cv.put("Mobile",p);
        Cursor c= db.rawQuery("Select * from appform where name=?", new String[] {n});
        if(c.getCount()>0){
            long res=db.insert("appform", null, cv);
            if(res==-1){
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }

    public boolean deletedata(String n){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor c= db.rawQuery("Select * from appform where name=?", new String[]{n});
        if(c.getCount()>0){
            long res=db.delete("appform", "name=?", new String[]{n});
            if(res==-1){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public Cursor showdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c= db.rawQuery("Select * from appform", null);
        return c;
    }
}
