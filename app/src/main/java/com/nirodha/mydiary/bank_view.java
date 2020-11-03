package com.nirodha.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class bank_view extends AppCompatActivity {

    private static final String TABLE="table3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_view);
        getSupportActionBar().hide();
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView bname =findViewById(R.id.bname);
        TextView btype =findViewById(R.id.btype);
        TextView bno =findViewById(R.id.bno);
        TextView bpin =findViewById(R.id.bpin);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String bank = bundle.getString("BANK");
        int x= Integer.parseInt(bank);



        toDoHelper td = new toDoHelper(this);
        SQLiteDatabase db = td.getReadableDatabase();


        String sql ="SELECT BankName FROM " + TABLE  + " WHERE _id = " + x;
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();

        String sql2 ="SELECT AccType FROM " + TABLE  + " WHERE _id = " + x;
        Cursor cursor2 = db.rawQuery(sql2,null);
        cursor2.moveToFirst();

        String sql3 ="SELECT AccNumber FROM " + TABLE  + " WHERE _id = " + x;
        Cursor cursor3 = db.rawQuery(sql3,null);
        cursor3.moveToFirst();

        String sql4 ="SELECT pin FROM " + TABLE  + " WHERE _id = " + x;
        Cursor cursor4 = db.rawQuery(sql4,null);
        cursor4.moveToFirst();


        String bank1 = cursor.getString(0);
        String type = cursor2.getString(0);
        String no = cursor3.getString(0);
        String pin = cursor4.getString(0);

       bname.setText(bank1);
        btype.setText(type);
        bno.setText(no);
        bpin.setText(pin);
    }
}