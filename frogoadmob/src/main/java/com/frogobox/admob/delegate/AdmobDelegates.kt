package com.frogobox.admob.delegate

import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.callback.FrogoAdmobBannerCallback
import com.frogobox.admob.callback.FrogoAdmobInterstitialCallback
import com.frogobox.admob.callback.FrogoAdmobRewardedCallback
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView


/**
 * Created by faisalamir on 03/07/22
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

interface AdmobDelegates {

    fun setupAdmobDelegates(activity: AppCompatActivity)

    // Show Ad Consent
    fun showAdConsent()

    // ---------------------------------------------------------------------------------------------

    fun setupAdmobApp()

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
        callback: FrogoAdmobBannerCallback
    )

    // Show Banner Ads with callback
    fun showAdBanner(mAdView: AdView, callback: FrogoAdmobBannerCallback)

    // Show Banner Ads  with timeout millisecond and callback
    fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int, callback: FrogoAdmobBannerCallback)

    // Show Banner Ads  with and keyword and callback
    fun showAdBanner(mAdView: AdView, keyword: List<String>, callback: FrogoAdmobBannerCallback)

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
        callback: FrogoAdmobBannerCallback
    )

    // Show Banner Ads with container and timeout millisecond and callback
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobBannerCallback
    )

    // Show Banner Ads with container and keyword and callback
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        keyword: List<String>,
        callback: FrogoAdmobBannerCallback
    )

    // Show Banner Ads with container and timeout millisecond and keyword and callback
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: FrogoAdmobBannerCallback
    )

    // ---------------------------------------------------------------------------------------------

    // Show Interstitial Ads with timeout millisecond, keyword, callback
    fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: FrogoAdmobInterstitialCallback
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
        callback: FrogoAdmobInterstitialCallback
    )

    // Show Interstitial Ads with keyword and callback
    fun showAdInterstitial(
        interstitialAdUnitId: String,
        keyword: List<String>,
        callback: FrogoAdmobInterstitialCallback
    )

    // Show Interstitial Ads with callback
    fun showAdInterstitial(
        interstitialAdUnitId: String,
        callback: FrogoAdmobInterstitialCallback
    )

    // ---------------------------------------------------------------------------------------------

    // Show Rewarded Ads
    fun showAdRewarded(mAdUnitIdRewarded: String, callback: FrogoAdmobRewardedCallback)

    // Show Rewarded Ads with timeout millisecond
    fun showAdRewarded(
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobRewardedCallback
    )

    // Show Rewarded Ads with keyword
    fun showAdRewarded(
        mAdUnitIdRewarded: String,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    )

    // Show Rewarded Ads with timeout millisecond and keyword
    fun showAdRewarded(
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    )

    // ---------------------------------------------------------------------------------------------

    // Show Rewarded Interstitial Ads
    fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        callback: FrogoAdmobRewardedCallback
    )

    // Show Rewarded Interstitial Ads with timeout millisecond
    fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobRewardedCallback
    )

    // Show Rewarded Interstitial Ads with keyword
    fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    )

    // Show Rewarded Interstitial Ads with timeout millisecond and keyword
    fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    )


}