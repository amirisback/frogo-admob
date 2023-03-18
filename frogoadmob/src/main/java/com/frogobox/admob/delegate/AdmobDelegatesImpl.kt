package com.frogobox.admob.delegate

import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.callback.FrogoAdmobBannerCallback
import com.frogobox.admob.callback.FrogoAdmobInterstitialCallback
import com.frogobox.admob.callback.FrogoAdmobRewardedCallback
import com.frogobox.admob.core.FrogoAdConsent
import com.frogobox.admob.core.FrogoAdmob
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

class AdmobDelegatesImpl : AdmobDelegates {

    companion object {
        val TAG: String = AdmobDelegatesImpl::class.java.simpleName
    }

    private lateinit var admobDelegatesActivity: AppCompatActivity

    override fun setupAdmobDelegates(activity: AppCompatActivity) {
        admobDelegatesActivity = activity
    }

    override fun setupAdmobApp() {
        FrogoAdmob.setupAdmobApp(admobDelegatesActivity)
    }

    override fun showAdConsent() {
        FrogoAdConsent.showConsent(admobDelegatesActivity)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdBanner(mAdView: AdView) {
        FrogoAdmob.showAdBanner(mAdView)
    }

    override fun showAdBanner(mAdView: AdView, callback: FrogoAdmobBannerCallback) {
        FrogoAdmob.showAdBanner(mAdView, callback)
    }

    override fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int) {
        FrogoAdmob.showAdBanner(mAdView, timeoutMilliSecond)
    }

    override fun showAdBanner(mAdView: AdView, keyword: List<String>) {
        FrogoAdmob.showAdBanner(mAdView, keyword)
    }

