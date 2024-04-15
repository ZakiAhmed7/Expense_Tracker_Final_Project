package com.example.expensetrackerfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.expensetrackerfinalproject.databinding.ActivityLoginBinding;
import com.example.expensetrackerfinalproject.databinding.ActivityLoginPage2Binding;

public class LoginPageActivity extends AppCompatActivity {

    private ActivityLoginPage2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page2);
        binding = com.example.expensetrackerfinalproject.databinding.ActivityLoginPage2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginButton.setOnClickListener(v-> {
            if (checkForAllValidations()) {
                Toast.makeText(this, "Everything is entered", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        });

    }
    private boolean checkForAllValidations() {
        // Check if username field is empty
        if (binding.usernameEditText.getText().toString().isEmpty()) {
            return false;
        }

        // Check if password field is empty
        if (binding.passwordEditText.getText().toString().isEmpty()) {
            return false;
        }

        return true;
    }

}


