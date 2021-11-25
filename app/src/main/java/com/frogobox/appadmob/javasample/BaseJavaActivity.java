package com.frogobox.appadmob.javasample;
/*
 * Created by faisalamir on 25/11/21
 * FrogoAdmob
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.
 * All rights reserved
 *
 */

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.frogobox.admob.ui.FrogoAdmobActivity;
import com.frogobox.appadmob.R;

public abstract class BaseJavaActivity extends FrogoAdmobActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupAdmob();
    }

    private void setupAdmob(){
        setPublisher();
        setBanner();
        setInterstitial();
        setRewarded();
        setRewardedInterstitial();
    }

    private void setPublisher() {
        // Your App ID
        setupAdsPublisher(getString(R.string.admob_publisher_id));
    }

    private void setBanner() {
        // Your Banner ID
        setupAdsBanner(getString(R.string.admob_banner));
    }

    private void setInterstitial() {
        // Your Interstitial ID
        setupAdsInterstitial(getString(R.string.admob_interstitial));
    }

    private void setRewarded() {
        // Your Rewarded ID
        setupAdsRewarded(getString(R.string.admob_rewarded));
    }

    private void setRewardedInterstitial() {
        // Your Rewarded ID
        setupAdsRewardedInterstitial(getString(R.string.admob_rewarded_interstitial));
    }

}
