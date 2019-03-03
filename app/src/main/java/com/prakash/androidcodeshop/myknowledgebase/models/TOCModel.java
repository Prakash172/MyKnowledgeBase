package com.prakash.androidcodeshop.myknowledgebase.models;

public class TOCModel {

    private String chapterName;
    private float rating;

    public String getChapterName() {
        return chapterName;
    }

    public float getRating() {
        return rating;
    }

    public TOCModel(String chapterName, float rating) {
        this.chapterName = chapterName;
        this.rating = rating;
    }
}
