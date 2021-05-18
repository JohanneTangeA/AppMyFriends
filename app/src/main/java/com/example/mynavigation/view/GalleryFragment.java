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
import com.example.mynavigation.Adapters.EventAdapter;
import com.example.mynavigation.Model.Concert;
import com.example.mynavigation.Model.Event;
import com.example.mynavigation.R;
import com.example.mynavigation.viewModel.EventsViewModel;
import com.example.mynavigation.viewModel.GalleryViewModel;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private RecyclerView recyclerViewConcerts;
    private ArrayList<Concert> concerts = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        System.out.println("Events: " + concerts);
        galleryViewModel.init();
        galleryViewModel.concerts();
        recyclerViewConcerts = root.findViewById(R.id.recyclerview_concerts);
        recyclerViewConcerts.setHasFixedSize(true);
        recyclerViewConcerts.setLayoutManager(new LinearLayoutManager(getContext()));

        ConcertAdapter adapter = new ConcertAdapter(galleryViewModel.concerts().getValue());
        recyclerViewConcerts.setAdapter(adapter);

        return root;
    }

}