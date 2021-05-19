package com.example.mynavigation.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynavigation.Adapters.ConcertAdapter;
import com.example.mynavigation.Model.Concert;
import com.example.mynavigation.R;
import com.example.mynavigation.viewModel.ConcertViewModel;

import java.util.ArrayList;

public class ConcertFragment extends Fragment {

    private ConcertViewModel concertViewModel;
    private RecyclerView recyclerViewConcerts;
    private ArrayList<Concert> concerts = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        concertViewModel =
                new ViewModelProvider(this).get(ConcertViewModel.class);
        View root = inflater.inflate(R.layout.fragment_concert, container, false);

        System.out.println("Events: " + concerts);
        concertViewModel.init();
        concertViewModel.concerts();
        recyclerViewConcerts = root.findViewById(R.id.recyclerview_concerts);
        recyclerViewConcerts.setHasFixedSize(true);
        recyclerViewConcerts.setLayoutManager(new LinearLayoutManager(getContext()));

        ConcertAdapter adapter = new ConcertAdapter(concertViewModel.concerts().getValue());
        recyclerViewConcerts.setAdapter(adapter);

        return root;
    }

}