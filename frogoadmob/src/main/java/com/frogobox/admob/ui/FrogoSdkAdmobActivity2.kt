package com.frogobox.admob.ui

import android.os.Bundle
import android.widget.RelativeLayout
import androidx.viewbinding.ViewBinding
import com.frogobox.admob.core.FrogoAdmob2
import com.frogobox.admob.core.IFrogoBannerListener
import com.frogobox.admob.core.IFrogoInterstitialCallback
import com.frogobox.sdk.FrogoActivity
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView


/*
 * Created by faisalamir on 10/03/22
 * FrogoAdmob
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Frogobox Media Inc.      
 * All rights reserved
 *
 */

abstract class FrogoSdkAdmobActivity2<VB : ViewBinding> : FrogoActivity<VB>(),
    IFrogoAdmobActivity2 {

    private val TAG: String = FrogoSdkAdmobActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FrogoAdmob2.setupAdmobApp(this)
    }

    override fun showInterstitial(interstitialAdUnitId: String) {
        FrogoAdmob2.Interstitial.showInterstitial(this, interstitialAdUnitId)
    }

    override fun showInterstitial(
        interstitialAdUnitId: String,
        interstitialListener: IFrogoInterstitialCallback
    ) {
        FrogoAdmob2.Interstitial.showInterstitial(this, interstitialAdUnitId, interstitialListener)
    }

    override fun showBanner(mAdView: AdView, bannerAdUnitId: String) {
        FrogoAdmob2.Banner.showBanner(mAdView, bannerAdUnitId)
    }

    override fun showBanner(
        mAdView: AdView,
        bannerAdUnitId: String,
        bannerListener: IFrogoBannerListener
    ) {
        FrogoAdmob2.Banner.showBanner(mAdView, bannerAdUnitId, bannerListener)
    }

    override fun showBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout
    ) {
        FrogoAdmob2.Banner.showBannerContainer(this, bannerAdUnitId, mAdsSize, container)
    }

    override fun showBannerContainer(
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        bannerListener: IFrogoBannerListener
    ) {
        FrogoAdmob2.Banner.showBannerContainer(
            this,
            bannerAdUnitId,
            mAdsSize,
            container,
            bannerListener
        )
    }

}