package com.example.Tunexa;

public class DataModel {

    private String title;
    private String image;
    private String artist;

    public DataModel(){

    }

    public DataModel(String title, String image, String artist) {
        this.title = title;
        this.image = image;
        this.artist = artist;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getImage() { return image; }

    public void setImage(String image){
        this.image = image;
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

}
