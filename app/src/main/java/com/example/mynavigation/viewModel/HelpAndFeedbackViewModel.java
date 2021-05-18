package com.example.mynavigation.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HelpAndFeedbackViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HelpAndFeedbackViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Should you have any questions or concerns, please contact us");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

