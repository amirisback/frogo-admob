package com.frogobox.admob.core

import android.content.Context
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.log.FLog
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

    private const val mobileAdsKey = "com.google.android.gms.ads.MobileAds"

    private lateinit var adapterStatus: AdapterStatus

    var initializationCode = 0
    var initializationName = ""

    // ---------------------------------------------------------------------------------------------

    fun getInitializedState(name: String, code: Int) {
        FLog.d(FrogoAdmobConstant.LINE)
        FLog.d("$TAG >> Setup MobileAds [Key] : $mobileAdsKey")
        FLog.d("$TAG >> Setup MobileAds [Initialization State Name] : $name")
        FLog.d("$TAG >> Setup MobileAds [Initialization State Code] : $code")
        FLog.d(FrogoAdmobConstant.LINE)
    }

    override fun setupAdmobApp(context: Context) {
        MobileAds.initialize(context) {
            adapterStatus = it.adapterStatusMap[mobileAdsKey]!!
            initializationCode = adapterStatus.initializationState.ordinal
            initializationName = adapterStatus.initializationState.name
            getInitializedState(initializationName, initializationCode)
            FLog.d("$TAG >> Setup MobileAds : Admob mobile Ads Initialized")
        }
        FrogoAdmobSingleFunc.waterMark()
    }

    // ---------------------------------------------------------------------------------------------

    private fun frogoAdListener(callback: IFrogoAdBanner?): AdListener {
        return object : AdListener() {
            override fun onAdLoaded() {
                FrogoAdmobSingleFunc.waterMark()
                FLog.d("$TAG [Banner] >> Run - IFrogoAdBanner [callback] : onAdLoaded()")
                FLog.d("$TAG [Banner] >> Success - onAdLoaded [message] : Ad Banner onAdLoaded")
                callback?.onAdLoaded(TAG, "Ad Banner onAdLoaded")
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                FrogoAdmobSingleFunc.waterMark()
                FLog.e("$TAG [Banner] >> Run - IFrogoAdBanner [callback] : onAdFailedToLoad()")

                FLog.e("$TAG [Banner] >> Error - onAdFailedToLoad [code] : ${p0.code}")
                FLog.e("$TAG [Banner] >> Error - onAdFailedToLoad [domain] : ${p0.domain}")
                FLog.e("$TAG [Banner] >> Error - onAdFailedToLoad [message] : ${p0.message}")
                callback?.onAdFailedToLoad(TAG, p0.code.toString(), p0.message)
            }

            override fun onAdOpened() {
                FLog.d("$TAG [Banner] >> Run - IFrogoAdBanner [callback] : onAdOpened()")
                FLog.d("$TAG [Banner] >> Success - onAdOpened [message] : Ad Banner onAdOpened")
                callback?.onAdOpened(TAG, "Ad Banner onAdOpened")
            }

            override fun onAdClicked() {
                FLog.d("$TAG [Banner] >> Run - IFrogoAdBanner [callback] : onAdClicked()")
                FLog.d("$TAG [Banner] >> Success - onAdClicked [message] : Ad Banner onAdClicked")
                callback?.onAdClicked(TAG, "Ad Banner onAdClicked")
            }

            override fun onAdClosed() {
                FLog.d("$TAG [Banner] >> Run - IFrogoAdBanner [callback] : onAdClicked()")
                FLog.d("$TAG [Banner] >> Success - onAdClosed [message] : Ad Banner onAdClosed")
                callback?.onAdClosed(TAG, "Ad Banner onAdClosed")
            }
        }
    }

    override fun showAdBanner(
        mAdView: AdView,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: IFrogoAdBanner?
    ) {
        FrogoAdmobSingleFunc.waterMark()
        FLog.d("Banner Id : Attach on Xml Layout")
        getInitializedState(initializationName, initializationCode)

        val adRequest = AdRequest.Builder()

        if (timeoutMilliSecond != null) {
            FLog.d("$TAG Banner HttpTimeOut Millisecond : $timeoutMilliSecond")
            adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
        }

        if (keyword != null) {
            for (i in keyword.indices) {
                FLog.d("$TAG Banner Keyworad Ads [$i] : ${keyword[i]}")
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

    override fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: IFrogoAdBanner?
    ) {
        FrogoAdmobSingleFunc.waterMark()
        FLog.d("Banner Id : $bannerAdUnitId")

        getInitializedState(initializationName, initializationCode)

        if (bannerAdUnitId != "") {

            val mAdView = AdView(context)

            val adRequest = AdRequest.Builder()

            if (timeoutMilliSecond != null) {
                FLog.d("$TAG Banner HttpTimeOut Millisecond : $timeoutMilliSecond")
                adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
            }

            if (keyword != null) {
                for (i in keyword.indices) {
                    FLog.d("$TAG Banner Keyworad Ads [$i] : ${keyword[i]}")
                    adRequest.addKeyword(keyword[i])
                }
            }

            mAdView.adUnitId = bannerAdUnitId
            mAdView.adSize = mAdsSize

            if (callback != null) {
                mAdView.adListener = frogoAdListener(callback)
            } else {
                mAdView.adListener = frogoAdListener(null)
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
        FrogoAdmobSingleFunc.waterMark()
        FLog.d("$TAG Interstitial Id : $interstitialAdUnitId")

        getInitializedState(initializationName, initializationCode)

        if (interstitialAdUnitId != "") {

            val adRequest = AdRequest.Builder()

            if (timeoutMilliSecond != null) {
                FLog.d("$TAG Interstitial HttpTimeOut Millisecond : $timeoutMilliSecond")
                adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
            }

            if (keyword != null) {
                for (i in keyword.indices) {
                    FLog.d("$TAG Interstitial Keyworad Ads [$i] : ${keyword[i]}")
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
                        FLog.e("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdFailedToLoad()")
                        FLog.d("$TAG [Interstitial] >> Error - onAdFailedToLoad [unit id] : $interstitialAdUnitId")
                        FLog.e("$TAG [Interstitial] >> Error - onAdFailedToLoad [code] : ${adError.code}")
                        FLog.e("$TAG [Interstitial] >> Error - onAdFailedToLoad [domain] : ${adError.domain}")
                        FLog.e("$TAG [Interstitial] >> Error - onAdFailedToLoad [message] : ${adError.message}")
                        callback?.onAdFailed(TAG, "Interstitial ${adError.message}")
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        FLog.d("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdLoaded()")
                        FLog.d("$TAG [Interstitial] >> Succes - onAdLoaded [message] : Ad was loaded")
                        FLog.d("$TAG [Interstitial] >> Succes - onAdLoaded [unit id] : ${interstitialAd.adUnitId}")
                        FLog.d("$TAG [Interstitial] >> Succes - onAdLoaded [response Info] : ${interstitialAd.responseInfo}")
                        FLog.d("$TAG [Interstitial] >> Suggest : You Can Give Your Reward Here")
                        callback?.onAdLoaded(TAG, "Interstitial Ad was loaded")

                        interstitialAd.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    FLog.d("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdDismissed()")
                                    FLog.d("$TAG [Interstitial] >> Succes - onAdDismissedFullScreenContent [message] : Ad was dismissed")
                                    callback?.onAdDismissed(TAG, "Interstitial Ad was dismissed")
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                                    getInitializedState(initializationName, initializationCode)
                                    FLog.e("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdFailedToShow()")
                                    FLog.d("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [unit id] : $interstitialAdUnitId")
                                    FLog.e("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [code] : ${adError?.code}")
                                    FLog.e("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [domain] : ${adError?.domain}")
                                    FLog.e("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [message] : ${adError?.message}")
                                    FLog.e("$TAG [Interstitial] >> Error : Ad failed to show")
                                    callback?.onAdFailed(TAG, "Interstitial Ad failed to show")
                                }

                                override fun onAdShowedFullScreenContent() {
                                    FLog.d("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdShowed()")
                                    FLog.d("$TAG [Interstitial] >> Succes - onAdShowedFullScreenContent [message] : Ad showed fullscreen content")
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
            callback?.onAdFailed(TAG, "$TAG : Interstitial ID is Empty")
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

        FrogoAdmobSingleFunc.waterMark()
        FLog.d("$TAG : Rewarded Unit Id : $mAdUnitIdRewarded")

        getInitializedState(initializationName, initializationCode)

        if (mAdUnitIdRewarded != "") {

            val adRequest = AdRequest.Builder()

            if (timeoutMilliSecond != null) {
                FLog.d("$TAG Rewarded HttpTimeOut Millisecond : $timeoutMilliSecond")
                adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
            }

            if (keyword != null) {
                for (i in keyword.indices) {
                    FLog.d("$TAG Rewarded Keyworad Ads [$i] : ${keyword[i]}")
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
                        FLog.e("$TAG [RewardedAd] >> Run - IFrogoAdRewarded [callback] : onAdFailedToLoad()")
                        FLog.d("$TAG [RewardedAd] >> Error - onAdFailedToLoad [unit id] : $mAdUnitIdRewarded")
                        FLog.e("$TAG [RewardedAd] >> Error - onAdFailedToLoad [code] : ${adError.code}")
                        FLog.e("$TAG [RewardedAd] >> Error - onAdFailedToLoad [domain] : ${adError.domain}")
                        FLog.e("$TAG [RewardedAd] >> Error - onAdFailedToLoad [message] : ${adError.message}")
                        callback.onAdFailed(TAG, "RewardedAd ${adError.message}")
                    }

                    override fun onAdLoaded(rewardedAd: RewardedAd) {
                        FLog.d("$TAG [RewardedAd] >> Run - IFrogoAdRewarded [callback] : onAdLoaded()")
                        FLog.d("$TAG [RewardedAd] >> Succes - onAdLoaded [message] : Ad was loaded")
                        FLog.d("$TAG [RewardedAd] >> Succes - onAdLoaded [unit id] : ${rewardedAd.adUnitId}")
                        FLog.d("$TAG [RewardedAd] >> Succes - onAdLoaded [response Info] : ${rewardedAd.responseInfo}")
                        callback.onAdLoaded(TAG, "RewardedAd was loaded")
                        rewardedAd.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    FLog.d("$TAG [RewardedAd] >> Run - IFrogoAdRewarded [callback] : onAdDismissed()")
                                    FLog.d("$TAG [RewardedAd] >> Succes - onAdDismissedFullScreenContent [message] : Ad was dismissed")
                                    callback.onAdDismissed(
                                        TAG,
                                        "Rewarded Ad was dismissed"
                                    )
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                                    getInitializedState(
                                        initializationName,
                                        initializationCode
                                    )
                                    FLog.e("$TAG [RewardedAd] >> Run - IFrogoAdRewarded [callback] : onAdFailedToShow()")
                                    FLog.d("$TAG [RewardedAd] >> Error - onAdFailedToShowFullScreenContent [unit id] : $mAdUnitIdRewarded")
                                    FLog.e("$TAG [RewardedAd] >> Error - onAdFailedToShowFullScreenContent [code] : ${adError?.code}")
                                    FLog.e("$TAG [RewardedAd] >> Error - onAdFailedToShowFullScreenContent [domain] : ${adError?.domain}")
                                    FLog.e("$TAG [RewardedAd] >> Error - onAdFailedToShowFullScreenContent [message] : ${adError?.message}")
                                    FLog.e("$TAG [RewardedAd] >> Error : Ad failed to show")
                                    callback.onAdFailed(
                                        TAG,
                                        "Interstitial Ad failed to show"
                                    )
                                }

                                override fun onAdShowedFullScreenContent() {
                                    FLog.d("$TAG [RewardedAd] >> Run - IFrogoAdRewarded [callback] : onAdShowed()")
                                    FLog.d("$TAG [RewardedAd] >> Succes - onAdShowedFullScreenContent [message] : Ad showed fullscreen content")
                                    callback.onAdShowed(
                                        TAG,
                                        "Rewarded Ad showed fullscreen content"
                                    )
                                }
                            }

                        rewardedAd.show(activity) {
                            FLog.d("$TAG [RewardedAd] >> Suggest : You Can Give Your Reward Here")
                            FLog.d("$TAG [RewardedAd] >> User Earned [ammount] : ${it.amount}")
                            FLog.d("$TAG [RewardedAd] >> User Earned [type] : ${it.type}")
                            callback.onUserEarnedReward(TAG, it)
                        }
                    }
                })
        } else {
            callback.onAdFailed(TAG, "$TAG : Rewarded Unit Id is Empty")
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
        callback: IFrogoAdRewarded
    ) {

        FrogoAdmobSingleFunc.waterMark()
        FLog.d("$TAG : Rewarded Interstitial Unit Id : $mAdUnitIdRewardedInterstitial")

        getInitializedState(initializationName, initializationCode)

        if (mAdUnitIdRewardedInterstitial == "") {
            callback.onAdFailed(TAG, "$TAG : Rewarded Interstitial Id Is Empty")
        } else {
            RewardedInterstitialAd.load(
                activity,
                mAdUnitIdRewardedInterstitial,
                AdRequest.Builder().build(),
                object : RewardedInterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        getInitializedState(initializationName, initializationCode)
                        FLog.e("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdFailedToLoad()")
                        FLog.d("$TAG [RewardedInterstitial] >> Error - onAdFailedToLoad [unit id] : $mAdUnitIdRewardedInterstitial")
                        FLog.e("$TAG [RewardedInterstitial] >> Error - onAdFailedToLoad [code] : ${loadAdError.code}")
                        FLog.e("$TAG [RewardedInterstitial] >> Error - onAdFailedToLoad [domain] : ${loadAdError.domain}")
                        FLog.e("$TAG [RewardedInterstitial] >> Error - onAdFailedToLoad [message] : ${loadAdError.message}")
                        callback.onAdFailed(TAG, "RewardedInterstitial ${loadAdError.message}")
                    }

                    override fun onAdLoaded(ad: RewardedInterstitialAd) {
                        FLog.d("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdLoaded()")
                        FLog.d("$TAG [RewardedInterstitial] >> Succes - onAdLoaded [message] : Ad was loaded")
                        FLog.d("$TAG [RewardedInterstitial] >> Succes - onAdLoaded [unit id] : ${ad.adUnitId}")
                        FLog.d("$TAG [RewardedInterstitial] >> Succes - onAdLoaded [response Info] : ${ad.responseInfo}")
                        callback.onAdLoaded(TAG, "RewardedInterstitial Ad was loaded")
                        ad.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    FLog.d("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdDismissed()")
                                    FLog.d("$TAG [RewardedInterstitial] >> Succes - onAdDismissedFullScreenContent [message] : Ad was dismissed")
                                    callback.onAdDismissed(
                                        TAG,
                                        "RewardedInterstitial Ad was dismissed"
                                    )
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                                    getInitializedState(initializationName, initializationCode)
                                    FLog.e("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdFailedToShow()")
                                    FLog.d("$TAG [RewardedInterstitial] >> Error - onAdFailedToShowFullScreenContent [unit id] : $mAdUnitIdRewardedInterstitial")
                                    FLog.e("$TAG [RewardedInterstitial] >> Error - onAdFailedToShowFullScreenContent [code] : ${adError?.code}")
                                    FLog.e("$TAG [RewardedInterstitial] >> Error - onAdFailedToShowFullScreenContent [domain] : ${adError?.domain}")
                                    FLog.e("$TAG [RewardedInterstitial] >> Error - onAdFailedToShowFullScreenContent [message] : ${adError?.message}")
                                    FLog.e("$TAG [RewardedInterstitial] >> Error : Ad failed to show")
                                    callback.onAdFailed(
                                        TAG,
                                        "RewardedInterstitial Ad failed to show"
                                    )
                                }

                                override fun onAdShowedFullScreenContent() {
                                    FLog.d("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdShowed()")
                                    FLog.d("$TAG [RewardedInterstitial] >> Succes - onAdShowedFullScreenContent [message] : Ad showed fullscreen content")
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
        }
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
            adView.adSize = AdSize.BANNER
            adView.adUnitId = bannerAdUnitId
            recyclerViewDataList.add(i, adView)
            i += FrogoAdmobConstant.RECYCLER_VIEW_ITEMS_PER_AD
        }
    }

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
                    index + FrogoAdmobConstant.RECYCLER_VIEW_ITEMS_PER_AD
                )
            }

            override fun onAdFailedToLoad(p0: LoadAdError) { // The previous banner ad failed to load. Call this method again to load the next ad in the items list.
                FLog.e("The previous banner ad failed to load. Attempting to load the next banner ad in the items list.")
                loadBannerAd(
                    recyclerViewDataList,
                    index + FrogoAdmobConstant.RECYCLER_VIEW_ITEMS_PER_AD
                )
            }
        }
        // Load the banner ad.
        adView.loadAd(AdRequest.Builder().build())
    }

}