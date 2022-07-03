package com.frogobox.admob.core

import android.annotation.SuppressLint
import android.content.Context
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.adcore.util.FrogoAdConstant
import com.frogobox.adcore.util.FrogoAdConstant.ADMOB_MOBILE_ADS_KEY
import com.frogobox.adcore.util.FrogoAdFunc.getInitializedState
import com.frogobox.adcore.util.FrogoAdFunc.waterMark
import com.frogobox.admob.deprecated.IFrogoAdBanner
import com.frogobox.admob.deprecated.IFrogoAdInterstitial
import com.frogobox.admob.deprecated.IFrogoAdRewarded
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.sdk.ext.showLogError
import com.google.android.gms.ads.*
import com.google.android.gms.ads.initialization.AdapterStatus
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback


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


object FrogoAdmob : IFrogoAdmob {

    val TAG: String = FrogoAdmob::class.java.simpleName

    private lateinit var adapterStatus: AdapterStatus

    var initializationCode = 0

    var initializationName = ""


    // ---------------------------------------------------------------------------------------------


    override fun setupAdmobApp(context: Context) {
        MobileAds.initialize(context) {
            adapterStatus = it.adapterStatusMap[ADMOB_MOBILE_ADS_KEY]!!
            initializationCode = adapterStatus.initializationState.ordinal
            initializationName = adapterStatus.initializationState.name
            getInitializedState(initializationName, initializationCode)
            showLogDebug("$TAG >> Setup MobileAds : Admob mobile Ads Initialized")
        }
        waterMark()
    }

    // ---------------------------------------------------------------------------------------------

    private fun frogoAdListener(callback: IFrogoAdBanner?): AdListener {
        return object : AdListener() {
            override fun onAdLoaded() {
                waterMark()
                showLogDebug("$TAG [Banner] >> Run - IFrogoAdBanner [callback] : onAdLoaded()")
                showLogDebug("$TAG [Banner] >> Success - onAdLoaded [message] : Ad Banner onAdLoaded")
                callback?.onAdLoaded(TAG, "Ad Banner onAdLoaded")
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                waterMark()
                showLogError("$TAG [Banner] >> Run - IFrogoAdBanner [callback] : onAdFailedToLoad()")

                showLogError("$TAG [Banner] >> Error - onAdFailedToLoad [code] : ${p0.code}")
                showLogError("$TAG [Banner] >> Error - onAdFailedToLoad [domain] : ${p0.domain}")
                showLogError("$TAG [Banner] >> Error - onAdFailedToLoad [message] : ${p0.message}")
                callback?.onAdFailedToLoad(TAG, p0.code.toString(), p0.message)
            }

            override fun onAdOpened() {
                showLogDebug("$TAG [Banner] >> Run - IFrogoAdBanner [callback] : onAdOpened()")
                showLogDebug("$TAG [Banner] >> Success - onAdOpened [message] : Ad Banner onAdOpened")
                callback?.onAdOpened(TAG, "Ad Banner onAdOpened")
            }

            override fun onAdClicked() {
                showLogDebug("$TAG [Banner] >> Run - IFrogoAdBanner [callback] : onAdClicked()")
                showLogDebug("$TAG [Banner] >> Success - onAdClicked [message] : Ad Banner onAdClicked")
                callback?.onAdClicked(TAG, "Ad Banner onAdClicked")
            }

            override fun onAdClosed() {
                showLogDebug("$TAG [Banner] >> Run - IFrogoAdBanner [callback] : onAdClicked()")
                showLogDebug("$TAG [Banner] >> Success - onAdClosed [message] : Ad Banner onAdClosed")
                callback?.onAdClosed(TAG, "Ad Banner onAdClosed")
            }
        }
    }

