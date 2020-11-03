package com.nirodha.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class birthdayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        getSupportActionBar().hide();
    }
    public void AddNew(View view) {
        Intent i1 = new Intent(this, addbirthday.class);
        startActivity(i1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //cureYear = new SimpleDateFormat("yyyy", Locale.getDefault()).format(new Date());

        toDoHelper td3 = new toDoHelper(this);
        SQLiteDatabase db = td3.getReadableDatabase();
        String sql = "SELECT _id,name,date,day,month,year FROM table4";


        Cursor cursor = db.rawQuery(sql, null);
        List<String> list = new ArrayList<String>();
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            String name = cursor.getString(0);
            String date = cursor.getString(1);

            String month =cursor.getString(3);
            String year=cursor.getString(4);

            list.add(name + "(" + date + ")");
            cursor.moveToNext();
        }
        ListView lv = findViewById(R.id.list3);



        int layout = R.layout.third_one;
        String[] columns = {"name", "date","day","month","year","_id"};
        int[] labels = {R.id.name, R.id.date,R.id.day,R.id.month,R.id.year,R.id.list3_id}; // hadagatta custom layout eke lable thune id thuna
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, layout, cursor, columns, labels);
        lv.setAdapter(adapter);

    }
}