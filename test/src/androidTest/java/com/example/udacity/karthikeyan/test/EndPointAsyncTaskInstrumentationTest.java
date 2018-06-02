package com.example.udacity.karthikeyan.test;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class EndPointAsyncTaskInstrumentationTest {

    @Test
    public void instrumentationTest() throws Exception {
        EndPointAsyncTaskTest aTest =  new EndPointAsyncTaskTest();
        aTest.execute(InstrumentationRegistry.getContext());
        String joke = aTest.get(5, TimeUnit.SECONDS);
        Assert.assertEquals(5,joke.length());
    }
}
