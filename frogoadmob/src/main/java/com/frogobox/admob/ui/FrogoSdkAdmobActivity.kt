package com.frogobox.admob.ui

import android.content.Context
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.viewbinding.ViewBinding
import com.frogobox.admob.core.FrogoAdmob.App.setupApp
import com.frogobox.admob.core.FrogoAdmob.Banner.showBanner
import com.frogobox.admob.core.FrogoAdmob.Banner.showBannerContainer
import com.frogobox.admob.core.FrogoAdmob.Interstitial.setupInterstitial
import com.frogobox.admob.core.FrogoAdmob.Interstitial.showInterstitial
import com.frogobox.admob.core.FrogoAdmob.Rewarded.setupRewarded
import com.frogobox.admob.core.FrogoAdmob.Rewarded.showRewarded
import com.frogobox.admob.core.FrogoAdmob.RewardedInterstitial.setupRewardedInterstitial
import com.frogobox.admob.core.FrogoAdmob.RewardedInterstitial.showRewardedInterstitial
import com.frogobox.admob.core.FrogoAdmob.setupAppID
import com.frogobox.admob.core.FrogoAdmob.setupBannerAdUnitID
import com.frogobox.admob.core.FrogoAdmob.setupInterstialAdUnitID
import com.frogobox.admob.core.FrogoAdmob.setupRewardedAdUnitID
import com.frogobox.admob.core.FrogoAdmob.setupRewardedInterstitialAdUnitID
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

    private val TAG: String = FrogoSdkAdmobActivity::class.java.simpleName

    protected val arrayFrogoAdmobData = mutableListOf<Any>()

    abstract fun setupAdmob()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupAdmob()
        FLog.d("$TAG : Setup Admob")
    }

    override fun setupAdsApp(mAppId: String) {
        setupAppID(mAppId)
        setupApp(this)
    }

    override fun setupAdsBanner(mAdUnitId: String) {
        setupBannerAdUnitID(mAdUnitId)
    }

    override fun setupAdsInterstitial(mAdUnitId: String) {
        setupInterstialAdUnitID(mAdUnitId)
        setupInterstitial(this)
    }

    override fun setupAdsRewarded(mAdUnitId: String) {
        setupRewardedAdUnitID(mAdUnitId)
        setupRewarded(this)
    }

    override fun setupAdsRewardedInterstitial(mAdUnitId: String) {
        setupRewardedInterstitialAdUnitID(mAdUnitId)
        setupRewardedInterstitial(this)
    }

    override fun setupShowAdsBanner(mAdView: AdView) {
        showBanner(mAdView)
    }

    override fun setupShowAdsBanner(mAdView: AdView, bannerListener: IFrogoAdListener.Banner) {
        showBanner(mAdView, bannerListener)
    }

    override fun setupShowAdsBannerContainer(
        context: Context,
        mAdsSize: AdSize,
        container: RelativeLayout
    ) {
        showBannerContainer(context, mAdsSize, container)
    }

    override fun setupShowAdsBannerContainer(
        context: Context,
        mAdsSize: AdSize,
        container: RelativeLayout,
        bannerListener: IFrogoAdListener.Banner
    ) {
        showBannerContainer(context, mAdsSize, container, bannerListener)
    }

    override fun setupShowAdsInterstitial() {
        showInterstitial(this)
    }

    override fun setupShowAdsRewarded(callback: IFrogoAdmob.UserEarned) {
        showRewarded(this, callback)
    }

    override fun setupShowAdsRewardedInterstitial(callback: IFrogoAdmob.UserEarned) {
        showRewardedInterstitial(this, callback)
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