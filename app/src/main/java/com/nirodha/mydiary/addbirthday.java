package com.nirodha.mydiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class addbirthday extends AppCompatActivity {

    EditText pname;
    CalendarView calendar1;
    String date1,day,month,year;
    TextView setdate,dateview;
    String cureYear,age2,newmonth;
    Integer age,m1;
    //---------------------
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    //---------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbirthday);
        getSupportActionBar().hide();

        //--------------------------
        setdate = findViewById(R.id.setdate);
        dateview= findViewById(R.id.date);
        setdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(addbirthday.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                date1 = String.valueOf(i)+"-"+String.valueOf(i1+1)+"-"+String.valueOf(i2);
                dateview.setText(date1);
                day=String.valueOf(i2);
                month=String.valueOf(i1+1);
                year=String.valueOf(i);
                m1=i1+1;



            }
        };

        //-------------------
        pname = findViewById(R.id.pname);
//        calendar1= findViewById(R.id.calendar1);
//
//       calendar1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//           @Override
//           public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
//               date1 = String.valueOf(i)+"-"+String.valueOf(i1+1)+"-"+String.valueOf(i2);
//           }
//       });
    }



    public void save(View v) {
        String name = pname.getText().toString();

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = sdf.format(new Date(calendar1.getDate()));


        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        switch (m1) {
            case 1:
                newmonth = months[0];
                break;
            case 2:
                newmonth = months[1];
                break;
            case 3:
                newmonth = months[2];
                break;
            case 4:
                newmonth = months[3];
                break;
            case 5:
                newmonth = months[4];
                break;
            case 6:
                newmonth = months[5];
                break;
            case 7:
                newmonth = months[6];
                break;
            case 8:
                newmonth = months[7];
                break;
            case 9:
                newmonth = months[8];
                break;
            case 10:
                newmonth = months[9];
                break;
            case 11:
                newmonth = months[10];
                break;
            case 12:
                newmonth = months[11];
                break;
            default:
                newmonth = "null";
        }

                cureYear = new SimpleDateFormat("yyyy", Locale.getDefault()).format(new Date());

                age = Integer.parseInt(cureYear) - Integer.parseInt(year);
                age2 = String.valueOf(age);

                toDoHelper td3 = new toDoHelper(this);
                SQLiteDatabase db = td3.getWritableDatabase();

                String sql = "INSERT INTO table4 (name,date,day,month,year) VALUES ('" + name + "','" + date1 + "','" + day + "','" + newmonth + "','" + age2 + "')";
                db.execSQL(sql);

                Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_SHORT).show();


        }
    }