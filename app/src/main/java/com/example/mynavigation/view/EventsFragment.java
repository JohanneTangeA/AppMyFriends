package com.example.mynavigation.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynavigation.Adapters.EventAdapter;
import com.example.mynavigation.Model.Event;
import com.example.mynavigation.R;
import com.example.mynavigation.viewModel.EventsViewModel;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    private EventsViewModel eventsViewModel;
    private RecyclerView recyclerViewEvents;
    private ArrayList<Event> events = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        eventsViewModel =
                new ViewModelProvider(this).get(EventsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_events, container, false);

        System.out.println("Events: " + events);
        eventsViewModel.init();
        eventsViewModel.events();
        recyclerViewEvents = root.findViewById(R.id.recyclerview_events);
        recyclerViewEvents.setHasFixedSize(true);
        recyclerViewEvents.setLayoutManager(new LinearLayoutManager(getContext()));

        EventAdapter adapter = new EventAdapter(eventsViewModel.events().getValue());
        recyclerViewEvents.setAdapter(adapter);

        return root;
    }

}