package com.frogobox.frogoadmobhelper

import android.content.Context
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener

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
interface FrogoAdmobView {
    fun setupPublisherID(mPublisherId : String)
    fun setupBannerAdUnitID(mAdUnitId : String)
    fun setupInterstialAdUnitID(mAdUnitId : String)
    fun setupRewardedAdUnitID(mAdUnitId : String)

    interface Publisher {
        fun setupPublisher(context: Context)
    }

    interface Banner {
        fun setupBanner(mAdView: AdView)
        fun showBanner(mAdView: AdView)
    }

    interface Interstitial {
        fun setupInterstitial(mInterstitialAd: InterstitialAd)
        fun showInterstitial(mInterstitialAd: InterstitialAd)
    }

    interface Video {
        fun setupVideo(rewardedVideoAdListener: RewardedVideoAdListener, mRewardedVideoAd: RewardedVideoAd)
        fun showVideo(mRewardedVideoAd: RewardedVideoAd)
    }

    interface RecyclerView {
        fun loadRecyclerBannerAds(context: Context, recyclerViewDataList: MutableList<Any>)
        fun addBannerAds(context: Context, recyclerViewDataList: MutableList<Any>)
        fun loadBannerAd(recyclerViewDataList: MutableList<Any>, index: Int)
    }


}