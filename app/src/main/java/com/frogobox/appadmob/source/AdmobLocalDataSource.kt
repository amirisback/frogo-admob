package com.frogobox.appadmob.source

import android.content.Context
import com.frogobox.coresdk.response.FrogoDataResponse
import com.frogobox.sdk.delegate.preference.PreferenceDelegatesImpl
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.sdk.ext.toModel
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
    private val preferences: PreferenceDelegatesImpl
) : FrogoLocalDataSource(appExecutors, preferences), AdmobDataSource {

    override fun getInterstitial(context: Context, callback: FrogoDataResponse<InterstitialAd>) {
        callback.onShowProgress()
        val data = getPrefString("PREF_INTERSTITIAL_AD")
        callback.onSuccess(Gson().fromJson(data, InterstitialAd::class.java))
        callback.onHideProgress()
    }

    override fun saveInterstitial(interstitialAd: InterstitialAd) {
        showLogDebug(Gson().toJson(interstitialAd))
        savePrefString("PREF_INTERSTITIAL_AD", Gson().toJson(interstitialAd))
    }
}