package com.frogobox.admobhelper.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admobhelper.helper.AdmobHelper.Interstitial.setupInterstitial
import com.frogobox.admobhelper.helper.AdmobHelper.Interstitial.showInterstitial
import com.frogobox.admobhelper.helper.AdmobHelper.Publisher.setupPublisher
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.reward.RewardedVideoAd

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 31/10/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.admobhelper
 *
 */

open class BaseActivity : AppCompatActivity() {

    lateinit var mActivity: AppCompatActivity
    lateinit var mInterstitialAd: InterstitialAd
    lateinit var mRewardedVideoAd: RewardedVideoAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        setupAdmob()
    }

    private fun setupAdmob() {
        setupPublisher(this)
        setupAdmobInterstitial()
//        setupAdmobVideo(context)
    }

    private fun setupAdmobInterstitial() {
        mInterstitialAd = InterstitialAd(this)
        setupInterstitial(this, mInterstitialAd)
    }

    fun setupShowAdsInterstitial() {
        showInterstitial(mInterstitialAd)
    }

}