package com.cloudskol.jokema;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * @author tham
 * Main fragment for free version
 */
public class MainActivityFragment extends Fragment {
    private static final String LOG_TAG = MainActivityFragment.class.getSimpleName();

    private InterstitialAd interstitialAd;

    public MainActivityFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        interstitialAd = new InterstitialAd(getActivity());
        interstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                final Activity parent = getActivity().getParent();
                if (parent instanceof MainActivity) {
                    ((MainActivity)parent).callCloudJoke();
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        showAds(root);
        return root;
    }

    private void showAds(View root) {
        AdView adView = (AdView) root.findViewById(R.id.adView);
        final AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
