package com.frogobox.admob.core

import android.content.Context
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

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
            listener: IFrogoAdBanner
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
            listener: IFrogoAdBanner
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
            callback: IFrogoAdInterstitial
        )

    }

    // ---------------------------------------------------------------------------------------------

    interface Rewarded {

        fun showRewarded(
            activity: AppCompatActivity,
            mAdUnitIdRewarded: String,
            callback: IFrogoAdRewarded
        )

        fun showRewardedInterstitial(
            activity: AppCompatActivity,
            mAdUnitIdRewardedInterstitial: String,
            callback: IFrogoAdRewarded
        )

    }

    // ---------------------------------------------------------------------------------------------

    interface RecyclerView {

        fun loadRecyclerBannerAds(
            bannerAdUnitId: String,
            context: Context,
            recyclerViewDataList: MutableList<Any>
        )

        fun addBannerAds(
            bannerAdUnitId: String,
            context: Context,
            recyclerViewDataList: MutableList<Any>
        )

        fun loadBannerAd(recyclerViewDataList: MutableList<Any>, index: Int)

    }

    // ---------------------------------------------------------------------------------------------

}