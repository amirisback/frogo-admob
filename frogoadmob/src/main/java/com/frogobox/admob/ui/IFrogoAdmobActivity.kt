package com.frogobox.admob.ui

import android.widget.RelativeLayout
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

@Deprecated("Please re-import to latest package and use the new one")
interface IFrogoAdmobActivity {

    // Show Ad Consent
    fun showAdConsent()

    // ---------------------------------------------------------------------------------------------

    // Show Banner Ads
    fun showAdBanner(mAdView: AdView)

    // Show Banner Ads with timeout millisecond
    fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int)

    // Show Banner Ads with keyword
    fun showAdBanner(mAdView: AdView, keyword: List<String>)

    // Show Banner Ads with timeout millisecond and keyword
    fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int, keyword: List<String>)

    // Show Banner Ads  with timeout millisecond and keyword and callback
    fun showAdBanner(
        mAdView: AdView,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: IFrogoAdBanner
    )

    // Show Banner Ads with callback
    fun showAdBanner(mAdView: AdView, callback: IFrogoAdBanner)

    // Show Banner Ads  with timeout millisecond and callback
    fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int, callback: IFrogoAdBanner)

    // Show Banner Ads  with and keyword and callback
    fun showAdBanner(mAdView: AdView, keyword: List<String>, callback: IFrogoAdBanner)

    // ---------------------------------------------------------------------------------------------

    // Show Banner Ads with container
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
    )

    // Show Banner Ads with container and timeout millisecond
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
    )

    // Show Banner Ads with container and keyword
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        keyword: List<String>,
    )

    // Show Banner Ads with container and keyword and timeout millisecond
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        keyword: List<String>
    )

    // Show Banner Ads with container and callback
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        callback: IFrogoAdBanner
    )

    // Show Banner Ads with container and timeout millisecond and callback
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        callback: IFrogoAdBanner
    )

    // Show Banner Ads with container and keyword and callback
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        keyword: List<String>,
        callback: IFrogoAdBanner
    )

    // Show Banner Ads with container and timeout millisecond and keyword and callback
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: IFrogoAdBanner
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

    // Show Rewarded Ads with timeout millisecond
    fun showAdRewarded(
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        callback: IFrogoAdRewarded
    )

    // Show Rewarded Ads with keyword
    fun showAdRewarded(
        mAdUnitIdRewarded: String,
        keyword: List<String>,
        callback: IFrogoAdRewarded
    )

    // Show Rewarded Ads with timeout millisecond and keyword
    fun showAdRewarded(
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: IFrogoAdRewarded
    )

    // ---------------------------------------------------------------------------------------------

    // Show Rewarded Interstitial Ads
    fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        callback: IFrogoAdRewarded
    )

    // Show Rewarded Interstitial Ads with timeout millisecond
    fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int,
        callback: IFrogoAdRewarded
    )

    // Show Rewarded Interstitial Ads with keyword
    fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        keyword: List<String>,
        callback: IFrogoAdRewarded
    )

    // Show Rewarded Interstitial Ads with timeout millisecond and keyword
    fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
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