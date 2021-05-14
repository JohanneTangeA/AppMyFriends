package com.example.mynavigation.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynavigation.Event;
import com.example.mynavigation.EventAdapter;
import com.example.mynavigation.R;


import java.util.ArrayList;

public class GalleryFragment extends Fragment implements EventAdapter.OnListItemClickListener {

    public GalleryViewModel galleryViewModel;

    RecyclerView mEventList;
    EventAdapter mEventAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        mEventList = root.findViewById(R.id.ev);
        mEventList.hasFixedSize();
        mEventList.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Event> events = new ArrayList<>();

        events.add(new Event("Evdddent", "evennnntsss"));
        events.add(new Event("Evsssent", "evennnntvvvsss"));
        events.add(new Event("Evdddent", "evedddnnnntsss"));

        mEventAdapter = new EventAdapter(events, this);
        mEventList.setAdapter(mEventAdapter);

        return root;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        int eventNumber = clickedItemIndex + 1;
        Toast.makeText(getContext(), "User Number: " + eventNumber, Toast.LENGTH_SHORT).show();
    }

}