package com.frogobox.admob.ui

import android.content.Context
import android.widget.RelativeLayout
import com.frogobox.admob.core.IFrogoAdListener
import com.frogobox.admob.core.IFrogoAdmob
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

    // Setup Admob Publisher
    fun setupAdsPublisher(mPublisherId: String)

    // Setup Admob Banner
    fun setupAdsBanner(mAdUnitId: String)

    // Setup Admob Interstitial
    fun setupAdsInterstitial(mAdUnitId: String)

    // Setup Admob Rewarded
    fun setupAdsRewarded(mAdUnitId: String)

    // Setup Admob RewardedInterstitial
    fun setupAdsRewardedInterstitial(mAdUnitId: String)

    // Show Banner Ads
    fun setupShowAdsBanner(mAdView: AdView)

    // Show Banner Ads with listener
    fun setupShowAdsBanner(mAdView: AdView, bannerListener: IFrogoAdListener.Banner)

    // Show Banner Ads with container
    fun setupShowAdsBannerContainer(context: Context, mAdsSize: AdSize, container: RelativeLayout)

    // Show Banner Ads with container and listener
    fun setupShowAdsBannerContainer(
        context: Context,
        mAdsSize: AdSize,
        container: RelativeLayout,
        bannerListener: IFrogoAdListener.Banner
    )

    // Show Interstitial Ads
    fun setupShowAdsInterstitial()

    // Show Rewarded Ads
    fun setupShowAdsRewarded(callback: IFrogoAdmob.UserEarned)

    // Show Rewarded Interstitial Ads
    fun setupShowAdsRewardedInterstitial(callback: IFrogoAdmob.UserEarned)

}