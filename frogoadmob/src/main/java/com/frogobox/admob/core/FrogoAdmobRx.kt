package com.frogobox.admob.core

import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.ext.executeAd
import com.frogobox.coresdk.response.FrogoStateResponse
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.sdk.ext.showLogError
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import io.reactivex.rxjava3.core.Completable


/*
 * Created by faisalamir on 18/04/22
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

class FrogoAdmobRx {

    fun showIterstitialAd(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: IFrogoAdInterstitial?
    ) {

        FrogoAdmobSingleFunc.waterMark()
        showLogDebug("${FrogoAdmob.TAG} Interstitial Id : $interstitialAdUnitId")

        FrogoAdmobSingleFunc.getInitializedState(
            FrogoAdmob.initializationName,
            FrogoAdmob.initializationCode
        )

        if (interstitialAdUnitId != "") {

            val adRequest = AdRequest.Builder()

            if (timeoutMilliSecond != null) {
                showLogDebug("${FrogoAdmob.TAG} Interstitial HttpTimeOut Millisecond : $timeoutMilliSecond")
                adRequest.setHttpTimeoutMillis(timeoutMilliSecond)
            }

            if (keyword != null) {
                for (i in keyword.indices) {
                    showLogDebug("${FrogoAdmob.TAG} Interstitial Keyworad Ads [$i] : ${keyword[i]}")
                    adRequest.addKeyword(keyword[i])
                }
            }


            Completable.fromAction {

                InterstitialAd.load(
                    activity,
                    interstitialAdUnitId,
                    adRequest.build(),
                    object : InterstitialAdLoadCallback() {
                        override fun onAdFailedToLoad(adError: LoadAdError) {
                            FrogoAdmobSingleFunc.getInitializedState(
                                FrogoAdmob.initializationName,
                                FrogoAdmob.initializationCode
                            )
                            showLogError("${FrogoAdmob.TAG} [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdFailedToLoad()")
                            showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToLoad [unit id] : $interstitialAdUnitId")
                            showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToLoad [code] : ${adError.code}")
                            showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToLoad [domain] : ${adError.domain}")
                            showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToLoad [message] : ${adError.message}")
                            callback?.onHideAdRequestProgress(
                                FrogoAdmob.TAG,
                                "${FrogoAdmob.TAG} [Interstitial] >> Error - onHideAdRequestProgress [message] : ${adError.message}"
                            )
                            callback?.onAdFailed(FrogoAdmob.TAG, "Interstitial ${adError.message}")
                        }

                        override fun onAdLoaded(interstitialAd: InterstitialAd) {
                            showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdLoaded()")
                            showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Succes - onAdLoaded [message] : Ad was loaded")
                            showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Succes - onAdLoaded [unit id] : ${interstitialAd.adUnitId}")
                            showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Succes - onAdLoaded [response Info] : ${interstitialAd.responseInfo}")
                            showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Suggest : You Can Give Your Reward Here")
                            callback?.onAdLoaded(FrogoAdmob.TAG, "Interstitial Ad was loaded")

                            interstitialAd.fullScreenContentCallback =
                                object : FullScreenContentCallback() {
                                    override fun onAdDismissedFullScreenContent() {
                                        showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdDismissed()")
                                        showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Succes - onAdDismissedFullScreenContent [message] : Ad was dismissed")
                                        callback?.onAdDismissed(FrogoAdmob.TAG, "Interstitial Ad was dismissed")
                                    }

                                    override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                        FrogoAdmobSingleFunc.getInitializedState(
                                            FrogoAdmob.initializationName,
                                            FrogoAdmob.initializationCode
                                        )
                                        showLogError("${FrogoAdmob.TAG} [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdFailedToShow()")
                                        showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToShowFullScreenContent [unit id] : $interstitialAdUnitId")
                                        showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToShowFullScreenContent [code] : ${adError.code}")
                                        showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToShowFullScreenContent [domain] : ${adError.domain}")
                                        showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToShowFullScreenContent [message] : ${adError.message}")
                                        showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error : Ad failed to show")
                                        callback?.onHideAdRequestProgress(
                                            FrogoAdmob.TAG,
                                            "${FrogoAdmob.TAG} [Interstitial] >> Error - onHideAdRequestProgress [message] : onAdFailedToShowFullScreenContent"
                                        )
                                        callback?.onAdFailed(FrogoAdmob.TAG, "Interstitial Ad failed to show")
                                    }

                                    override fun onAdShowedFullScreenContent() {
                                        showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdShowed()")
                                        showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Succes - onAdShowedFullScreenContent [message] : Ad showed fullscreen content")
                                        callback?.onHideAdRequestProgress(
                                            FrogoAdmob.TAG,
                                            "${FrogoAdmob.TAG} [Interstitial] >> Succes - onHideAdRequestProgress [message] : Ad showed fullscreen content"
                                        )
                                        callback?.onAdShowed(
                                            FrogoAdmob.TAG,
                                            "Interstitial Ad showed fullscreen content"
                                        )
                                    }
                                }
                            interstitialAd.show(activity)
                        }
                    }
                )

            }
                .executeAd(object : FrogoStateResponse {

                    override fun onFailed(statusCode: Int, errorMessage: String) {

                    }

                    override fun onFinish() {

                    }

                    override fun onHideProgress() {
                    }

                    override fun onShowProgress() {
                        callback?.onShowAdRequestProgress(
                            FrogoAdmob.TAG,
                            "${FrogoAdmob.TAG} [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onShowAdRequestProgress()"
                        )
                    }

                    override fun onSuccess() {

                    }
                })
        }  else {
            showLogError("${FrogoAdmob.TAG} Interstitial ID is Empty")
            callback?.onAdFailed(FrogoAdmob.TAG, "${FrogoAdmob.TAG} Interstitial ID is Empty")
        }


    }

}