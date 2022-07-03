package com.frogobox.admob.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.delegate.AdmobDelegates
import com.frogobox.admob.delegate.AdmobDelegatesImpl
import com.frogobox.admob.deprecated.FrogoUnityAd
import com.frogobox.admob.deprecated.IFrogoAdInterstitial
import com.frogobox.admob.deprecated.IFrogoUnityAdInitialization
import com.frogobox.admob.deprecated.IFrogoUnityAdInterstitial
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.sdk.view.FrogoActivity
import com.google.android.gms.ads.AdView

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


abstract class FrogoAdmobActivity : FrogoActivity(), IFrogoAdmobActivity,
    AdmobDelegates by AdmobDelegatesImpl() {

    companion object {
        val TAG: String = FrogoAdmobActivity::class.java.simpleName
    }

    protected val arrayFrogoAdmobData = mutableListOf<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.setupAdmobApp")
            setupAdmobDelegates(this)
            setupAdmobApp()
        }
    }


    // ---------------------------------------------------------------------------------------------

    override fun setupUnityAdApp(testMode: Boolean, unityGameId: String) {
        FrogoUnityAd.setupUnityAdApp(this, testMode, unityGameId)
    }

    override fun setupUnityAdApp(
        testMode: Boolean,
        unityGameId: String,
        callback: IFrogoUnityAdInitialization
    ) {
        FrogoUnityAd.setupUnityAdApp(this, testMode, unityGameId, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showUnityAdInterstitial(adInterstitialUnitId: String) {
        FrogoUnityAd.showAdInterstitial(this, adInterstitialUnitId)
    }

    override fun showUnityAdInterstitial(
        adInterstitialUnitId: String,
        callback: IFrogoUnityAdInterstitial
    ) {
        FrogoUnityAd.showAdInterstitial(this, adInterstitialUnitId, callback)
    }

    // ---------------------------------------------------------------------------------------------

    // Mixed Ads Admob >> Unity
    override fun showAdmobXUnityAdInterstitial(
        admobInterstitialId: String,
        unityInterstitialId: String,
        callback: IFrogoMixedAdsInterstitial
    ) {
        showAdInterstitial(admobInterstitialId, object : IFrogoAdInterstitial {
            override fun onShowAdRequestProgress(tag: String, message: String) {
                callback.onShowAdRequestProgress(tag, message)
            }

            override fun onHideAdRequestProgress(tag: String, message: String) {
                callback.onHideAdRequestProgress(tag, message)
            }

            override fun onAdDismissed(tag: String, message: String) {
                callback.onAdDismissed(tag, message)
            }

            override fun onAdFailed(tag: String, errorMessage: String) {
                showUnityAdInterstitial(unityInterstitialId,
                    object : IFrogoUnityAdInterstitial {
                        override fun onClicked(tag: String, message: String) {
                            callback.onClicked(tag, message)
                        }

                        override fun onShowAdRequestProgress(tag: String, message: String) {
                            callback.onShowAdRequestProgress(tag, message)
                        }

                        override fun onHideAdRequestProgress(tag: String, message: String) {
                            callback.onHideAdRequestProgress(tag, message)
                        }

                        override fun onAdDismissed(tag: String, message: String) {
                            callback.onAdDismissed(tag, message)
                        }

                        override fun onAdFailed(tag: String, errorMessage: String) {
                            callback.onAdFailed(tag, errorMessage)
                        }

                        override fun onAdLoaded(tag: String, message: String) {
                            callback.onAdLoaded(tag, message)
                        }

                        override fun onAdShowed(tag: String, message: String) {
                            callback.onAdShowed(tag, message)
                        }
                    })
            }

            override fun onAdLoaded(tag: String, message: String) {
                callback.onAdLoaded(tag, message)
            }

            override fun onAdShowed(tag: String, message: String) {
                callback.onAdShowed(tag, message)
            }
        })
    }

    // Mixed Ads Unity >> Admob
    override fun showUnityXAdmobAdInterstitial(
        admobInterstitialId: String,
        unityInterstitialId: String,
        callback: IFrogoMixedAdsInterstitial
    ) {
        showUnityAdInterstitial(unityInterstitialId, object : IFrogoUnityAdInterstitial {
            override fun onAdDismissed(tag: String, message: String) {
                callback.onAdDismissed(tag, message)
            }

            override fun onAdFailed(tag: String, errorMessage: String) {
                showAdInterstitial(admobInterstitialId,
                    object : IFrogoAdInterstitial {
                        override fun onShowAdRequestProgress(tag: String, message: String) {
                            callback.onShowAdRequestProgress(tag, message)
                        }

                        override fun onHideAdRequestProgress(tag: String, message: String) {
                            callback.onHideAdRequestProgress(tag, message)
                        }

                        override fun onAdDismissed(tag: String, message: String) {
                            callback.onAdDismissed(tag, message)
                        }

                        override fun onAdFailed(tag: String, errorMessage: String) {
                            callback.onAdFailed(tag, errorMessage)
                        }

                        override fun onAdLoaded(tag: String, message: String) {
                            callback.onAdLoaded(tag, message)
                        }

                        override fun onAdShowed(tag: String, message: String) {
                            callback.onAdShowed(tag, message)
                        }
                    })
            }

            override fun onAdLoaded(tag: String, message: String) {
                callback.onAdLoaded(tag, message)
            }

            override fun onAdShowed(tag: String, message: String) {
                callback.onAdShowed(tag, message)
            }

            override fun onClicked(tag: String, message: String) {
                callback.onClicked(tag, message)
            }

            override fun onShowAdRequestProgress(tag: String, message: String) {
                callback.onShowAdRequestProgress(tag, message)
            }

            override fun onHideAdRequestProgress(tag: String, message: String) {
                callback.onHideAdRequestProgress(tag, message)
            }
        })
    }

    // ---------------------------------------------------------------------------------------------

    override fun onResume() {
        super.onResume()
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.resume()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.pause()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.destroy()
            }
        }

    }

}