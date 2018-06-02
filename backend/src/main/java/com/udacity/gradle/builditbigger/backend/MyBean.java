package com.udacity.gradle.builditbigger.backend;

import com.example.udacity.karthikeyan.jokelib.JokeGenerator;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        myData = new JokeGenerator().getJoke();
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}