package com.example.evliionclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {
    private TextView payAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Intent intent = getIntent();
        String amount = intent.getStringExtra("PAY_AMOUNT");

        payAmount = (TextView)findViewById(R.id.amount_to_pay);
        payAmount.setText(amount);
    }
}
