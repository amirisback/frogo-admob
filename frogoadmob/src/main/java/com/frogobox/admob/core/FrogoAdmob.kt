package com.frogobox.admob.core

import android.content.Context
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.core.FrogoAdmobConstant.RECYCLER_VIEW_ITEMS_PER_AD
import com.frogobox.frogolog.FLog
import com.google.android.gms.ads.*
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

    private val TAG = "FrogoAdmob"
    private val frogoAdRequest = AdRequest.Builder().build()

    private lateinit var admobPublisherID: String
    private lateinit var mAdUnitIdInterstitial: String
    private lateinit var mAdUnitIdBanner: String
    private lateinit var mAdUnitIdRewarded: String
    private lateinit var mAdUnitIdRewardedInterstitial: String

    private var mInterstitialAd: InterstitialAd? = null
    private var mRewardedAd: RewardedAd? = null
    private var mRewardedInterstitialAd: RewardedInterstitialAd? = null

    override fun setupPublisherID(mPublisherId: String) {
        admobPublisherID = mPublisherId
        FLog.d("Publisher Id : $admobPublisherID")
    }

    override fun setupBannerAdUnitID(mAdUnitId: String) {
        mAdUnitIdBanner = mAdUnitId
        FLog.d("Banner Id : $mAdUnitIdBanner")
    }

    override fun setupInterstialAdUnitID(mAdUnitId: String) {
        mAdUnitIdInterstitial = mAdUnitId
        FLog.d("Interstitial Id : $mAdUnitIdInterstitial")
    }

    override fun setupRewardedAdUnitID(mAdUnitId: String) {
        mAdUnitIdRewarded = mAdUnitId
        FLog.d("Rewarded Id : $mAdUnitIdRewarded")
    }

    override fun setupRewardedInterstitialAdUnitID(mAdUnitId: String) {
        mAdUnitIdRewardedInterstitial = mAdUnitId
        FLog.d("Rewarded Interstitial Id : $mAdUnitIdRewardedInterstitial")
    }

    object Publisher : IFrogoAdmob.Publisher {
        override fun setupPublisher(context: Context) {
            MobileAds.initialize(context) {}
        }
    }

    object Banner : IFrogoAdmob.Banner {

        private fun frogoAdListener(): AdListener {
            return object : AdListener() {
                override fun onAdLoaded() {
                    FLog.d("Ads Banner onAdLoaded")
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    FLog.d("Ads Banner onAdFailedToLoad")
                }

                override fun onAdOpened() {
                    FLog.d("Ads Banner onAdOpened")
                }

                override fun onAdClicked() {
                    FLog.d("Ads Banner onAdClicked")
                }

                override fun onAdClosed() {
                    FLog.d("Ads Banner onAdClosed")
                }
            }
        }

        private fun frogoAdListener(bannerListener: IFrogoAdListener.Banner): AdListener {
            return object : AdListener() {
                override fun onAdLoaded() {
                    FLog.d("Ads Banner onAdLoaded")
                    bannerListener.onAdLoaded()
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    FLog.d("Ads Banner onAdFailedToLoad")
                    bannerListener.onAdFailedToLoad(p0)
                }

                override fun onAdOpened() {
                    FLog.d("Ads Banner onAdOpened")
                    bannerListener.onAdOpened()
                }

                override fun onAdClicked() {
                    FLog.d("Ads Banner onAdClicked")
                    bannerListener.onAdClicked()
                }

                override fun onAdClosed() {
                    FLog.d("Ads Banner onAdClosed")
                    bannerListener.onAdClosed()
                }
            }
        }

        override fun showBanner(mAdView: AdView) {
            mAdView.adListener = frogoAdListener()
            mAdView.loadAd(frogoAdRequest)
        }

        override fun showBanner(mAdView: AdView, bannerListener: IFrogoAdListener.Banner) {
            mAdView.adListener = frogoAdListener(bannerListener)
            mAdView.loadAd(frogoAdRequest)
        }

        override fun showBannerContainer(
            context: Context,
            mAdsSize: AdSize,
            container: RelativeLayout
        ) {
            val mAdView = AdView(context)
            mAdView.adUnitId = mAdUnitIdBanner
            mAdView.adSize = mAdsSize
            mAdView.adListener = frogoAdListener()
            container.addView(mAdView)
            mAdView.loadAd(frogoAdRequest)
        }

        override fun showBannerContainer(
            context: Context,
            mAdsSize: AdSize,
            container: RelativeLayout,
            bannerListener: IFrogoAdListener.Banner
        ) {
            val mAdView = AdView(context)
            mAdView.adUnitId = mAdUnitIdBanner
            mAdView.adSize = mAdsSize
            mAdView.adListener = frogoAdListener(bannerListener)
            container.addView(mAdView)
            mAdView.loadAd(frogoAdRequest)
        }

        override fun showBannerContainer(
            context: Context,
            bannerAdUnitId: String,
            mAdsSize: AdSize,
            container: RelativeLayout
        ) {
            val mAdView = AdView(context)
            mAdView.adUnitId = bannerAdUnitId
            mAdView.adSize = mAdsSize
            mAdView.adListener = frogoAdListener()
            container.addView(mAdView)
            mAdView.loadAd(frogoAdRequest)
        }

        override fun showBannerContainer(
            context: Context,
            bannerAdUnitId: String,
            mAdsSize: AdSize,
            container: RelativeLayout,
            bannerListener: IFrogoAdListener.Banner
        ) {
            val mAdView = AdView(context)
            mAdView.adUnitId = bannerAdUnitId
            mAdView.adSize = mAdsSize
            mAdView.adListener = frogoAdListener(bannerListener)
            container.addView(mAdView)
            mAdView.loadAd(frogoAdRequest)
        }

    }

    object Interstitial : IFrogoAdmob.Interstitial {

        private fun frogoInterstitialCallback(): InterstitialAdLoadCallback {
            return object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    val error =
                        "domain: ${adError.domain}, code: ${adError.code}, " + "message: ${adError.message}"
                    FLog.d(adError.message)
                    FLog.d("onAdFailedToLoad() with error $error")
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    FLog.d("Ad was loaded.")
                    FLog.d("onAdLoaded() success")
                    mInterstitialAd = interstitialAd
                }
            }
        }

        private fun frogoInterstitialCallback(interstitialListener: IFrogoAdListener.Interstitial): InterstitialAdLoadCallback {
            return object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    val error =
                        "domain: ${adError.domain}, code: ${adError.code}, " + "message: ${adError.message}"
                    FLog.d(adError.message)
                    FLog.d("onAdFailedToLoad() with error $error")
                    mInterstitialAd = null
                    interstitialListener.onAdFailedToLoad(adError)
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    FLog.d("Ad was loaded.")
                    FLog.d("onAdLoaded() success")
                    mInterstitialAd = interstitialAd
                    interstitialListener.onAdLoaded(interstitialAd)
                }
            }
        }

        private fun frogoFullScreenContentCallback(context: Context): FullScreenContentCallback {
            return object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    // Don't forget to set the ad reference to null so you
                    // don't show the ad a second time.
                    FLog.d("Ad was dismissed.")
                    mInterstitialAd = null
                    setupInterstitial(context)
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                    // Don't forget to set the ad reference to null so you
                    // don't show the ad a second time.
                    FLog.d("Ad failed to show.")
                    mInterstitialAd = null
                }

                override fun onAdShowedFullScreenContent() {
                    // Called when ad is dismissed.
                    FLog.d("Ad showed fullscreen content.")
                }
            }
        }

        private fun frogoFullScreenContentCallback(
            context: Context,
            interstitialListener: IFrogoAdListener.Interstitial
        ): FullScreenContentCallback {
            return object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    // Don't forget to set the ad reference to null so you
                    // don't show the ad a second time.
                    FLog.d("Ad was dismissed.")
                    mInterstitialAd = null
                    setupInterstitial(context, interstitialListener)
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                    // Don't forget to set the ad reference to null so you
                    // don't show the ad a second time.
                    FLog.d("Ad failed to show.")
                    mInterstitialAd = null
                }

                override fun onAdShowedFullScreenContent() {
                    // Called when ad is dismissed.
                    FLog.d("Ad showed fullscreen content.")
                }
            }
        }

        override fun setupInterstitial(context: Context) {
            InterstitialAd.load(
                context,
                mAdUnitIdInterstitial,
                frogoAdRequest,
                frogoInterstitialCallback()
            )
        }

        override fun setupInterstitial(
            context: Context,
            interstitialListener: IFrogoAdListener.Interstitial
        ) {
            InterstitialAd.load(
                context,
                mAdUnitIdInterstitial,
                frogoAdRequest,
                frogoInterstitialCallback(interstitialListener)
            )
        }

        override fun setupInterstitial(context: Context, interstitialAdUnitId: String) {
            InterstitialAd.load(
                context,
                interstitialAdUnitId,
                frogoAdRequest,
                frogoInterstitialCallback()
            )
        }

        override fun setupInterstitial(
            context: Context,
            interstitialAdUnitId: String,
            interstitialListener: IFrogoAdListener.Interstitial
        ) {
            InterstitialAd.load(
                context,
                interstitialAdUnitId,
                frogoAdRequest,
                frogoInterstitialCallback(interstitialListener)
            )
        }

        override fun showInterstitial(activity: AppCompatActivity) {
            if (mInterstitialAd != null) {
                mInterstitialAd!!.fullScreenContentCallback =
                    frogoFullScreenContentCallback(activity)
                mInterstitialAd!!.show(activity)
            }
        }

        override fun showInterstitial(
            activity: AppCompatActivity,
            interstitialListener: IFrogoAdListener.Interstitial
        ) {
            if (mInterstitialAd != null) {
                mInterstitialAd!!.fullScreenContentCallback =
                    frogoFullScreenContentCallback(activity, interstitialListener)
                mInterstitialAd!!.show(activity)
            }
        }

    }

    object Rewarded : IFrogoAdmob.Rewarded {

        override fun setupRewarded(context: Context) {
            val adRequest = AdRequest.Builder().build()

            RewardedAd.load(
                context,
                mAdUnitIdRewarded,
                adRequest,
                object : RewardedAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        FLog.d(adError.message)
                        mRewardedAd = null
                    }

                    override fun onAdLoaded(rewardedAd: RewardedAd) {
                        FLog.d("Ad was loaded.")
                        mRewardedAd = rewardedAd
                        mRewardedAd!!.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdShowedFullScreenContent() {
                                    // Called when ad is shown.
                                    FLog.d("Ad was shown.")
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                                    // Called when ad fails to show.
                                    FLog.d("Ad failed to show.")
                                }

                                override fun onAdDismissedFullScreenContent() {
                                    // Called when ad is dismissed.
                                    // Set the ad reference to null so you don't show the ad a second time.
                                    FLog.d("Ad was dismissed.")
                                    mRewardedAd = null
                                }
                            }

                    }
                })
        }

        override fun showRewarded(
            activity: AppCompatActivity,
            callback: IFrogoAdmob.UserEarned
        ) {
            if (mRewardedAd != null) {
                mRewardedAd?.show(activity) {
                    callback.onUserEarnedReward(it)
                }
            } else {
                FLog.d("The rewarded ad wasn't ready yet.")
            }
        }

    }

    object RewardedInterstitial : IFrogoAdmob.RewardedInterstitial {

        override fun setupRewardedInterstitial(context: Context) {
            RewardedInterstitialAd.load(context, mAdUnitIdRewardedInterstitial, frogoAdRequest,
                object : RewardedInterstitialAdLoadCallback() {
                    override fun onAdLoaded(ad: RewardedInterstitialAd) {
                        mRewardedInterstitialAd = ad
                        mRewardedInterstitialAd!!.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                /** Called when the ad failed to show full screen content.  */
                                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                    FLog.i("onAdFailedToShowFullScreenContent")
                                }

                                /** Called when ad showed the full screen content.  */
                                override fun onAdShowedFullScreenContent() {
                                    FLog.i("onAdShowedFullScreenContent")
                                }

                                /** Called when full screen content is dismissed.  */
                                override fun onAdDismissedFullScreenContent() {
                                    FLog.i("onAdDismissedFullScreenContent")
                                }
                            }
                        FLog.e("onAdLoaded")
                    }

                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        FLog.e("onAdFailedToLoad")
                    }
                })
        }

        override fun showRewardedInterstitial(
            activity: AppCompatActivity,
            callback: IFrogoAdmob.UserEarned
        ) {
            if (mRewardedInterstitialAd != null) {
                mRewardedInterstitialAd?.show(activity) {
                    callback.onUserEarnedReward(it)
                }
            } else {
                FLog.d("The rewarded ad wasn't ready yet.")
            }
        }

    }

    object RecyclerView : IFrogoAdmob.RecyclerView {

        override fun loadRecyclerBannerAds(
            context: Context,
            recyclerViewDataList: MutableList<Any>
        ) { // Load the first banner ad in the items list (subsequent ads will be loaded automatically in sequence).
            addBannerAds(context, recyclerViewDataList)
            loadBannerAd(recyclerViewDataList, 0)
        }

        override fun addBannerAds(
            context: Context,
            recyclerViewDataList: MutableList<Any>
        ) {
            // Loop through the items array and place a new banner ad in every ith position in the items List.
            var i = 0
            while (i <= recyclerViewDataList.size) {
                val adView = AdView(context)
                adView.adSize = AdSize.BANNER
                adView.adUnitId = mAdUnitIdBanner
                recyclerViewDataList.add(i, adView)
                i += RECYCLER_VIEW_ITEMS_PER_AD
            }
        }

        override fun loadBannerAd(recyclerViewDataList: MutableList<Any>, index: Int) {
            if (index >= recyclerViewDataList.size) {
                return
            }
            val item: Any = recyclerViewDataList.get(index) as? AdView
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
                    loadBannerAd(recyclerViewDataList, index + RECYCLER_VIEW_ITEMS_PER_AD)
                }

                override fun onAdFailedToLoad(p0: LoadAdError) { // The previous banner ad failed to load. Call this method again to load the next ad in the items list.
                    FLog.e("The previous banner ad failed to load. Attempting to load the next banner ad in the items list.")
                    loadBannerAd(recyclerViewDataList, index + RECYCLER_VIEW_ITEMS_PER_AD)
                }
            }
            // Load the banner ad.
            adView.loadAd(AdRequest.Builder().build())
        }

    }

}