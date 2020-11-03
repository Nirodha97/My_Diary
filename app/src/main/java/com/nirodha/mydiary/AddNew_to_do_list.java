package com.nirodha.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddNew_to_do_list extends AppCompatActivity {

    EditText etTitle;
    EditText etList1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_to_do_list);
        getSupportActionBar().hide();
        etTitle = findViewById(R.id.etTitle);
        etList1= findViewById(R.id.etList1);
    }

    public void save(View view){
        String title= etTitle.getText().toString();
        String list1= etList1.getText().toString();
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        toDoHelper td = new toDoHelper(this);
        SQLiteDatabase db =td.getWritableDatabase();

        String sql ="INSERT INTO table1 (title,date,tasks) VALUES ('"+title+"','"+date+"','"+list1+"')";
        db.execSQL(sql);

        Toast.makeText(this,title+" Saved Successfully!",Toast.LENGTH_SHORT).show();
    }

    public void clear(View view)
    {
        etTitle.setText("");
        etList1.setText("");
    }

}