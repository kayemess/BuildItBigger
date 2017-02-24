package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.android.jokeuilibrary.JavaUI;
import com.example.kristenwoodward.myapplication.backend.myApi.MyApi;
import com.example.kristenwoodward.myapplication.backend.myApi.model.MyBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import static com.example.android.jokeuilibrary.JavaUI.JOKE_INTENT_EXTRAS;

/**
 * Created by kristenwoodward on 2/24/17.
 */

public class JokeTask{

    private static MyApi myApiService = null;
    private String mRandomJoke;
    Context mContext;
    Activity mActivity;

    JokeTask(Context context, Activity activity){
        mContext = context;
        mActivity = activity;
    }

    public void getRandomJoke(Object[] objects){
        GetJokeTask getJokeTask = new GetJokeTask();
        getJokeTask.execute(objects);

        //return mRandomJoke;
    }

    class GetJokeTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
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

            //context = params[0].first;
            Object name = params[0];

            try {
                return myApiService.getJoke(String.valueOf(name)).execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(Object result) {
            mRandomJoke = String.valueOf(result);
            Log.i("AsyncTask: ", mRandomJoke);

            Intent displayJoke = new Intent(mContext, JavaUI.class);
            displayJoke.putExtra(JOKE_INTENT_EXTRAS,mRandomJoke);
            mActivity.startActivity(displayJoke);
        }
    }

}
