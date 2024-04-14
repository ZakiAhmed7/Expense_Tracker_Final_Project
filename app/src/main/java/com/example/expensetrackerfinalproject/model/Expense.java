package com.example.expensetrackerfinalproject.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Expense {
    @PrimaryKey
    private int expenseID;
    @ColumnInfo (name = "transaction date")
    private String transactionDate;
    @ColumnInfo (name = "amount")
    private float amount;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo (name = "description")
    private String description;

    public Expense(int expenseID, String transactionDate, float amount, String title, String description) {
        this.expenseID = expenseID;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.title = title;
        this.description = description;
    }

    public int getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
