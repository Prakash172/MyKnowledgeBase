package com.prakash.androidcodeshop.myknowledgebase.repository;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.prakash.androidcodeshop.myknowledgebase.codestrings.ChapterTwo;

public class CodeDisplayRepository  {

    private static CodeDisplayRepository codeDisplayRepository;
    private MutableLiveData<String> codeStringMutableLiveData;
    private Context context;

    private CodeDisplayRepository() {
        codeStringMutableLiveData = new MutableLiveData<>();
    }

    public static CodeDisplayRepository getInstance(){
        if(codeDisplayRepository == null) codeDisplayRepository = new CodeDisplayRepository();
        return codeDisplayRepository;
    }

    public MutableLiveData<String> getCodeStringMutableLiveData() {
        if(((Activity)context).getIntent() != null) {
            String code = ChapterTwo.getCode(((Activity) context).getIntent().getStringExtra("code"));
            codeStringMutableLiveData.setValue(code);
        }else codeStringMutableLiveData.setValue("No Code available");
        return codeStringMutableLiveData;
    }

    public void setContext(Context applicationContext) {
        this.context = applicationContext;
    }
}
