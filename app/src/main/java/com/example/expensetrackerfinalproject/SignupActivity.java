package com.example.expensetrackerfinalproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Patterns;
import android.widget.Toast;
import com.example.expensetrackerfinalproject.databinding.ActivitySignupBinding;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
    private ActivitySignupBinding binding;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        binding.signupButton.setOnClickListener(v-> {
            if (checkForAllValidations()) {
                saveUserData();
                navigateToLoginPage();
                Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        });


    }

    private boolean checkForAllValidations() {
        String enteredUsername = binding.usernameEditText.getText().toString().trim();
        String enteredEmail = binding.emailEditText.getText().toString().trim();
        String enteredPassword = binding.passwordEditText.getText().toString().trim();
        String enteredConfirmPassword = binding.confirmPasswordEditText.getText().toString().trim();
        if (enteredUsername.isEmpty() && enteredEmail.isEmpty() && enteredPassword.isEmpty() && enteredConfirmPassword.isEmpty()) {
            binding.usernameEditText.setError("Enter username");
            binding.emailEditText.setError("Enter email");
            binding.passwordEditText.setError("Enter password");
            binding.confirmPasswordEditText.setError("Enter password");
            return false;
        }


        // Regex pattern for alphabets only
        Pattern usernamePattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher usernameMatcher = usernamePattern.matcher(enteredUsername);

        // Regex pattern for email
        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
        Matcher emailMatcher = emailPattern.matcher(enteredEmail);

        // Regex pattern for password (at least 7 characters)
        Pattern passwordPattern = Pattern.compile(".{7,}");
        Matcher passwordMatcher = passwordPattern.matcher(enteredPassword);

        // Check if all fields pass regex validations
        if (!usernameMatcher.matches()) {
            binding.usernameEditText.setError("Username should contain only alphabets");
            return false;
        }
        if (!emailMatcher.matches()) {
            binding.emailEditText.setError("Enter a valid email address");
            return false;
        }
        if (!passwordMatcher.matches()) {
            binding.passwordEditText.setError("Password should contain at least 7 characters");
            return false;
        }
        if (!enteredPassword.equals(enteredConfirmPassword)) {
            binding.confirmPasswordEditText.setError("Passwords do not match");
            return false;
        }
        return true;
    }


    private void saveUserData() {
        // Get user data from EditText fields
        String username = binding.usernameEditText.getText().toString();
        String email = binding.emailEditText.getText().toString();
        String password = binding.passwordEditText.getText().toString();

        // Save user data in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();
    }

    private void navigateToLoginPage() {
        Intent intent = new Intent(this, LoginPageActivity.class);
        startActivity(intent);
        finish();
    }

}