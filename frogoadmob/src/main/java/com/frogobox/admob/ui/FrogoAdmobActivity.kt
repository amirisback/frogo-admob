package com.frogobox.admob.ui

import android.content.Context
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.core.FrogoAdmob.Banner.showBanner
import com.frogobox.admob.core.FrogoAdmob.Banner.showBannerContainer
import com.frogobox.admob.core.FrogoAdmob.Interstitial.setupInterstitial
import com.frogobox.admob.core.FrogoAdmob.Interstitial.showInterstitial
import com.frogobox.admob.core.FrogoAdmob.Publisher.setupPublisher
import com.frogobox.admob.core.FrogoAdmob.Rewarded.setupRewarded
import com.frogobox.admob.core.FrogoAdmob.Rewarded.showRewarded
import com.frogobox.admob.core.FrogoAdmob.RewardedInterstitial.setupRewardedInterstitial
import com.frogobox.admob.core.FrogoAdmob.RewardedInterstitial.showRewardedInterstitial
import com.frogobox.admob.core.FrogoAdmob.setupBannerAdUnitID
import com.frogobox.admob.core.FrogoAdmob.setupInterstialAdUnitID
import com.frogobox.admob.core.FrogoAdmob.setupPublisherID
import com.frogobox.admob.core.FrogoAdmob.setupRewardedAdUnitID
import com.frogobox.admob.core.FrogoAdmob.setupRewardedInterstitialAdUnitID
import com.frogobox.admob.core.IFrogoAdListener
import com.frogobox.admob.core.IFrogoAdmob
import com.frogobox.frogolog.FLog
import com.google.android.gms.ads.AdSize
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

abstract class FrogoAdmobActivity : AppCompatActivity(), IFrogoAdmobActivity {

    private val TAG: String = FrogoAdmobActivity::class.java.simpleName

    protected val arrayFrogoAdmobData = mutableListOf<Any>()

    abstract fun setupAdmob()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupAdmob()
        FLog.d("$TAG : Setup Admob")
    }

    override fun setupAdsPublisher(mPublisherId: String) {
        setupPublisherID(mPublisherId)
        setupPublisher(this)
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