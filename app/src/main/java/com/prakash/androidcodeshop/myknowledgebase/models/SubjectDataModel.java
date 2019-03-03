package com.prakash.androidcodeshop.myknowledgebase.models;

public class SubjectDataModel {

    private int imageID;
    private float rating;

    public SubjectDataModel(int imageID, float rating) {
        this.imageID = imageID;
        this.rating = rating;
    }

    public int getImageID() {
        return imageID;
    }

    public float getRating() {
        return rating;
    }
}
