package com.frogobox.admob.core

import android.content.Context
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogolog.FLog
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


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
object FrogoAdmob2 {

    private val TAG = "FrogoAdmob"

    private lateinit var mAdUnitIdInterstitial: String
    private lateinit var mAdUnitIdBanner: String

    private var mInterstitialAd: InterstitialAd? = null

    private fun frogoAdListener(): AdListener {
        return object : AdListener() {
            override fun onAdLoaded() {
                FLog.d("Ads Banner onAdLoaded")
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                FLog.d("Ads Banner onAdFailedToLoad")
            }

            override fun onAdOpened() {
                FLog.d("Ads Banner onAdOpened")
            }

            override fun onAdClicked() {
                FLog.d("Ads Banner onAdClicked")
            }

            override fun onAdClosed() {
                FLog.d("Ads Banner onAdClosed")
            }
        }
    }

    private fun frogoAdListener(bannerListener: IFrogoBanner): AdListener {
        return object : AdListener() {
            override fun onAdLoaded() {
                FLog.d("Ads Banner onAdLoaded")
                bannerListener.onAdLoaded()
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                FLog.d("Ads Banner onAdFailedToLoad")
                bannerListener.onAdFailedToLoad(p0)
            }

            override fun onAdOpened() {
                FLog.d("Ads Banner onAdOpened")
                bannerListener.onAdOpened()
            }

            override fun onAdClicked() {
                FLog.d("Ads Banner onAdClicked")
                bannerListener.onAdClicked()
            }

            override fun onAdClosed() {
                FLog.d("Ads Banner onAdClosed")
                bannerListener.onAdClosed()
            }
        }
    }

    // ---------------------------------------------------------------------------------------------

    fun setupAdmobApp(context: Context) {
        MobileAds.initialize(context) {}
        FLog.d("Admob mobile Ads Initialized")
    }

    // ---------------------------------------------------------------------------------------------

    object Banner : IAdBanner {
        override fun showBanner(mAdView: AdView, bannerAdUnitId: String) {
            mAdView.adListener = frogoAdListener()
            mAdView.loadAd(AdRequest.Builder().build())
            mAdUnitIdBanner = bannerAdUnitId
            FLog.d("Banner Id : $mAdUnitIdBanner")
        }

        override fun showBanner(
            mAdView: AdView,
            bannerAdUnitId: String,
            listener: IFrogoBanner
        ) {
            mAdView.adListener = frogoAdListener(listener)
            mAdView.loadAd(AdRequest.Builder().build())
            mAdUnitIdBanner = bannerAdUnitId
            FLog.d("Banner Id : $mAdUnitIdBanner")
        }

        override fun showBannerContainer(
            context: Context,
            bannerAdUnitId: String,
            mAdsSize: AdSize,
            container: RelativeLayout
        ) {
            mAdUnitIdBanner = bannerAdUnitId
            FLog.d("Banner Id : $mAdUnitIdBanner")
            val mAdView = AdView(context)
            mAdView.adUnitId = bannerAdUnitId
            mAdView.adSize = mAdsSize
            mAdView.adListener = frogoAdListener()
            container.addView(mAdView)
            mAdView.loadAd(AdRequest.Builder().build())
        }

        override fun showBannerContainer(
            context: Context,
            bannerAdUnitId: String,
            mAdsSize: AdSize,
            container: RelativeLayout,
            listener: IFrogoBanner
        ) {
            mAdUnitIdBanner = bannerAdUnitId
            FLog.d("Banner Id : $mAdUnitIdBanner")
            val mAdView = AdView(context)
            mAdView.adUnitId = bannerAdUnitId
            mAdView.adSize = mAdsSize
            mAdView.adListener = frogoAdListener(listener)
            container.addView(mAdView)
            mAdView.loadAd(AdRequest.Builder().build())
        }
    }

    // ---------------------------------------------------------------------------------------------

    object Interstitial : IAdInterstitial {

