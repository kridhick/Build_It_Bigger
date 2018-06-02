package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    private final String TEST_AD_ID = "ca-app-pub-3940256099942544/1033173712";
    private InterstitialAd mInterstitialAd;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        hideLoadingInfo();

        MobileAds.initialize(this, TEST_AD_ID);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(TEST_AD_ID);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener(){

            @Override
            public void onAdClosed() {
                //user closed the ad - show the joke
                invokeAsyncTask();
                }

            @Override
            public void onAdClicked() {
                Toast.makeText(getBaseContext(), "Thanks for your support!", Toast.LENGTH_LONG).show();
            }
        } );


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

        if(BuildConfig.FLAVOR.equals("pro")) {
            invokeAsyncTask();
        }
        else{
           //free version- its okay to display the ads
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
            else {
                invokeAsyncTask();
            }

        }
    }

    private void showLoadingInfo() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideLoadingInfo()
    {
        progressBar.setVisibility(View.GONE);
    }

    private void invokeAsyncTask()
    {
        showLoadingInfo();
        new EndPointAsyncTask().execute(this);
        hideLoadingInfo();

    }



}
