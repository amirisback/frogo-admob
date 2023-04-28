package com.frogobox.appadmob.mvvm.appopenad

import android.os.Bundle
import android.util.Log
import com.frogobox.ad.ui.FrogoAdBindActivity
import com.frogobox.admob.callback.FrogoAdmobAppOpenAdCallback
import com.frogobox.appadmob.SampleAdmobApplication
import com.frogobox.appadmob.databinding.ActivityAppOpenAdBinding
import com.frogobox.appadmob.util.AdHelper
import com.frogobox.sdk.ext.gone
import com.frogobox.sdk.ext.showToast
import com.frogobox.sdk.ext.visible

/**
 * Created by Faisal Amir on 24/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */


class AppOpenAdActivity : FrogoAdBindActivity<ActivityAppOpenAdBinding>(), FrogoAdmobAppOpenAdCallback {

    companion object {
        const val TAG = "AppOpenAdActivity"
    }

    override fun setupViewBinding(): ActivityAppOpenAdBinding {
        return ActivityAppOpenAdBinding.inflate(layoutInflater)
    }

    override fun onCreateExt(savedInstanceState: Bundle?) {
        super.onCreateExt(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnAdmobAppOpenAd.setOnClickListener {
                setupAppOpenAd()
            }
        }
    }

    override fun onShowAdRequestProgress(tag: String, message: String) {
        binding.ivProgress.visible()
        Log.d(TAG, "onShowAdRequestProgress: $tag, $message")
    }

    override fun onHideAdRequestProgress(tag: String, message: String) {
        binding.ivProgress.gone()
        Log.d(TAG, "onHideAdRequestProgress: $tag, $message")
    }

    override fun onAdDismissed(tag: String, message: String) {
        Log.d(TAG, "onAdDismissed: $tag, $message")
    }

    override fun onAdFailed(tag: String, errorMessage: String) {
        showToast(errorMessage)
        Log.d(TAG, "onAdFailed: $tag, $errorMessage")
    }

    override fun onAdLoaded(tag: String, message: String) {

        Log.d(TAG, "onAdLoaded: $tag, $message")
    }

    override fun onAdShowed(tag: String, message: String) {
        Log.d(TAG, "onAdShowed: $tag, $message")
    }

    private fun setupAppOpenAd() {
        val application = application as? SampleAdmobApplication

        if (application != null) {
            application.showAdIfAvailable(
                this,
                AdHelper.getAdOpenAppUnitId(this),
                this
            )
        } else {
            Log.e(TAG, "Failed to cast application to MyApplication.")
        }
    }

}