package com.example.expensetrackerfinalproject.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Upsert;

import com.example.expensetrackerfinalproject.model.Expense;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ExpenseDAO {
    //Get all expenses to show
    @Query("SELECT * FROM Expense")
    public List<Expense> getAllExpenses();

    // insert a expense
    @Insert
    public void addAExpense(Expense expense);

    @Upsert
    // update an expense details
    public void updateAnExpense(Expense expense);

    @Delete
    // delete an expense
    public void deleteExpense(Expense expense);

}
