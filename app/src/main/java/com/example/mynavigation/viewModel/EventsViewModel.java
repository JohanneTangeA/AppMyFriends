package com.example.mynavigation.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mynavigation.Model.Event;
import com.example.mynavigation.Repository.EventRepository;

import java.util.ArrayList;

public class EventsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Event>> event;
    private EventRepository eventRepository;

    public EventsViewModel() {
        eventRepository = EventRepository.getInstance();
    }

    public void init(){
        event = EventRepository.getInstance().getEvents();
    }

    public LiveData<ArrayList<Event>> events(){
        return eventRepository.getEvents();
    }
}