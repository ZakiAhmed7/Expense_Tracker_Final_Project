package com.example.expensetrackerfinalproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.expensetrackerfinalproject.database.AppDatabase;
import com.example.expensetrackerfinalproject.database.ExpenseDAO;
import com.example.expensetrackerfinalproject.model.Expense;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.expensetrackerfinalproject.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements ExpenseDAO {
    private ActivityMainBinding binding;
    private AppDatabase database;
    ArrayList<Expense> expensesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_update_details, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration); // This line is removed
        NavigationUI.setupWithNavController(binding.navView, navController);

        database = AppDatabase.getInstance(this);
    }

    @Override
    public ArrayList<Expense> getAllExpenses() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                expensesList = (ArrayList<Expense>) database.expenseDAO().getAllExpenses();
            }
        });

        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.d("TAG", "All expenses executed");
                Toast.makeText(MainActivity.this, "Loaded all the expenses", Toast.LENGTH_SHORT).show();
            }
        });
        return expensesList;
    }

    @Override
    public void addAExpense(Expense expense) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                database.expenseDAO().addAExpense(expense);
            }
        });
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Expense added", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateAnExpense(Expense expense) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                database.expenseDAO().updateAnExpense(expense);
            }
        });

        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Updated Expense successfully.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void deleteExpense(Expense expense) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                database.expenseDAO().deleteExpense(expense);
            }
        });
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Deleted an expense successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
