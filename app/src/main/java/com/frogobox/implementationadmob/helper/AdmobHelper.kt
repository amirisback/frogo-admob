package com.frogobox.implementationadmob.helper

import android.content.Context
import android.util.Log
import com.frogobox.implementationadmob.R
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
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
 * com.frogobox.implementationadmob
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