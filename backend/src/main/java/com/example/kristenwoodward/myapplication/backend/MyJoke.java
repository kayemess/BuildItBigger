package com.example.kristenwoodward.myapplication.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyJoke {

    private String myJoke;

    public String getData() {
        return myJoke;
    }

    public void setData(String data) {
        myJoke = data;
    }
}