package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.android.jokeuilibrary.JavaUI;
import com.example.kristenwoodward.myapplication.backend.myApi.MyApi;
import com.example.kristenwoodward.myapplication.backend.myApi.model.MyJoke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static com.example.android.jokeuilibrary.JavaUI.JOKE_INTENT_EXTRAS;

/**
 * Created by kristenwoodward on 2/24/17.
 */

public class GetJokeTask extends AsyncTask<Void,String,String> {

    private static MyApi myApiService = null;
    private OnTaskCompleted mListener;

    private Random rand;

    public GetJokeTask(OnTaskCompleted listener) {
        mListener = listener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            rand = new Random();
            int randomInt = rand.nextInt(9);
            return myApiService.getJoke(randomInt).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        mListener.OnTaskCompleted(result);
    }
}


