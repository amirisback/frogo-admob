package com.frogobox.admob.ui

import android.widget.RelativeLayout
import com.frogobox.admob.core.IFrogoAdBanner
import com.frogobox.admob.core.IFrogoAdInterstitial
import com.frogobox.admob.core.IFrogoAdRewarded
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

/*
 * Created by faisalamir on 01/07/21
 * FrogoAdmob
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface IFrogoAdmobActivity {

    // Show Banner Ads
    fun showAdsBanner(mAdView: AdView)

    // Show Banner Ads with listener
    fun showAdsBanner(mAdView: AdView, listener: IFrogoAdBanner)

    // Show Banner Ads with container
    fun showAdsBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout
    )

    // Show Banner Ads with container and listener
    fun showAdsBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        listener: IFrogoAdBanner
    )

    // Show Interstitial Ads
    fun showAdsInterstitial(interstitialAdUnitId: String)

    // Show Interstitial Ads with listener
    fun showAdsInterstitial(
        interstitialAdUnitId: String,
        callback: IFrogoAdInterstitial
    )

    // Show Rewarded Ads
    fun showAdsRewarded(mAdUnitIdRewarded: String, callback: IFrogoAdRewarded)

    // Show Rewarded Interstitial Ads
    fun showAdsRewardedInterstitial(mAdUnitIdRewardedInterstitial: String,callback: IFrogoAdRewarded)

}