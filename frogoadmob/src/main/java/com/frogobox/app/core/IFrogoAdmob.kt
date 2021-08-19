package com.frogobox.app.core

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
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

        fun setupBanner(mAdView: AdView)

        fun showBanner(mAdView: AdView)

    }

    interface Interstitial {

        fun setupInterstitial(context: Context)

        fun showInterstitial(activity: AppCompatActivity)

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