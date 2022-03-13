package com.frogobox.admob.ui

import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.core.*
import com.frogobox.admob.core.FrogoAdmob.Banner.showAdBannerContainer
import com.frogobox.admob.core.FrogoAdmob.Interstitial.showAdInterstitial
import com.frogobox.admob.core.FrogoAdmob.Rewarded.showAdRewarded
import com.frogobox.admob.core.FrogoAdmob.Rewarded.showAdRewardedInterstitial
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

    companion object {
        val TAG: String = FrogoAdmobActivity::class.java.simpleName
    }

    protected val arrayFrogoAdmobData = mutableListOf<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FLog.d("$TAG : Setup Admob")
        FrogoAdmob.setupAdmobApp(this)
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
        FrogoAdmob.Banner.showAdBannerContainer(this, bannerAdUnitId, mAdsSize, container)
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
        showAdRewardedInterstitial(this,mAdUnitIdRewardedInterstitial, callback)
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