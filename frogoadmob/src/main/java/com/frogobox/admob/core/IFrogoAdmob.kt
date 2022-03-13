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

    fun setupAdmobApp(context: Context)

    // ---------------------------------------------------------------------------------------------

    interface Banner {

        fun showBanner(mAdView: AdView)

        fun showBanner(
            mAdView: AdView,
            listener: IFrogoBanner
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
            listener: IFrogoBanner
        )

    }

    // ---------------------------------------------------------------------------------------------

    interface Interstitial {

        fun showInterstitial(
            activity: AppCompatActivity,
            interstitialAdUnitId: String
        )

        fun showInterstitial(
            activity: AppCompatActivity,
            interstitialAdUnitId: String,
            callback: IFrogoInterstitial
        )

    }

    // ---------------------------------------------------------------------------------------------

    interface Rewarded{

        fun setupRewarded(context: Context, mAdUnitIdRewarded: String)

        fun showRewarded(activity: AppCompatActivity, callback: IFrogoAdmob.UserEarned)

    }

    // ---------------------------------------------------------------------------------------------

    interface RewardedInterstitial {

        fun setupRewardedInterstitial(context: Context, mAdUnitIdRewardedInterstitial : String)

        fun showRewardedInterstitial(activity: AppCompatActivity, callback: IFrogoAdmob.UserEarned)

    }

    // ---------------------------------------------------------------------------------------------

    interface UserEarned {

        fun onUserEarnedReward(rewardItem: RewardItem)

    }

    // ---------------------------------------------------------------------------------------------

    interface RecyclerView {

        fun loadRecyclerBannerAds(bannerAdUnitId: String, context: Context, recyclerViewDataList: MutableList<Any>)

        fun addBannerAds(bannerAdUnitId: String, context: Context, recyclerViewDataList: MutableList<Any>)

        fun loadBannerAd(recyclerViewDataList: MutableList<Any>, index: Int)

    }

    // ---------------------------------------------------------------------------------------------

}