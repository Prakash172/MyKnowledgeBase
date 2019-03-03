package com.prakash.androidcodeshop.myknowledgebase.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.prakash.androidcodeshop.myknowledgebase.R;
import com.prakash.androidcodeshop.myknowledgebase.adapters.SubjectGridAdapter;
import com.prakash.androidcodeshop.myknowledgebase.models.SubjectDataModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    GridView subjectGrid;
    int[] imageId = {R.drawable.android_sub_iv, R.drawable.html_five_iv, R.drawable.css_three_iv};
    float[] ratings = {4.0f, 5.0f, 3.5f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.drawer_layout);
        subjectGrid = findViewById(R.id.subject_gridview);
        toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(HomeActivity.this, "Open", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText(HomeActivity.this, "Close", Toast.LENGTH_SHORT).show();
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        // Adapter settings
        ArrayList<SubjectDataModel> subjects = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            subjects.add(new SubjectDataModel(imageId[i], ratings[i]));
        }
        SubjectGridAdapter adapter = new SubjectGridAdapter(this, subjects);
        subjectGrid.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show();
                break;
//            case R.id.navigate:
//                Toast.makeText(this, "Navigate clicked", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.setting:
                Toast.makeText(this, "Setting clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.notification:
                Toast.makeText(this, "notification clicked", Toast.LENGTH_SHORT).show();
                break;
//            case R.id.visited:
//                Toast.makeText(this, "Visited clicked", Toast.LENGTH_SHORT).show();
//                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawers();
        switch (item.getItemId()) {
            case R.id.profile:
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

}
