package com.example.android.jokeuilibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by kristenwoodward on 2/23/17.
 */

public class JavaUI extends AppCompatActivity {

    public static final String JOKE_INTENT_EXTRAS = "joke_intent_extras";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_display);
        TextView jokeTextView = (TextView) findViewById(R.id.joke_container);

        Intent passedIntent = getIntent();

        if(passedIntent.hasExtra(JOKE_INTENT_EXTRAS)){
            String joke = passedIntent.getStringExtra(JOKE_INTENT_EXTRAS);
            jokeTextView.setText(joke);
        }
    }
}
