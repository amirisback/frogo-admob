package com.frogobox.appadmob.mvvm.main

import android.os.Bundle
import com.frogobox.admob.core.IFrogoAdInterstitial
import com.frogobox.admob.ui.FrogoSdkAdmobActivity
import com.frogobox.appadmob.R
import com.frogobox.appadmob.databinding.ActivityInterstitialBinding

class InterstitialActivity : FrogoSdkAdmobActivity<ActivityInterstitialBinding>() {

    override fun setupViewBinding(): ActivityInterstitialBinding {
        return ActivityInterstitialBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {}

    override fun setupOnCreate(savedInstanceState: Bundle?) {
        setupDetailActivity("Sample Frogo Sdk Admob 2")

        binding.apply {

            btnInterstitial.setOnClickListener {
                showAdInterstitial(getString(R.string.admob_interstitial))
            }

            btnInterstitialCallback.setOnClickListener {
                showAdInterstitial(
                    getString(R.string.admob_interstitial),
                    object : IFrogoAdInterstitial {

                        override fun onAdClosed() {
                            baseStartActivity<MainActivity>()
                        }

                        override fun onAdFailedToLoad() {
                            baseStartActivity<MainActivity>()
                        }

                        override fun onAdFailedToShow() {
                            baseStartActivity<MainActivity>()
                        }

                        override fun onAdLoaded() {

                        }

                    }
                )
            }

        }

    }


}