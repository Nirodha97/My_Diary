package com.nirodha.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addShopingItemActivity extends AppCompatActivity {

    EditText etItem,etQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_shoping_item);
        etItem= findViewById(R.id.etItem);
        etQ=findViewById(R.id.etQ);

    }

    public void clear(View view)
    {
        etItem.setText("");
        etQ.setText("");

    }

    public void save(View view){
        String item = etItem.getText().toString();
        String quantity = etQ.getText().toString();


        toDoHelper td2 = new toDoHelper(this);
        SQLiteDatabase db =td2.getWritableDatabase();

        String sql ="INSERT INTO table5 (item,quantity) VALUES ('"+item+"','"+quantity+"')";
        db.execSQL(sql);


        Toast.makeText(this, "Save Successfully", Toast.LENGTH_SHORT).show();
    }
}