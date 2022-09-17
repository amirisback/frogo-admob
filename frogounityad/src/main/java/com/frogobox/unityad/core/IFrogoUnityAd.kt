package com.frogobox.unityad.core

import android.app.Activity
import android.content.Context
import com.frogobox.unityad.callback.FrogoUnityAdInitializationCallback
import com.frogobox.unityad.callback.FrogoUnityAdInterstitialCallback

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


interface IFrogoUnityAd {

    fun setupUnityAdApp(context: Context, testMode: Boolean, unityGameId: String)

    fun setupUnityAdApp(
        context: Context,
        testMode: Boolean,
        unityGameId: String,
        callback: FrogoUnityAdInitializationCallback?
    )

    // ---------------------------------------------------------------------------------------------

    fun showAdInterstitial(activity: Activity, adInterstitialUnitId: String)

    fun showAdInterstitial(
        activity: Activity,
        adInterstitialUnitId: String,
        callback: FrogoUnityAdInterstitialCallback?
    )

}