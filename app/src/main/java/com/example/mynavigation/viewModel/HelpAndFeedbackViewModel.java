package com.example.mynavigation.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mynavigation.Model.HelpAndFeedback;
import com.example.mynavigation.Repository.HelpAndFeedbackRepository;

public class HelpAndFeedbackViewModel extends ViewModel {

    private MutableLiveData<HelpAndFeedback> helpAndFeedbackMutableLiveData = new MutableLiveData();
    private HelpAndFeedbackRepository helpAndFeedbackRepository;

    public HelpAndFeedbackViewModel() {
        helpAndFeedbackRepository = HelpAndFeedbackRepository.getInstance();
    }
    public LiveData<HelpAndFeedback> getText() {
        return helpAndFeedbackRepository.getHelpAndFeedback();
    }

}

