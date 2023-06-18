package com.frogobox.admob.core

import android.annotation.SuppressLint
import android.content.Context
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.adcore.util.FrogoAdConstant
import com.frogobox.adcore.util.FrogoAdConstant.ADMOB_MOBILE_ADS_KEY
import com.frogobox.admob.callback.FrogoAdmobBannerCallback
import com.frogobox.admob.callback.FrogoAdmobInterstitialCallback
import com.frogobox.admob.callback.FrogoAdmobRewardedCallback
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


object FrogoAdmob : IFrogoAdmob,
    IFrogoAdmobBanner,
    IFrogoAdmobInterstitial,
    IFrogoAdmobRewarded {

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
        }
    }

    // ---------------------------------------------------------------------------------------------

    private fun frogoAdListener(callback: FrogoAdmobBannerCallback?): AdListener {
        return object : AdListener() {
            override fun onAdLoaded() {
                callback?.onAdLoaded(TAG, "Ad Banner onAdLoaded")
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                callback?.onAdFailedToLoad(TAG, p0.code.toString(), p0.message)
            }

            override fun onAdOpened() {
                callback?.onAdOpened(TAG, "Ad Banner onAdOpened")
            }

            override fun onAdClicked() {
                callback?.onAdClicked(TAG, "Ad Banner onAdClicked")
            }

            override fun onAdClosed() {
                callback?.onAdClosed(TAG, "Ad Banner onAdClosed")
            }
        }
    }

    @SuppressLint("MissingPermission")
    override fun showAdBanner(
        mAdView: AdView,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: FrogoAdmobBannerCallback?
    ) {
        val adRequest = AdRequest.Builder()

        if (timeoutMilliSecond != null) {
            adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
        }

        if (keyword != null) {
            for (i in keyword.indices) {
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

    override fun showAdBanner(mAdView: AdView, callback: FrogoAdmobBannerCallback) {
        showAdBanner(mAdView, null, null, callback)
    }

    override fun showAdBanner(
        mAdView: AdView,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobBannerCallback
    ) {
        showAdBanner(mAdView, timeoutMilliSecond, null, callback)
    }

    override fun showAdBanner(
        mAdView: AdView,
        keyword: List<String>,
        callback: FrogoAdmobBannerCallback
    ) {
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
        callback: FrogoAdmobBannerCallback?
    ) {
        if (bannerAdUnitId != "") {

            val mAdView = AdView(context)

            val adRequest = AdRequest.Builder()

            if (timeoutMilliSecond != null) {
                adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
            }

            if (keyword != null) {
                for (i in keyword.indices) {
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
        callback: FrogoAdmobBannerCallback
    ) {
        showAdBannerContainer(context, bannerAdUnitId, mAdsSize, container, null, null, callback)
    }

    override fun showAdBannerContainer(
        context: Context,
        bannerAdUnitId: String,
        mAdsSize: AdSize,
        container: RelativeLayout,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobBannerCallback
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
        callback: FrogoAdmobBannerCallback
    ) {
        showAdBannerContainer(context, bannerAdUnitId, mAdsSize, container, null, keyword, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: FrogoAdmobInterstitialCallback?
    ) {
        if (interstitialAdUnitId != "") {

            callback?.onShowAdRequestProgress(TAG, "$TAG [Interstitial] >> Run - FrogoAdmobInterstitialCallback [callback] : onShowAdRequestProgress()")

            val adRequest = AdRequest.Builder()

            if (timeoutMilliSecond != null) {
                adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
            }

            if (keyword != null) {
                for (i in keyword.indices) {
                    adRequest.addKeyword(keyword[i])
                }
            }

            InterstitialAd.load(
                activity,
                interstitialAdUnitId,
                adRequest.build(),
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        callback?.onHideAdRequestProgress(TAG, "$TAG [Interstitial] >> Error - onHideAdRequestProgress [message] : ${adError.message}")
                        callback?.onAdFailed(TAG, "Interstitial ${adError.message}")
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        callback?.onAdLoaded(TAG, "Interstitial Ad was loaded")

                        interstitialAd.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    callback?.onAdDismissed(TAG, "Interstitial Ad was dismissed")
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                    callback?.onHideAdRequestProgress(TAG, "$TAG [Interstitial] >> Error - onHideAdRequestProgress [message] : onAdFailedToShowFullScreenContent")
                                    callback?.onAdFailed(TAG, "Interstitial Ad failed to show")
                                }

                                override fun onAdShowedFullScreenContent() {
                                    callback?.onHideAdRequestProgress(TAG, "$TAG [Interstitial] >> Succes - onHideAdRequestProgress [message] : Ad showed fullscreen content")
                                    callback?.onAdShowed(TAG, "Interstitial Ad showed fullscreen content")
                                }
                            }
                        interstitialAd.show(activity)
                    }
                }
            )
        } else {
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
        callback: FrogoAdmobInterstitialCallback
    ) {
        showAdInterstitial(activity, interstitialAdUnitId, timeoutMilliSecond, null, callback)
    }

    override fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        keyword: List<String>,
        callback: FrogoAdmobInterstitialCallback
    ) {
        showAdInterstitial(activity, interstitialAdUnitId, null, keyword, callback)
    }

    override fun showAdInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        callback: FrogoAdmobInterstitialCallback
    ) {
        showAdInterstitial(activity, interstitialAdUnitId, null, null, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: FrogoAdmobRewardedCallback
    ) {
        if (mAdUnitIdRewarded != "") {

            callback.onShowAdRequestProgress(TAG, "$TAG [RewardedAd] >> Run - FrogoAdmobRewardedCallback [callback] : onShowAdRequestProgress()")

            val adRequest = AdRequest.Builder()

            if (timeoutMilliSecond != null) {
                adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
            }

            if (keyword != null) {
                for (i in keyword.indices) {
                    adRequest.addKeyword(keyword[i])
                }
            }

            RewardedAd.load(
                activity,
                mAdUnitIdRewarded,
                adRequest.build(),
                object : RewardedAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        callback.onHideAdRequestProgress(TAG, "$TAG [RewardedAd] >> Error - onHideAdRequestProgress [message] : ${adError.message}")
                        callback.onAdFailed(TAG, "RewardedAd ${adError.message}")
                    }

                    override fun onAdLoaded(rewardedAd: RewardedAd) {
                        callback.onAdLoaded(TAG, "RewardedAd was loaded")
                        rewardedAd.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                   callback.onAdDismissed(TAG, "Rewarded Ad was dismissed")
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                    callback.onHideAdRequestProgress(TAG, "$TAG [RewardedAd] >> Error - FrogoAdmobRewardedCallback [callback] : onHideAdRequestProgress() : onAdFailedToShowFullScreenContent")
                                    callback.onAdFailed(TAG, "Interstitial Ad failed to show")
                                }

                                override fun onAdShowedFullScreenContent() {
                                    callback.onHideAdRequestProgress(TAG, "$TAG [RewardedAd] >> Succes - FrogoAdmobRewardedCallback [callback] : onHideAdRequestProgress() : onAdShowedFullScreenContent")
                                    callback.onAdShowed(TAG, "Rewarded Ad showed fullscreen content")
                                }
                            }

                        rewardedAd.show(activity) {
                            callback.onUserEarnedReward(TAG, it)
                        }
                    }
                })
        } else {
            callback.onAdFailed(TAG, "$TAG Rewarded Unit Id is Empty")
        }

    }

    override fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        callback: FrogoAdmobRewardedCallback
    ) {
        showAdRewarded(activity, mAdUnitIdRewarded, null, null, callback)
    }

    override fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobRewardedCallback
    ) {
        showAdRewarded(activity, mAdUnitIdRewarded, timeoutMilliSecond, null, callback)
    }

    override fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    ) {
        showAdRewarded(activity, mAdUnitIdRewarded, null, keyword, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: FrogoAdmobRewardedCallback
    ) {
        if (mAdUnitIdRewardedInterstitial != "") {

            callback.onShowAdRequestProgress(TAG, "$TAG [RewardedInterstitial] >> Run - FrogoAdmobRewardedCallback [callback] : onShowAdRequestProgress()")

            val adRequest = AdRequest.Builder()

            if (timeoutMilliSecond != null) {
                adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
            }

            if (keyword != null) {
                for (i in keyword.indices) {
                    adRequest.addKeyword(keyword[i])
                }
            }

            RewardedInterstitialAd.load(
                activity,
                mAdUnitIdRewardedInterstitial,
                AdRequest.Builder().build(),
                object : RewardedInterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        callback.onHideAdRequestProgress(TAG, "$TAG [RewardedInterstitial] >> Error - onHideAdRequestProgress [message] : ${loadAdError.message}")
                        callback.onAdFailed(TAG, "RewardedInterstitial ${loadAdError.message}")
                    }

                    override fun onAdLoaded(ad: RewardedInterstitialAd) {
                        callback.onAdLoaded(TAG, "RewardedInterstitial Ad was loaded")
                        ad.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    callback.onAdDismissed(TAG, "RewardedInterstitial Ad was dismissed")
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                    callback.onHideAdRequestProgress(TAG, "$TAG [RewardedInterstitial] >> Error - FrogoAdmobRewardedCallback [callback] : onHideAdRequestProgress() : onAdFailedToShowFullScreenContent")
                                    callback.onAdFailed(TAG, "RewardedInterstitial Ad failed to show")
                                }

                                override fun onAdShowedFullScreenContent() {
                                    callback.onHideAdRequestProgress(TAG, "$TAG [RewardedInterstitial] >> Run - FrogoAdmobRewardedCallback [callback] : onHideAdRequestProgress() : onAdShowedFullScreenContent")
                                    callback.onAdShowed(TAG, "RewardedInterstitial Ad showed fullscreen content")
                                }
                            }

                        ad.show(activity) {
                            callback.onUserEarnedReward(TAG, it)
                        }

                    }
                })
        } else {
            callback.onAdFailed(TAG, "$TAG Rewarded Interstitial Id Is Empty")
        }
    }

    override fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        callback: FrogoAdmobRewardedCallback
    ) {
        showAdRewardedInterstitial(activity, mAdUnitIdRewardedInterstitial, null, null, callback)
    }

    override fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobRewardedCallback
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
        callback: FrogoAdmobRewardedCallback
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