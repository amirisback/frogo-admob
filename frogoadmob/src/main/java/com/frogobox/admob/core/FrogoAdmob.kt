package com.frogobox.admob.core

import android.content.Context
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogolog.FLog
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback


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
object FrogoAdmob : IFrogoAdmob {

    val TAG = FrogoAdmob::class.java.simpleName

    private var mInterstitialAd: InterstitialAd? = null
    private var mRewardedAd: RewardedAd? = null
    private var mRewardedInterstitialAd: RewardedInterstitialAd? = null

    // ---------------------------------------------------------------------------------------------

    override fun setupAdmobApp(context: Context) {
        MobileAds.initialize(context) {}
        FLog.d("Admob mobile Ads Initialized")
    }

    // ---------------------------------------------------------------------------------------------

    object Banner : IFrogoAdmob.Banner {

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

        private fun frogoAdListener(listener: IFrogoBanner): AdListener {
            return object : AdListener() {
                override fun onAdLoaded() {
                    FLog.d("Ads Banner onAdLoaded")
                    listener.onAdLoaded()
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    FLog.d("Ads Banner onAdFailedToLoad")
                    listener.onAdFailedToLoad(p0)
                }

                override fun onAdOpened() {
                    FLog.d("Ads Banner onAdOpened")
                    listener.onAdOpened()
                }

                override fun onAdClicked() {
                    FLog.d("Ads Banner onAdClicked")
                    listener.onAdClicked()
                }

                override fun onAdClosed() {
                    FLog.d("Ads Banner onAdClosed")
                    listener.onAdClosed()
                }
            }
        }

        override fun showBanner(mAdView: AdView) {
            mAdView.adListener = frogoAdListener()
            mAdView.loadAd(AdRequest.Builder().build())
            FLog.d("Banner Id : Attach on Xml Layout")
        }

        override fun showBanner(mAdView: AdView, listener: IFrogoBanner) {
            mAdView.adListener = frogoAdListener(listener)
            mAdView.loadAd(AdRequest.Builder().build())
            FLog.d("Banner Id : Attach on Xml Layout")
        }

        override fun showBannerContainer(
            context: Context,
            bannerAdUnitId: String,
            mAdsSize: AdSize,
            container: RelativeLayout
        ) {
            FLog.d("Banner Id : $bannerAdUnitId")
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
            FLog.d("Banner Id : $bannerAdUnitId")
            val mAdView = AdView(context)
            mAdView.adUnitId = bannerAdUnitId
            mAdView.adSize = mAdsSize
            mAdView.adListener = frogoAdListener(listener)
            container.addView(mAdView)
            mAdView.loadAd(AdRequest.Builder().build())
        }

    }

    // ---------------------------------------------------------------------------------------------

    object Interstitial : IFrogoAdmob.Interstitial {

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
                    callback.onAdFailedToLoad()
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    FLog.d("Ad was loaded.")
                    FLog.d("onAdLoaded() success")
                    FLog.d("You Can Give Your Reward Here")
                    mInterstitialAd = interstitialAd
                    callback.onAdLoaded()
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
                    callback.onAdClosed()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                    // Don't forget to set the ad reference to null so you
                    // don't show the ad a second time.
                    FLog.d("Ad failed to show.")
                    mInterstitialAd = null
                    callback.onAdFailedToShow()
                }

