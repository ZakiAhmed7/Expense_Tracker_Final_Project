package com.example.expensetrackerfinalproject.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.expensetrackerfinalproject.model.Expense;

@Database(entities = {Expense.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ExpenseDAO expenseDAO();
}
