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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class to_do_list extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_to_do_list);

    }

    public void AddNew(View view)
    {
        Intent i1 = new Intent(this,AddNew_to_do_list.class);
        startActivity(i1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        toDoHelper td = new toDoHelper(this);
        SQLiteDatabase db = td.getReadableDatabase();
        String sql ="SELECT _id,title,date FROM table1";




        Cursor cursor = db.rawQuery(sql,null);
        final List<String> list = new ArrayList<String>();
        cursor.moveToFirst();

        while (cursor.isAfterLast()==false){
            String title = cursor.getString(0);
            String date = cursor.getString(1);
            list.add(title +"("+date+")");
            cursor.moveToNext();
        }
         ListView lv = (ListView) findViewById(R.id.list1);


        int layout = R.layout.first_one;
        String[] columns = {"title","date","_id"};
        int[] labels= {R.id.title,R.id.date,R.id.list_id}; // hadagatta custom layout eke lable thune id thuna
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,layout,cursor,columns,labels);
        lv.setAdapter(adapter);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //TextView t1 = (TextView) view;

                    TextView t1=findViewById(R.id.title);
                    //String name = list.get(i);
                int x=i+1;
                String name= Integer.toString(x);

                Intent intent = new Intent(to_do_list.this,to_do_view.class);
               intent.putExtra("NAME",name);
               startActivity(intent);


            }
        });
    }




    }
