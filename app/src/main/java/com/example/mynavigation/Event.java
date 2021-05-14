package com.example.mynavigation;

public class Event {

    private String title;
    private String eventDescription;

    public Event(String titleE, String eventD) {
        title = titleE;
        eventDescription = eventD;

    }

    public String getTitle() {
        return title;
    }

    public String getEventDescription() {
        return eventDescription;
    }

}
