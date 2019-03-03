package com.prakash.androidcodeshop.myknowledgebase.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;

import com.prakash.androidcodeshop.myknowledgebase.activities.CodeDisplayDialogActivity;
import com.prakash.androidcodeshop.myknowledgebase.repository.CodeDisplayRepository;

public class CodeDisplayViewModel extends AndroidViewModel {

    private MutableLiveData<String> codeStringMutableLiveData;
    private CodeDisplayRepository codeDisplayRepository;
    Context context;
    public LiveData<String> getCodeStringMutableLiveData() {
        return codeStringMutableLiveData;
    }
    public void init(Context context){
        if(codeStringMutableLiveData!=null)return;
        codeDisplayRepository = CodeDisplayRepository.getInstance();
        codeDisplayRepository.setContext(context);
        codeStringMutableLiveData = codeDisplayRepository.getCodeStringMutableLiveData();
    }
    public CodeDisplayViewModel(@NonNull Application application) {
        super(application);
    }
}
