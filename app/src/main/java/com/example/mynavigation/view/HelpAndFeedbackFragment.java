package com.example.mynavigation.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mynavigation.R;
import com.example.mynavigation.viewModel.HelpAndFeedbackViewModel;

public class HelpAndFeedbackFragment extends Fragment {

    private HelpAndFeedbackViewModel helpAndFeedbackViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        helpAndFeedbackViewModel =
                new ViewModelProvider(this).get(HelpAndFeedbackViewModel.class);
        View root = inflater.inflate(R.layout.fragment_helpfeedback, container, false);
        final TextView textView = root.findViewById(R.id.text_helpfeedback);
        helpAndFeedbackViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}