package com.example.expensetrackerfinalproject.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Upsert;

import com.example.expensetrackerfinalproject.model.Expense;

import java.util.ArrayList;

@Dao
public interface ExpenseDAO {
    //Get all expenses to show
    @Query("SELECT * FROM Expense")
    ArrayList<Expense> getAllExpenses();

    // insert a expense
    @Insert
    boolean addAExpense(Expense expense);

    @Upsert
    // update an expense details
    boolean updateAnExpense(int expId, Expense expense);

    @Delete
    // delete an expense
    boolean deleteExpense(int expId, Expense expense);

}
