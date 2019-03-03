package com.prakash.androidcodeshop.myknowledgebase.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ListView;

import com.prakash.androidcodeshop.myknowledgebase.R;
import com.prakash.androidcodeshop.myknowledgebase.adapters.TOCAdapter;
import com.prakash.androidcodeshop.myknowledgebase.models.TOCModel;
import com.prakash.androidcodeshop.myknowledgebase.viewmodel.TOCViewModel;

import java.util.ArrayList;

public class AndroidTOCActivity extends AppCompatActivity {

    private TOCAdapter adapter;
    private ArrayList<TOCModel> chapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_toclist);

        Toolbar toolbar = findViewById(R.id.toc_toolbar);
        toolbar.setTitle("Table of Contents");
        setSupportActionBar(toolbar);

        chapters = new ArrayList<>();
        ListView chapterListView = findViewById(R.id.toc_list_view);
        chapterListView.setLayoutMode(ViewGroup.LAYOUT_MODE_CLIP_BOUNDS);
        adapter = new TOCAdapter(this, chapters);
        chapterListView.setAdapter(adapter);

        TOCViewModel tocViewModel = ViewModelProviders.of(this).get(TOCViewModel.class);
        tocViewModel.init();

        tocViewModel.getStringMutableLiveData().observe(this, new Observer<ArrayList<TOCModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<TOCModel> tocModels) {
                chapters.clear();
                chapters.addAll(tocModels);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
