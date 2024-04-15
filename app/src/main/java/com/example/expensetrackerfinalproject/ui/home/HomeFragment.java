package com.example.expensetrackerfinalproject.ui.home;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.room.Database;

import com.example.expensetrackerfinalproject.MainActivity;
import com.example.expensetrackerfinalproject.R;
import com.example.expensetrackerfinalproject.database.AppDatabase;
import com.example.expensetrackerfinalproject.databinding.FragmentHomeBinding;
import com.example.expensetrackerfinalproject.model.Expense;
import com.example.expensetrackerfinalproject.ui.adapter.ExpenseAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private Dialog dialog;
    private EditText etTransactionDate, etAmount, etTitle, etDescription;
    private Button cancelButton, saveButton;
    private TextView tvTransactionText;
    ArrayList<Expense> expensesList;
    MainActivity mainActivity;

    AppDatabase appDatabase;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment with data binding.
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        appDatabase = AppDatabase.getInstance(getContext());

        expensesList = new ArrayList<>();

        expensesList = (ArrayList<Expense>) appDatabase.expenseDAO().getAllExpenses();

        for (Expense e: expensesList) {
            Log.d("TAG", e.getExpenseID() +" " + e.getTitle() + " " );
        }

        ExpenseAdapter adapter = new ExpenseAdapter(expensesList);
        binding.summaryRecyclerView.setAdapter(adapter);

        binding.buttonAddExpense.setOnClickListener(v -> {
            openAddExpenseDialog();
        });


        // Return the root view.
        return root;
    }

    private void openAddExpenseDialog() {

        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.add_expense_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        etTransactionDate = dialog.findViewById(R.id.transactionDate_edit_text);
        etAmount = dialog.findViewById(R.id.amount_edit_text);
        etTitle = dialog.findViewById(R.id.title_edit_text);
        etDescription = dialog.findViewById(R.id.description_edit_text);
        tvTransactionText = dialog.findViewById(R.id.transaction_text);

        cancelButton = dialog.findViewById(R.id.cancel_dialog_button);
        saveButton = dialog.findViewById(R.id.save_dialog_button);

        saveButton.setOnClickListener(v -> {
            checkForValidations();
        });

        cancelButton.setOnClickListener(v -> {
            dialog.dismiss();
        });
        dialog.show();
    }

    private void checkForValidations() {
        if (!etTransactionDate.getText().toString().isEmpty() &&
                etTitle.getText().toString().isEmpty() &&
                etAmount.getText().toString().isEmpty() &&
                etDescription.getText().toString().isEmpty()) {

            mainActivity.addAExpense(new Expense(etTransactionDate.getText().toString(), Float.parseFloat(etAmount.getText().toString()), etTitle.getText().toString(), etDescription.getText().toString()));

        } else {
            tvTransactionText.setVisibility(View.VISIBLE);
            tvTransactionText.setText("Enter all the fields");
        }
    }

    // onDestroyView is called when the view hierarchy associated with the fragment is being removed.
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Nullify the binding when the view is destroyed to avoid memory leaks.
        binding = null;
    }
}
