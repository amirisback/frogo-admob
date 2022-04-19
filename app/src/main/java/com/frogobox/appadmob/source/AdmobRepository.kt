package com.frogobox.appadmob.source

import android.content.Context
import com.frogobox.coresdk.response.FrogoDataResponse
import com.frogobox.sdk.source.FrogoRepository
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

class AdmobRepository(
    private val remoteDataSource: AdmobRemoteDataSource,
    private val localDataSource: AdmobLocalDataSource
) : FrogoRepository(remoteDataSource, localDataSource), AdmobDataSource {

    override fun getInterstitial(context: Context, callback: FrogoDataResponse<InterstitialAd>) {
        if (localDataSource.getPrefString("PREF_INTERSTITIAL_AD") == "") {
            remoteDataSource.getInterstitial(context, object : FrogoDataResponse<InterstitialAd> {
                override fun onFailed(statusCode: Int, errorMessage: String) {
                    callback.onFailed(statusCode, errorMessage)
                }

                override fun onFinish() {
                    callback.onFinish()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onSuccess(data: InterstitialAd) {
                    saveInterstitial(data)
                    callback.onSuccess(data)
                }

            })
        } else {
            localDataSource.getInterstitial(context, callback)
        }
    }

    override fun saveInterstitial(interstitialAd: InterstitialAd) {
        localDataSource.saveInterstitial(interstitialAd)
    }
}