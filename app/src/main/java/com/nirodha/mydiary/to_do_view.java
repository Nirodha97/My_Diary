package com.nirodha.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class to_do_view extends AppCompatActivity {


    private static final String TABLE="table1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_to_do_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView tvNote =findViewById(R.id.tv_todo);
        TextView tvList= findViewById(R.id.tv_list);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("NAME");
        int x= Integer.parseInt(name);

        toDoHelper td = new toDoHelper(this);
        SQLiteDatabase db = td.getReadableDatabase();


        String sql ="SELECT title FROM " + TABLE  + " WHERE _id = " + x;
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();

        String sql2 ="SELECT tasks FROM " + TABLE  + " WHERE _id = " + x;
        Cursor cursor2 = db.rawQuery(sql2,null);
        cursor2.moveToFirst();

        String title = cursor.getString(0);
        String list = cursor2.getString(0);

        tvNote.setText(title);
        tvList.setText(list);



    }
}