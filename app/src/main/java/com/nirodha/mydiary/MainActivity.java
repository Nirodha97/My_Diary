package com.nirodha.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void homebtn1(View view)
    {
        Intent i1 = new Intent(this,to_do_list.class);
        startActivity(i1);
    }

    public void homebtn4(View view)
    {
        Intent i2 = new Intent(this,accountsActivity.class);
        startActivity(i2);
    }

    public void homebtn5(View view)
    {
        Intent i2 = new Intent(this,banksActivity.class);
        startActivity(i2);
    }

    public void homebtn3(View view)
    {
        Intent i2 = new Intent(this,birthdayActivity.class);
        startActivity(i2);
    }

    public void homebtn2(View view)
    {
        Intent i2 = new Intent(this,shopingActivity.class);
        startActivity(i2);
    }
}