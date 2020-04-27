package com.example.calendar_nomemo_0427;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //initialize
    TextView disablePastDate, disableFutureDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Assign variable
        disablePastDate=findViewById(R.id.disable_past_date);
        disableFutureDate=findViewById(R.id.disable_future_date);

        //Initialize calendar
        Calendar calendar= Calendar.getInstance();

        //Get year
        final int year=calendar.get(Calendar.YEAR);
        //Get month
        final int month=calendar.get(Calendar.MONTH);
        //Get day
        final int day=calendar.get(Calendar.DAY_OF_MONTH);

        disablePastDate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                //Initialize date picker dialog
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //store date in string
                        String sDate=dayOfMonth+"/"+month+"/"+year;
                        //set date on text view
                        disablePastDate.setText(sDate);
                    }
                } ,year ,month ,day
                );
                //Disable past date
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
                //show date picket dialog
                datePickerDialog.show();
            }
        });

        disableFutureDate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Initialize date picker dialog
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //store date in string
                        String sDate=dayOfMonth+"/"+month+"/"+year;
                        //set date on text view
                        disableFutureDate.setText(sDate);
                    }
                },year,month,day
                );
                //Disable future date
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                //show date picker dialog
                datePickerDialog.show();
            }
        });
    }
}
