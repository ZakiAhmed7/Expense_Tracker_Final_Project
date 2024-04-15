package com.example.expensetrackerfinalproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.example.expensetrackerfinalproject.databinding.ActivityLoginPage2Binding;

public class LoginPageActivity extends AppCompatActivity {
    private ActivityLoginPage2Binding binding;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page2);
        binding = com.example.expensetrackerfinalproject.databinding.ActivityLoginPage2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        binding.loginButton.setOnClickListener(v-> {
            if (checkForAllValidations()) {
            login();
            }
            else
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        });

    }
    private boolean checkForAllValidations() {
        // Check if username and password fields are empty
        if (binding.usernameEditText.getText().toString().isEmpty() && binding.passwordEditText.getText().toString().isEmpty()) {
            binding.usernameEditText.setError("Enter username");
            binding.passwordEditText.setError("Enter password");
            return false;
        }

        return true;
    }


    private void login() {
        String savedUsername = sharedPreferences.getString("username", "");
        String savedPassword = sharedPreferences.getString("password", "");

        // Get entered username and password
        String enteredUsername = binding.usernameEditText.getText().toString();
        String enteredPassword = binding.passwordEditText.getText().toString();

        // Check if entered credentials match saved credentials
        if (savedUsername.equals(enteredUsername) && savedPassword.equals(enteredPassword)) {
            // Login successful
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            // Set a boolean flag indicating successful login
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLoggedIn", true);
            editor.apply();
            navigateToHomePage();
        } else {
            // Login failed
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }

    private void navigateToHomePage() {
        // Start the LoginActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}


