package com.example.android.oyo;

import android.content.Intent;
import android.graphics.Typeface;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    Calendar c;
    int timeOfDay;
    private TextView mTextViewName;
    String name;
    String welcomeMessage;
    Typeface custom_font;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        c = Calendar.getInstance();
        timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        name =  getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getString("name", null);

        mTextViewName = (TextView) findViewById(R.id.text_view_name);

        custom_font = Typeface.createFromAsset(getAssets(), "fonts/anagram.ttf");
        mTextViewName.setTypeface(custom_font);

        if(timeOfDay >= 0 && timeOfDay < 12){
            welcomeMessage = "Good Morning";
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            welcomeMessage = "Good Afternoon";
        }else if(timeOfDay >= 16 && timeOfDay < 21){
            welcomeMessage = "Good Evening";
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            welcomeMessage = "Good Night";
        }
        mTextViewName.setText(welcomeMessage+" "+name);






    }
}
