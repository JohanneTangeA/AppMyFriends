package com.example.mynavigation.Model;

public class Event {

    private String title;
    private String eventDescription;
    private int image;

    public Event(String titleE, String eventD, int image) {
        this.title = titleE;
        this.eventDescription = eventD;
        this.image = image;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public int getImage(){
        return image;
    }

}