        private fun frogoInterstitialCallback(): InterstitialAdLoadCallback {
            return object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    val error =
                        "domain: ${adError.domain}, code: ${adError.code}, message: ${adError.message}"
                    FLog.d(adError.message)
                    FLog.d("onAdFailedToLoad() with error $error")
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    FLog.d("Ad was loaded.")
                    FLog.d("onAdLoaded() success")
                    mInterstitialAd = interstitialAd
                }
            }
        }

        private fun frogoInterstitialCallback(callback: IFrogoInterstitial): InterstitialAdLoadCallback {
            return object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    val error =
                        "domain: ${adError.domain}, code: ${adError.code}, message: ${adError.message}"
                    FLog.d(adError.message)
                    FLog.d("onAdFailedToLoad() with error $error")
                    mInterstitialAd = null
                    callback.onAdFailedToLoadAndShow()
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    FLog.d("Ad was loaded.")
                    FLog.d("onAdLoaded() success")
                    mInterstitialAd = interstitialAd
                    callback.onAdLoaded(interstitialAd)
                }
            }
        }

        private fun frogoFullScreenContentCallback(): FullScreenContentCallback {
            return object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    // Don't forget to set the ad reference to null so you
                    // don't show the ad a second time.
                    FLog.d("Ad was dismissed.")
                    mInterstitialAd = null
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                    // Don't forget to set the ad reference to null so you
                    // don't show the ad a second time.
                    FLog.d("Ad failed to show.")
                    mInterstitialAd = null
                }

                override fun onAdShowedFullScreenContent() {
                    // Called when ad is dismissed.
                    FLog.d("Ad showed fullscreen content.")
                }
            }
        }

        private fun frogoFullScreenContentCallback(callback: IFrogoInterstitial): FullScreenContentCallback {
            return object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    // Don't forget to set the ad reference to null so you
                    // don't show the ad a second time.
                    FLog.d("Ad was dismissed.")
                    FLog.d("Ad was closed and do callback.onClosedAd")
                    mInterstitialAd = null
                    callback.onClosedAd()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                    // Don't forget to set the ad reference to null so you
                    // don't show the ad a second time.
                    FLog.d("Ad failed to show.")
                    mInterstitialAd = null
                    callback.onAdFailedToLoadAndShow()
                }

                override fun onAdShowedFullScreenContent() {
                    // Called when ad is dismissed.
                    FLog.d("Ad showed fullscreen content.")
                }
            }
        }

        private fun loadInterstitialAd(activity: AppCompatActivity, interstitialAdUnitId: String) {
            mAdUnitIdInterstitial = interstitialAdUnitId
            FLog.d("Interstitial Id : $mAdUnitIdInterstitial")
            InterstitialAd.load(
                activity,
                interstitialAdUnitId,
                AdRequest.Builder().build(),
                frogoInterstitialCallback()
            )
        }

        private fun loadInterstitialAd(activity: AppCompatActivity, interstitialAdUnitId: String, callback: IFrogoInterstitial) {
            mAdUnitIdInterstitial = interstitialAdUnitId
            FLog.d("Interstitial Id : $mAdUnitIdInterstitial")
            InterstitialAd.load(
                activity,
                interstitialAdUnitId,
                AdRequest.Builder().build(),
                frogoInterstitialCallback(callback)
            )
        }

        override fun showInterstitial(activity: AppCompatActivity, interstitialAdUnitId: String, ) {
            loadInterstitialAd(activity, interstitialAdUnitId)
            if (mInterstitialAd != null) {
                mInterstitialAd!!.fullScreenContentCallback = frogoFullScreenContentCallback()
                mInterstitialAd!!.show(activity)
            }
        }

        override fun showInterstitial(activity: AppCompatActivity, interstitialAdUnitId: String, callback: IFrogoInterstitial) {
            loadInterstitialAd(activity, interstitialAdUnitId, callback)
            if (mInterstitialAd != null) {
                mInterstitialAd!!.fullScreenContentCallback = frogoFullScreenContentCallback(callback)
                mInterstitialAd!!.show(activity)
            }
        }

    }

    // ---------------------------------------------------------------------------------------------

}