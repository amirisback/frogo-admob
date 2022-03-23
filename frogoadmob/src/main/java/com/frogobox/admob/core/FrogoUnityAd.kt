package com.frogobox.admob.core

import android.app.Activity
import android.content.Context
import com.frogobox.frogolog.FLog
import com.unity3d.ads.*


/*
 * Created by faisalamir on 22/03/22
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

object FrogoUnityAd {

    val TAG: String = FrogoUnityAd::class.java.simpleName

    fun setupUnityAdApp(context: Context, testMode: Boolean, unityGameId: String) {

        FrogoAdmobSingleFunc.waterMark()
        FLog.d("$TAG Unity Game Id : $unityGameId")
        FLog.d("$TAG State Unity Intialized : ${UnityAds.isInitialized()}")

        if (unityGameId != "") {
            if (!UnityAds.isInitialized()) {
                UnityAds.initialize(
                    context,
                    unityGameId,
                    testMode,
                    object : IUnityAdsInitializationListener {
                        override fun onInitializationComplete() {
                            FLog.d("$TAG >> Setup UnityAdApp : Unity Ads Initialized Complete")
                        }

                        override fun onInitializationFailed(
                            error: UnityAds.UnityAdsInitializationError?,
                            message: String?
                        ) {
                            FLog.e("$TAG [Unity Initialization] >> Error - onInitializationFailed [error] : $error")
                            FLog.e("$TAG [Unity Initialization] >> Error - onInitializationFailed [message] : $message")
                        }

                    })
            }
        }

    }

    fun setupUnityAdApp(
        context: Context,
        testMode: Boolean,
        unityGameId: String,
        callback: IFrogoUnityAdInitialization
    ) {

        FrogoAdmobSingleFunc.waterMark()
        FLog.d("$TAG Unity Game Id : $unityGameId")
        FLog.d("$TAG State Unity Intialized : ${UnityAds.isInitialized()}")

        if (unityGameId == "") {
            callback.onInitializationFailed(TAG, "$TAG : Unity Game Id is Empty")
        } else {
            if (!UnityAds.isInitialized()) {
                UnityAds.initialize(
                    context,
                    unityGameId,
                    testMode,
                    object : IUnityAdsInitializationListener {

                        override fun onInitializationComplete() {
                            FLog.d("$TAG >> Setup UnityAdApp : Unity Ads Initialized Complete")
                            callback.onInitializationComplete(
                                TAG,
                                "$TAG : onInitializationComplete"
                            )
                        }

                        override fun onInitializationFailed(
                            error: UnityAds.UnityAdsInitializationError?,
                            message: String?
                        ) {
                            FLog.e("$TAG [Unity Initialization] >> Error - onInitializationFailed [error] : $error")
                            FLog.e("$TAG [Unity Initialization] >> Error - onInitializationFailed [message] : $message")
                            callback.onInitializationFailed(
                                TAG,
                                "$TAG: onInitializationFailed with error message : $message"
                            )
                        }

                    })
            }
        }

    }

    fun showAdInterstitial(
        activity: Activity,
        adInterstitialUnitId: String
    ) {

        FrogoAdmobSingleFunc.waterMark()
        FLog.d("$TAG Unity Ad Interstitial Unit Id : $adInterstitialUnitId")
        FLog.d("$TAG State Unity Intialized : ${UnityAds.isInitialized()}")

        if (adInterstitialUnitId != "") {
            if (!UnityAds.isInitialized()) {
                FLog.e("$TAG [Unity showAdInterstitial] >> Error - UnityAds Error Initilized [status] : ${UnityAds.isInitialized()}")
            } else {
                FLog.d("$TAG [Unity showAdInterstitial] >> Succes - UnityAds isInitialized [status] : ${UnityAds.isInitialized()}")
                UnityAds.load(adInterstitialUnitId, object : IUnityAdsLoadListener {
                    override fun onUnityAdsAdLoaded(placementId: String) {
                        UnityAds.show(
                            activity,
                            placementId,
                            UnityAdsShowOptions(),
                            object : IUnityAdsShowListener {
                                override fun onUnityAdsShowFailure(
                                    placementId: String,
                                    error: UnityAds.UnityAdsShowError,
                                    message: String
                                ) {
                                    FLog.e("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsShowFailure [placementId] : $placementId")
                                    FLog.e("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsShowFailure [error] : $error")
                                    FLog.e("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsShowFailure [message] : ${UnityAds.isInitialized()}")
                                }

                                override fun onUnityAdsShowStart(placementId: String) {
                                    FLog.d("$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowStart [placementId] : $placementId")
                                }

                                override fun onUnityAdsShowClick(placementId: String) {
                                    FLog.d("$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowClick [placementId] : $placementId")
                                }

                                override fun onUnityAdsShowComplete(
                                    placementId: String,
                                    state: UnityAds.UnityAdsShowCompletionState
                                ) {
                                    FLog.d("$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowComplete [placementId] : $placementId")
                                    FLog.d("$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowComplete [state] : $state")
                                }
                            })
                    }

                    override fun onUnityAdsFailedToLoad(
                        placementId: String,
                        error: UnityAds.UnityAdsLoadError,
                        message: String
                    ) {
                        FLog.e("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsFailedToLoad [placementId] : $placementId")
                        FLog.e("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsFailedToLoad [error] : $error")
                        FLog.e("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsFailedToLoad [message] : ${UnityAds.isInitialized()}")
                    }
                })
            }
        } else {
            FLog.d("$TAG : Unity Ad Interstitial Id Is Empty")
        }

    }

    fun showAdInterstitial(
        activity: Activity,
        adInterstitialUnitId: String,
        callback: IFrogoUnityAdInterstitial
    ) {

        FrogoAdmobSingleFunc.waterMark()
        FLog.d("$TAG Unity Ad Interstitial Unit Id : $adInterstitialUnitId")

        if (adInterstitialUnitId == "") {
            FLog.d("$TAG : Unity Ad Interstitial id is Empty")
            callback.onAdFailed(TAG, "$TAG : Unity Ad Interstitial id is Empty")
        } else {
            if (!UnityAds.isInitialized()) {
                FLog.e("$TAG [Unity showAdInterstitial] >> Error - UnityAds Error Initilized [status] : ${UnityAds.isInitialized()}")
                callback.onAdFailed(
                    TAG,
                    "$TAG [Unity showAdInterstitial] >> Error - UnityAds Error Initilized [status] : ${UnityAds.isInitialized()}"
                )
            } else {
                FLog.d("$TAG [Unity showAdInterstitial] >> Succes - UnityAds isInitialized [status] : ${UnityAds.isInitialized()}")
                UnityAds.load(adInterstitialUnitId, object : IUnityAdsLoadListener {
                    override fun onUnityAdsAdLoaded(placementId: String) {
                        callback.onAdLoaded(TAG, "$TAG : onUnityAdsAdLoaded $placementId")
                        UnityAds.show(
                            activity,
                            placementId,
                            UnityAdsShowOptions(),
                            object : IUnityAdsShowListener {
                                override fun onUnityAdsShowFailure(
                                    placementId: String,
                                    error: UnityAds.UnityAdsShowError,
                                    message: String
                                ) {
                                    FLog.e("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsShowFailure [placementId] : $placementId")
                                    FLog.e("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsShowFailure [error] : $error")
                                    FLog.e("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsShowFailure [message] : $message")
                                    callback.onAdFailed(
                                        TAG,
                                        "$TAG [Unity showAdInterstitial] >> Error - onUnityAdsShowFailure [message] : $message"
                                    )
                                }

                                override fun onUnityAdsShowStart(placementId: String) {
                                    FLog.d("$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowStart [placementId] : $placementId")
                                    callback.onAdShowed(
                                        TAG,
                                        "$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowStart [placementId] : $placementId"
                                    )
                                }

                                override fun onUnityAdsShowClick(placementId: String) {
                                    FLog.d("$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowClick [placementId] : $placementId")
                                    callback.onClicked(
                                        TAG,
                                        "$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowClick [placementId] : $placementId"
                                    )
                                }

                                override fun onUnityAdsShowComplete(
                                    placementId: String,
                                    state: UnityAds.UnityAdsShowCompletionState
                                ) {
                                    FLog.d("$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowComplete [placementId] : $placementId")
                                    FLog.d("$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowComplete [state] : $state")
                                    callback.onAdDismissed(
                                        TAG,
                                        "$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowComplete [state] : $state, [placement] : $placementId"
                                    )
                                }
                            })
                    }

                    override fun onUnityAdsFailedToLoad(
                        placementId: String,
                        error: UnityAds.UnityAdsLoadError,
                        message: String
                    ) {
                        FLog.e("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsFailedToLoad [placementId] : $placementId")
                        FLog.e("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsFailedToLoad [error] : $error")
                        FLog.e("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsFailedToLoad [message] : ${UnityAds.isInitialized()}")
                        callback.onAdFailed(
                            TAG,
                            "$TAG [Unity showAdInterstitial] >> Error - UnityAds Error Initilized [status] : ${UnityAds.isInitialized()}"
                        )
                    }
                })
            }
        }

    }

}