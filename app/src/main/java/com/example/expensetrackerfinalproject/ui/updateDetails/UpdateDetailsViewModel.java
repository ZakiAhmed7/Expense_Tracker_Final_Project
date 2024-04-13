package com.example.expensetrackerfinalproject.ui.updateDetails;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UpdateDetailsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public UpdateDetailsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}