    override fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int, keyword: List<String>) {
        FrogoAdmob.showAdBanner(mAdView, timeoutMilliSecond, keyword)
    }

    override fun showAdBanner(
        mAdView: AdView,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: FrogoAdmobBannerCallback
    ) {
        FrogoAdmob.showAdBanner(mAdView, timeoutMilliSecond, keyword, callback)
    }

    override fun showAdBanner(
        mAdView: AdView,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobBannerCallback
    ) {
        FrogoAdmob.showAdBanner(mAdView, timeoutMilliSecond, callback)
    }

    override fun showAdBanner(
        mAdView: AdView,
        keyword: List<String>,
        callback: FrogoAdmobBannerCallback
    ) {
        FrogoAdmob.showAdBanner(mAdView, keyword, callback)
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout
    ) {
        FrogoAdmob.showAdBannerContainer(
            admobDelegatesActivity,
            bannerAdUnitId,
            mAdsSize,
            container
        )
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        callback: FrogoAdmobBannerCallback
    ) {
        FrogoAdmob.showAdBannerContainer(
            admobDelegatesActivity,
            bannerAdUnitId,
            mAdsSize,
            container,
            callback
        )
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int
    ) {
        FrogoAdmob.showAdBannerContainer(
            admobDelegatesActivity,
            bannerAdUnitId,
            mAdsSize,
            container,
            timeoutMilliSecond
        )
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        keyword: List<String>
    ) {
        FrogoAdmob.showAdBannerContainer(
            admobDelegatesActivity,
            bannerAdUnitId,
            mAdsSize,
            container,
            keyword
        )
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        keyword: List<String>
    ) {
        FrogoAdmob.showAdBannerContainer(
            admobDelegatesActivity,
            bannerAdUnitId,
            mAdsSize,
            container,
            timeoutMilliSecond,
            keyword
        )
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobBannerCallback
    ) {
        FrogoAdmob.showAdBannerContainer(
            admobDelegatesActivity,
            bannerAdUnitId,
            mAdsSize,
            container,
            timeoutMilliSecond,
            callback
        )
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        keyword: List<String>,
        callback: FrogoAdmobBannerCallback
    ) {
        FrogoAdmob.showAdBannerContainer(
            admobDelegatesActivity,
            bannerAdUnitId,
            mAdsSize,
            container,
            keyword,
            callback
        )
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: FrogoAdmobBannerCallback
    ) {
        FrogoAdmob.showAdBannerContainer(
            admobDelegatesActivity,
            bannerAdUnitId,
            mAdsSize,
            container,
            timeoutMilliSecond,
            keyword,
            callback
        )
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdInterstitial(interstitialAdUnitId: String) {
        FrogoAdmob.showAdInterstitial(admobDelegatesActivity, interstitialAdUnitId)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        callback: FrogoAdmobInterstitialCallback
    ) {
        FrogoAdmob.showAdInterstitial(admobDelegatesActivity, interstitialAdUnitId, callback)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: FrogoAdmobInterstitialCallback
    ) {
        FrogoAdmob.showAdInterstitial(
            admobDelegatesActivity,
            interstitialAdUnitId,
            timeoutMilliSecond,
            keyword,
            callback
        )
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        keyword: List<String>
    ) {
        FrogoAdmob.showAdInterstitial(
            admobDelegatesActivity,
            interstitialAdUnitId,
            timeoutMilliSecond,
            keyword
        )
    }

    override fun showAdInterstitial(interstitialAdUnitId: String, timeoutMilliSecond: Int) {
        FrogoAdmob.showAdInterstitial(
            admobDelegatesActivity,
            interstitialAdUnitId,
            timeoutMilliSecond
        )
    }

    override fun showAdInterstitial(interstitialAdUnitId: String, keyword: List<String>) {
        FrogoAdmob.showAdInterstitial(admobDelegatesActivity, interstitialAdUnitId, keyword)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobInterstitialCallback
    ) {
        FrogoAdmob.showAdInterstitial(
            admobDelegatesActivity,
            interstitialAdUnitId,
            timeoutMilliSecond,
            callback
        )
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        keyword: List<String>,
        callback: FrogoAdmobInterstitialCallback
    ) {
        FrogoAdmob.showAdInterstitial(
            admobDelegatesActivity,
            interstitialAdUnitId,
            keyword,
            callback
        )
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdRewarded(mAdUnitIdRewarded: String, callback: FrogoAdmobRewardedCallback) {
        FrogoAdmob.showAdRewarded(admobDelegatesActivity, mAdUnitIdRewarded, callback)
    }

    override fun showAdRewarded(
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobRewardedCallback
    ) {
        FrogoAdmob.showAdRewarded(
            admobDelegatesActivity,
            mAdUnitIdRewarded,
            timeoutMilliSecond,
            callback
        )
    }

    override fun showAdRewarded(
        mAdUnitIdRewarded: String,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    ) {
        FrogoAdmob.showAdRewarded(admobDelegatesActivity, mAdUnitIdRewarded, keyword, callback)
    }

    override fun showAdRewarded(
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    ) {
        FrogoAdmob.showAdRewarded(
            admobDelegatesActivity,
            mAdUnitIdRewarded,
            timeoutMilliSecond,
            keyword,
            callback
        )
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        callback: FrogoAdmobRewardedCallback
    ) {
        FrogoAdmob.showAdRewardedInterstitial(
            admobDelegatesActivity,
            mAdUnitIdRewardedInterstitial,
            callback
        )
    }

    override fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobRewardedCallback
    ) {
        FrogoAdmob.showAdRewardedInterstitial(
            admobDelegatesActivity,
            mAdUnitIdRewardedInterstitial,
            timeoutMilliSecond,
            callback
        )
    }

    override fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    ) {
        FrogoAdmob.showAdRewardedInterstitial(
            admobDelegatesActivity,
            mAdUnitIdRewardedInterstitial,
            keyword,
            callback
        )
    }

    override fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    ) {
        FrogoAdmob.showAdRewardedInterstitial(
            admobDelegatesActivity,
            mAdUnitIdRewardedInterstitial,
            timeoutMilliSecond,
            keyword,
            callback
        )
    }
}