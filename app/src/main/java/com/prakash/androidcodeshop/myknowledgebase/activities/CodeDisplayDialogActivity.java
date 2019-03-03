package com.prakash.androidcodeshop.myknowledgebase.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.prakash.androidcodeshop.myknowledgebase.R;
import com.prakash.androidcodeshop.myknowledgebase.codestrings.ChapterTwo;
import com.prakash.androidcodeshop.myknowledgebase.viewmodel.CodeDisplayViewModel;

import java.util.logging.XMLFormatter;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.classifier.CodeProcessor;

public class CodeDisplayDialogActivity extends AppCompatActivity {

    private CodeView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_display_dialog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CodeProcessor.init(this);
        textView = findViewById(R.id.code_display_tv);

        CodeDisplayViewModel codeDisplayViewModel = ViewModelProviders.of(this).get(CodeDisplayViewModel.class);
        codeDisplayViewModel.init(this);
        codeDisplayViewModel.getCodeStringMutableLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                    textView.setCode(s);
            }
        });

//        Intent data = getIntent();
//        if(data != null && data.getStringExtra("code") != null) {
//            textView.setCode(ChapterTwo.getCode(getIntent().getStringExtra("code")));
//        }else textView.setCode("Code not available");
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Label", textView.getOptions().getCode());
                if (clipboard != null) {
                    clipboard.setPrimaryClip(clip);
                }
                Snackbar.make(view, "Content copied successfully", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
