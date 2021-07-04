package com.frogobox.admob.ui

import com.frogobox.admob.core.IFrogoAdmob
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

    // Set Pub-ID
    fun setBasePublisherID(mPublisherId: String)

    // Set Banner ID
    fun setBaseBannerAdUnitID(mAdUnitId: String)

    // Set Interstitial ID
    fun setBaseInterstialAdUnitID(mAdUnitId: String)

    // Set Rewarded ID
    fun setBaseRewardedAdUnitID(mAdUnitId: String)

    // set Rewarded Interstitial ID
    fun setBaseRewardedInterstitialAdUnitID(mAdUnitId: String)

    // Setup Frogo Admob
    fun setBaseAdmob()

    // Show Banner Ads
    fun setupShowAdsBanner(mAdView: AdView)

    // Show Interstitial Ads
    fun setupShowAdsInterstitial()

    // Show Rewarded Ads
    fun setupShowAdsRewarded(callback: IFrogoAdmob.UserEarned)

    // Show Rewarded Interstitial Ads
    fun setupShowAdsRewardedInterstitial(callback: IFrogoAdmob.UserEarned)

}