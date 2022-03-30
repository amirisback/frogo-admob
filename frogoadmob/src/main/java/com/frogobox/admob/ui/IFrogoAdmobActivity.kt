package com.frogobox.admob.ui

import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.core.*
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

/*
 * Created by faisalamir on 01/07/21
 * FrogoAdmob
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface IFrogoAdmobActivity {

    // Show Ad Consent
    fun showAdConsent()

    // Show Banner Ads
    fun showAdBanner(mAdView: AdView)

    // Show Banner Ads with listener
    fun showAdBanner(mAdView: AdView, listener: IFrogoAdBanner)

    // Show Banner Ads with container
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout
    )

    // Show Banner Ads with container and listener
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        listener: IFrogoAdBanner
    )
    
    // ---------------------------------------------------------------------------------------------

    // Show Interstitial Ads with timeout millisecond, keyword, callback
    fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: IFrogoAdInterstitial
    )

    // Show Interstitial Ads with timeout millisecond and keyword
    fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        keyword: List<String>
    )

    // Show Interstitial Ads with timeout millisecond
    fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int
    )

    // Show Interstitial Ads with keyword
    fun showAdInterstitial(
        interstitialAdUnitId: String,
        keyword: List<String>
    )

    // Show Interstitial Ads
    fun showAdInterstitial(interstitialAdUnitId: String)

    // Show Interstitial Ads with timeout milliSecond and callback
    fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        callback: IFrogoAdInterstitial
    )

    // Show Interstitial Ads with keyword and callback
    fun showAdInterstitial(
        interstitialAdUnitId: String,
        keyword: List<String>,
        callback: IFrogoAdInterstitial
    )

    // Show Interstitial Ads with callback
    fun showAdInterstitial(
        interstitialAdUnitId: String,
        callback: IFrogoAdInterstitial
    )

    // ---------------------------------------------------------------------------------------------

    // Show Rewarded Ads
    fun showAdRewarded(mAdUnitIdRewarded: String, callback: IFrogoAdRewarded)

    // Show Rewarded Interstitial Ads
    fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        callback: IFrogoAdRewarded
    )

    // ---------------------------------------------------------------------------------------------

    // Unity Ads

    fun setupUnityAdApp(
        testMode: Boolean,
        unityGameId: String
    )

    fun setupUnityAdApp(
        testMode: Boolean,
        unityGameId: String,
        callback: IFrogoUnityAdInitialization
    )

    fun showUnityAdInterstitial(
        adInterstitialUnitId: String
    )

    fun showUnityAdInterstitial(
        adInterstitialUnitId: String,
        callback: IFrogoUnityAdInterstitial
    )

    // ---------------------------------------------------------------------------------------------

    fun showAdmobXUnityAdInterstitial(
        admobInterstitialId: String,
        unityInterstitialId: String,
        callback: IFrogoMixedAdsInterstitial
    )

    fun showUnityXAdmobAdInterstitial(
        admobInterstitialId: String,
        unityInterstitialId: String,
        callback: IFrogoMixedAdsInterstitial
    )

}