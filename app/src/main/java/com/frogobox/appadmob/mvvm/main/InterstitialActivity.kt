package com.frogobox.appadmob.mvvm.main

import android.os.Bundle
import com.frogobox.admob.core.IFrogoAdInterstitial
import com.frogobox.admob.core.IFrogoUnityAdInterstitial
import com.frogobox.admob.ui.FrogoSdkAdmobActivity
import com.frogobox.admob.ui.IFrogoMixedAdsInterstitial
import com.frogobox.appadmob.R
import com.frogobox.appadmob.databinding.ActivityInterstitialBinding
import com.frogobox.log.FLog
import com.frogobox.sdk.ext.gone
import com.frogobox.sdk.ext.visible

class InterstitialActivity : FrogoSdkAdmobActivity<ActivityInterstitialBinding>(),
    IFrogoAdInterstitial, IFrogoUnityAdInterstitial, IFrogoMixedAdsInterstitial {

    private fun getKeyword(): MutableList<String> {
        val keywords = mutableListOf<String>()
        keywords.add("Kids")
        keywords.add("Toys")
        keywords.add("Game")
        keywords.add("Music")
        keywords.add("Piano")
        return keywords
    }

    private val HTTP_TIMEOUT_MILLIS = 30000

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

            btnAdmobInterstitialTimeout.setOnClickListener {
                showAdInterstitial(getString(R.string.admob_interstitial), HTTP_TIMEOUT_MILLIS)
            }

            btnAdmobInterstitialKeyword.setOnClickListener {
                showAdInterstitial(getString(R.string.admob_interstitial), getKeyword())
            }

            btnAdmobInterstitialTimeoutKeyword.setOnClickListener {
                showAdInterstitial(
                    getString(R.string.admob_interstitial),
                    HTTP_TIMEOUT_MILLIS,
                    getKeyword()
                )
            }

            btnAdmobInterstitialCallback.setOnClickListener {
                showAdInterstitial(
                    getString(R.string.admob_interstitial),
                    this@InterstitialActivity
                )
            }

            btnAdmobInterstitialCallbackTimeout.setOnClickListener {
                showAdInterstitial(
                    getString(R.string.admob_interstitial),
                    HTTP_TIMEOUT_MILLIS,
                    this@InterstitialActivity
                )
            }

            btnAdmobInterstitialCallbackKeyword.setOnClickListener {
                showAdInterstitial(
                    getString(R.string.admob_interstitial),
                    getKeyword(),
                    this@InterstitialActivity
                )
            }

            btnAdmobInterstitialCallbackTimeoutKeyword.setOnClickListener {
                showAdInterstitial(
                    getString(R.string.admob_interstitial),
                    HTTP_TIMEOUT_MILLIS,
                    getKeyword(),
                    this@InterstitialActivity
                )
            }

            btnUnityInterstitial.setOnClickListener {
                showUnityAdInterstitial(getString(R.string.unity_ad_interstitial))
            }

            btnUnityInterstitialCallback.setOnClickListener {
                showUnityAdInterstitial(
                    getString(R.string.unity_ad_interstitial),
                    this@InterstitialActivity
                )
            }

            btnAdmobXUnityInterstitial.setOnClickListener {
                showAdmobXUnityAdInterstitial(
                    "",
                    getString(R.string.unity_ad_interstitial),
                    this@InterstitialActivity
                )
            }

            btnUnityXAdmobInterstitialCallback.setOnClickListener {
                showUnityXAdmobAdInterstitial(
                    getString(R.string.admob_interstitial),
                    "",
                    this@InterstitialActivity
                )
            }
        }
    }

    override fun onClicked(tag: String, message: String) {}

    override fun onShowAdRequestProgress() {
        binding.ivProgress.visible()
    }

    override fun onHideAdRequestProgress(message: String) {
        binding.ivProgress.gone()
        FLog.d(message)
    }

    override fun onAdDismissed(tag: String, message: String) {
        showToast(message)
    }

    override fun onAdFailed(tag: String, errorMessage: String) {
        showToast(errorMessage)
    }

    override fun onAdLoaded(tag: String, message: String) {}

    override fun onAdShowed(tag: String, message: String) {}

}