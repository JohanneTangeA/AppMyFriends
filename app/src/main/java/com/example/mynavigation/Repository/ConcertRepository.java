package com.example.mynavigation.Repository;


import androidx.lifecycle.MutableLiveData;

import com.example.mynavigation.Model.Concert;
import com.example.mynavigation.R;

import java.util.ArrayList;

public class ConcertRepository {

    private static ConcertRepository instance;
    private ArrayList<Concert>  concerts = new ArrayList<>();
    private MutableLiveData<ArrayList<Concert>> concert = new MutableLiveData<>();

    public static synchronized ConcertRepository getInstance() {
        if (instance == null) {
            instance = new ConcertRepository();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<Concert>> getConcerts(){
        loadEvents();
        concert.setValue(concerts);
        return concert;
    }


    public void loadEvents(){
        concerts.add(new Concert("Thomas Helmig", "For the first time, Thomas Helmig occupies a Danish stadium to fire off his very own concert. Bring a new friend!", R.drawable.c1));
        concerts.add(new Concert("Sanne Salomonsen", "Get ready for the next concert of Sanne Salomonsen. The queen will play on 12 July to 'Grøn Koncert'. ", R.drawable.c2));
        concerts.add(new Concert("Magtens Korridor", "Do not miss the next concert with the 'Magtens Korridor'. The concert will be at Train in Århus on 6 June.", R.drawable.c3));
        concerts.add(new Concert("Phlake", "Phlake has been on an impressive journey with the hit single ‘Pregnant’.Join the concert at Train on 5 July.", R.drawable.c4));
        concerts.add(new Concert("Rasmus Seebach", "This summer, Rasmus will play one of the special Family Concerts in Aarhus on 17 July. This is a fun day for everyone!", R.drawable.c5));
        concerts.add(new Concert("Marie Key", "Marie Key will be playing on a stage in 'Musikhusparken', when she gives a solo concert in the open air on 24 June.", R.drawable.c6));
        concerts.add(new Concert("Nik & Jay", "Take a unique journey and feel Nik & Jay's words and tones, stories and songs as they play at Voxhall on 6 August.", R.drawable.c7));
        concerts.add(new Concert("Lukas Graham", "Join Lukas Graham's exclusive concert when he plays at Ceres Park Arena on 8 July. He promises a cool party.", R.drawable.c8));
        concerts.add(new Concert("Christopher", "Christopher is back with new music and a concert at Tangkrogen in Aarhus on 30 July. Bring a new friend and sing along!", R.drawable.c9));
        concerts.add(new Concert("Jonny Madsen", "He is known for his surrealist lyrics and captivating concerts. It is clearly an exciting and fun experience with a new friend on 20 July!", R.drawable.c10));




    }

}
