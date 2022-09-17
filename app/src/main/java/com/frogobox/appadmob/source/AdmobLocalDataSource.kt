package com.frogobox.appadmob.source

import android.content.Context
import com.frogobox.coresdk.response.FrogoDataResponse
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.sdk.preference.FrogoPreference
import com.frogobox.sdk.source.FrogoLocalDataSource
import com.frogobox.sdk.util.AppExecutors
import com.google.android.gms.ads.interstitial.InterstitialAd
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

class AdmobLocalDataSource(
    private val appExecutors: AppExecutors,
    private val preferences: FrogoPreference
) : FrogoLocalDataSource(appExecutors, preferences), AdmobDataSource {

    override fun getInterstitial(context: Context, callback: FrogoDataResponse<InterstitialAd>) {
        getPrefString("PREF_INTERSTITIAL_AD", object : FrogoDataResponse<String> {
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
                callback.onFinish()
            }

            override fun onSuccess(data: String) {
                showLogDebug(data)
                callback.onSuccess(Gson().fromJson(data, InterstitialAd::class.java))
            }
        })
    }

    override fun saveInterstitial(interstitialAd: InterstitialAd) {
        showLogDebug(Gson().toJson(interstitialAd))
        savePrefString("PREF_INTERSTITIAL_AD", Gson().toJson(interstitialAd))
    }
}