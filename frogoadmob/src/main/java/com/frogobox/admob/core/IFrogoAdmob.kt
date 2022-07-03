package com.frogobox.admob.core

import android.content.Context
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.callback.FrogoAdmobBannerCallback
import com.frogobox.admob.callback.FrogoAdmobInterstitialCallback
import com.frogobox.admob.callback.FrogoAdmobRewardedCallback
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 10/02/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basehelper
 *
 */


interface IFrogoAdmob {

    fun setupAdmobApp(context: Context)

    // ---------------------------------------------------------------------------------------------

    fun showAdBanner(
        mAdView: AdView,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: FrogoAdmobBannerCallback?
    )

    fun showAdBanner(mAdView: AdView)

    fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int)

    fun showAdBanner(mAdView: AdView, keyword: List<String>)

    fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int, keyword: List<String>)

    fun showAdBanner(mAdView: AdView, callback: FrogoAdmobBannerCallback)

    fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int, callback: FrogoAdmobBannerCallback)

    fun showAdBanner(mAdView: AdView, keyword: List<String>, callback: FrogoAdmobBannerCallback)

    // ---------------------------------------------------------------------------------------------

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: FrogoAdmobBannerCallback?
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        keyword: List<String>,
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        keyword: List<String>
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        callback: FrogoAdmobBannerCallback
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobBannerCallback
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        keyword: List<String>,
        callback: FrogoAdmobBannerCallback
    )

    // ---------------------------------------------------------------------------------------------

    fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: FrogoAdmobInterstitialCallback?
    )

    fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        keyword: List<String>
    )

    fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int
    )

    fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        keyword: List<String>
    )

    fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
    )

    fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobInterstitialCallback
    )

    fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        keyword: List<String>,
        callback: FrogoAdmobInterstitialCallback
    )

    fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        callback: FrogoAdmobInterstitialCallback
    )

    // ---------------------------------------------------------------------------------------------

    fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: FrogoAdmobRewardedCallback
    )

    fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        callback: FrogoAdmobRewardedCallback
    )

    fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobRewardedCallback
    )

    fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    )

    // ---------------------------------------------------------------------------------------------

    fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: FrogoAdmobRewardedCallback
    )

    fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        callback: FrogoAdmobRewardedCallback
    )

    fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobRewardedCallback
    )

    fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    )

    // ---------------------------------------------------------------------------------------------

    fun loadRecyclerBannerAds(
        bannerAdUnitId: String,
        context: Context,
        recyclerViewDataList: MutableList<Any>
    )

    fun addBannerAds(
        bannerAdUnitId: String,
        context: Context,
        recyclerViewDataList: MutableList<Any>
    )

    fun loadBannerAd(recyclerViewDataList: MutableList<Any>, index: Int)

    // ---------------------------------------------------------------------------------------------

}