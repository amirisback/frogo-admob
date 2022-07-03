package com.frogobox.appadmob.base

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.core.FrogoAdmob
import com.frogobox.adcore.util.FrogoAdFunc
import com.frogobox.admob.deprecated.IFrogoAdInterstitial
import com.frogobox.appadmob.source.AdmobRepository
import com.frogobox.coresdk.response.FrogoDataResponse
import com.frogobox.sdk.view.FrogoViewModel
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.interstitial.InterstitialAd


/*
 * Created by faisalamir on 19/04/22
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

open class BaseViewModel(
    private val context: Application,
    private val repository: AdmobRepository
) : FrogoViewModel(context) {

    fun showInterstitial(activity: AppCompatActivity, callback: IFrogoAdInterstitial?) {
        repository.getInterstitial(context, object : FrogoDataResponse<InterstitialAd> {
            override fun onFinish() {}

            override fun onFailed(statusCode: Int, errorMessage: String) {
                callback?.onAdFailed(statusCode.toString(), errorMessage)
            }
            override fun onHideProgress() {
                callback?.onHideAdRequestProgress("", "")
            }

            override fun onShowProgress() {
                callback?.onShowAdRequestProgress("", "")
            }

            override fun onSuccess(data: InterstitialAd) {
                callback?.onAdLoaded("", "")
                data.fullScreenContentCallback =
                    object : FullScreenContentCallback() {
                        override fun onAdDismissedFullScreenContent() {
                            com.frogobox.sdk.ext.showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdDismissed()")
                            com.frogobox.sdk.ext.showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Succes - onAdDismissedFullScreenContent [message] : Ad was dismissed")
                            callback?.onAdDismissed(FrogoAdmob.TAG, "Interstitial Ad was dismissed")
                        }

                        override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                            FrogoAdFunc.getInitializedState(
                                FrogoAdmob.initializationName,
                                FrogoAdmob.initializationCode
                            )
                            com.frogobox.sdk.ext.showLogError("${FrogoAdmob.TAG} [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdFailedToShow()")
//                            com.frogobox.sdk.ext.showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToShowFullScreenContent [unit id] : $")
                            com.frogobox.sdk.ext.showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToShowFullScreenContent [code] : ${adError.code}")
                            com.frogobox.sdk.ext.showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToShowFullScreenContent [domain] : ${adError.domain}")
                            com.frogobox.sdk.ext.showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToShowFullScreenContent [message] : ${adError.message}")
                            com.frogobox.sdk.ext.showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error : Ad failed to show")
                            callback?.onHideAdRequestProgress(
                                FrogoAdmob.TAG,
                                "${FrogoAdmob.TAG} [Interstitial] >> Error - onHideAdRequestProgress [message] : onAdFailedToShowFullScreenContent"
                            )
                            callback?.onAdFailed(FrogoAdmob.TAG, "Interstitial Ad failed to show")
                        }

                        override fun onAdShowedFullScreenContent() {
                            com.frogobox.sdk.ext.showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdShowed()")
                            com.frogobox.sdk.ext.showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Succes - onAdShowedFullScreenContent [message] : Ad showed fullscreen content")
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
                data.show(activity)
            }
        })
    }
}