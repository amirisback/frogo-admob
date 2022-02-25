package com.frogobox.admob.core

import android.content.Context
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.rewarded.RewardItem

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
interface IFrogoAdmob {

    fun setupPublisherID(mPublisherId: String)

    fun setupBannerAdUnitID(mAdUnitId: String)

    fun setupInterstialAdUnitID(mAdUnitId: String)

    fun setupRewardedAdUnitID(mAdUnitId: String)

    fun setupRewardedInterstitialAdUnitID(mAdUnitId: String)

    interface Publisher {

        fun setupPublisher(context: Context)

    }

    interface Banner {

        fun showBanner(mAdView: AdView)

        fun showBanner(mAdView: AdView, bannerListener: IFrogoAdListener.Banner)

        fun showBannerContainer(context: Context, mAdsSize: AdSize, container: RelativeLayout)

        fun showBannerContainer(
            context: Context,
            mAdsSize: AdSize,
            container: RelativeLayout,
            bannerListener: IFrogoAdListener.Banner
        )

        fun showBannerContainer(
            context: Context,
            bannerAdUnitId: String,
            mAdsSize: AdSize,
            container: RelativeLayout
        )

        fun showBannerContainer(
            context: Context,
            bannerAdUnitId: String,
            mAdsSize: AdSize,
            container: RelativeLayout,
            bannerListener: IFrogoAdListener.Banner
        )

    }

    interface Interstitial {

        fun setupInterstitial(context: Context)

        fun setupInterstitial(context: Context, interstitialListener: IFrogoAdListener.Interstitial)

        fun setupInterstitial(context: Context, interstitialAdUnitId: String)

        fun setupInterstitial(
            context: Context,
            interstitialAdUnitId: String,
            interstitialListener: IFrogoAdListener.Interstitial
        )

        fun showInterstitial(activity: AppCompatActivity)

        fun showInterstitial(
            activity: AppCompatActivity,
            interstitialListener: IFrogoAdListener.Interstitial
        )

    }

    interface Rewarded {

        fun setupRewarded(context: Context)

        fun showRewarded(activity: AppCompatActivity, callback: UserEarned)

    }

    interface RewardedInterstitial {

        fun setupRewardedInterstitial(context: Context)

        fun showRewardedInterstitial(activity: AppCompatActivity, callback: UserEarned)

    }

    interface UserEarned {

        fun onUserEarnedReward(rewardItem: RewardItem)

    }

    interface RecyclerView {

        fun loadRecyclerBannerAds(context: Context, recyclerViewDataList: MutableList<Any>)

        fun addBannerAds(context: Context, recyclerViewDataList: MutableList<Any>)

        fun loadBannerAd(recyclerViewDataList: MutableList<Any>, index: Int)

    }

}