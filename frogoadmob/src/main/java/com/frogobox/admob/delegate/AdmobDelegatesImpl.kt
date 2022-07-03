package com.frogobox.admob.delegate

import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.callback.FrogoAdmobBannerCallback
import com.frogobox.admob.callback.FrogoAdmobInterstitialCallback
import com.frogobox.admob.callback.FrogoAdmobRewardedCallback
import com.frogobox.admob.core.FrogoAdConsent
import com.frogobox.admob.core.FrogoAdmob
import com.frogobox.sdk.ext.showLogD
import com.frogobox.sdk.ext.showLogDebug
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView


/*
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
        showLogD<AdmobDelegatesImpl>("activity: $activity")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner")
        FrogoAdmob.showAdBanner(mAdView)
    }

    override fun showAdBanner(mAdView: AdView, callback: FrogoAdmobBannerCallback) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner")
        FrogoAdmob.showAdBanner(mAdView, callback)
    }

    override fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner")
        FrogoAdmob.showAdBanner(mAdView, timeoutMilliSecond)
    }

    override fun showAdBanner(mAdView: AdView, keyword: List<String>) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner")
        FrogoAdmob.showAdBanner(mAdView, keyword)
    }

    override fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int, keyword: List<String>) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner")
        FrogoAdmob.showAdBanner(mAdView, timeoutMilliSecond, keyword)
    }

    override fun showAdBanner(
        mAdView: AdView,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: FrogoAdmobBannerCallback
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner")
        FrogoAdmob.showAdBanner(mAdView, timeoutMilliSecond, keyword, callback)
    }

    override fun showAdBanner(
        mAdView: AdView,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobBannerCallback
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner")
        FrogoAdmob.showAdBanner(mAdView, timeoutMilliSecond, callback)
    }

    override fun showAdBanner(
        mAdView: AdView,
        keyword: List<String>,
        callback: FrogoAdmobBannerCallback
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner")
        FrogoAdmob.showAdBanner(mAdView, keyword, callback)
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
        FrogoAdmob.showAdInterstitial(admobDelegatesActivity, interstitialAdUnitId)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        callback: FrogoAdmobInterstitialCallback
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
        FrogoAdmob.showAdInterstitial(admobDelegatesActivity, interstitialAdUnitId, callback)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: FrogoAdmobInterstitialCallback
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
        FrogoAdmob.showAdInterstitial(
            admobDelegatesActivity,
            interstitialAdUnitId,
            timeoutMilliSecond,
            keyword
        )
    }

    override fun showAdInterstitial(interstitialAdUnitId: String, timeoutMilliSecond: Int) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
        FrogoAdmob.showAdInterstitial(
            admobDelegatesActivity,
            interstitialAdUnitId,
            timeoutMilliSecond
        )
    }

    override fun showAdInterstitial(interstitialAdUnitId: String, keyword: List<String>) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
        FrogoAdmob.showAdInterstitial(admobDelegatesActivity, interstitialAdUnitId, keyword)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobInterstitialCallback
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
        FrogoAdmob.showAdInterstitial(
            admobDelegatesActivity,
            interstitialAdUnitId,
            keyword,
            callback
        )
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdRewarded(mAdUnitIdRewarded: String, callback: FrogoAdmobRewardedCallback) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewarded")
        FrogoAdmob.showAdRewarded(admobDelegatesActivity, mAdUnitIdRewarded, callback)
    }

    override fun showAdRewarded(
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobRewardedCallback
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewarded")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewarded")
        FrogoAdmob.showAdRewarded(admobDelegatesActivity, mAdUnitIdRewarded, keyword, callback)
    }

    override fun showAdRewarded(
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewarded")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewardedInterstitial")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewardedInterstitial")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewardedInterstitial")
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
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewardedInterstitial")
        FrogoAdmob.showAdRewardedInterstitial(
            admobDelegatesActivity,
            mAdUnitIdRewardedInterstitial,
            timeoutMilliSecond,
            keyword,
            callback
        )
    }
}