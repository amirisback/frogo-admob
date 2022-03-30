package com.frogobox.admob.ui

import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.core.*
import com.frogobox.log.FLog
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
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.setupAdmobApp ")
        FrogoAdmob.setupAdmobApp(this)
        FrogoAdConsent.showConsent(this)
    }

    override fun showAdBanner(mAdView: AdView) {
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner ")
        FrogoAdmob.showAdBanner(mAdView)
    }

    override fun showAdBanner(mAdView: AdView, listener: IFrogoAdBanner) {
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdBanner ")
        FrogoAdmob.showAdBanner(mAdView, listener)
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout
    ) {
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer ")
        FrogoAdmob.showAdBannerContainer(this, bannerAdUnitId, mAdsSize, container)
    }

    override fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        listener: IFrogoAdBanner
    ) {
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdBannerContainer ")
        FrogoAdmob.showAdBannerContainer(this, bannerAdUnitId, mAdsSize, container, listener)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdInterstitial(interstitialAdUnitId: String) {
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial ")
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        callback: IFrogoAdInterstitial
    ) {
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial ")
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId, callback)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        keyword: List<String>,
        callback: IFrogoAdInterstitial
    ) {
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial ")
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
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial ")
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId, timeoutMilliSecond, keyword)
    }

    override fun showAdInterstitial(interstitialAdUnitId: String, timeoutMilliSecond: Int) {
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial ")
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId, timeoutMilliSecond)
    }

    override fun showAdInterstitial(interstitialAdUnitId: String, keyword: List<String>) {
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial ")
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId, keyword)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        callback: IFrogoAdInterstitial
    ) {
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial ")
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId, timeoutMilliSecond, callback)
    }

    override fun showAdInterstitial(
        interstitialAdUnitId: String,
        keyword: List<String>,
        callback: IFrogoAdInterstitial
    ) {
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdInterstitial ")
        FrogoAdmob.showAdInterstitial(this, interstitialAdUnitId, keyword, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdRewarded(mAdUnitIdRewarded: String, callback: IFrogoAdRewarded) {
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdRewarded ")
        FrogoAdmob.showAdRewarded(this, mAdUnitIdRewarded, callback)
    }

    override fun showAdRewardedInterstitial(
        mAdUnitIdRewardedInterstitial: String,
        callback: IFrogoAdRewarded
    ) {
        FLog.d("$TAG : Run From $TAG class : FrogoAdmob.showAdRewardedInterstitial ")
        FrogoAdmob.showAdRewardedInterstitial(this, mAdUnitIdRewardedInterstitial, callback)
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
            override fun onAdDismissed(tag: String, message: String) {
                callback.onAdDismissed(tag, message)
            }

            override fun onAdFailed(tag: String, errorMessage: String) {
                showUnityAdInterstitial(unityInterstitialId,
                    object : IFrogoUnityAdInterstitial {
                        override fun onClicked(tag: String, message: String) {
                            callback.onClicked(tag, message)
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
        })
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