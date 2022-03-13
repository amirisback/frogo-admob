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

        fun showAdBanner(mAdView: AdView)

        fun showAdBanner(
            mAdView: AdView,
            listener: IFrogoAdBanner
        )

        fun showAdBannerContainer(
            context: Context,
            bannerAdUnitId: String,
            mAdsSize: AdSize,
            container: RelativeLayout
        )

        fun showAdBannerContainer(
            context: Context,
            bannerAdUnitId: String,
            mAdsSize: AdSize,
            container: RelativeLayout,
            listener: IFrogoAdBanner
        )

    }

    // ---------------------------------------------------------------------------------------------

    interface Interstitial {

        fun showAdInterstitial(
            activity: AppCompatActivity,
            interstitialAdUnitId: String
        )

        fun showAdInterstitial(
            activity: AppCompatActivity,
            interstitialAdUnitId: String,
            callback: IFrogoAdInterstitial
        )

    }

    // ---------------------------------------------------------------------------------------------

    interface Rewarded {

        fun showAdRewarded(
            activity: AppCompatActivity,
            mAdUnitIdRewarded: String,
            callback: IFrogoAdRewarded
        )

        fun showAdRewardedInterstitial(
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