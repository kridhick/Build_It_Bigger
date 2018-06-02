package com.example.udacity.karthikeyan.showlib;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    public static String MY_INTENT_STRING = "GCE_PASSED_JOKE_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String receivedJoke = getIntent().getStringExtra(MY_INTENT_STRING);
        TextView displayJokeTextView = findViewById(R.id.txtDisplayJoke);
        if(!receivedJoke.isEmpty())
        {
            displayJokeTextView.setText(receivedJoke);
        }


    }

}
