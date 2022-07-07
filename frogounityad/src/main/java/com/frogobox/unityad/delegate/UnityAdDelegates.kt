package com.frogobox.unityad.delegate

import androidx.appcompat.app.AppCompatActivity
import com.frogobox.unityad.callback.FrogoUnityAdInitializationCallback
import com.frogobox.unityad.callback.FrogoUnityAdInterstitialCallback

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


interface UnityAdDelegates {

    fun setupUnityAdDelegates(activity: AppCompatActivity)

    fun setupUnityAdApp(
        testMode: Boolean,
        unityGameId: String
    )

    fun setupUnityAdApp(
        testMode: Boolean,
        unityGameId: String,
        callback: FrogoUnityAdInitializationCallback
    )

    fun showUnityAdInterstitial(
        adInterstitialUnitId: String
    )

    fun showUnityAdInterstitial(
        adInterstitialUnitId: String,
        callback: FrogoUnityAdInterstitialCallback
    )

}