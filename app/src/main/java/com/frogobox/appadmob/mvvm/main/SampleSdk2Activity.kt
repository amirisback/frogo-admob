package com.frogobox.appadmob.mvvm.main

import android.os.Bundle
import com.frogobox.admob.core.IFrogoInterstitialCallback
import com.frogobox.admob.ui.FrogoSdkAdmobActivity2
import com.frogobox.appadmob.R
import com.frogobox.appadmob.databinding.ActivitySampleSdk2Binding
import com.google.android.gms.ads.interstitial.InterstitialAd

class SampleSdk2Activity : FrogoSdkAdmobActivity2<ActivitySampleSdk2Binding>() {

    override fun setupViewBinding(): ActivitySampleSdk2Binding {
        return ActivitySampleSdk2Binding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupOnCreate(savedInstanceState: Bundle?) {
        setupDetailActivity("Sample Frogo Sdk Admob 2")

        binding.apply {

            btnInterstitial.setOnClickListener {
                showInterstitial(getString(R.string.admob_interstitial))
            }

            btnInterstitialCallback.setOnClickListener {
                showInterstitial(
                    getString(R.string.admob_interstitial),
                    object : IFrogoInterstitialCallback {
                        override fun onAdLoaded(interstitialAd: InterstitialAd) {

                        }

                        override fun onClosedAd() {
                            baseStartActivity<MainActivity>()
                        }

                        override fun onAdFailedToLoadAndShow() {
                            baseStartActivity<MainActivity>()
                        }
                    }
                )
            }

        }

    }


}