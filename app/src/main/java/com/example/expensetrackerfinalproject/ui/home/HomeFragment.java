package com.example.expensetrackerfinalproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.expensetrackerfinalproject.R;
import com.example.expensetrackerfinalproject.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    // onCreateView is called to have the fragment instantiate its user interface view.
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // ViewModelProvider connects your ViewModel to the UI.
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        // Inflate the layout for this fragment with data binding.
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Set up the RecyclerView with a LinearLayoutManager and adapter.
        binding.summaryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Set the text of the total expenditure TextView.
        binding.totalExpenditure.setText("$100");

        // Initialize the Spinner for selecting time frames.
        // Commenting out Spinner setup code
        /*
        Spinner spinnerTimeFrame = binding.spinnerTimeFrame;
        ArrayAdapter<CharSequence> timeFrameAdapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.time_frame_options)
        );
        timeFrameAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerTimeFrame.setAdapter(timeFrameAdapter);

        // Handle selection events on the Spinner.
        spinnerTimeFrame.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) view).setTextColor(getResources().getColor(android.R.color.white));
                String selected = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Action to take when no item is selected. Placeholder for required method.
            }
        });
        */

//        // Observe changes to text LiveData in the ViewModel and update UI.
//        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> binding.textHome.setText(s));

        // Return the root view.
        return root;
    }

    // onDestroyView is called when the view hierarchy associated with the fragment is being removed.
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Nullify the binding when the view is destroyed to avoid memory leaks.
        binding = null;
    }
}
