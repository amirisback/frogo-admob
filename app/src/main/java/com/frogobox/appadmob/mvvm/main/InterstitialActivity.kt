package com.frogobox.appadmob.mvvm.main

import android.os.Bundle
import com.frogobox.admob.core.IFrogoAdInterstitial
import com.frogobox.admob.core.IFrogoUnityAdInterstitial
import com.frogobox.admob.ui.FrogoSdkAdmobActivity
import com.frogobox.admob.ui.IFrogoMixedAdsInterstitial
import com.frogobox.appadmob.BuildConfig
import com.frogobox.appadmob.R
import com.frogobox.appadmob.databinding.ActivityInterstitialBinding

class InterstitialActivity : FrogoSdkAdmobActivity<ActivityInterstitialBinding>() {

    override fun setupViewBinding(): ActivityInterstitialBinding {
        return ActivityInterstitialBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {}

    override fun setupOnCreate(savedInstanceState: Bundle?) {
        setupDetailActivity("Sample Frogo Sdk Admob 2")
        setupUI()
    }

    private fun setupUI() {
        binding.apply {

            btnAdmobInterstitial.setOnClickListener {
                showAdInterstitial(getString(R.string.admob_interstitial))
            }

            btnAdmobInterstitialCallback.setOnClickListener {
                showAdInterstitial(
                    getString(R.string.admob_interstitial),
                    object : IFrogoAdInterstitial {
                        override fun onAdDismissed(tag: String, message: String) {
                            showToast(message)
                        }

                        override fun onAdFailed(tag: String, errorMessage: String) {
                            showToast(errorMessage)
                        }

                        override fun onAdLoaded(tag: String, message: String) {}

                        override fun onAdShowed(tag: String, message: String) {}

                    }
                )
            }

            btnUnityInterstitial.setOnClickListener {
                showUnityAdInterstitial(getString(R.string.unity_ad_interstitial))
            }

            btnUnityInterstitialCallback.setOnClickListener {
                showUnityAdInterstitial(getString(R.string.unity_ad_interstitial),
                    object : IFrogoUnityAdInterstitial {
                        override fun onClicked(tag: String, message: String) {}

                        override fun onAdDismissed(tag: String, message: String) {
                            showToast(message)
                        }

                        override fun onAdFailed(tag: String, errorMessage: String) {
                            showToast(errorMessage)
                        }

                        override fun onAdLoaded(tag: String, message: String) {}

                        override fun onAdShowed(tag: String, message: String) {}
                    })
            }

            btnAdmobXUnityInterstitial.setOnClickListener {
                showAdmobXUnityAdInterstitial(
                    "",
                    getString(R.string.unity_ad_interstitial),
                    object : IFrogoMixedAdsInterstitial {
                        override fun onClicked(tag: String, message: String) {}

                        override fun onAdDismissed(tag: String, message: String) {
                            showToast(message)
                        }

                        override fun onAdFailed(tag: String, errorMessage: String) {
                            showToast(errorMessage)
                        }

                        override fun onAdLoaded(tag: String, message: String) {}

                        override fun onAdShowed(tag: String, message: String) {}
                    }
                )
            }

            btnUnityXAdmobInterstitialCallback.setOnClickListener {
                showUnityXAdmobAdInterstitial(
                    getString(R.string.admob_interstitial),
                    "",
                    object : IFrogoMixedAdsInterstitial {
                        override fun onClicked(tag: String, message: String) {}

                        override fun onAdDismissed(tag: String, message: String) {
                            showToast(message)
                        }

                        override fun onAdFailed(tag: String, errorMessage: String) {
                            showToast(errorMessage)
                        }

                        override fun onAdLoaded(tag: String, message: String) {}

                        override fun onAdShowed(tag: String, message: String) {}
                    }
                )
            }
        }
    }

}