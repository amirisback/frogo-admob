package com.frogobox.admob.core

import android.content.Context
import android.widget.RelativeLayout
import com.frogobox.admob.callback.FrogoAdmobBannerCallback
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
 * com.frogobox.admob
 *
 */


interface IFrogoAdmobBanner {

    fun showAdBanner(
        mAdView: AdView,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: FrogoAdmobBannerCallback?
    )

    fun showAdBanner(mAdView: AdView)

    fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int)

    fun showAdBanner(mAdView: AdView, keyword: List<String>)

    fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int, keyword: List<String>)

    fun showAdBanner(mAdView: AdView, callback: FrogoAdmobBannerCallback)

    fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int, callback: FrogoAdmobBannerCallback)

    fun showAdBanner(mAdView: AdView, keyword: List<String>, callback: FrogoAdmobBannerCallback)

    // ---------------------------------------------------------------------------------------------

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: FrogoAdmobBannerCallback?
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        keyword: List<String>,
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        keyword: List<String>
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        callback: FrogoAdmobBannerCallback
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobBannerCallback
    )

    fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        keyword: List<String>,
        callback: FrogoAdmobBannerCallback
    )

}