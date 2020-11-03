package com.nirodha.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class accountsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_accounts);
    }


    public void AddNew(View view) {
        Intent i1 = new Intent(this, addAccount.class);
        startActivity(i1);
    }


    @Override
    protected void onResume() {
        super.onResume();

        toDoHelper td = new toDoHelper(this);
        SQLiteDatabase db = td.getReadableDatabase();
        String sql = "SELECT _id,title2,email2,username,password FROM table2";


        Cursor cursor = db.rawQuery(sql, null);
        List<String> list = new ArrayList<String>();
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            String title = cursor.getString(0);
            String email = cursor.getString(1);
            String username = cursor.getString(2);
            String password = cursor.getString(3);
            list.add(title + "(" + email + ")"+"("+username+")"+"("+password+")");
            cursor.moveToNext();
        }
        ListView lv = findViewById(R.id.list4);


        int layout = R.layout.fourth_one;
        String[] columns = {"title2", "email2","username","password","_id"};
        int[] labels = {R.id.t4, R.id.e4, R.id.u4,R.id.p4,R.id.list4_id}; // hadagatta custom layout eke lable thune id thuna
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, layout, cursor, columns, labels);
        lv.setAdapter(adapter);

    }}

