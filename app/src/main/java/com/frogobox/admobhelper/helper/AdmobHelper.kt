package com.frogobox.admobhelper.helper

import android.content.Context
import android.util.Log
import com.frogobox.admobhelper.R
import com.frogobox.admobhelper.helper.Constant.Var.RECYCLER_VIEW_ITEMS_PER_AD
import com.google.android.gms.ads.*
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener

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
class AdmobHelper {

    object Publisher {

        fun setupPublisher(context: Context) {
            MobileAds.initialize(context, context.getString(R.string.admob_publisher_id))
        }

    }

    object Interstitial {

        fun setupInterstitial(context: Context, mInterstitialAd: InterstitialAd) {
            mInterstitialAd.adUnitId = context.getString(R.string.admob_interstitial)
            mInterstitialAd.loadAd(AdRequest.Builder().build())
            mInterstitialAd.adListener = object : AdListener() {
                override fun onAdClosed() {
                    mInterstitialAd.loadAd(AdRequest.Builder().build())
                }

                override fun onAdLoaded() {
                    Log.d("Interstitial Load State", "loaded");
                }

                override fun onAdFailedToLoad(i: Int) {
                    Log.w("Interstitial Load State", "onAdFailedToLoad:" + i)
                }
            }
        }

        fun showInterstitial(mInterstitialAd: InterstitialAd) {
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                Log.d("Interstitial Ads State", "The interstitial wasn't loaded yet.")
            }
        }

    }

    object Banner {

        fun setupBanner(mAdView: AdView) {
            mAdView.adListener = object : AdListener() {
                override fun onAdLoaded() {}
                override fun onAdFailedToLoad(errorCode: Int) {}
                override fun onAdOpened() {}
                override fun onAdClicked() {}
                override fun onAdLeftApplication() {}
                override fun onAdClosed() {}
            }
        }

        fun showBanner(mAdView: AdView){
            mAdView.loadAd(AdRequest.Builder().build())
        }

    }
    
    object RecyclerView {

        fun loadRecyclerBannerAds(context: Context, recyclerViewDataList: MutableList<Any>) { // Load the first banner ad in the items list (subsequent ads will be loaded automatically in sequence).
            addBannerAds(context, recyclerViewDataList)
            loadBannerAd(recyclerViewDataList, 0)
        }

        private fun addBannerAds(context: Context, recyclerViewDataList: MutableList<Any>) { // Loop through the items array and place a new banner ad in every ith position in the items List.
            var i = 0
            while (i <= recyclerViewDataList.size) {
                val adView = AdView(context)
                adView.adSize = AdSize.BANNER
                adView.adUnitId = context.getString(R.string.admob_banner)
                recyclerViewDataList.add(i, adView)
                i += RECYCLER_VIEW_ITEMS_PER_AD
            }
        }

        private fun loadBannerAd(recyclerViewDataList: MutableList<Any>, index: Int) {
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
                    loadBannerAd(recyclerViewDataList,index + RECYCLER_VIEW_ITEMS_PER_AD)
                }

                override fun onAdFailedToLoad(errorCode: Int) { // The previous banner ad failed to load. Call this method again to load the next ad in the items list.
                    Log.e(
                        "MainActivity", "The previous banner ad failed to load. Attempting to"
                                + " load the next banner ad in the items list."
                    )
                    loadBannerAd(recyclerViewDataList,index + RECYCLER_VIEW_ITEMS_PER_AD)
                }
            }
            // Load the banner ad.
            adView.loadAd(AdRequest.Builder().build())
        }
        
    }

    object Video {

        fun setupVideo(
            context: Context,
            rewardedVideoAdListener: RewardedVideoAdListener,
            mRewardedVideoAd: RewardedVideoAd
        ) {
            mRewardedVideoAd.rewardedVideoAdListener = rewardedVideoAdListener
            mRewardedVideoAd.loadAd(
                context.getString(R.string.admob_rewarded_video),
                AdRequest.Builder().build()
            )
        }

        fun showVideo(mRewardedVideoAd: RewardedVideoAd) {
            if (mRewardedVideoAd.isLoaded) {
                mRewardedVideoAd.show()
            }
        }

    }

}