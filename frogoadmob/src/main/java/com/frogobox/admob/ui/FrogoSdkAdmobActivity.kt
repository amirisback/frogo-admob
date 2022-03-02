package com.frogobox.admob.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import androidx.viewbinding.ViewBinding
import com.frogobox.admob.core.FrogoAdmob
import com.frogobox.admob.core.IFrogoAdListener
import com.frogobox.admob.core.IFrogoAdmob
import com.frogobox.frogolog.FLog
import com.frogobox.sdk.FrogoActivity
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView


/*
 * Created by faisalamir on 01/03/22
 * FrogoAdmob
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Frogobox Media Inc.      
 * All rights reserved
 *
 */

abstract class FrogoSdkAdmobActivity<VB : ViewBinding> : FrogoActivity<VB>(), IFrogoAdmobActivity {

    private val TAG : String = FrogoSdkAdmobActivity::class.java.simpleName

    protected val arrayFrogoAdmobData = mutableListOf<Any>()

    abstract fun setupAdmob()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupAdmob()
        FLog.d("$TAG : Setup Admob")
    }

    override fun setupAdsPublisher(mPublisherId: String) {
        FrogoAdmob.setupPublisherID(mPublisherId)
        FrogoAdmob.Publisher.setupPublisher(this)
    }

    override fun setupAdsBanner(mAdUnitId: String) {
        FrogoAdmob.setupBannerAdUnitID(mAdUnitId)
    }

    override fun setupAdsInterstitial(mAdUnitId: String) {
        FrogoAdmob.setupInterstialAdUnitID(mAdUnitId)
        FrogoAdmob.Interstitial.setupInterstitial(this)
    }

    override fun setupAdsRewarded(mAdUnitId: String) {
        FrogoAdmob.setupRewardedAdUnitID(mAdUnitId)
        FrogoAdmob.Rewarded.setupRewarded(this)
    }

    override fun setupAdsRewardedInterstitial(mAdUnitId: String) {
        FrogoAdmob.setupRewardedInterstitialAdUnitID(mAdUnitId)
        FrogoAdmob.RewardedInterstitial.setupRewardedInterstitial(this)
    }

    override fun setupShowAdsBanner(mAdView: AdView) {
        FrogoAdmob.Banner.showBanner(mAdView)
    }

    override fun setupShowAdsBanner(mAdView: AdView, bannerListener: IFrogoAdListener.Banner) {
        FrogoAdmob.Banner.showBanner(mAdView, bannerListener)
    }

    override fun setupShowAdsBannerContainer(
        context: Context,
        mAdsSize: AdSize,
        container: RelativeLayout
    ) {
        FrogoAdmob.Banner.showBannerContainer(context, mAdsSize, container)
    }

    override fun setupShowAdsBannerContainer(
        context: Context,
        mAdsSize: AdSize,
        container: RelativeLayout,
        bannerListener: IFrogoAdListener.Banner
    ) {
        FrogoAdmob.Banner.showBannerContainer(context, mAdsSize, container, bannerListener)
    }

    override fun setupShowAdsInterstitial() {
        FrogoAdmob.Interstitial.showInterstitial(this)
    }

    override fun setupShowAdsRewarded(callback: IFrogoAdmob.UserEarned) {
        FrogoAdmob.Rewarded.showRewarded(this, callback)
    }

    override fun setupShowAdsRewardedInterstitial(callback: IFrogoAdmob.UserEarned) {
        FrogoAdmob.RewardedInterstitial.showRewardedInterstitial(this, callback)
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