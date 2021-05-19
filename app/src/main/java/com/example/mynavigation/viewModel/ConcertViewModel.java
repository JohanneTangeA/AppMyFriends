package com.example.mynavigation.viewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.mynavigation.Model.Concert;
import com.example.mynavigation.Repository.ConcertRepository;


import java.util.ArrayList;

public class ConcertViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Concert>> concert;
    private ConcertRepository concertRepository;

    public ConcertViewModel() {
        concertRepository = ConcertRepository.getInstance();
    }

    public void init(){
        concert = ConcertRepository.getInstance().getConcerts();
    }

    public LiveData<ArrayList<Concert>> concerts(){
        return concertRepository.getConcerts();
    }
}