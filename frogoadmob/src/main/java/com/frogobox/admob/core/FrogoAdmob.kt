package com.frogobox.admob.core

import android.content.Context
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogolog.FLog
import com.frogobox.frogolog.FrogoLog
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

    val TAG = FrogoAdmob::class.java.simpleName

    private var mInterstitialAd: InterstitialAd? = null
    private var mRewardedAd: RewardedAd? = null
    private var mRewardedInterstitialAd: RewardedInterstitialAd? = null

    // ---------------------------------------------------------------------------------------------

    override fun setupAdmobApp(context: Context) {
        MobileAds.initialize(context) {}
        FLog.d("Admob mobile Ads Initialized")
    }

    // ---------------------------------------------------------------------------------------------

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

        private fun frogoAdListener(listener: IFrogoAdBanner): AdListener {
            return object : AdListener() {
                override fun onAdLoaded() {
                    FLog.d("Ads Banner onAdLoaded")
                    listener.onAdLoaded()
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    FLog.d("Ads Banner onAdFailedToLoad")
                    listener.onAdFailedToLoad(p0)
                }

                override fun onAdOpened() {
                    FLog.d("Ads Banner onAdOpened")
                    listener.onAdOpened()
                }

                override fun onAdClicked() {
                    FLog.d("Ads Banner onAdClicked")
                    listener.onAdClicked()
                }

                override fun onAdClosed() {
                    FLog.d("Ads Banner onAdClosed")
                    listener.onAdClosed()
                }
            }
        }

        override fun showAdBanner(mAdView: AdView) {
            mAdView.adListener = frogoAdListener()
            mAdView.loadAd(AdRequest.Builder().build())
            FLog.d("Banner Id : Attach on Xml Layout")
        }

        override fun showAdBanner(mAdView: AdView, listener: IFrogoAdBanner) {
            mAdView.adListener = frogoAdListener(listener)
            mAdView.loadAd(AdRequest.Builder().build())
            FLog.d("Banner Id : Attach on Xml Layout")
        }

        override fun showAdBannerContainer(
            context: Context,
            bannerAdUnitId: String,
            mAdsSize: AdSize,
            container: RelativeLayout
        ) {
            FLog.d("Banner Id : $bannerAdUnitId")
            val mAdView = AdView(context)
            mAdView.adUnitId = bannerAdUnitId
            mAdView.adSize = mAdsSize
            mAdView.adListener = frogoAdListener()
            container.addView(mAdView)
            mAdView.loadAd(AdRequest.Builder().build())
        }

        override fun showAdBannerContainer(
            context: Context,
            bannerAdUnitId: String,
            mAdsSize: AdSize,
            container: RelativeLayout,
            listener: IFrogoAdBanner
        ) {
            FLog.d("Banner Id : $bannerAdUnitId")
            val mAdView = AdView(context)
            mAdView.adUnitId = bannerAdUnitId
            mAdView.adSize = mAdsSize
            mAdView.adListener = frogoAdListener(listener)
            container.addView(mAdView)
            mAdView.loadAd(AdRequest.Builder().build())
        }

    }

    // ---------------------------------------------------------------------------------------------

    object Interstitial : IFrogoAdmob.Interstitial {

        override fun showAdInterstitial(activity: AppCompatActivity, interstitialAdUnitId: String) {

            FLog.d("$TAG Interstitial Id : $interstitialAdUnitId")

            InterstitialAd.load(
                activity,
                interstitialAdUnitId,
                AdRequest.Builder().build(),
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        FLog.e("$TAG [Interstitial] >> Error - onAdFailedToLoad [code] : ${adError.code}")
                        FLog.e("$TAG [Interstitial] >> Error - onAdFailedToLoad [domain] : ${adError.domain}")
                        FLog.e("$TAG [Interstitial] >> Error - onAdFailedToLoad [message] : ${adError.message}")
                        mInterstitialAd = null
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        FLog.d("$TAG [Interstitial] >> Succes - onAdLoaded [message] : Ad was loaded")
                        FLog.d("$TAG [Interstitial] >> Succes - onAdLoaded [unit id] : ${interstitialAd.adUnitId}")
                        FLog.d("$TAG [Interstitial] >> Succes - onAdLoaded [response Info] : ${interstitialAd.responseInfo}")
                        mInterstitialAd = interstitialAd
                        mInterstitialAd!!.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    FLog.d("$TAG [Interstitial] >> Succes - onAdDismissedFullScreenContent [message] : Ad was dismissed")
                                    mInterstitialAd = null
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                                    FLog.e("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [code] : ${adError?.code}")
                                    FLog.e("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [domain] : ${adError?.domain}")
                                    FLog.e("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [message] : ${adError?.message}")
                                    FLog.e("$TAG [Interstitial] >> Error : Ad failed to show")

                                    mInterstitialAd = null
                                }

                                override fun onAdShowedFullScreenContent() {
                                    FLog.d("$TAG [Interstitial] >> Succes - onAdShowedFullScreenContent [message] : Ad showed fullscreen content")
                                }
                            }
                    }
                }
            )

            if (mInterstitialAd != null) {
                mInterstitialAd!!.show(activity)
            } else {
                FLog.e("$TAG : The interstitial ad wasn't ready yet.")
            }
        }

        override fun showAdInterstitial(
            activity: AppCompatActivity,
            interstitialAdUnitId: String,
            callback: IFrogoAdInterstitial
        ) {

            FLog.d("$TAG Interstitial Id : $interstitialAdUnitId")

            InterstitialAd.load(
                activity,
                interstitialAdUnitId,
                AdRequest.Builder().build(),
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        FLog.e("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdFailedToLoad()")

                        FLog.e("$TAG [Interstitial] >> Error - onAdFailedToLoad [code] : ${adError.code}")
                        FLog.e("$TAG [Interstitial] >> Error - onAdFailedToLoad [domain] : ${adError.domain}")
                        FLog.e("$TAG [Interstitial] >> Error - onAdFailedToLoad [message] : ${adError.message}")

                        mInterstitialAd = null
                        callback.onAdFailedToLoad("Interstitial ${adError.message}")
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        FLog.d("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdLoaded()")

                        FLog.d("$TAG [Interstitial] >> Succes - onAdLoaded [message] : Ad was loaded")
                        FLog.d("$TAG [Interstitial] >> Succes - onAdLoaded [unit id] : ${interstitialAd.adUnitId}")
                        FLog.d("$TAG [Interstitial] >> Succes - onAdLoaded [response Info] : ${interstitialAd.responseInfo}")

                        FLog.d("$TAG [Interstitial] >> Suggest : You Can Give Your Reward Here")

                        mInterstitialAd = interstitialAd
                        mInterstitialAd!!.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    FLog.d("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdDismissed()")
                                    FLog.d("$TAG [Interstitial] >> Succes - onAdDismissedFullScreenContent [message] : Ad was dismissed")
                                    mInterstitialAd = null
                                    callback.onAdDismissed("Interstitial Ad was dismissed")
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                                    FLog.e("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdFailedToShow()")

                                    FLog.e("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [code] : ${adError?.code}")
                                    FLog.e("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [domain] : ${adError?.domain}")
                                    FLog.e("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [message] : ${adError?.message}")
                                    FLog.e("$TAG [Interstitial] >> Error : Ad failed to show")

                                    mInterstitialAd = null
                                    callback.onAdFailedToShow("Interstitial Ad failed to show")
                                }

                                override fun onAdShowedFullScreenContent() {
                                    FLog.d("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdShowed()")

                                    FLog.d("$TAG [Interstitial] >> Succes - onAdShowedFullScreenContent [message] : Ad showed fullscreen content")
                                    callback.onAdShowed("Interstitial Ad showed fullscreen content")
                                }
                            }

                        callback.onAdLoaded("Interstitial Ad was loaded")
                    }
                }
            )

            if (mInterstitialAd != null) {
                mInterstitialAd!!.show(activity)
            } else {
                FrogoLog.e("$TAG : The interstitialAd ad wasn't ready yet.")
                callback.onAdNotReady("The interstitialAd ad wasn't ready yet")
            }
        }

    }

    // ---------------------------------------------------------------------------------------------

    object Rewarded : IFrogoAdmob.Rewarded {

        override fun showAdRewarded(
            activity: AppCompatActivity,
            mAdUnitIdRewarded: String,
            callback: IFrogoAdRewarded
        ) {
            RewardedAd.load(
                activity,
                mAdUnitIdRewarded,
                AdRequest.Builder().build(),
                object : RewardedAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        FLog.e("$TAG [RewardedAd] >> Run - IFrogoAdRewarded [callback] : onAdFailedToLoad()")

                        FLog.e("$TAG [RewardedAd] >> Error - onAdFailedToLoad [code] : ${adError.code}")
                        FLog.e("$TAG [RewardedAd] >> Error - onAdFailedToLoad [domain] : ${adError.domain}")
                        FLog.e("$TAG [RewardedAd] >> Error - onAdFailedToLoad [message] : ${adError.message}")

                        mRewardedAd = null
                        callback.onAdFailedToLoad("RewardedAd ${adError.message}")
                    }

                    override fun onAdLoaded(rewardedAd: RewardedAd) {
                        FLog.d("$TAG [RewardedAd] >> Run - IFrogoAdRewarded [callback] : onAdLoaded()")

                        FLog.d("$TAG [RewardedAd] >> Succes - onAdLoaded [message] : Ad was loaded")
                        FLog.d("$TAG [RewardedAd] >> Succes - onAdLoaded [unit id] : ${rewardedAd.adUnitId}")
                        FLog.d("$TAG [RewardedAd] >> Succes - onAdLoaded [response Info] : ${rewardedAd.responseInfo}")

                        mRewardedAd = rewardedAd
                        mRewardedAd!!.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    FLog.d("$TAG [Rewarded] >> Run - IFrogoAdRewarded [callback] : onAdDismissed()")
                                    FLog.d("$TAG [Rewarded] >> Succes - onAdDismissedFullScreenContent [message] : Ad was dismissed")

                                    mRewardedAd = null
                                    callback.onAdDismissed("Rewarded Ad was dismissed")
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                                    FLog.e("$TAG [Rewarded] >> Run - IFrogoAdRewarded [callback] : onAdFailedToShow()")

                                    FLog.e("$TAG [Rewarded] >> Error - onAdFailedToShowFullScreenContent [code] : ${adError?.code}")
                                    FLog.e("$TAG [Rewarded] >> Error - onAdFailedToShowFullScreenContent [domain] : ${adError?.domain}")
                                    FLog.e("$TAG [Rewarded] >> Error - onAdFailedToShowFullScreenContent [message] : ${adError?.message}")
                                    FLog.e("$TAG [Rewarded] >> Error : Ad failed to show")

                                    mRewardedAd = null
                                    callback.onAdFailedToShow("Interstitial Ad failed to show")
                                }

                                override fun onAdShowedFullScreenContent() {
                                    FLog.d("$TAG [Rewarded] >> Run - IFrogoAdRewarded [callback] : onAdShowed()")

                                    FLog.d("$TAG [Rewarded] >> Succes - onAdShowedFullScreenContent [message] : Ad showed fullscreen content")
                                    callback.onAdShowed("Rewarded Ad showed fullscreen content")
                                }
                            }

                        callback.onAdLoaded("RewardedAd was loaded")
                    }
                })

            if (mRewardedAd != null) {
                mRewardedAd?.show(activity) {
                    FLog.d("$TAG [RewardedAd] >> Suggest : You Can Give Your Reward Here")
                    FLog.d("$TAG [RewardedAd] >> User Earned [ammount] : ${it.amount}")
                    FLog.d("$TAG [RewardedAd] >> User Earned [type] : ${it.type}")
                    callback.onUserEarnedReward(it)
                }
            } else {
                FLog.e("$TAG : The rewarded ad wasn't ready yet.")
                callback.onAdNotReady("The rewarded ad wasn't ready yet")
            }
        }

        override fun showAdRewardedInterstitial(
            activity: AppCompatActivity,
            mAdUnitIdRewardedInterstitial: String,
            callback: IFrogoAdRewarded
        ) {

            RewardedInterstitialAd.load(
                activity,
                mAdUnitIdRewardedInterstitial,
                AdRequest.Builder().build(),
                object : RewardedInterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        FLog.e("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdFailedToLoad()")

                        FLog.e("$TAG [RewardedInterstitial] >> Error - onAdFailedToLoad [code] : ${loadAdError.code}")
                        FLog.e("$TAG [RewardedInterstitial] >> Error - onAdFailedToLoad [domain] : ${loadAdError.domain}")
                        FLog.e("$TAG [RewardedInterstitial] >> Error - onAdFailedToLoad [message] : ${loadAdError.message}")
                        mRewardedInterstitialAd = null
                        callback.onAdFailedToLoad("RewardedInterstitial ${loadAdError.message}")
                    }

                    override fun onAdLoaded(ad: RewardedInterstitialAd) {

                        FLog.d("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdLoaded()")

                        FLog.d("$TAG [RewardedInterstitial] >> Succes - onAdLoaded [message] : Ad was loaded")
                        FLog.d("$TAG [RewardedInterstitial] >> Succes - onAdLoaded [unit id] : ${ad.adUnitId}")
                        FLog.d("$TAG [RewardedInterstitial] >> Succes - onAdLoaded [response Info] : ${ad.responseInfo}")

                        mRewardedInterstitialAd = ad
                        mRewardedInterstitialAd!!.fullScreenContentCallback =
                            object : FullScreenContentCallback() {
                                override fun onAdDismissedFullScreenContent() {
                                    FLog.d("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdDismissed()")
                                    FLog.d("$TAG [RewardedInterstitial] >> Succes - onAdDismissedFullScreenContent [message] : Ad was dismissed")
                                    mRewardedInterstitialAd = null
                                    callback.onAdDismissed("RewardedInterstitial Ad was dismissed")
                                }

                                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                                    FLog.e("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdFailedToShow()")

                                    FLog.e("$TAG [RewardedInterstitial] >> Error - onAdFailedToShowFullScreenContent [code] : ${adError?.code}")
                                    FLog.e("$TAG [RewardedInterstitial] >> Error - onAdFailedToShowFullScreenContent [domain] : ${adError?.domain}")
                                    FLog.e("$TAG [RewardedInterstitial] >> Error - onAdFailedToShowFullScreenContent [message] : ${adError?.message}")
                                    FLog.e("$TAG [RewardedInterstitial] >> Error : Ad failed to show")

                                    mRewardedInterstitialAd = null
                                    callback.onAdFailedToShow("RewardedInterstitial Ad failed to show")
                                }

                                override fun onAdShowedFullScreenContent() {
                                    FLog.d("$TAG [RewardedInterstitial] >> Run - IFrogoAdRewarded [callback] : onAdShowed()")

                                    FLog.d("$TAG [RewardedInterstitial] >> Succes - onAdShowedFullScreenContent [message] : Ad showed fullscreen content")
                                    callback.onAdShowed("RewardedInterstitial Ad showed fullscreen content")
                                }
                            }

                        callback.onAdLoaded("RewardedInterstitial Ad was loaded")
                    }
                })

            if (mRewardedInterstitialAd != null) {
                mRewardedInterstitialAd?.show(activity) {
                    callback.onUserEarnedReward(it)
                }
            } else {
                FLog.e("$TAG : The rewarded ad wasn't ready yet.")
                callback.onAdNotReady("The rewarded ad wasn't ready yet")
            }
        }

    }

    object RecyclerView : IFrogoAdmob.RecyclerView {

        override fun loadRecyclerBannerAds(
            bannerAdUnitId: String,
            context: Context,
            recyclerViewDataList: MutableList<Any>
        ) { // Load the first banner ad in the items list (subsequent ads will be loaded automatically in sequence).
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

}