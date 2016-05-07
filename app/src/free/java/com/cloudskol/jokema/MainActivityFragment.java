package com.cloudskol.jokema;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author tham
 * Main fragment for free version
 */
public class MainActivityFragment extends Fragment {
    private static final String LOG_TAG = MainActivityFragment.class.getSimpleName();

    public MainActivityFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    /**
     * Method to show ads
     */
    private void showAds() {
//        AdView adView = (AdView) findViewById(R.id.adView);
//        final AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);
    }
}