    @SuppressLint("MissingPermission")
    override fun showAdBanner(
        mAdView: AdView,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: IFrogoAdBanner?
    ) {
        waterMark()
        showLogDebug("Banner Id : Attach on Xml Layout")
        getInitializedState(initializationName, initializationCode)

        val adRequest = AdRequest.Builder()

        if (timeoutMilliSecond != null) {
            showLogDebug("$TAG Banner HttpTimeOut Millisecond : $timeoutMilliSecond")
            adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
        }

        if (keyword != null) {
            for (i in keyword.indices) {
                showLogDebug("$TAG Banner Keyworad Ads [$i] : ${keyword[i]}")
                adRequest.addKeyword(keyword[i])
            }
        }
        if (callback != null) {
            mAdView.adListener = frogoAdListener(callback)
        } else {
            mAdView.adListener = frogoAdListener(null)
        }

        mAdView.loadAd(adRequest.build())
    }

    override fun showAdBanner(mAdView: AdView) {
        showAdBanner(mAdView, null, null, null)
    }

    override fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int) {
        showAdBanner(mAdView, timeoutMilliSecond, null, null)
    }

    override fun showAdBanner(mAdView: AdView, keyword: List<String>) {
        showAdBanner(mAdView, null, keyword, null)
    }

    override fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int, keyword: List<String>) {
        showAdBanner(mAdView, timeoutMilliSecond, keyword, null)
    }

    override fun showAdBanner(mAdView: AdView, callback: IFrogoAdBanner) {
        showAdBanner(mAdView, null, null, callback)
    }

    override fun showAdBanner(mAdView: AdView, timeoutMilliSecond: Int, callback: IFrogoAdBanner) {
        showAdBanner(mAdView, timeoutMilliSecond, null, callback)
    }

    override fun showAdBanner(mAdView: AdView, keyword: List<String>, callback: IFrogoAdBanner) {
        showAdBanner(mAdView, null, keyword, callback)
    }

    @SuppressLint("MissingPermission")
    override fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: IFrogoAdBanner?
    ) {
        waterMark()
        showLogDebug("Banner Id : $bannerAdUnitId")

        getInitializedState(initializationName, initializationCode)

        if (bannerAdUnitId != "") {

            val mAdView = AdView(context)

            val adRequest = AdRequest.Builder()

            if (timeoutMilliSecond != null) {
                showLogDebug("$TAG Banner HttpTimeOut Millisecond : $timeoutMilliSecond")
                adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
            }

            if (keyword != null) {
                for (i in keyword.indices) {
                    showLogDebug("$TAG Banner Keyworad Ads [$i] : ${keyword[i]}")
                    adRequest.addKeyword(keyword[i])
                }
            }

            mAdView.apply {
                adUnitId = bannerAdUnitId
                setAdSize(mAdsSize)

                adListener = if (callback != null) {
                    frogoAdListener(callback)
                } else {
                    frogoAdListener(null)
                }
            }

            container.addView(mAdView)

            mAdView.loadAd(adRequest.build())
        } else {
            callback?.onAdFailedToLoad(TAG, "000", "$TAG : Banner Unit Id is Empty")
        }

    }

    override fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
    ) {
        showAdBannerContainer(context, bannerAdUnitId, mAdsSize, container, null, null, null)
    }

    override fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
    ) {
        showAdBannerContainer(
            context,
            bannerAdUnitId,
            mAdsSize,
            container,
            timeoutMilliSecond,
            null,
            null
        )
    }

    override fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        keyword: List<String>,
    ) {
        showAdBannerContainer(context, bannerAdUnitId, mAdsSize, container, null, keyword, null)
    }

    override fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        keyword: List<String>
    ) {
        showAdBannerContainer(
            context,
            bannerAdUnitId,
            mAdsSize,
            container,
            timeoutMilliSecond,
            keyword,
            null
        )
    }

    override fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        callback: IFrogoAdBanner
    ) {
        showAdBannerContainer(context, bannerAdUnitId, mAdsSize, container, null, null, callback)
    }

    override fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        callback: IFrogoAdBanner
    ) {
        showAdBannerContainer(
            context,
            bannerAdUnitId,
            mAdsSize,
            container,
            timeoutMilliSecond,
            null,
            callback
        )
    }

    override fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        keyword: List<String>,
        callback: IFrogoAdBanner
    ) {
        showAdBannerContainer(context, bannerAdUnitId, mAdsSize, container, null, keyword, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: IFrogoAdInterstitial?
    ) {
        waterMark()
        showLogDebug("$TAG Interstitial Id : $interstitialAdUnitId")

        getInitializedState(initializationName, initializationCode)

        if (interstitialAdUnitId != "") {

            callback?.onShowAdRequestProgress(
                TAG,
                "$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onShowAdRequestProgress()"
            )

            val adRequest = AdRequest.Builder()

            if (timeoutMilliSecond != null) {
                showLogDebug("$TAG Interstitial HttpTimeOut Millisecond : $timeoutMilliSecond")
                adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
            }

            if (keyword != null) {
                for (i in keyword.indices) {
                    showLogDebug("$TAG Interstitial Keyworad Ads [$i] : ${keyword[i]}")
                    adRequest.addKeyword(keyword[i])
                }
            }

            InterstitialAd.load(
                activity,
                interstitialAdUnitId,
                adRequest.build(),
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        getInitializedState(initializationName, initializationCode)
                        showLogError("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdFailedToLoad()")
                        showLogError("$TAG [Interstitial] >> Error - onAdFailedToLoad [unit id] : $interstitialAdUnitId")
                        showLogError("$TAG [Interstitial] >> Error - onAdFailedToLoad [code] : ${adError.code}")
                        showLogError("$TAG [Interstitial] >> Error - onAdFailedToLoad [domain] : ${adError.domain}")
                        showLogError("$TAG [Interstitial] >> Error - onAdFailedToLoad [message] : ${adError.message}")
                        callback?.onHideAdRequestProgress(
                            TAG,
                            "$TAG [Interstitial] >> Error - onHideAdRequestProgress [message] : ${adError.message}"
                        )
                        callback?.onAdFailed(TAG, "Interstitial ${adError.message}")
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        showLogDebug("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdLoaded()")
                        showLogDebug("$TAG [Interstitial] >> Succes - onAdLoaded [message] : Ad was loaded")
                        showLogDebug("$TAG [Interstitial] >> Succes - onAdLoaded [unit id] : ${interstitialAd.adUnitId}")
                        showLogDebug("$TAG [Interstitial] >> Succes - onAdLoaded [response Info] : ${interstitialAd.responseInfo}")
                        showLogDebug("$TAG [Interstitial] >> Suggest : You Can Give Your Reward Here")
                        callback?.onAdLoaded(TAG, "Interstitial Ad was loaded")

                        interstitialAd.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    showLogDebug("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdDismissed()")
                                    showLogDebug("$TAG [Interstitial] >> Succes - onAdDismissedFullScreenContent [message] : Ad was dismissed")
                                    callback?.onAdDismissed(TAG, "Interstitial Ad was dismissed")
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                    getInitializedState(initializationName, initializationCode)
                                    showLogError("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdFailedToShow()")
                                    showLogError("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [unit id] : $interstitialAdUnitId")
                                    showLogError("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [code] : ${adError.code}")
                                    showLogError("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [domain] : ${adError.domain}")
                                    showLogError("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [message] : ${adError.message}")
                                    showLogError("$TAG [Interstitial] >> Error : Ad failed to show")
                                    callback?.onHideAdRequestProgress(
                                        TAG,
                                        "$TAG [Interstitial] >> Error - onHideAdRequestProgress [message] : onAdFailedToShowFullScreenContent"
                                    )
                                    callback?.onAdFailed(TAG, "Interstitial Ad failed to show")
                                }

                                override fun onAdShowedFullScreenContent() {
                                    showLogDebug("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdShowed()")
                                    showLogDebug("$TAG [Interstitial] >> Succes - onAdShowedFullScreenContent [message] : Ad showed fullscreen content")
                                    callback?.onHideAdRequestProgress(
                                        TAG,
                                        "$TAG [Interstitial] >> Succes - onHideAdRequestProgress [message] : Ad showed fullscreen content"
                                    )
                                    callback?.onAdShowed(
                                        TAG,
                                        "Interstitial Ad showed fullscreen content"
                                    )
                                }
                            }
                        interstitialAd.show(activity)
                    }
                }
            )
        } else {
            showLogError("$TAG Interstitial ID is Empty")
            callback?.onAdFailed(TAG, "$TAG Interstitial ID is Empty")
        }

    }

    override fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        keyword: List<String>
    ) {
        showAdInterstitial(activity, interstitialAdUnitId, timeoutMilliSecond, keyword, null)
    }

    override fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int
    ) {
        showAdInterstitial(activity, interstitialAdUnitId, timeoutMilliSecond, null, null)
    }

    override fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        keyword: List<String>
    ) {
        showAdInterstitial(activity, interstitialAdUnitId, null, keyword, null)
    }

    override fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
    ) {
        showAdInterstitial(activity, interstitialAdUnitId, null, null, null)
    }


    override fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int,
        callback: IFrogoAdInterstitial
    ) {
        showAdInterstitial(activity, interstitialAdUnitId, timeoutMilliSecond, null, callback)
    }

    override fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        keyword: List<String>,
        callback: IFrogoAdInterstitial
    ) {
        showAdInterstitial(activity, interstitialAdUnitId, null, keyword, callback)
    }

    override fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        callback: IFrogoAdInterstitial
    ) {
        showAdInterstitial(activity, interstitialAdUnitId, null, null, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: IFrogoAdRewarded
    ) {

        waterMark()
        showLogDebug("$TAG : Rewarded Unit Id : $mAdUnitIdRewarded")

        getInitializedState(initializationName, initializationCode)

        if (mAdUnitIdRewarded != "") {

            callback.onShowAdRequestProgress(
                TAG,
                "$TAG [RewardedAd] >> Run - IFrogoAdRewarded [callback] : onShowAdRequestProgress()"
            )

            val adRequest = AdRequest.Builder()

            if (timeoutMilliSecond != null) {
                showLogDebug("$TAG Rewarded HttpTimeOut Millisecond : $timeoutMilliSecond")
                adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
            }

            if (keyword != null) {
                for (i in keyword.indices) {
                    showLogDebug("$TAG Rewarded Keyworad Ads [$i] : ${keyword[i]}")
                    adRequest.addKeyword(keyword[i])
                }
            }

            RewardedAd.load(
                activity,
                mAdUnitIdRewarded,
                adRequest.build(),
                object : RewardedAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        getInitializedState(
                            initializationName,
                            initializationCode
                        )
                        showLogError("$TAG [RewardedAd] >> Run - IFrogoAdRewarded [callback] : onAdFailedToLoad()")
                        showLogError("$TAG [RewardedAd] >> Error - onAdFailedToLoad [unit id] : $mAdUnitIdRewarded")
                        showLogError("$TAG [RewardedAd] >> Error - onAdFailedToLoad [code] : ${adError.code}")
                        showLogError("$TAG [RewardedAd] >> Error - onAdFailedToLoad [domain] : ${adError.domain}")
                        showLogError("$TAG [RewardedAd] >> Error - onAdFailedToLoad [message] : ${adError.message}")
                        callback.onHideAdRequestProgress(
                            TAG,
                            "$TAG [RewardedAd] >> Error - onHideAdRequestProgress [message] : ${adError.message}"
                        )
                        callback.onAdFailed(TAG, "RewardedAd ${adError.message}")
                    }

                    override fun onAdLoaded(rewardedAd: RewardedAd) {
                        showLogDebug("$TAG [RewardedAd] >> Run - IFrogoAdRewarded [callback] : onAdLoaded()")
                        showLogDebug("$TAG [RewardedAd] >> Succes - onAdLoaded [message] : Ad was loaded")
                        showLogDebug("$TAG [RewardedAd] >> Succes - onAdLoaded [unit id] : ${rewardedAd.adUnitId}")
                        showLogDebug("$TAG [RewardedAd] >> Succes - onAdLoaded [response Info] : ${rewardedAd.responseInfo}")
                        callback.onAdLoaded(TAG, "RewardedAd was loaded")
                        rewardedAd.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    showLogDebug("$TAG [RewardedAd] >> Run - IFrogoAdRewarded [callback] : onAdDismissed()")
                                    showLogDebug("$TAG [RewardedAd] >> Succes - onAdDismissedFullScreenContent [message] : Ad was dismissed")
                                    callback.onAdDismissed(
                                        TAG,
                                        "Rewarded Ad was dismissed"
                                    )
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                    getInitializedState(initializationName, initializationCode)
                                    showLogError("$TAG [RewardedAd] >> Run - IFrogoAdRewarded [callback] : onAdFailedToShow()")
                                    showLogError("$TAG [RewardedAd] >> Error - onAdFailedToShowFullScreenContent [unit id] : $mAdUnitIdRewarded")
                                    showLogError("$TAG [RewardedAd] >> Error - onAdFailedToShowFullScreenContent [code] : ${adError.code}")
                                    showLogError("$TAG [RewardedAd] >> Error - onAdFailedToShowFullScreenContent [domain] : ${adError.domain}")
                                    showLogError("$TAG [RewardedAd] >> Error - onAdFailedToShowFullScreenContent [message] : ${adError.message}")
                                    showLogError("$TAG [RewardedAd] >> Error : Ad failed to show")
                                    callback.onHideAdRequestProgress(
                                        TAG,
                                        "$TAG [RewardedAd] >> Error - IFrogoAdRewarded [callback] : onHideAdRequestProgress() : onAdFailedToShowFullScreenContent"
                                    )
                                    callback.onAdFailed(
                                        TAG,
                                        "Interstitial Ad failed to show"
                                    )
                                }

                                override fun onAdShowedFullScreenContent() {
                                    showLogDebug("$TAG [RewardedAd] >> Run - IFrogoAdRewarded [callback] : onAdShowed()")
                                    showLogDebug("$TAG [RewardedAd] >> Succes - onAdShowedFullScreenContent [message] : Ad showed fullscreen content")
                                    callback.onHideAdRequestProgress(
                                        TAG,
                                        "$TAG [RewardedAd] >> Succes - IFrogoAdRewarded [callback] : onHideAdRequestProgress() : onAdShowedFullScreenContent"
                                    )
                                    callback.onAdShowed(
                                        TAG,
                                        "Rewarded Ad showed fullscreen content"
                                    )
                                }
                            }

                        rewardedAd.show(activity) {
                            showLogDebug("$TAG [RewardedAd] >> Suggest : You Can Give Your Reward Here")
                            showLogDebug("$TAG [RewardedAd] >> User Earned [ammount] : ${it.amount}")
                            showLogDebug("$TAG [RewardedAd] >> User Earned [type] : ${it.type}")
                            callback.onUserEarnedReward(TAG, it)
                        }
                    }
                })
        } else {
            showLogError("$TAG Rewarded Unit Id is Empty")
            callback.onAdFailed(TAG, "$TAG Rewarded Unit Id is Empty")
        }

    }

    override fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        callback: IFrogoAdRewarded
    ) {
        showAdRewarded(activity, mAdUnitIdRewarded, null, null, callback)
    }

    override fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        callback: IFrogoAdRewarded
    ) {
        showAdRewarded(activity, mAdUnitIdRewarded, timeoutMilliSecond, null, callback)
    }

    override fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        keyword: List<String>,
        callback: IFrogoAdRewarded
    ) {
        showAdRewarded(activity, mAdUnitIdRewarded, null, keyword, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: IFrogoAdRewarded
    ) {

        waterMark()
        showLogDebug("$TAG : Rewarded Interstitial Unit Id : $mAdUnitIdRewardedInterstitial")

        getInitializedState(initializationName, initializationCode)

        if (mAdUnitIdRewardedInterstitial != "") {

            callback.onShowAdRequestProgress(
                TAG,
                "$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onShowAdRequestProgress()"
            )

            val adRequest = AdRequest.Builder()

            if (timeoutMilliSecond != null) {
                showLogDebug("$TAG Rewarded HttpTimeOut Millisecond : $timeoutMilliSecond")
                adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
            }

            if (keyword != null) {
                for (i in keyword.indices) {
                    showLogDebug("$TAG Rewarded Keyworad Ads [$i] : ${keyword[i]}")
                    adRequest.addKeyword(keyword[i])
                }
            }

            RewardedInterstitialAd.load(
                activity,
                mAdUnitIdRewardedInterstitial,
                AdRequest.Builder().build(),
                object : RewardedInterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        getInitializedState(
                            initializationName,
                            initializationCode
                        )
                        showLogError("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdFailedToLoad()")
                        showLogError("$TAG [RewardedInterstitial] >> Error - onAdFailedToLoad [unit id] : $mAdUnitIdRewardedInterstitial")
                        showLogError("$TAG [RewardedInterstitial] >> Error - onAdFailedToLoad [code] : ${loadAdError.code}")
                        showLogError("$TAG [RewardedInterstitial] >> Error - onAdFailedToLoad [domain] : ${loadAdError.domain}")
                        showLogError("$TAG [RewardedInterstitial] >> Error - onAdFailedToLoad [message] : ${loadAdError.message}")
                        callback.onHideAdRequestProgress(
                            TAG,
                            "$TAG [RewardedInterstitial] >> Error - onHideAdRequestProgress [message] : ${loadAdError.message}"
                        )
                        callback.onAdFailed(TAG, "RewardedInterstitial ${loadAdError.message}")
                    }

                    override fun onAdLoaded(ad: RewardedInterstitialAd) {
                        showLogDebug("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdLoaded()")
                        showLogDebug("$TAG [RewardedInterstitial] >> Succes - onAdLoaded [message] : Ad was loaded")
                        showLogDebug("$TAG [RewardedInterstitial] >> Succes - onAdLoaded [unit id] : ${ad.adUnitId}")
                        showLogDebug("$TAG [RewardedInterstitial] >> Succes - onAdLoaded [response Info] : ${ad.responseInfo}")
                        callback.onAdLoaded(TAG, "RewardedInterstitial Ad was loaded")
                        ad.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    showLogDebug("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdDismissed()")
                                    showLogDebug("$TAG [RewardedInterstitial] >> Succes - onAdDismissedFullScreenContent [message] : Ad was dismissed")
                                    callback.onAdDismissed(
                                        TAG,
                                        "RewardedInterstitial Ad was dismissed"
                                    )
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                    getInitializedState(
                                        initializationName,
                                        initializationCode
                                    )
                                    showLogError("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdFailedToShow()")
                                    showLogError("$TAG [RewardedInterstitial] >> Error - onAdFailedToShowFullScreenContent [unit id] : $mAdUnitIdRewardedInterstitial")
                                    showLogError("$TAG [RewardedInterstitial] >> Error - onAdFailedToShowFullScreenContent [code] : ${adError.code}")
                                    showLogError("$TAG [RewardedInterstitial] >> Error - onAdFailedToShowFullScreenContent [domain] : ${adError.domain}")
                                    showLogError("$TAG [RewardedInterstitial] >> Error - onAdFailedToShowFullScreenContent [message] : ${adError.message}")
                                    showLogError("$TAG [RewardedInterstitial] >> Error : Ad failed to show")
                                    callback.onHideAdRequestProgress(
                                        TAG,
                                        "$TAG [RewardedInterstitial] >> Error - IFrogoAdRewarded [callback] : onHideAdRequestProgress() : onAdFailedToShowFullScreenContent"
                                    )
                                    callback.onAdFailed(
                                        TAG,
                                        "RewardedInterstitial Ad failed to show"
                                    )
                                }

                                override fun onAdShowedFullScreenContent() {
                                    showLogDebug("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdShowed()")
                                    showLogDebug("$TAG [RewardedInterstitial] >> Succes - onAdShowedFullScreenContent [message] : Ad showed fullscreen content")
                                    callback.onHideAdRequestProgress(
                                        TAG,
                                        "$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onHideAdRequestProgress() : onAdShowedFullScreenContent"
                                    )
                                    callback.onAdShowed(
                                        TAG,
                                        "RewardedInterstitial Ad showed fullscreen content"
                                    )
                                }
                            }

                        ad.show(activity) {
                            callback.onUserEarnedReward(TAG, it)
                        }

                    }
                })
        } else {
            showLogError("$TAG Rewarded Interstitial Id Is Empty")
            callback.onAdFailed(TAG, "$TAG Rewarded Interstitial Id Is Empty")
        }
    }

    override fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        callback: IFrogoAdRewarded
    ) {
        showAdRewardedInterstitial(activity, mAdUnitIdRewardedInterstitial, null, null, callback)
    }

    override fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int,
        callback: IFrogoAdRewarded
    ) {
        showAdRewardedInterstitial(
            activity,
            mAdUnitIdRewardedInterstitial,
            timeoutMilliSecond,
            null,
            callback
        )
    }

    override fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        keyword: List<String>,
        callback: IFrogoAdRewarded
    ) {
        showAdRewardedInterstitial(activity, mAdUnitIdRewardedInterstitial, null, keyword, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun loadRecyclerBannerAds(
        bannerAdUnitId: String,
        context: Context,
        recyclerViewDataList: MutableList<Any>
    ) {
        // Load the first banner ad in the items list (subsequent ads will be loaded automatically in sequence).
        addBannerAds(bannerAdUnitId, context, recyclerViewDataList)
        loadBannerAd(recyclerViewDataList, 0)
    }

    override fun addBannerAds(
        bannerAdUnitId: String,
        context: Context,
        recyclerViewDataList: MutableList<Any>
    ) {
        // Loop through the items array and place a new banner ad in every ith position in the items List.
        var i = 0
        while (i <= recyclerViewDataList.size) {
            val adView = AdView(context)
            adView.setAdSize(AdSize.BANNER)
            adView.adUnitId = bannerAdUnitId
            recyclerViewDataList.add(i, adView)
            i += FrogoAdConstant.RECYCLER_VIEW_ITEMS_PER_AD
        }
    }

    @SuppressLint("MissingPermission")
    override fun loadBannerAd(recyclerViewDataList: MutableList<Any>, index: Int) {
        if (index >= recyclerViewDataList.size) {
            return
        }
        val item: Any = recyclerViewDataList[index] as? AdView
            ?: throw ClassCastException(
                "Expected item at index " + index + " to be a banner ad"
                        + " ad."
            )
        val adView = item as AdView
        // Set an AdListener on the AdView to wait for the previous banner ad to finish loading before loading the next ad in the items list.
        adView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                super.onAdLoaded()
                // The previous banner ad loaded successfully, call this method again to
                // load the next ad in the items list.
                loadBannerAd(
                    recyclerViewDataList,
                    index + FrogoAdConstant.RECYCLER_VIEW_ITEMS_PER_AD
                )
            }

            override fun onAdFailedToLoad(p0: LoadAdError) { // The previous banner ad failed to load. Call this method again to load the next ad in the items list.
                showLogError("The previous banner ad failed to load. Attempting to load the next banner ad in the items list.")
                loadBannerAd(
                    recyclerViewDataList,
                    index + FrogoAdConstant.RECYCLER_VIEW_ITEMS_PER_AD
                )
            }
        }
        // Load the banner ad.
        adView.loadAd(AdRequest.Builder().build())
    }

}