package com.cloudskol.jokemalib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LibraryActivity extends AppCompatActivity {
    private static final String LOG_TAG = LibraryActivity.class.getSimpleName();

    private static final String JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        renderJoke();
    }

    private void renderJoke() {
        String jokeSummary = getIntent().getStringExtra(JOKE);
        Log.v(LOG_TAG, "Joke summary in library: " + jokeSummary);

        if (jokeSummary == null || jokeSummary.isEmpty()) {
            jokeSummary = getResources().getString(R.string.joke_warning);
        }

        TextView summaryTextView = (TextView) findViewById(R.id.joke_summary);
        summaryTextView.setText(jokeSummary);
    }
}
