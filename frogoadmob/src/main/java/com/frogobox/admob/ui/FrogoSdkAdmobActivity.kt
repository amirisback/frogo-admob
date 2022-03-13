package com.frogobox.admob.ui

import android.os.Bundle
import android.widget.RelativeLayout
import androidx.viewbinding.ViewBinding
import com.frogobox.admob.core.FrogoAdmob
import com.frogobox.admob.core.FrogoAdmob.Rewarded.showRewarded
import com.frogobox.admob.core.FrogoAdmob.RewardedInterstitial.showRewardedInterstitial
import com.frogobox.admob.core.IFrogoAdmob
import com.frogobox.admob.core.IFrogoBanner
import com.frogobox.admob.core.IFrogoInterstitial
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FLog.d("$TAG : Setup Admob")
    }

    override fun showBanner(mAdView: AdView) {
        FrogoAdmob.Banner.showBanner(mAdView)
    }

    override fun showBanner(mAdView: AdView, listener: IFrogoBanner) {
        FrogoAdmob.Banner.showBanner(mAdView, listener)
    }

    override fun showBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout
    ) {
        FrogoAdmob.Banner.showBannerContainer(this, bannerAdUnitId, mAdsSize, container)
    }

    override fun showBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        listener: IFrogoBanner
    ) {
        FrogoAdmob.Banner.showBannerContainer(this, bannerAdUnitId, mAdsSize, container, listener)
    }

    override fun showInterstitial(interstitialAdUnitId: String) {
        FrogoAdmob.Interstitial.showInterstitial(this, interstitialAdUnitId)
    }

    override fun showInterstitial(
        interstitialAdUnitId: String,
        callback: IFrogoInterstitial
    ) {
        FrogoAdmob.Interstitial.showInterstitial(this, interstitialAdUnitId, callback)
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