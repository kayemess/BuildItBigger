package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.jokeuilibrary.JavaUI;

import static com.example.android.jokeuilibrary.JavaUI.JOKE_INTENT_EXTRAS;


public class MainActivity extends AppCompatActivity {

    //static final String JOKE_INTENT_EXTRAS = "joke_intent_extras";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        GetJokeTask getJokeTask = new GetJokeTask(new OnTaskCompleted() {
            @Override
            public void OnTaskCompleted(String result) {
                Intent displayJoke = new Intent(getBaseContext(), JavaUI.class);
                displayJoke.putExtra(JOKE_INTENT_EXTRAS, result);
                startActivity(displayJoke);
            }
        });
        getJokeTask.execute();
    }


}
