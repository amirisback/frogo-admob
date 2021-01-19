package com.frogobox.frogoadmobhelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogoadmobhelper.FrogoAdmobHelper.Banner.setupBanner
import com.frogobox.frogoadmobhelper.FrogoAdmobHelper.Banner.showBanner
import com.frogobox.frogoadmobhelper.FrogoAdmobHelper.Interstitial.setupInterstitial
import com.frogobox.frogoadmobhelper.FrogoAdmobHelper.Interstitial.showInterstitial
import com.frogobox.frogoadmobhelper.FrogoAdmobHelper.Publisher.setupPublisher
import com.frogobox.frogoadmobhelper.FrogoAdmobHelper.setupBannerAdUnitID
import com.frogobox.frogoadmobhelper.FrogoAdmobHelper.setupInterstialAdUnitID
import com.frogobox.frogoadmobhelper.FrogoAdmobHelper.setupPublisherID
import com.frogobox.frogoadmobhelper.FrogoAdmobHelper.setupRewardedAdUnitID
import com.google.android.gms.ads.AdView
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

open class FrogoAdmobActivity : AppCompatActivity() {

    protected lateinit var mActivity: AppCompatActivity
    protected val arrayFrogoAdmobData = mutableListOf<Any>()
    
    lateinit var mInterstitialAd: InterstitialAd

    private lateinit var mRewardedVideoAd: RewardedVideoAd
    private lateinit var baseAdmobPublisherID : String
    private lateinit var baseAdUnitIdBanner: String
    private lateinit var baseAdUnitIdInterstitial: String
    private lateinit var baseAdUnitIdRewardedVideo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
    }

    protected fun setBasePublisherID(mPublisherId : String){
        baseAdmobPublisherID = mPublisherId
    }

    protected fun setBaseBannerAdUnitID(mAdUnitId : String){
        baseAdUnitIdBanner = mAdUnitId
    }

    protected fun setBaseInterstialAdUnitID(mAdUnitId : String){
        baseAdUnitIdInterstitial = mAdUnitId
    }

    protected fun setBaseRewardedAdUnitID(mAdUnitId : String){
        baseAdUnitIdRewardedVideo = mAdUnitId
    }

    protected fun setBaseAdmob() {

        setupPublisherID(baseAdmobPublisherID)
        setupBannerAdUnitID(baseAdUnitIdBanner)
        setupInterstialAdUnitID(baseAdUnitIdInterstitial)
        setupRewardedAdUnitID(baseAdUnitIdRewardedVideo)

        setupPublisher(this)
        setupAdmobInterstitial()
//        setupAdmobVideo(context)
    }

    private fun setupAdmobInterstitial() {
        mInterstitialAd = InterstitialAd(this)
        setupInterstitial(mInterstitialAd)
    }

    fun setupShowAdsInterstitial() {
        showInterstitial(mInterstitialAd)
    }

    fun setupShowAdsBanner(mAdView : AdView) {
        setupBanner(mAdView)
        showBanner(mAdView)
    }

    override fun onResume() {
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.resume()
            }
        }
        super.onResume()
    }

    override fun onPause() {
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.pause()
            }
        }
        super.onPause()
    }

    override fun onDestroy() {
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.destroy()
            }
        }
        super.onDestroy()
    }


}