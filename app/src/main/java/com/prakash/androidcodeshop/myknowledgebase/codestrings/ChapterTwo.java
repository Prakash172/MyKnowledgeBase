package com.prakash.androidcodeshop.myknowledgebase.codestrings;

import android.widget.Switch;

public class ChapterTwo {

    String name = "";
    public static String getCode(String str){
        switch (str){
            case "textView":return "<TextView\n" +
                        "    android:text=\"@string/simple_text\"\n" +
                        "    android:layout_width=\"wrap_content\"\n" +
                        "    android:layout_height=\"wrap_content\" />";
            case "textViewBold":return "<TextView\n" +
                    "    android:layout_weight=\"1\"\n" +
                    "    android:textColor=\"@color/Black\"\n" +
                    "    android:textStyle=\"bold\"\n" +
                    "    android:text=\"@string/bold_text\"\n" +
                    "    android:layout_width=\"wrap_content\"\n" +
                    "    android:layout_height=\"wrap_content\" />";
            case "textViewItalic": return "<TextView\n" +
                    "    android:layout_weight=\"1\"\n" +
                    "    android:textColor=\"@color/Black\"\n" +
                    "    android:textStyle=\"italic\"\n" +
                    "    android:text=\"@string/italic_text\"\n" +
                    "    android:layout_width=\"wrap_content\"\n" +
                    "    android:layout_height=\"wrap_content\" />";

            case "textViewLetterSpacing": return "<TextView\n" +
                    "    android:layout_weight=\"1\"\n" +
                    "    android:textColor=\"@color/Black\"\n" +
                    "    android:text=\"@string/spacing_text\"\n" +
                    "    android:layout_width=\"0dp\"\n" +
                    "    android:letterSpacing=\"0.1\"\n" +
                    "    android:lineSpacingExtra=\"@dimen/six_dp\"\n" +
                    "    android:layout_height=\"wrap_content\" />";
            case "textWithLink": return "<TextView\n" +
                    "    android:textStyle=\"italic\"\n" +
                    "    android:layout_weight=\"1\"\n" +
                    "    android:textColor=\"@color/Black\"\n" +
                    "    android:text=\"@string/linkified_text\"\n" +
                    "    android:layout_width=\"0dp\"\n" +
                    "    android:autoLink=\"all\"\n" +
                    "    android:layout_height=\"wrap_content\" />";
            case "editTextName": return "<EditText\n" +
                    "    android:layout_weight=\"1\"\n" +
                    "    android:hint=\"Enter the name...\"\n" +
                    "    android:inputType=\"textPersonName\"\n" +
                    "    android:layout_width=\"0dp\"\n" +
                    "    android:layout_height=\"wrap_content\" />";
            case "editTextPassword": return "<EditText\n" +
                    "    android:layout_weight=\"1\"\n" +
                    "    android:hint=\"Enter the password...\"\n" +
                    "    android:inputType=\"password\"\n" +
                    "    android:layout_width=\"0dp\"\n" +
                    "    android:layout_height=\"wrap_content\" />";
            case "editTextPhone": return "<EditText\n" +
                    "    android:layout_weight=\"1\"\n" +
                    "    android:hint=\"Enter the phone...\"\n" +
                    "    android:inputType=\"phone\"\n" +
                    "    android:layout_width=\"0dp\"\n" +
                    "    android:layout_height=\"wrap_content\" />";

            default:return "No Code Found";
        }
    }

}
