package com.nirodha.mydiary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class toDoHelper extends SQLiteOpenHelper {



    public toDoHelper(Context context){
        super(context,"mydb",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql3="CREATE TABLE table3 (_id INTEGER PRIMARY KEY AUTOINCREMENT,BankName TEXT, AccType TEXT, AccNumber INTEGER, pin TEXT)";
        String sql2 ="CREATE TABLE  table2  (_id INTEGER PRIMARY KEY AUTOINCREMENT,title2 TEXT,email2 TEXT,username TEXT,password TEXT)";
        String sql1 ="CREATE TABLE table1 (_id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT,date DATE,tasks TEXT)";
        String sql4 = "CREATE TABLE table4 (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,date DATE,day INTEGER,month TEXT,year INTEGER )";
        String sql5 = "CREATE TABLE table5 (_id INTEGER PRIMARY KEY AUTOINCREMENT,item TEXT,quantity TEXT )";


        sqLiteDatabase.execSQL(sql5);
        sqLiteDatabase.execSQL(sql4);
        sqLiteDatabase.execSQL(sql3);
        sqLiteDatabase.execSQL(sql2);
        sqLiteDatabase.execSQL(sql1);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
