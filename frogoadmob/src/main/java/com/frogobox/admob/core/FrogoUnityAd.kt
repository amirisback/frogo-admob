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
        UnityAds.initialize(
            context,
            unityGameId,
            testMode,
            object : IUnityAdsInitializationListener {
                override fun onInitializationComplete() {
                    FLog.d("$TAG : onInitializationComplete")
                }

                override fun onInitializationFailed(
                    error: UnityAds.UnityAdsInitializationError?,
                    message: String?
                ) {
                    FLog.d("$TAG: onInitializationFailed with error message : $message")
                }

            })
    }

    fun setupUnityAdApp(
        context: Context,
        testMode: Boolean,
        unityGameId: String,
        callback: IFrogoUnityAdInitialization
    ) {
        UnityAds.initialize(
            context,
            unityGameId,
            testMode,
            object : IUnityAdsInitializationListener {
                override fun onInitializationComplete() {
                    FLog.d("$TAG : onInitializationComplete")
                    callback.onInitializationComplete(TAG, "$TAG : onInitializationComplete")
                }

                override fun onInitializationFailed(
                    error: UnityAds.UnityAdsInitializationError?,
                    message: String?
                ) {
                    FLog.d("$TAG: onInitializationFailed with error message : $message")
                    callback.onInitializationFailed(
                        TAG,
                        "$TAG: onInitializationFailed with error message : $message"
                    )
                }

            })
    }

    fun showAdInterstitial(
        activity: Activity,
        adInterstitialUnitId: String
    ) {
        if (!UnityAds.isInitialized()) {
        } else {
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
                                FLog.e("$TAG : Unity Ads failed to show ad for $placementId with error: [$error] $message")
                            }

                            override fun onUnityAdsShowStart(placementId: String) {
                                FLog.v("$TAG : onUnityAdsShowStart: $placementId")
                            }

                            override fun onUnityAdsShowClick(placementId: String) {
                                FLog.v("$TAG : onUnityAdsShowClick: $placementId")
                            }

                            override fun onUnityAdsShowComplete(
                                placementId: String,
                                state: UnityAds.UnityAdsShowCompletionState
                            ) {
                                FLog.v("$TAG : onUnityAdsShowComplete: $placementId")
                            }
                        })
                }

                override fun onUnityAdsFailedToLoad(
                    placementId: String,
                    error: UnityAds.UnityAdsLoadError,
                    message: String
                ) {
                    FLog.e("$TAG : Unity Ads failed to load ad for $placementId with error: [$error] $message")
                }
            }) // interstitial
        }

    }

    fun showAdInterstitial(
        activity: Activity,
        adInterstitialUnitId: String,
        callback: IFrogoUnityAdInterstitial
    ) {
        if (!UnityAds.isInitialized()) {
            callback.onAdFailed(TAG, "$TAG : Unity Ads Not Initialized")
        } else {
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
                                FLog.e("$TAG : Unity Ads failed to show ad for $placementId with error: [$error] $message")
                                callback.onAdFailed(
                                    TAG,
                                    "$TAG : Unity Ads failed to load ad for $placementId with error: [$error] $message"
                                )
                            }

                            override fun onUnityAdsShowStart(placementId: String) {
                                FLog.v("$TAG : onUnityAdsShowStart: $placementId")
                                callback.onAdShowed(TAG, "$TAG : onUnityAdsShowStart: $placementId")
                            }

                            override fun onUnityAdsShowClick(placementId: String) {
                                FLog.v("$TAG : onUnityAdsShowClick: $placementId")
                                callback.onClicked(TAG, "$TAG : onUnityAdsShowClick: $placementId")
                            }

                            override fun onUnityAdsShowComplete(
                                placementId: String,
                                state: UnityAds.UnityAdsShowCompletionState
                            ) {
                                FLog.v("$TAG : onUnityAdsShowComplete: $placementId")
                                callback.onAdDismissed(
                                    TAG,
                                    "$TAG : onUnityAdsShowComplete: $placementId"
                                )
                            }
                        })
                }

                override fun onUnityAdsFailedToLoad(
                    placementId: String,
                    error: UnityAds.UnityAdsLoadError,
                    message: String
                ) {
                    FLog.e("$TAG : Unity Ads failed to load ad for $placementId with error: [$error] $message")
                    callback.onAdFailed(
                        TAG,
                        "$TAG : Unity Ads failed to load ad for $placementId with error: [$error] $message"
                    )
                }
            }) // interstitial
        }

    }

}