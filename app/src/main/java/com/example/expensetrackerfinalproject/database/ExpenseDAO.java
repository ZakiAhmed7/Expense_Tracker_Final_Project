
package com.example.expensetrackerfinalproject.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Upsert;

import com.example.expensetrackerfinalproject.model.Expense;

import java.util.ArrayList;
https://github.com/ZakiAhmed7/Expense_Tracker_Final_Project/pull/9/conflict?name=app%252Fsrc%252Fmain%252Fjava%252Fcom%252Fexample%252Fexpensetrackerfinalproject%252Fdatabase%252FExpenseDAO.java&ancestor_oid=4889195f396aa523d1a20c8f6cbe847e8c2d4b1a&base_oid=61e6f677f5bcf35a413595d582076d9d4b41da45&head_oid=4344217603b8ebcc3890b42a4a57acb0c7416331import java.util.List;

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