package com.nirodha.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addBank extends AppCompatActivity {

    EditText etBankName, etAccType, etAccNumber, etPin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bank);
        getSupportActionBar().hide();

        etBankName = findViewById(R.id.etBankName);
        etAccType=findViewById(R.id.etAccType);
        etAccNumber= findViewById(R.id.etAccNumber);
        etPin=findViewById(R.id.etPin);
    }


    public void clear(View view)
    {
        etBankName.setText("");
        etAccType.setText("");
        etAccNumber.setText("");
        etPin.setText("");
    }

    public void save(View view)
    {
        String BankName=etBankName.getText().toString();
        String AccType=etAccType.getText().toString();
        String AccNumber=etAccNumber.getText().toString();
        String pin=etPin.getText().toString();

        toDoHelper td3 = new toDoHelper(this);
        SQLiteDatabase db =td3.getWritableDatabase();

        String sql ="INSERT INTO table3 (BankName,AccType,AccNumber,pin) VALUES ('"+BankName+"','"+AccType+"','"+AccNumber+"','"+pin+"')";
        db.execSQL(sql);


        Toast.makeText(this, "Save Successfully", Toast.LENGTH_SHORT).show();
    }
}