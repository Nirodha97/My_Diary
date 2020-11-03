package com.nirodha.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addAccount extends AppCompatActivity {

    EditText etTitle, etEmail,etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        getSupportActionBar().hide();
        etTitle = findViewById(R.id.etTitle);
        etEmail=findViewById(R.id.etEmail);
        etUsername=findViewById(R.id.etUsername);
        etPassword= findViewById(R.id.etPassword);
    }



    public void clear(View view){
        etTitle.setText("");
        etEmail.setText("");
        etUsername.setText("");
        etPassword.setText("");
    }

    public void save(View v)
    {
        String title=etTitle.getText().toString();
        String email=etEmail.getText().toString();
        String username=etUsername.getText().toString();
        String password= etPassword.getText().toString();


        toDoHelper td2 = new toDoHelper(this);
        SQLiteDatabase db =td2.getWritableDatabase();

        String sql ="INSERT INTO table2 (title2,email2,username,password) VALUES ('"+title+"','"+email+"','"+username+"','"+password+"')";
        db.execSQL(sql);

        Toast.makeText(this,title+"Saved Successfully!",Toast.LENGTH_SHORT).show();


    }
}