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
    fun showAdBanner(mAdView: AdView)

    // Show Banner Ads with listener
    fun showAdBanner(mAdView: AdView, listener: IFrogoAdBanner)

    // Show Banner Ads with container
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout
    )

    // Show Banner Ads with container and listener
    fun showAdBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        listener: IFrogoAdBanner
    )

    // Show Interstitial Ads
    fun showAdInterstitial(interstitialAdUnitId: String)

    // Show Interstitial Ads with listener
    fun showAdInterstitial(
        interstitialAdUnitId: String,
        callback: IFrogoAdInterstitial
    )

    // Show Rewarded Ads
    fun showAdRewarded(mAdUnitIdRewarded: String, callback: IFrogoAdRewarded)

    // Show Rewarded Interstitial Ads
    fun showAdRewardedInterstitial(mAdUnitIdRewardedInterstitial: String, callback: IFrogoAdRewarded)

}