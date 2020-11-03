package com.nirodha.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class banksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banks);
        getSupportActionBar().hide();
    }

    public void AddNew(View view) {
        Intent i1 = new Intent(this, addBank.class);
        startActivity(i1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        toDoHelper td3 = new toDoHelper(this);
        SQLiteDatabase db = td3.getReadableDatabase();
        String sql ="SELECT _id,BankName,AccType,AccNumber,pin FROM table3";




        Cursor cursor = db.rawQuery(sql,null);
        List<String> list = new ArrayList<String>();
        cursor.moveToFirst();

        while (cursor.isAfterLast()==false){
            String BankName = cursor.getString(0);
            String AccType = cursor.getString(1);
            list.add(BankName +"("+AccType+")");
            cursor.moveToNext();
        }
        ListView lv = findViewById(R.id.list5);


        int layout = R.layout.fifth_one;
        String[] columns = {"BankName","_id"};
        int[] labels= {R.id.b5,R.id.list_id}; // hadagatta custom layout eke lable thune id thuna
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,layout,cursor,columns,labels);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView bname=findViewById(R.id.b5);
                //String bank = bname.getText().toString();

                int x=i+1;
                String bank= Integer.toString(x);
                Intent intent = new Intent(banksActivity.this,bank_view.class);
                intent.putExtra("BANK",bank);
                startActivity(intent);
            }
        });
    }}