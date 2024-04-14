//package com.example.expensetrackerfinalproject.ui.adapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import com.example.expensetrackerfinalproject.R;
//import com.example.expensetrackerfinalproject.data.Expense;
//import java.util.List;
//
//public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {
//
//    private final List<Expense> expenseList;
//
//    // Constructor
//    public ExpenseAdapter(List<Expense> expenseList) {
//        this.expenseList = expenseList;
//    }
//
//    // Create new views (invoked by the layout manager)
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_item, parent, false);
//        return new ViewHolder(itemView);
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Expense expense = expenseList.get(position);
//        holder.titleTextView.setText(expense.getTitle());
//        holder.dateTextView.setText(expense.getTransactionDate());
//        holder.amountTextView.setText(String.valueOf(expense.getAmount()));
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    @Override
//    public int getItemCount() {
//        return expenseList.size();
//    }
//
//    // Provide a reference to the views for each data item
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        TextView titleTextView;
//        TextView dateTextView;
//        TextView amountTextView;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            titleTextView = itemView.findViewById(R.id.title_text_view);
//            dateTextView = itemView.findViewById(R.id.date_text_view);
//            amountTextView = itemView.findViewById(R.id.amount_text_view);
//        }
//    }
//}
