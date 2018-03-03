package com.example.android.oyo;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView mOyo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity","yes");

        mOyo = (TextView) findViewById(R.id.oyo_main) ;
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/anagram.ttf");
        mOyo.setTypeface(custom_font);
        mOyo.setLetterSpacing(-0.03f);

        if (isFirstRun) {
            //show start activity

            Intent intent = new Intent(MainActivity.this, FirstRunOneActivity.class);
            new Timer().schedule(new TimerTask(){
                public void run() {
                    MainActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            startActivity(new Intent(MainActivity.this, FirstRunOneActivity.class));
                            overridePendingTransition(0, 0);
                            finish();
                        }
                    });
                }
            }, 3000);

        }
        else {
            final Intent intent = new Intent(this,FirstActivity.class);
            new Timer().schedule(new TimerTask(){
                public void run() {
                    MainActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }, 3000);

        }
    }
}
