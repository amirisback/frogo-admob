package com.frogobox.admob.core.admob

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.core.FrogoRvConstant.RECYCLER_VIEW_ITEMS_PER_AD
import com.frogobox.frogolog.FrogoLog
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

    private val TAG = "FrogoAdmob"

    private lateinit var admobPublisherID: String
    private lateinit var mAdUnitIdInterstitial: String
    private lateinit var mAdUnitIdBanner: String
    private lateinit var mAdUnitIdRewarded: String
    private lateinit var mAdUnitIdRewardedInterstitial: String

    private var mInterstitialAd: InterstitialAd? = null
    private var mRewardedAd: RewardedAd? = null
    private var rewardedInterstitialAd: RewardedInterstitialAd? = null

    override fun setupPublisherID(mPublisherId: String) {
        admobPublisherID = mPublisherId
        FrogoLog.d(admobPublisherID)
    }

    override fun setupBannerAdUnitID(mAdUnitId: String) {
        mAdUnitIdBanner = mAdUnitId
        FrogoLog.d(mAdUnitIdBanner)
    }

    override fun setupInterstialAdUnitID(mAdUnitId: String) {
        mAdUnitIdInterstitial = mAdUnitId
        FrogoLog.d(mAdUnitIdInterstitial)
    }

    override fun setupRewardedAdUnitID(mAdUnitId: String) {
        mAdUnitIdRewarded = mAdUnitId
        FrogoLog.d(mAdUnitIdRewarded)
    }

    override fun setupRewardedInterstitialAdUnitID(mAdUnitId: String) {
        mAdUnitIdRewardedInterstitial = mAdUnitId
        FrogoLog.d(mAdUnitIdRewarded)
    }

    object Publisher : IFrogoAdmob.Publisher {
        override fun setupPublisher(context: Context) {
            MobileAds.initialize(context) {}
        }
    }

    object Banner : IFrogoAdmob.Banner {

        override fun setupBanner(mAdView: AdView) {
            mAdView.adListener = object : AdListener() {
                override fun onAdLoaded() {}
                override fun onAdFailedToLoad(p0: LoadAdError) {}
                override fun onAdOpened() {}
                override fun onAdClicked() {}
                override fun onAdClosed() {}
            }
        }

        override fun showBanner(mAdView: AdView) {
            mAdView.loadAd(AdRequest.Builder().build())
        }

    }

    object Interstitial : IFrogoAdmob.Interstitial {

        override fun setupInterstitial(context: Context) {
            val adRequest = AdRequest.Builder().build()

            InterstitialAd.load(
                context,
                mAdUnitIdInterstitial,
                adRequest,
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        Log.d(TAG, adError.message)
                        mInterstitialAd = null
                        val error =
                            "domain: ${adError.domain}, code: ${adError.code}, " + "message: ${adError.message}"
                        Log.d(TAG, "onAdFailedToLoad() with error $error")
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        Log.d(TAG, "Ad was loaded.")
                        mInterstitialAd = interstitialAd
                        Log.d(TAG, "onAdLoaded() success")
                    }
                }
            )
        }

        override fun showInterstitial(activity: AppCompatActivity) {
            if (mInterstitialAd != null) {
                mInterstitialAd!!.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        Log.d(TAG, "Ad was dismissed.")
                        // Don't forget to set the ad reference to null so you
                        // don't show the ad a second time.
                        mInterstitialAd = null
                        setupInterstitial(activity)
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                        Log.d(TAG, "Ad failed to show.")
                        // Don't forget to set the ad reference to null so you
                        // don't show the ad a second time.
                        mInterstitialAd = null
                    }

                    override fun onAdShowedFullScreenContent() {
                        Log.d(TAG, "Ad showed fullscreen content.")
                        // Called when ad is dismissed.
                    }
                }
                mInterstitialAd!!.show(activity)
            }
        }

    }

    object Rewarded : IFrogoAdmob.Rewarded {

        override fun setupRewarded(context: Context) {
            val adRequest = AdRequest.Builder().build()

            RewardedAd.load(
                context,
                mAdUnitIdRewarded,
                adRequest,
                object : RewardedAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        Log.d(TAG, adError.message)
                        mRewardedAd = null
                    }

                    override fun onAdLoaded(rewardedAd: RewardedAd) {
                        Log.d(TAG, "Ad was loaded.")
                        mRewardedAd = rewardedAd
                        mRewardedAd!!.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdShowedFullScreenContent() {
                                    // Called when ad is shown.
                                    Log.d(TAG, "Ad was shown.")
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                                    // Called when ad fails to show.
                                    Log.d(TAG, "Ad failed to show.")
                                }

                                override fun onAdDismissedFullScreenContent() {
                                    // Called when ad is dismissed.
                                    // Set the ad reference to null so you don't show the ad a second time.
                                    Log.d(TAG, "Ad was dismissed.")
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
                Log.d(TAG, "The rewarded ad wasn't ready yet.")
            }
        }

    }

    object RewardedInterstitial : IFrogoAdmob.RewardedInterstitial {

        val adRequest = AdRequest.Builder().build()

        override fun setupRewardedInterstitial(context: Context) {
            RewardedInterstitialAd.load(context, mAdUnitIdRewardedInterstitial, adRequest,
                object : RewardedInterstitialAdLoadCallback() {
                    override fun onAdLoaded(ad: RewardedInterstitialAd) {
                        rewardedInterstitialAd = ad
                        rewardedInterstitialAd!!.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                /** Called when the ad failed to show full screen content.  */
                                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                    Log.i(TAG, "onAdFailedToShowFullScreenContent")
                                }

                                /** Called when ad showed the full screen content.  */
                                override fun onAdShowedFullScreenContent() {
                                    Log.i(TAG, "onAdShowedFullScreenContent")
                                }

                                /** Called when full screen content is dismissed.  */
                                override fun onAdDismissedFullScreenContent() {
                                    Log.i(TAG, "onAdDismissedFullScreenContent")
                                }
                            }
                        Log.e(TAG, "onAdLoaded")
                    }

                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        Log.e(TAG, "onAdFailedToLoad")
                    }
                })
        }

        override fun showRewardedInterstitial(
            activity: AppCompatActivity,
            callback: IFrogoAdmob.UserEarned
        ) {
            if (rewardedInterstitialAd != null) {
                rewardedInterstitialAd?.show(activity) {
                    callback.onUserEarnedReward(it)
                }
            } else {
                Log.d(TAG, "The rewarded ad wasn't ready yet.")
            }
        }

    }

    object RecyclerView : IFrogoAdmob.RecyclerView {

        override fun loadRecyclerBannerAds(
            context: Context,
            recyclerViewDataList: MutableList<Any>
        ) { // Load the first banner ad in the items list (subsequent ads will be loaded automatically in sequence).
            addBannerAds(context, recyclerViewDataList)
            loadBannerAd(recyclerViewDataList, 0)
        }

        override fun addBannerAds(
            context: Context,
            recyclerViewDataList: MutableList<Any>
        ) {
            // Loop through the items array and place a new banner ad in every ith position in the items List.
            var i = 0
            while (i <= recyclerViewDataList.size) {
                val adView = AdView(context)
                adView.adSize = AdSize.BANNER
                adView.adUnitId = mAdUnitIdBanner
                recyclerViewDataList.add(i, adView)
                i += RECYCLER_VIEW_ITEMS_PER_AD
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
                    loadBannerAd(recyclerViewDataList, index + RECYCLER_VIEW_ITEMS_PER_AD)
                }

                override fun onAdFailedToLoad(p0: LoadAdError) { // The previous banner ad failed to load. Call this method again to load the next ad in the items list.
                    Log.e(
                        "MainActivity", "The previous banner ad failed to load. Attempting to"
                                + " load the next banner ad in the items list."
                    )
                    loadBannerAd(recyclerViewDataList, index + RECYCLER_VIEW_ITEMS_PER_AD)
                }
            }
            // Load the banner ad.
            adView.loadAd(AdRequest.Builder().build())
        }

    }

}