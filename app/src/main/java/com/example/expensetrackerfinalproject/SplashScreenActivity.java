package com.example.expensetrackerfinalproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.preference.PreferenceManager;

public class SplashScreenActivity extends AppCompatActivity {
    private static final int SPLASH_DELAY = 2000;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Check if the user is already logged in
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        // Handler to navigate after the minimum splash duration
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isLoggedIn) {
                    navigateToHomePage();
                } else {
                    navigateToLoginPage();
                }
            }
        }, SPLASH_DELAY);
    }


    private void navigateToHomePage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void navigateToLoginPage() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}