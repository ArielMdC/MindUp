package com.example.mindup.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mindup.R;

public class LoginActivity extends Activity implements View.OnClickListener {

    Button buttonSignIn;
    EditText editTextUsername, editTextPassword;

    String USERNAME = "admin", PASSWORD = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);

        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);

        buttonSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (buttonSignIn.getId() == view.getId()) {

            if (editTextUsername.getText().toString().equals(USERNAME)) {

                if (editTextPassword.getText().toString().equals(PASSWORD)) {
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    Toast.makeText(this, "PASSWORD ERRADO", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "USERNAME ERRADO", Toast.LENGTH_SHORT).show();
            }

        }

    }

}
