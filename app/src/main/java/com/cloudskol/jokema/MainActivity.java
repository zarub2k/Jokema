package com.cloudskol.jokema;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cloudskol.jokema.api.Joke;
import com.cloudskol.jokema.api.JokemaAPI;
import com.cloudskol.jokemalib.LibraryActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Main entry point for our application
 */
public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private static final String JOKE = "JOKE";

    public String result;

    private ProgressBar spinner;
    private boolean asyncTesting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        spinner = (ProgressBar) findViewById(R.id.spinner);
        hideSpinner();

        showAds();
    }

    /**
     * Method to show ads
     */
    private void showAds() {
        AdView adView = (AdView) findViewById(R.id.adView);
        final AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
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

    /**
     * Sample method to generate joke internally and render in the UI
     * @param view
     */
    public void apiJoke(View view) {
        final JokemaAPI jokemaAPI = new JokemaAPI();
        final Joke joke = jokemaAPI.getJoke();

        Log.v(LOG_TAG, "Generated Joke: " + joke.getSummary());
        Toast.makeText(MainActivity.this, joke.getSummary(), Toast.LENGTH_SHORT).show();
    }

    /**
     * Method to fetch joke data from the cloud instance
     * @param view
     */
    public void cloudJoke(View view) {
        showSpinner();
        new JokeAsyncTask(this).execute();
    }

    /**
     * Call back method to handle joke rendering after the server call
     * @param joke
     */
    public void onJokeFetched(String joke) {
        hideSpinner();

        result = joke;

        final Intent libraryIntent = new Intent(this, LibraryActivity.class);
        libraryIntent.putExtra(JOKE, joke);
        startActivity(libraryIntent);
    }

    /**
     * Utility method to show the spinner widget
     */
    private void showSpinner() {
        spinner.setVisibility(View.VISIBLE);
    }

    /**
     * Utility method to hide the spinner widget
     */
    private void hideSpinner() {
        spinner.setVisibility(View.GONE);
    }

    public void setAsyncTesting(boolean asyncTesting) {
        this.asyncTesting = asyncTesting;
    }
}