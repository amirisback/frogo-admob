package com.frogobox.admob.ui

import android.content.Context
import android.widget.RelativeLayout
import com.frogobox.admob.core.IFrogoAdListener
import com.frogobox.admob.core.IFrogoAdmob
import com.frogobox.admob.core.IFrogoBanner
import com.frogobox.admob.core.IFrogoInterstitial
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
    fun showBanner(mAdView: AdView)

    // Show Banner Ads with listener
    fun showBanner(mAdView: AdView, listener: IFrogoBanner)

    // Show Banner Ads with container
    fun showBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout
    )

    // Show Banner Ads with container and listener
    fun showBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        listener: IFrogoBanner
    )

    // Show Interstitial Ads
    fun showInterstitial(interstitialAdUnitId: String)

    // Show Interstitial Ads with listener
    fun showInterstitial(
        interstitialAdUnitId: String,
        callback: IFrogoInterstitial
    )

    // Show Rewarded Ads
    fun setupShowAdsRewarded(callback: IFrogoAdmob.UserEarned)

    // Show Rewarded Interstitial Ads
    fun setupShowAdsRewardedInterstitial(callback: IFrogoAdmob.UserEarned)

}