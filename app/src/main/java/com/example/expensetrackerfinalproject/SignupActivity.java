package com.example.expensetrackerfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.expensetrackerfinalproject.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {
    private ActivitySignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.signupButton.setOnClickListener(v-> {
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
            binding.usernameEditText.setError("Enter username");
            return false;
        }
        // Check if email field is empty
        if (binding.emailEditText.getText().toString().isEmpty()) {
            return false;
        }
        // Check if password field is empty
        if (binding.passwordEditText.getText().toString().isEmpty()) {
            return false;
        }
        // Check if confirm password field is empty
        if (binding.confirmPasswordEditText.getText().toString().isEmpty()) {
            return false;
        }
        // Check if password and confirm password match
        if (!binding.passwordEditText.getText().toString().equals(binding.confirmPasswordEditText.getText().toString())) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}