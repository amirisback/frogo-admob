package com.frogobox.unityad.core

import android.app.Activity
import android.content.Context
import com.frogobox.unityad.callback.FrogoUnityAdInitializationCallback
import com.frogobox.unityad.callback.FrogoUnityAdInterstitialCallback
import com.unity3d.ads.*


/**
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
        callback: FrogoUnityAdInitializationCallback?
    ) {

        if (unityGameId != "") {
            if (!UnityAds.isInitialized) {
                UnityAds.initialize(
                    context,
                    unityGameId,
                    testMode,
                    object : IUnityAdsInitializationListener {

                        override fun onInitializationComplete() {
                            callback?.onInitializationComplete(TAG, "$TAG : onInitializationComplete")
                        }

                        override fun onInitializationFailed(
                            error: UnityAds.UnityAdsInitializationError?,
                            message: String?
                        ) {
                            callback?.onInitializationFailed(TAG, "$TAG: onInitializationFailed with error message : $message")
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
        callback: FrogoUnityAdInterstitialCallback?
    ) {

        if (adInterstitialUnitId != "") {
            if (UnityAds.isInitialized) {
                callback?.onShowAdRequestProgress(TAG, "$TAG [Unity showAdInterstitial] >> Run - onShowAdRequestProgress")
                UnityAds.load(adInterstitialUnitId, object : IUnityAdsLoadListener {

                    override fun onUnityAdsFailedToLoad(
                        placementId: String,
                        error: UnityAds.UnityAdsLoadError,
                        message: String
                    ) {
                        callback?.onHideAdRequestProgress(TAG, "$TAG [Unity showAdInterstitial] >> Run - onHideAdRequestProgress : onUnityAdsShowFailure")
                        callback?.onAdFailed(TAG, "$TAG [Unity showAdInterstitial] >> Error - UnityAds Error Initilized [status] : ${UnityAds.isInitialized}")
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
                                    callback?.onHideAdRequestProgress(TAG, "$TAG [Unity showAdInterstitial] >> Run - onHideAdRequestProgress : onUnityAdsShowFailure")
                                    callback?.onAdFailed(TAG, "$TAG [Unity showAdInterstitial] >> Error - onUnityAdsShowFailure [message] : $message")
                                }

                                override fun onUnityAdsShowStart(placementId: String) {
                                    callback?.onHideAdRequestProgress(TAG, "$TAG [Unity showAdInterstitial] >> Run - onHideAdRequestProgress : onUnityAdsShowStart")
                                    callback?.onAdShowed(TAG, "$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowStart [placementId] : $placementId")
                                }

                                override fun onUnityAdsShowClick(placementId: String) {
                                    callback?.onClicked(TAG, "$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowClick [placementId] : $placementId")
                                }

                                override fun onUnityAdsShowComplete(
                                    placementId: String,
                                    state: UnityAds.UnityAdsShowCompletionState
                                ) {
                                    callback?.onAdDismissed(TAG, "$TAG [Unity showAdInterstitial] >> Succes - onUnityAdsShowComplete [state] : $state, [placement] : $placementId")
                                }
                            })
                    }
                })
            } else {
                callback?.onAdFailed(TAG, "$TAG [Unity showAdInterstitial] >> Error - UnityAds Error Initilized [status] : ${UnityAds.isInitialized}")
            }
        } else {
            callback?.onAdFailed(TAG, "$TAG Unity Ad Interstitial id is Empty")
        }
    }

    override fun showAdInterstitial(activity: Activity, adInterstitialUnitId: String) {
        showAdInterstitial(activity, adInterstitialUnitId, null)
    }

}