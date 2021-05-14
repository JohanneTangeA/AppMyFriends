package com.example.mynavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mynavigation.ui.home.HomeViewModel;

public class DetailFragment extends Fragment {

    TextView name;
    ImageView icon;
    TextView desc;
    TextView numb;
    HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.detail_fragment, container, false);

        name = root.findViewById(R.id.name);
        icon = root.findViewById(R.id.icon);
        desc = root.findViewById(R.id.desc);
        numb = root.findViewById(R.id.numb);

        User user  = homeViewModel.getUser();
        name.setText(user.getName());
        icon.setImageResource(user.getIconId());
        desc.setText(user.getDesc());
        numb.setText(user.getNumb());

        return root;

    }

}