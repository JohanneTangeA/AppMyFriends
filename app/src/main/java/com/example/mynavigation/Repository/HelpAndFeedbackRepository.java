package com.example.mynavigation.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mynavigation.Model.Event;
import com.example.mynavigation.Model.HelpAndFeedback;
import com.example.mynavigation.R;

public class HelpAndFeedbackRepository {

    private static HelpAndFeedbackRepository instance;
    private HelpAndFeedback helpAndFeedback;
    private MutableLiveData<HelpAndFeedback> help = new MutableLiveData<>();

    public static synchronized HelpAndFeedbackRepository getInstance() {
        if (instance == null) {
            instance = new HelpAndFeedbackRepository();
        }
        return instance;
    }

    public MutableLiveData<HelpAndFeedback> getHelpAndFeedback(){
        loadHelpAndFeedback();
        if(helpAndFeedback != null){
            help.postValue(helpAndFeedback);
        }
            return help;
    }

    public void loadHelpAndFeedback(){
        helpAndFeedback = new HelpAndFeedback("Should you have any questions or concerns please contact us for help", "myFriendsApp@outlook.com", "80 80 80 80");
    }

}