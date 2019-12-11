package com.sqlproject.android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MaBase extends SQLiteOpenHelper {
    private static final String DATABASENAME = "student1.db";
    private static final int DATABASEVERSION = 1;
    public MaBase(@Nullable Context context) {
        super(context, DATABASENAME,null,DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE student(id INTEGER PRIMARY KEY, name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }
}
