package com.prakash.androidcodeshop.myknowledgebase.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.prakash.androidcodeshop.myknowledgebase.R;
import com.prakash.androidcodeshop.myknowledgebase.activities.AndroidTOCActivity;
import com.prakash.androidcodeshop.myknowledgebase.models.SubjectDataModel;

import java.util.ArrayList;

public class SubjectGridAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<SubjectDataModel> subjects;

    public SubjectGridAdapter(Context mContext, ArrayList<SubjectDataModel> subjects) {
        this.mContext = mContext;
        this.subjects = subjects;
    }

    @Override
    public int getCount() {
        return subjects.size();
    }

    @Override
    public Object getItem(int i) {
        return subjects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(mContext).inflate(R.layout.subject_item_view,viewGroup,false);
        ImageView subjectImage = view.findViewById(R.id.subject_iv);
        RatingBar subjectRating = view.findViewById(R.id.subject_rating_bar);
        CardView parent = view.findViewById(R.id.subject_grid_parent_cv);
        subjectImage.setBackground(mContext.getResources().getDrawable(subjects.get(i).getImageID()));
        subjectRating.setRating(subjects.get(i).getRating());

        //listeners code
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Card "+i+" is clicked", Toast.LENGTH_SHORT).show();
                switch (i){
                    case 0:
                        Intent androidIntent = new Intent(mContext, AndroidTOCActivity.class);
                        androidIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        mContext.startActivity(androidIntent);
                        break;
                }
            }
        });
        return view;
    }
}
