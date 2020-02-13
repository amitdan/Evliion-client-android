package com.example.evliionclient;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class StartChargingActivity extends AppCompatActivity {


    private TextView selectedHours, selectedMinutes, yearTV, monthTV, dayTV;
    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_charging);


        LinearLayout selectTime = (LinearLayout) findViewById(R.id.selectTimeLL);
        LinearLayout selectDate = (LinearLayout) findViewById(R.id.selectDateLL);

        selectedHours = (TextView) findViewById(R.id.selectedHours);
        selectedMinutes = (TextView) findViewById(R.id.selectedMinutes);

        yearTV = (TextView) findViewById(R.id.year);
        dayTV = (TextView) findViewById(R.id.day);
        monthTV = (TextView) findViewById(R.id.month);


        selectTime.setOnClickListener(new View.OnClickListener() {

            Calendar mcurrentTime = Calendar.getInstance();
            int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
            int minute = mcurrentTime.get(Calendar.MINUTE);
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(StartChargingActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        selectedHours.setText( selectedHour);
                        selectedMinutes.setText(selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
            }
        });

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(StartChargingActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        yearTV.setText(year);
                        dayTV.setText(dayOfMonth);
                        monthTV.setText(month);
                    }
                }, year, month, day);
            }
        });
    }




}
