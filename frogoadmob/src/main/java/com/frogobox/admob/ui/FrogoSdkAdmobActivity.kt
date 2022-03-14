package com.frogobox.admob.ui

import android.os.Bundle
import android.widget.RelativeLayout
import androidx.viewbinding.ViewBinding
import com.frogobox.admob.core.FrogoAdmob
import com.frogobox.admob.core.FrogoAdmob.Banner.showAdBannerContainer
import com.frogobox.admob.core.FrogoAdmob.Interstitial.showAdInterstitial
import com.frogobox.admob.core.FrogoAdmob.Rewarded.showAdRewarded
import com.frogobox.admob.core.FrogoAdmob.Rewarded.showAdRewardedInterstitial
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

    override fun showAdBanner(mAdView: AdView) {
        FrogoAdmob.Banner.showAdBanner(mAdView)
    }

    override fun showAdBanner(mAdView: AdView, listener: IFrogoAdBanner) {
        FrogoAdmob.Banner.showAdBanner(mAdView, listener)
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout
    ) {
        showAdBannerContainer(this, bannerAdUnitId, mAdsSize, container)
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        listener: IFrogoAdBanner
    ) {
        showAdBannerContainer(this, bannerAdUnitId, mAdsSize, container, listener)
    }

    override fun showAdInterstitial(interstitialAdUnitId: String) {
        showAdInterstitial(this, interstitialAdUnitId)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        callback: IFrogoAdInterstitial
    ) {
        showAdInterstitial(this, interstitialAdUnitId, callback)
    }

    override fun showAdRewarded(mAdUnitIdRewarded: String, callback: IFrogoAdRewarded) {
        showAdRewarded(this, mAdUnitIdRewarded, callback)
    }

    override fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        callback: IFrogoAdRewarded
    ) {
        showAdRewardedInterstitial(this, mAdUnitIdRewardedInterstitial, callback)
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