                override fun onAdShowedFullScreenContent() {
                    // Called when ad is dismissed.
                    FLog.d("Ad showed fullscreen content.")
                }
            }
        }

        private fun loadInterstitialAd(activity: AppCompatActivity, interstitialAdUnitId: String) {
            FLog.d("Interstitial Id : $interstitialAdUnitId")
            InterstitialAd.load(
                activity,
                interstitialAdUnitId,
                AdRequest.Builder().build(),
                frogoInterstitialCallback()
            )
        }

        private fun loadInterstitialAd(
            activity: AppCompatActivity,
            interstitialAdUnitId: String,
            callback: IFrogoInterstitial
        ) {
            FLog.d("Interstitial Id : $interstitialAdUnitId")
            InterstitialAd.load(
                activity,
                interstitialAdUnitId,
                AdRequest.Builder().build(),
                frogoInterstitialCallback(callback)
            )
        }

        override fun showInterstitial(activity: AppCompatActivity, interstitialAdUnitId: String) {
            loadInterstitialAd(activity, interstitialAdUnitId)
            if (mInterstitialAd != null) {
                mInterstitialAd!!.fullScreenContentCallback = frogoFullScreenContentCallback()
                mInterstitialAd!!.show(activity)
            }
        }

        override fun showInterstitial(
            activity: AppCompatActivity,
            interstitialAdUnitId: String,
            callback: IFrogoInterstitial
        ) {
            loadInterstitialAd(activity, interstitialAdUnitId, callback)
            if (mInterstitialAd != null) {
                mInterstitialAd!!.fullScreenContentCallback =
                    frogoFullScreenContentCallback(callback)
                mInterstitialAd!!.show(activity)
            }
        }

    }

    // ---------------------------------------------------------------------------------------------

    object Rewarded : IFrogoAdmob.Rewarded {

        override fun setupRewarded(context: Context, mAdUnitIdRewarded: String) {
            val adRequest = AdRequest.Builder().build()

            RewardedAd.load(
                context,
                mAdUnitIdRewarded,
                adRequest,
                object : RewardedAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        FLog.d(adError.message)
                        mRewardedAd = null
                    }

                    override fun onAdLoaded(rewardedAd: RewardedAd) {
                        FLog.d("Ad was loaded.")
                        mRewardedAd = rewardedAd
                        mRewardedAd!!.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdShowedFullScreenContent() {
                                    // Called when ad is shown.
                                    FLog.d("Ad was shown.")
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                                    // Called when ad fails to show.
                                    FLog.d("Ad failed to show.")
                                }

                                override fun onAdDismissedFullScreenContent() {
                                    // Called when ad is dismissed.
                                    // Set the ad reference to null so you don't show the ad a second time.
                                    FLog.d("Ad was dismissed.")
                                    mRewardedAd = null
                                }
                            }

                    }
                })
        }

        override fun showRewarded(
            activity: AppCompatActivity,
            callback: IFrogoAdmob.UserEarned
        ) {
            if (mRewardedAd != null) {
                mRewardedAd?.show(activity) {
                    callback.onUserEarnedReward(it)
                }
            } else {
                FLog.d("The rewarded ad wasn't ready yet.")
            }
        }

    }

    object RewardedInterstitial : IFrogoAdmob.RewardedInterstitial {

        override fun setupRewardedInterstitial(
            context: Context,
            mAdUnitIdRewardedInterstitial: String
        ) {
            RewardedInterstitialAd.load(context,
                mAdUnitIdRewardedInterstitial,
                AdRequest.Builder().build(),
                object : RewardedInterstitialAdLoadCallback() {
                    override fun onAdLoaded(ad: RewardedInterstitialAd) {
                        mRewardedInterstitialAd = ad
                        mRewardedInterstitialAd!!.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                /** Called when the ad failed to show full screen content.  */
                                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                    FLog.i("onAdFailedToShowFullScreenContent")
                                }

                                /** Called when ad showed the full screen content.  */
                                override fun onAdShowedFullScreenContent() {
                                    FLog.i("onAdShowedFullScreenContent")
                                }

                                /** Called when full screen content is dismissed.  */
                                override fun onAdDismissedFullScreenContent() {
                                    FLog.i("onAdDismissedFullScreenContent")
                                }
                            }
                        FLog.e("onAdLoaded")
                    }

                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        FLog.e("onAdFailedToLoad")
                    }
                })
        }

        override fun showRewardedInterstitial(
            activity: AppCompatActivity,
            callback: IFrogoAdmob.UserEarned
        ) {
            if (mRewardedInterstitialAd != null) {
                mRewardedInterstitialAd?.show(activity) {
                    callback.onUserEarnedReward(it)
                }
            } else {
                FLog.d("The rewarded ad wasn't ready yet.")
            }
        }

    }

    object RecyclerView : IFrogoAdmob.RecyclerView {

        override fun loadRecyclerBannerAds(
            bannerAdUnitId: String,
            context: Context,
            recyclerViewDataList: MutableList<Any>
        ) { // Load the first banner ad in the items list (subsequent ads will be loaded automatically in sequence).
            addBannerAds(bannerAdUnitId, context, recyclerViewDataList)
            loadBannerAd(recyclerViewDataList, 0)
        }

        override fun addBannerAds(
            bannerAdUnitId: String,
            context: Context,
            recyclerViewDataList: MutableList<Any>
        ) {
            // Loop through the items array and place a new banner ad in every ith position in the items List.
            var i = 0
            while (i <= recyclerViewDataList.size) {
                val adView = AdView(context)
                adView.adSize = AdSize.BANNER
                adView.adUnitId = bannerAdUnitId
                recyclerViewDataList.add(i, adView)
                i += FrogoAdmobConstant.RECYCLER_VIEW_ITEMS_PER_AD
            }
        }

        override fun loadBannerAd(recyclerViewDataList: MutableList<Any>, index: Int) {
            if (index >= recyclerViewDataList.size) {
                return
            }
            val item: Any = recyclerViewDataList.get(index) as? AdView
                ?: throw ClassCastException(
                    "Expected item at index " + index + " to be a banner ad"
                            + " ad."
                )
            val adView = item as AdView
            // Set an AdListener on the AdView to wait for the previous banner ad to finish loading before loading the next ad in the items list.
            adView.adListener = object : AdListener() {
                override fun onAdLoaded() {
                    super.onAdLoaded()
                    // The previous banner ad loaded successfully, call this method again to
                    // load the next ad in the items list.
                    loadBannerAd(
                        recyclerViewDataList,
                        index + FrogoAdmobConstant.RECYCLER_VIEW_ITEMS_PER_AD
                    )
                }

                override fun onAdFailedToLoad(p0: LoadAdError) { // The previous banner ad failed to load. Call this method again to load the next ad in the items list.
                    FLog.e("The previous banner ad failed to load. Attempting to load the next banner ad in the items list.")
                    loadBannerAd(
                        recyclerViewDataList,
                        index + FrogoAdmobConstant.RECYCLER_VIEW_ITEMS_PER_AD
                    )
                }
            }
            // Load the banner ad.
            adView.loadAd(AdRequest.Builder().build())
        }

    }

}