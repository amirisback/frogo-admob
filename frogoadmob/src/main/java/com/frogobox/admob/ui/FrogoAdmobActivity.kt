package com.frogobox.admob.ui

import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.core.*
import com.frogobox.sdk.ext.showLogDebug
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

@Deprecated("Please re-import to latest package and use the new one")
abstract class FrogoAdmobActivity : AppCompatActivity(), IFrogoAdmobActivity {

    companion object {
        val TAG: String = FrogoAdmobActivity::class.java.simpleName
    }

    protected val arrayFrogoAdmobData = mutableListOf<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.setupAdmobApp")
            FrogoAdmob.setupAdmobApp(this)
        }
    }

    override fun showAdConsent() {
        FrogoAdConsent.showConsent(this)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdBanner(mAdView: AdView) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner")
        FrogoAdmob.showAdBanner(mAdView)
    }

    override fun showAdBanner(mAdView: AdView, callback: IFrogoAdBanner) {
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
        callback: IFrogoAdBanner
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner")
        FrogoAdmob.showAdBanner(mAdView, timeoutMilliSecond, keyword, callback)
    }

    override fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int, callback: IFrogoAdBanner) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner")
        FrogoAdmob.showAdBanner(mAdView, timeoutMilliSecond, callback)
    }

    override fun showAdBanner(mAdView: AdView, keyword: List<String>, callback: IFrogoAdBanner) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner")
        FrogoAdmob.showAdBanner(mAdView, keyword, callback)
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
        FrogoAdmob.showAdBannerContainer(this, bannerAdUnitId, mAdsSize, container)
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        callback: IFrogoAdBanner
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
        FrogoAdmob.showAdBannerContainer(this, bannerAdUnitId, mAdsSize, container, callback)
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
        FrogoAdmob.showAdBannerContainer(
            this,
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
        FrogoAdmob.showAdBannerContainer(this, bannerAdUnitId, mAdsSize, container, keyword)
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
            this,
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
        callback: IFrogoAdBanner
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
        FrogoAdmob.showAdBannerContainer(
            this,
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
        callback: IFrogoAdBanner
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
        FrogoAdmob.showAdBannerContainer(
            this,
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
        callback: IFrogoAdBanner
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer")
        FrogoAdmob.showAdBannerContainer(
            this,
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
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        callback: IFrogoAdInterstitial
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId, callback)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: IFrogoAdInterstitial
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
        FrogoAdmob.showAdInterstitial(
            this,
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
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId, timeoutMilliSecond, keyword)
    }

    override fun showAdInterstitial(interstitialAdUnitId: String, timeoutMilliSecond: Int) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId, timeoutMilliSecond)
    }

    override fun showAdInterstitial(interstitialAdUnitId: String, keyword: List<String>) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId, keyword)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        callback: IFrogoAdInterstitial
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId, timeoutMilliSecond, callback)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        keyword: List<String>,
        callback: IFrogoAdInterstitial
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial")
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId, keyword, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdRewarded(mAdUnitIdRewarded: String, callback: IFrogoAdRewarded) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewarded")
        FrogoAdmob.showAdRewarded(this, mAdUnitIdRewarded, callback)
    }

    override fun showAdRewarded(
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        callback: IFrogoAdRewarded
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewarded")
        FrogoAdmob.showAdRewarded(this, mAdUnitIdRewarded, timeoutMilliSecond, callback)
    }

    override fun showAdRewarded(
        mAdUnitIdRewarded: String,
        keyword: List<String>,
        callback: IFrogoAdRewarded
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewarded")
        FrogoAdmob.showAdRewarded(this, mAdUnitIdRewarded, keyword, callback)
    }

    override fun showAdRewarded(
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: IFrogoAdRewarded
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewarded")
        FrogoAdmob.showAdRewarded(this, mAdUnitIdRewarded, timeoutMilliSecond, keyword, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        callback: IFrogoAdRewarded
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewardedInterstitial")
        FrogoAdmob.showAdRewardedInterstitial(this, mAdUnitIdRewardedInterstitial, callback)
    }

    override fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int,
        callback: IFrogoAdRewarded
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewardedInterstitial")
        FrogoAdmob.showAdRewardedInterstitial(
            this,
            mAdUnitIdRewardedInterstitial,
            timeoutMilliSecond,
            callback
        )
    }

    override fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        keyword: List<String>,
        callback: IFrogoAdRewarded
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewardedInterstitial")
        FrogoAdmob.showAdRewardedInterstitial(
            this,
            mAdUnitIdRewardedInterstitial,
            keyword,
            callback
        )
    }

    override fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: IFrogoAdRewarded
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.showAdRewardedInterstitial")
        FrogoAdmob.showAdRewardedInterstitial(
            this,
            mAdUnitIdRewardedInterstitial,
            timeoutMilliSecond,
            keyword,
            callback
        )
    }

    // ---------------------------------------------------------------------------------------------

    override fun setupUnityAdApp(testMode: Boolean, unityGameId: String) {
        FrogoUnityAd.setupUnityAdApp(this, testMode, unityGameId)
    }

    override fun setupUnityAdApp(
        testMode: Boolean,
        unityGameId: String,
        callback: IFrogoUnityAdInitialization
    ) {
        FrogoUnityAd.setupUnityAdApp(this, testMode, unityGameId, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showUnityAdInterstitial(adInterstitialUnitId: String) {
        FrogoUnityAd.showAdInterstitial(this, adInterstitialUnitId)
    }

    override fun showUnityAdInterstitial(
        adInterstitialUnitId: String,
        callback: IFrogoUnityAdInterstitial
    ) {
        FrogoUnityAd.showAdInterstitial(this, adInterstitialUnitId, callback)
    }

    // ---------------------------------------------------------------------------------------------

    // Mixed Ads Admob >> Unity
    override fun showAdmobXUnityAdInterstitial(
        admobInterstitialId: String,
        unityInterstitialId: String,
        callback: IFrogoMixedAdsInterstitial
    ) {
        showAdInterstitial(admobInterstitialId, object : IFrogoAdInterstitial {
            override fun onShowAdRequestProgress(tag: String, message: String) {
                callback.onShowAdRequestProgress(tag, message)
            }

            override fun onHideAdRequestProgress(tag: String, message: String) {
                callback.onHideAdRequestProgress(tag, message)
            }

            override fun onAdDismissed(tag: String, message: String) {
                callback.onAdDismissed(tag, message)
            }

            override fun onAdFailed(tag: String, errorMessage: String) {
                showUnityAdInterstitial(unityInterstitialId,
                    object : IFrogoUnityAdInterstitial {
                        override fun onClicked(tag: String, message: String) {
                            callback.onClicked(tag, message)
                        }

                        override fun onShowAdRequestProgress(tag: String, message: String) {
                            callback.onShowAdRequestProgress(tag, message)
                        }

                        override fun onHideAdRequestProgress(tag: String, message: String) {
                            callback.onHideAdRequestProgress(tag, message)
                        }

                        override fun onAdDismissed(tag: String, message: String) {
                            callback.onAdDismissed(tag, message)
                        }

                        override fun onAdFailed(tag: String, errorMessage: String) {
                            callback.onAdFailed(tag, errorMessage)
                        }

                        override fun onAdLoaded(tag: String, message: String) {
                            callback.onAdLoaded(tag, message)
                        }

                        override fun onAdShowed(tag: String, message: String) {
                            callback.onAdShowed(tag, message)
                        }
                    })
            }

            override fun onAdLoaded(tag: String, message: String) {
                callback.onAdLoaded(tag, message)
            }

            override fun onAdShowed(tag: String, message: String) {
                callback.onAdShowed(tag, message)
            }
        })
    }

    // Mixed Ads Unity >> Admob
    override fun showUnityXAdmobAdInterstitial(
        admobInterstitialId: String,
        unityInterstitialId: String,
        callback: IFrogoMixedAdsInterstitial
    ) {
        showUnityAdInterstitial(unityInterstitialId, object : IFrogoUnityAdInterstitial {
            override fun onAdDismissed(tag: String, message: String) {
                callback.onAdDismissed(tag, message)
            }

            override fun onAdFailed(tag: String, errorMessage: String) {
                showAdInterstitial(admobInterstitialId,
                    object : IFrogoAdInterstitial {
                        override fun onShowAdRequestProgress(tag: String, message: String) {
                            callback.onShowAdRequestProgress(tag, message)
                        }

                        override fun onHideAdRequestProgress(tag: String, message: String) {
                            callback.onHideAdRequestProgress(tag, message)
                        }

                        override fun onAdDismissed(tag: String, message: String) {
                            callback.onAdDismissed(tag, message)
                        }

                        override fun onAdFailed(tag: String, errorMessage: String) {
                            callback.onAdFailed(tag, errorMessage)
                        }

                        override fun onAdLoaded(tag: String, message: String) {
                            callback.onAdLoaded(tag, message)
                        }

                        override fun onAdShowed(tag: String, message: String) {
                            callback.onAdShowed(tag, message)
                        }
                    })
            }

            override fun onAdLoaded(tag: String, message: String) {
                callback.onAdLoaded(tag, message)
            }

            override fun onAdShowed(tag: String, message: String) {
                callback.onAdShowed(tag, message)
            }

            override fun onClicked(tag: String, message: String) {
                callback.onClicked(tag, message)
            }

            override fun onShowAdRequestProgress(tag: String, message: String) {
                callback.onShowAdRequestProgress(tag, message)
            }

            override fun onHideAdRequestProgress(tag: String, message: String) {
                callback.onHideAdRequestProgress(tag, message)
            }
        })
    }

    // ---------------------------------------------------------------------------------------------

    override fun onResume() {
        super.onResume()
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.resume()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.pause()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.destroy()
            }
        }
        
    }

}