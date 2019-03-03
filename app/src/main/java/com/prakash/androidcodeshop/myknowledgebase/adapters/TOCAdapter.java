package com.prakash.androidcodeshop.myknowledgebase.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.prakash.androidcodeshop.myknowledgebase.R;
import com.prakash.androidcodeshop.myknowledgebase.activities.ContentDisplayCH1Activity;
import com.prakash.androidcodeshop.myknowledgebase.activities.ContentDisplayCH2Activity;
import com.prakash.androidcodeshop.myknowledgebase.models.TOCModel;

import java.util.ArrayList;

public class TOCAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<TOCModel> chapters;

    public TOCAdapter(Context mContext, ArrayList<TOCModel> chapters) {
        this.mContext = mContext;
        this.chapters = chapters;
    }

    @Override
    public int getCount() {
        return chapters.size();
    }

    @Override
    public Object getItem(int position) {
        return chapters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(mContext).inflate(R.layout.toc_item_view, viewGroup, false);
        TextView chapterName = view.findViewById(R.id.topic_name);
        RatingBar topicRating = view.findViewById(R.id.topic_rating_bar);

        chapterName.setText(chapters.get(position).getChapterName());
        topicRating.setRating(chapters.get(position).getRating());

        LinearLayout parent = view.findViewById(R.id.parent_llo);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(mContext, ContentDisplayCH1Activity.class);
                        break;
                    case 1:
                        intent = new Intent(mContext, ContentDisplayCH2Activity.class);
                        break;
                    default:
                        Toast.makeText(mContext,  "Content is coming soon", Toast.LENGTH_SHORT).show();
                }
                if (intent != null) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    mContext.startActivity(intent);
                }
            }
        });
        return view;
    }
}
