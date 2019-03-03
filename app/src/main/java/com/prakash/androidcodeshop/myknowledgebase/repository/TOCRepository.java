package com.prakash.androidcodeshop.myknowledgebase.repository;

import android.arch.lifecycle.MutableLiveData;

import com.prakash.androidcodeshop.myknowledgebase.codestrings.AndroidTocString;
import com.prakash.androidcodeshop.myknowledgebase.models.TOCModel;

import java.util.ArrayList;

public class TOCRepository {

    private MutableLiveData<ArrayList<TOCModel>> stringMutableLiveData;

    private static TOCRepository repoInstance;
    private ArrayList<TOCModel> chapterList;

    public TOCRepository() {
        stringMutableLiveData = new MutableLiveData<>();
    }

    public static TOCRepository getInstance() {
        if (repoInstance == null)
            repoInstance = new TOCRepository();
        return repoInstance;
    }

    public MutableLiveData<ArrayList<TOCModel>> getStringMutableLiveData() {
        stringMutableLiveData.setValue(fetchTocData());
        return stringMutableLiveData;
    }

    private ArrayList<TOCModel> fetchTocData(){
        chapterList = new ArrayList<>();
        for(int i = 0; i < AndroidTocString.androidToc.length ; i++){
            chapterList.add(new TOCModel(AndroidTocString.androidToc[i],AndroidTocString.ratings[i]));
        }

        return chapterList;
    }
}
