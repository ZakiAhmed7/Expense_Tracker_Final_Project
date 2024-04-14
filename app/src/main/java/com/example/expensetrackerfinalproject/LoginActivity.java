package com.example.expensetrackerfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_signup);
        // Get reference to the sign-up button
        MaterialButton signUpButton = findViewById(R.id.sign_up_button);
        MaterialButton loginButton = findViewById(R.id.login_button);
        // Set OnClickListener to the sign-up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to SignUpActivity
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent); // Start the SignUpActivity
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to SignUpActivity
                Intent intent = new Intent(LoginActivity.this, LoginPageActivity.class);
                startActivity(intent);
            }
        });


    }
}