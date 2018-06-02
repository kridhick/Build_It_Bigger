package com.example.udacity.karthikeyan.jokelib;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class JokeGenerator {

    List<String> mJokeList = asList("joke1", "joke2", "joke3","joke4","joke5", "joke6");


    public String getJoke()
    {
        int mRandomInt = new Random().nextInt(mJokeList.size());
        return mJokeList.get(mRandomInt);
    }
}
