package com.example.evliionclient;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class StartChargingActivity extends AppCompatActivity {


    private TextView selectedHours, selectedMinutes, yearTV, monthTV, dayTV, amPmTV, sName, vInfo;
    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;
    private String stationName, vmodel, vmake, vtype;
    private Button payButton;
    private String amount_to_pay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        stationName = intent.getStringExtra("stationName");
        vmodel = intent.getStringExtra("VMODEL");
        vmake = intent.getStringExtra("VMAKE");
        vtype = intent.getStringExtra("VTYPE");
        String vMessage = String.format("Type: %s \n Made by: %s \n Model: %s",vtype, vmake, vmodel);
        //Toast.makeText(this, vMessage, Toast.LENGTH_LONG).show();


        setContentView(R.layout.activity_start_charging);

        LinearLayout selectTime = (LinearLayout) findViewById(R.id.selectTimeLL);
        LinearLayout selectDate = (LinearLayout) findViewById(R.id.selectDateLL);

        selectedHours = (TextView) findViewById(R.id.selectedHours);
        selectedMinutes = (TextView) findViewById(R.id.selectedMinutes);
        amPmTV = (TextView) findViewById(R.id.amPm);

        yearTV = (TextView) findViewById(R.id.year);
        dayTV = (TextView) findViewById(R.id.day);
        monthTV = (TextView) findViewById(R.id.month);
        sName = (TextView)findViewById(R.id.sname);
        vInfo = (TextView)findViewById(R.id.vInfo);
        sName.setText(stationName);
        vInfo.setText(vMessage);


        payButton = (Button) findViewById(R.id.payButton);




        selectTime.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                Log.i("LOG", "Select time clicked");
                timePickerDialog = new TimePickerDialog(StartChargingActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        selectedHours.setText( String.valueOf(selectedHour));
                        selectedMinutes.setText(String.valueOf(selectedMinute));

                        if(selectedHour < 12) {
                            amPmTV.setText("AM");
                        }
                        else {
                            amPmTV.setText("PM");
                        }
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.show();
            }
        });

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("LOG", "Select date clicked");
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(StartChargingActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        yearTV.setText(String.valueOf(year));
                        dayTV.setText(String.valueOf(dayOfMonth));
                        monthTV.setText(String.valueOf(month));
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        payButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(StartChargingActivity.this, PaymentActivity.class);
                amount_to_pay = "50 dollars";
                intent.putExtra("PAY_AMOUNT", amount_to_pay);
                startActivity(intent);
            }
        });
    }




}
