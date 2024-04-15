package com.example.expensetrackerfinalproject.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.expensetrackerfinalproject.R;
import com.example.expensetrackerfinalproject.model.Expense;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {

    private List<Expense> expenseList;

    public ExpenseAdapter(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_item_layout, parent, false);
        return new ExpenseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        Expense expense = expenseList.get(position);

        holder.tvAmount.setText("$" + String.valueOf(expense.getAmount()));
        holder.tvTitle.setText(expense.getTitle());
        holder.tvDate.setText(expense.getTransactionDate());

        holder.btnViewDetails.setOnClickListener( v-> {
            Toast.makeText(v.getContext(), "Showing details", Toast.LENGTH_SHORT);
        });

    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public static class ExpenseViewHolder extends RecyclerView.ViewHolder {
        public TextView tvAmount, tvTitle, tvDate;
         public Button btnViewDetails;
        public ExpenseViewHolder(View view) {
            super(view);
            tvAmount = view.findViewById(R.id.expense_amount);
            tvTitle = view.findViewById(R.id.expense_category);
            tvDate = view.findViewById(R.id.expense_date);
            btnViewDetails = view.findViewById(R.id.view_details_button);

        }
    }
}