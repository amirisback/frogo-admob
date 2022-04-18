package com.frogobox.admob.core

import android.app.Activity
import android.content.Context
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.sdk.ext.showLogError
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

object FrogoUnityAd : IFrogoUnityAd {

    val TAG: String = FrogoUnityAd::class.java.simpleName

    override fun setupUnityAdApp(
        context: Context,
        testMode: Boolean,
        unityGameId: String,
        callback: IFrogoUnityAdInitialization?
    ) {

        FrogoAdmobSingleFunc.waterMark()
        showLogDebug("$TAG Unity Game Id : $unityGameId")
        showLogDebug("$TAG State Unity Intialized : ${UnityAds.isInitialized()}")

        if (unityGameId != "") {
            if (!UnityAds.isInitialized()) {
                UnityAds.initialize(
                    context,
                    unityGameId,
                    testMode,
                    object : IUnityAdsInitializationListener {

                        override fun onInitializationComplete() {
                            showLogDebug("$TAG >> Setup UnityAdApp : Unity Ads Initialized Complete")
                            callback?.onInitializationComplete(
                                TAG,
                                "$TAG : onInitializationComplete"
                            )
                        }

                        override fun onInitializationFailed(
                            error: UnityAds.UnityAdsInitializationError?,
                            message: String?
                        ) {
                            showLogError("$TAG [Unity Initialization] >> Error - Unity Game Id : $unityGameId")
                            showLogError("$TAG [Unity Initialization] >> Error - onInitializationFailed [error] : $error")
                            showLogError("$TAG [Unity Initialization] >> Error - onInitializationFailed [message] : $message")
                            callback?.onInitializationFailed(
                                TAG,
                                "$TAG: onInitializationFailed with error message : $message"
                            )
                        }

                    })
            }
        } else {
            callback?.onInitializationFailed(TAG, "$TAG : Unity Game Id is Empty")
        }

    }

    override fun setupUnityAdApp(context: Context, testMode: Boolean, unityGameId: String) {
        setupUnityAdApp(context, testMode, unityGameId, null)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showAdInterstitial(
        activity: Activity,
        adInterstitialUnitId: String,
        callback: IFrogoUnityAdInterstitial?
    ) {

        FrogoAdmobSingleFunc.waterMark()
        showLogDebug("$TAG Unity Ad Interstitial Unit Id : $adInterstitialUnitId")
        showLogDebug("$TAG State Unity Intialized : ${UnityAds.isInitialized()}")

        if (adInterstitialUnitId != "") {
            if (UnityAds.isInitialized()) {
                callback?.onShowAdRequestProgress(
                    TAG,
                    "$TAG [Unity showAdInterstitial] >> Run - onShowAdRequestProgress"
                )
                UnityAds.load(adInterstitialUnitId, object : IUnityAdsLoadListener {

                    override fun onUnityAdsFailedToLoad(
                        placementId: String,
                        error: UnityAds.UnityAdsLoadError,
                        message: String
                    ) {
                        showLogError("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsFailedToLoad [placementId] : $placementId")
                        showLogError("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsFailedToLoad [error] : $error")
                        showLogError("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsFailedToLoad [message] : ${UnityAds.isInitialized()}")
                        callback?.onHideAdRequestProgress(
                            TAG,
                            "$TAG [Unity showAdInterstitial] >> Run - onHideAdRequestProgress : onUnityAdsShowFailure"
                        )
                        callback?.onAdFailed(
                            TAG,
                            "$TAG [Unity showAdInterstitial] >> Error - UnityAds Error Initilized [status] : ${UnityAds.isInitialized()}"
                        )
                    }

                    override fun onUnityAdsAdLoaded(placementId: String) {
                        callback?.onAdLoaded(TAG, "$TAG : onUnityAdsAdLoaded $placementId")
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
                                    showLogError("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsShowFailure [placementId] : $placementId")
                                    showLogError("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsShowFailure [error] : $error")
                                    showLogError("$TAG [Unity showAdInterstitial] >> Error - onUnityAdsShowFailure [message] : $message")
                                    callback?.onHideAdRequestProgress(
                                        TAG,
                                        "$TAG [Unity showAdInterstitial] >> Run - onHideAdRequestProgress : onUnityAdsShowFailure"
                                    )
                                    callback?.onAdFailed(
                                        TAG,
                                        "$TAG [Unity showAdInterstitial] >> Error - onUnityAdsShowFailure [message] : $message"
                                    )
                                }

                                override fun onUnityAdsShowStart(placementId: String) {
                                    showLogDebug("$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowStart [placementId] : $placementId")
                                    callback?.onHideAdRequestProgress(
                                        TAG,
                                        "$TAG [Unity showAdInterstitial] >> Run - onHideAdRequestProgress : onUnityAdsShowStart"
                                    )
                                    callback?.onAdShowed(
                                        TAG,
                                        "$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowStart [placementId] : $placementId"
                                    )
                                }

                                override fun onUnityAdsShowClick(placementId: String) {
                                    showLogDebug("$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowClick [placementId] : $placementId")
                                    callback?.onClicked(
                                        TAG,
                                        "$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowClick [placementId] : $placementId"
                                    )
                                }

                                override fun onUnityAdsShowComplete(
                                    placementId: String,
                                    state: UnityAds.UnityAdsShowCompletionState
                                ) {
                                    showLogDebug("$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowComplete [placementId] : $placementId")
                                    showLogDebug("$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowComplete [state] : $state")
                                    callback?.onAdDismissed(
                                        TAG,
                                        "$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowComplete [state] : $state, [placement] : $placementId"
                                    )
                                }
                            })
                    }
                })
            } else {
                showLogError("$TAG [Unity showAdInterstitial] >> Error - UnityAds Error Initilized [status] : ${UnityAds.isInitialized()}")
                callback?.onAdFailed(
                    TAG,
                    "$TAG [Unity showAdInterstitial] >> Error - UnityAds Error Initilized [status] : ${UnityAds.isInitialized()}"
                )
            }
        } else {
            showLogError("$TAG Unity Ad Interstitial id is Empty")
            callback?.onAdFailed(TAG, "$TAG Unity Ad Interstitial id is Empty")
        }
    }

    override fun showAdInterstitial(activity: Activity, adInterstitialUnitId: String) {
        showAdInterstitial(activity, adInterstitialUnitId, null)
    }

}