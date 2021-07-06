package com.frogobox.admob.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.core.FrogoAdmob.Banner.setupBanner
import com.frogobox.admob.core.FrogoAdmob.Banner.showBanner
import com.frogobox.admob.core.FrogoAdmob.Interstitial.setupInterstitial
import com.frogobox.admob.core.FrogoAdmob.Interstitial.showInterstitial
import com.frogobox.admob.core.FrogoAdmob.Publisher.setupPublisher
import com.frogobox.admob.core.FrogoAdmob.Rewarded.setupRewarded
import com.frogobox.admob.core.FrogoAdmob.Rewarded.showRewarded
import com.frogobox.admob.core.FrogoAdmob.RewardedInterstitial.setupRewardedInterstitial
import com.frogobox.admob.core.FrogoAdmob.RewardedInterstitial.showRewardedInterstitial
import com.frogobox.admob.core.FrogoAdmob.setupBannerAdUnitID
import com.frogobox.admob.core.FrogoAdmob.setupInterstialAdUnitID
import com.frogobox.admob.core.FrogoAdmob.setupPublisherID
import com.frogobox.admob.core.FrogoAdmob.setupRewardedAdUnitID
import com.frogobox.admob.core.FrogoAdmob.setupRewardedInterstitialAdUnitID
import com.frogobox.admob.core.IFrogoAdmob
import com.google.android.gms.ads.AdView

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 31/10/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.admobhelper
 *
 */

open class FrogoAdmobActivity : AppCompatActivity(), IFrogoAdmobActivity {

    protected lateinit var mActivity: AppCompatActivity

    protected val arrayFrogoAdmobData = mutableListOf<Any>()

    private lateinit var baseAdmobPublisherID: String
    private lateinit var baseAdUnitIdBanner: String
    private lateinit var baseAdUnitIdInterstitial: String
    private lateinit var baseAdUnitIdRewarded: String
    private lateinit var baseAdUnitIdRewardedInterstitial: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
    }

    override fun setupAdsPublisher(mPublisherId: String) {
        baseAdmobPublisherID = mPublisherId
        setupPublisherID(baseAdmobPublisherID)
        setupPublisher(this)
    }

    override fun setupAdsBanner(mAdUnitId: String) {
        baseAdUnitIdBanner = mAdUnitId
        setupBannerAdUnitID(baseAdUnitIdBanner)
    }

    override fun setupAdsInterstitial(mAdUnitId: String) {
        baseAdUnitIdInterstitial = mAdUnitId
        setupInterstialAdUnitID(baseAdUnitIdInterstitial)
        setupInterstitial(this)
    }

    override fun setupAdsRewarded(mAdUnitId: String) {
        baseAdUnitIdRewarded = mAdUnitId
        setupRewardedAdUnitID(baseAdUnitIdRewarded)
        setupRewarded(this)
    }

    override fun setupAdsRewardedInterstitial(mAdUnitId: String) {
        baseAdUnitIdRewardedInterstitial = mAdUnitId
        setupRewardedInterstitialAdUnitID(baseAdUnitIdRewardedInterstitial)
        setupRewardedInterstitial(this)
    }

    override fun setupShowAdsBanner(mAdView: AdView) {
        setupBanner(mAdView)
        showBanner(mAdView)
    }

    override fun setupShowAdsInterstitial() {
        showInterstitial(this)
    }

    override fun setupShowAdsRewarded(callback: IFrogoAdmob.UserEarned) {
        showRewarded(this, callback)
    }

    override fun setupShowAdsRewardedInterstitial(callback: IFrogoAdmob.UserEarned) {
        showRewardedInterstitial(this, callback)
    }

    override fun onResume() {
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.resume()
            }
        }
        super.onResume()
    }

    override fun onPause() {
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.pause()
            }
        }
        super.onPause()
    }

    override fun onDestroy() {
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.destroy()
            }
        }
        super.onDestroy()
    }

}