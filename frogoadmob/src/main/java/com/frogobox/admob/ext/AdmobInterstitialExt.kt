package com.frogobox.admob.ext

import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.core.FrogoAdmobSingleFunc.waterMark
import com.frogobox.admob.core.IFrogoAdInterstitial
import com.frogobox.log.FLog
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAd.load
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


/*
 * Created by faisalamir on 12/04/22
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

private const val TAG: String = "FrogoAdmobInterstitialExt"


fun InterstitialAd.showAd(
    activity: AppCompatActivity,
    interstitialAdUnitId: String,
    timeoutMilliSecond: Int?,
    keyword: List<String>?,
    callback: IFrogoAdInterstitial?
) {

    waterMark()
    FLog.d("$TAG Interstitial Id : $interstitialAdUnitId")

    if (interstitialAdUnitId != "") {

        callback?.onShowAdRequestProgress(
            TAG,
            "$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onShowAdRequestProgress()"
        )

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

        load(
            activity,
            interstitialAdUnitId,
            adRequest.build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    FLog.e("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdFailedToLoad()")
                    FLog.d("$TAG [Interstitial] >> Error - onAdFailedToLoad [unit id] : $interstitialAdUnitId")
                    FLog.e("$TAG [Interstitial] >> Error - onAdFailedToLoad [code] : ${adError.code}")
                    FLog.e("$TAG [Interstitial] >> Error - onAdFailedToLoad [domain] : ${adError.domain}")
                    FLog.e("$TAG [Interstitial] >> Error - onAdFailedToLoad [message] : ${adError.message}")
                    callback?.onHideAdRequestProgress(
                        TAG,
                        "$TAG [Interstitial] >> Error - onHideAdRequestProgress [message] : ${adError.message}"
                    )
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
                                callback?.onAdDismissed(
                                    TAG,
                                    "Interstitial Ad was dismissed"
                                )
                            }

                            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                FLog.e("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdFailedToShow()")
                                FLog.d("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [unit id] : $interstitialAdUnitId")
                                FLog.e("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [code] : ${adError.code}")
                                FLog.e("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [domain] : ${adError.domain}")
                                FLog.e("$TAG [Interstitial] >> Error - onAdFailedToShowFullScreenContent [message] : ${adError.message}")
                                FLog.e("$TAG [Interstitial] >> Error : Ad failed to show")
                                callback?.onHideAdRequestProgress(
                                    TAG,
                                    "$TAG [Interstitial] >> Error - onHideAdRequestProgress [message] : onAdFailedToShowFullScreenContent"
                                )
                                callback?.onAdFailed(
                                    TAG,
                                    "Interstitial Ad failed to show"
                                )
                            }

                            override fun onAdShowedFullScreenContent() {
                                FLog.d("$TAG [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdShowed()")
                                FLog.d("$TAG [Interstitial] >> Succes - onAdShowedFullScreenContent [message] : Ad showed fullscreen content")
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
        FLog.e("$TAG Interstitial ID is Empty")
        callback?.onAdFailed(TAG, "$TAG Interstitial ID is Empty")
    }

}