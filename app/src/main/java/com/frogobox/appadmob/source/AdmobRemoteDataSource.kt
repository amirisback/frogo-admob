package com.frogobox.appadmob.source

import android.content.Context
import com.frogobox.adcore.util.FrogoAdFunc
import com.frogobox.admob.core.FrogoAdmob
import com.frogobox.appadmob.R
import com.frogobox.coresdk.response.FrogoDataResponse
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.sdk.ext.showLogError
import com.frogobox.sdk.source.FrogoRemoteDataSource
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.gson.Gson


/**
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

class AdmobRemoteDataSource : FrogoRemoteDataSource(), AdmobDataSource {

    override fun getInterstitial(context: Context, callback: FrogoDataResponse<InterstitialAd>) {
        callback.onShowProgress()
        InterstitialAd.load(
            context,
            context.getString(R.string.admob_interstitial),
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    FrogoAdFunc.getInitializedState(
                        FrogoAdmob.initializationName,
                        FrogoAdmob.initializationCode
                    )
                    showLogError("${FrogoAdmob.TAG} [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdFailedToLoad()")
                    showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToLoad [code] : ${adError.code}")
                    showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToLoad [domain] : ${adError.domain}")
                    showLogError("${FrogoAdmob.TAG} [Interstitial] >> Error - onAdFailedToLoad [message] : ${adError.message}")
                    callback.onHideProgress()
                    callback.onFailed(adError.code, adError.message)
                    callback.onFinish()
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Run - IFrogoAdInterstitial [callback] : onAdLoaded()")
                    showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Succes - onAdLoaded [message] : Ad was loaded")
                    showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Succes - onAdLoaded [unit id] : ${interstitialAd.adUnitId}")
                    showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Succes - onAdLoaded [response Info] : ${interstitialAd.responseInfo}")
                    showLogDebug("${FrogoAdmob.TAG} [Interstitial] >> Suggest : You Can Give Your Reward Here")
                    callback.onHideProgress()
                    showLogDebug(Gson().toJson(interstitialAd))
                    callback.onSuccess(interstitialAd)
                    callback.onFinish()
                }
            }
        )
    }

    override fun saveInterstitial(interstitialAd: InterstitialAd) {
    }
}