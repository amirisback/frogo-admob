package com.frogobox.admob.ui

import android.os.Bundle
import android.widget.RelativeLayout
import androidx.viewbinding.ViewBinding
import com.frogobox.admob.core.FrogoAdmob
import com.frogobox.admob.core.FrogoAdmob.Banner.showBannerContainer
import com.frogobox.admob.core.FrogoAdmob.Interstitial.showInterstitial
import com.frogobox.admob.core.FrogoAdmob.Rewarded.showRewarded
import com.frogobox.admob.core.FrogoAdmob.Rewarded.showRewardedInterstitial
import com.frogobox.admob.core.IFrogoAdBanner
import com.frogobox.admob.core.IFrogoAdInterstitial
import com.frogobox.admob.core.IFrogoAdRewarded
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

    companion object {
        val TAG: String = FrogoSdkAdmobActivity::class.java.simpleName
    }

    protected val arrayFrogoAdmobData = mutableListOf<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FLog.d("$TAG : Setup Admob")
    }

    override fun showAdsBanner(mAdView: AdView) {
        FrogoAdmob.Banner.showBanner(mAdView)
    }

    override fun showAdsBanner(mAdView: AdView, listener: IFrogoAdBanner) {
        FrogoAdmob.Banner.showBanner(mAdView, listener)
    }

    override fun showAdsBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout
    ) {
        FrogoAdmob.Banner.showBannerContainer(this, bannerAdUnitId, mAdsSize, container)
    }

    override fun showAdsBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        listener: IFrogoAdBanner
    ) {
        showBannerContainer(this, bannerAdUnitId, mAdsSize, container, listener)
    }

    override fun showAdsInterstitial(interstitialAdUnitId: String) {
        showInterstitial(this, interstitialAdUnitId)
    }

    override fun showAdsInterstitial(
        interstitialAdUnitId: String,
        callback: IFrogoAdInterstitial
    ) {
        showInterstitial(this, interstitialAdUnitId, callback)
    }

    override fun showAdsRewarded(mAdUnitIdRewarded: String, callback: IFrogoAdRewarded) {
        showRewarded(this, mAdUnitIdRewarded, callback)
    }

    override fun showAdsRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        callback: IFrogoAdRewarded
    ) {
        showRewardedInterstitial(this, mAdUnitIdRewardedInterstitial, callback)
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