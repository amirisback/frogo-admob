package com.frogobox.admob.core.admob

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.core.admob.FrogoAdmob.Banner.setupBanner
import com.frogobox.admob.core.admob.FrogoAdmob.Banner.showBanner
import com.frogobox.admob.core.admob.FrogoAdmob.Interstitial.setupInterstitial
import com.frogobox.admob.core.admob.FrogoAdmob.Interstitial.showInterstitial
import com.frogobox.admob.core.admob.FrogoAdmob.Publisher.setupPublisher
import com.frogobox.admob.core.admob.FrogoAdmob.setupBannerAdUnitID
import com.frogobox.admob.core.admob.FrogoAdmob.setupInterstialAdUnitID
import com.frogobox.admob.core.admob.FrogoAdmob.setupPublisherID
import com.frogobox.admob.core.admob.FrogoAdmob.setupRewardedAdUnitID
import com.google.android.gms.ads.AdView

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
        setupInterstitial(this)
    }

    fun setupShowAdsInterstitial() {
        showInterstitial(this)
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