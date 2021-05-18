package com.example.mynavigation.Model;


public class Concert {

    private String titleConcert;
    private String concertDescription;
    private int imageConcert;

    public Concert(String titleC, String concertD, int imageC) {
        this.titleConcert = titleC;
        this.concertDescription = concertD;
        this.imageConcert = imageC;
    }

    public void setTitleConcert(String titleConcert) {
        this.titleConcert = titleConcert;
    }

    public void setConcertDescription(String concertDescription) {
        this.concertDescription = concertDescription;
    }

    public void setImageConcert(int imageConcert) {
        this.imageConcert = imageConcert;
    }

    public String getTitleConcert() {
        return titleConcert;
    }

    public String getConcertDescription() {
        return concertDescription;
    }

    public int getImageConcert() {
        return imageConcert;
    }

}