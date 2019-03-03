package com.prakash.androidcodeshop.myknowledgebase.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.prakash.androidcodeshop.myknowledgebase.models.TOCModel;
import com.prakash.androidcodeshop.myknowledgebase.repository.TOCRepository;

import java.util.ArrayList;

public class TOCViewModel extends AndroidViewModel {


    ArrayList<TOCModel> chapterList;

    public TOCViewModel(@NonNull Application application) {
        super(application);
    }

    private MutableLiveData<ArrayList<TOCModel>> stringMutableLiveData;
    private TOCRepository mRepo;

    public void init() {
        if (stringMutableLiveData != null) return;
        mRepo = TOCRepository.getInstance();
        stringMutableLiveData = mRepo.getStringMutableLiveData();
    }

    public LiveData<ArrayList<TOCModel>> getStringMutableLiveData() {
        return stringMutableLiveData;
    }


}
