package com.example.mynavigation.Repository;


import androidx.lifecycle.MutableLiveData;

import com.example.mynavigation.Model.Event;
import com.example.mynavigation.R;

import java.util.ArrayList;

public class EventRepository {

    private static EventRepository instance;
    private ArrayList<Event> events = new ArrayList<>();
    private MutableLiveData<ArrayList<Event>> event = new MutableLiveData<>();

    public static synchronized EventRepository getInstance() {
        if (instance == null) {
            instance = new EventRepository();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<Event>> getEvents(){
        loadEvents();
        event.setValue(events);
        return event;
    }


    public void loadEvents(){
        events.add(new Event("Tivoli Aarhus", "Tivoli Friheden is a theme park in the center of Aarhus located within walking distance from the city centre", R.drawable.e2));
        events.add(new Event("The Deer Park", "South of the Aarhus city, in the Thors woods which are part of the larger Marselisborg-Moesgaard forest, lies the Deer Park.", R.drawable.e3));
        events.add(new Event("Aros Museum", "ARoS has a large art collection with works from the Danish Golden Age until today, a changing selection of which are on display in the museum halls.", R.drawable.e4));
        events.add(new Event("Botanical Garden", "The Botanical Garden is a green oasis just to the west of Den Gamle By or The Old Town Museum the Urban Museum in the centre of Aarhus.", R.drawable.e1));
        events.add(new Event("Paddle", "Go Paddle - the Kayak Club offers that you and a friends can hire paddle boards and enjoy a lovely trip on the water.", R.drawable.e5));
        events.add(new Event("Moesgaard Museum", "Moesgaard Museum is a Danish regional museum dedicated to archaeology. Bring a friend to a adventure", R.drawable.e6));
        events.add(new Event("Circular bridge", "Imagine a bridge on which you can walk and walk and walk. Without ever reaching the end with a nice friend?", R.drawable.e8));
        events.add(new Event("Golf forrest", "The golf forest is the new indoor adventure golf forest in Aarhus. Bring a friend and play!", R.drawable.e7));

    }

}
