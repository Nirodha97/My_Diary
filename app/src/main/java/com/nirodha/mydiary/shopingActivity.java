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

public class shopingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_shoping);
    }

    public void AddNew(View view) {
        Intent i1 = new Intent(this, addShopingItemActivity.class);
        startActivity(i1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        toDoHelper td2 = new toDoHelper(this);
        SQLiteDatabase db = td2.getReadableDatabase();
        String sql = "SELECT _id,item,quantity FROM table5";


        Cursor cursor = db.rawQuery(sql, null);
        List<String> list = new ArrayList<String>();
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            String item = cursor.getString(0);
            String quantity = cursor.getString(1);

            list.add(item + "(" + quantity + ")");
            cursor.moveToNext();
        }
        ListView lv = findViewById(R.id.list2);


        int layout = R.layout.second_one;
        String[] columns = {"item", "quantity","_id"};
        int[] labels = {R.id.item, R.id.q,R.id.list2_id}; // hadagatta custom layout eke lable thune id thuna
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, layout, cursor, columns, labels);
        lv.setAdapter(adapter);

    }


}