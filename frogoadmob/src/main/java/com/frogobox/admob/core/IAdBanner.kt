package com.frogobox.admob.core

import android.content.Context
import android.widget.RelativeLayout
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

interface IAdBanner {

    fun showBanner(mAdView: AdView, bannerAdUnitId: String)

    fun showBanner(
        mAdView: AdView,
        bannerAdUnitId: String,
        listener: IFrogoBanner
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
        listener: IFrogoBanner
    )

}