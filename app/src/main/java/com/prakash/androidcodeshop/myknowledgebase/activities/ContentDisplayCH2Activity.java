package com.prakash.androidcodeshop.myknowledgebase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.prakash.androidcodeshop.myknowledgebase.R;
import com.prakash.androidcodeshop.myknowledgebase.codestrings.ChapterTwo;

public class ContentDisplayCH2Activity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_display_ch2);

        intent = new Intent(this, CodeDisplayDialogActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ImageButton textView = findViewById(R.id.textview_ib);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("code", "textView");
                startActivity(intent);
            }
        });
        ImageButton textViewBold = findViewById(R.id.textviewbold_ib);
        textViewBold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("code", "textViewBold");
                startActivity(intent);
            }
        });
        ImageButton textViewItalic = findViewById(R.id.textviewitalic_ib);
        textViewItalic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("code", "textViewItalic");
                startActivity(intent);
            }
        });
        ImageButton textViewLink = findViewById(R.id.textviewlinkify_ib);
        textViewLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("code", "textWithLink");
                startActivity(intent);
            }
        });
        ImageButton textViewLetterSpacing = findViewById(R.id.tvw_lineSpacing_and_padding_ib);
        textViewLetterSpacing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("code", "textViewLetterSpacing");
                startActivity(intent);
            }
        });

        ImageButton editTextName = findViewById(R.id.edittext_name);
        editTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("code", "editTextName");
                startActivity(intent);
            }
        });

        ImageButton editTextPassword = findViewById(R.id.edittext_password);
        editTextPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("code", "editTextPassword");
                startActivity(intent);
            }
        });
        ImageButton editTextPhone = findViewById(R.id.edittext_phone);
        editTextPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("code", "editTextPhone");
                startActivity(intent);
            }
        });
    }
}
