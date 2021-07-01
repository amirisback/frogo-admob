package com.frogobox.admob.core.admob

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.core.admob.FrogoAdmob.Banner.setupBanner
import com.frogobox.admob.core.admob.FrogoAdmob.Banner.showBanner
import com.frogobox.admob.core.admob.FrogoAdmob.Interstitial.setupInterstitial
import com.frogobox.admob.core.admob.FrogoAdmob.Interstitial.showInterstitial
import com.frogobox.admob.core.admob.FrogoAdmob.Publisher.setupPublisher
import com.frogobox.admob.core.admob.FrogoAdmob.Rewarded.setupRewarded
import com.frogobox.admob.core.admob.FrogoAdmob.Rewarded.showRewarded
import com.frogobox.admob.core.admob.FrogoAdmob.RewardedInterstitial.setupRewardedInterstitial
import com.frogobox.admob.core.admob.FrogoAdmob.RewardedInterstitial.showRewardedInterstitial
import com.frogobox.admob.core.admob.FrogoAdmob.setupBannerAdUnitID
import com.frogobox.admob.core.admob.FrogoAdmob.setupInterstialAdUnitID
import com.frogobox.admob.core.admob.FrogoAdmob.setupPublisherID
import com.frogobox.admob.core.admob.FrogoAdmob.setupRewardedAdUnitID
import com.frogobox.admob.core.admob.FrogoAdmob.setupRewardedInterstitialAdUnitID
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

    override fun setBasePublisherID(mPublisherId: String) {
        baseAdmobPublisherID = mPublisherId
    }

    override fun setBaseBannerAdUnitID(mAdUnitId: String) {
        baseAdUnitIdBanner = mAdUnitId
    }

    override fun setBaseInterstialAdUnitID(mAdUnitId: String) {
        baseAdUnitIdInterstitial = mAdUnitId
    }

    override fun setBaseRewardedAdUnitID(mAdUnitId: String) {
        baseAdUnitIdRewarded = mAdUnitId
    }

    override fun setBaseRewardedInterstitialAdUnitID(mAdUnitId: String) {
        baseAdUnitIdRewardedInterstitial = mAdUnitId
    }

    override fun setBaseAdmob() {
        setupPublisherID(baseAdmobPublisherID)
        setupBannerAdUnitID(baseAdUnitIdBanner)
        setupInterstialAdUnitID(baseAdUnitIdInterstitial)
        setupRewardedAdUnitID(baseAdUnitIdRewarded)
        setupRewardedInterstitialAdUnitID(baseAdUnitIdRewardedInterstitial)
        setupPublisher(this)
        setupInterstitial(this)
        setupRewarded(this)
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