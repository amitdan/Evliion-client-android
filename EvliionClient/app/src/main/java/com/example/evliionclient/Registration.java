package com.example.evliionclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registration extends AppCompatActivity {
    String name;
    String email;
    String phone;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
    }

    public void createAcc(View view){
        EditText nameText = findViewById(R.id.editName);
        EditText emailText = findViewById(R.id.editEmail);
        EditText phoneText = findViewById(R.id.editPhone);
        EditText passwordText = findViewById(R.id.editPassword);

        name = nameText.getText().toString();
        email = emailText.getText().toString();
        phone = phoneText.getText().toString();
        password = passwordText.getText().toString();

        System.out.println(name + " " + email + " " + phone + " " + password);
    }
}
