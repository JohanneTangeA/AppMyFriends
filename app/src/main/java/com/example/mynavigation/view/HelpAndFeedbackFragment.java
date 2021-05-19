package com.example.mynavigation.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mynavigation.Model.HelpAndFeedback;
import com.example.mynavigation.R;
import com.example.mynavigation.viewModel.HelpAndFeedbackViewModel;

public class HelpAndFeedbackFragment extends Fragment {

    private HelpAndFeedbackViewModel helpAndFeedbackViewModel;
    private TextView emailTextView, helpTextView, phoneTextView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        helpAndFeedbackViewModel =
                new ViewModelProvider(this).get(HelpAndFeedbackViewModel.class);
        View root = inflater.inflate(R.layout.fragment_helpfeedback, container, false);
        emailTextView = root.findViewById(R.id.text_email);
        helpTextView = root.findViewById(R.id.text_helpfeedback);
        phoneTextView = root.findViewById(R.id.text_phone);

        helpAndFeedbackViewModel.getText().observe(getViewLifecycleOwner(), new Observer<HelpAndFeedback>() {
            @Override
            public void onChanged(HelpAndFeedback helpAndFeedback) {
                if(helpAndFeedback != null){
                    String helpText = helpAndFeedback.getHelpText();
                    String emailText = helpAndFeedback.getEmailText();
                    String phoneText = helpAndFeedback.getPhoneText();
                    emailTextView.setText(emailText);
                    phoneTextView.setText(phoneText);
                    helpTextView.setText(helpText);
                }
                else {
                    Toast.makeText(getContext(),"Something went wrong", Toast.LENGTH_LONG).show();
                }
            }
        });

        return root;
    }

}