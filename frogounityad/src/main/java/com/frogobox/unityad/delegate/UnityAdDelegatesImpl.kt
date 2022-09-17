package com.frogobox.unityad.delegate

import androidx.appcompat.app.AppCompatActivity
import com.frogobox.sdk.ext.showLogD
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.unityad.callback.FrogoUnityAdInitializationCallback
import com.frogobox.unityad.callback.FrogoUnityAdInterstitialCallback
import com.frogobox.unityad.core.FrogoUnityAd

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


class UnityAdDelegatesImpl : UnityAdDelegates {

    companion object {
        val TAG: String = UnityAdDelegatesImpl::class.java.simpleName
    }

    private lateinit var unityAdDelegatesActivity: AppCompatActivity

    override fun setupUnityAdDelegates(activity: AppCompatActivity) {
        showLogD<UnityAdDelegatesImpl>("activity: $activity")
        unityAdDelegatesActivity = activity
    }

    // ---------------------------------------------------------------------------------------------

    override fun setupUnityAdApp(testMode: Boolean, unityGameId: String) {
        FrogoUnityAd.setupUnityAdApp(unityAdDelegatesActivity, testMode, unityGameId)
    }

    override fun setupUnityAdApp(
        testMode: Boolean,
        unityGameId: String,
        callback: FrogoUnityAdInitializationCallback
    ) {
        FrogoUnityAd.setupUnityAdApp(unityAdDelegatesActivity, testMode, unityGameId, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showUnityAdInterstitial(adInterstitialUnitId: String) {
        showLogDebug("$TAG : Run From $TAG class : FrogoUnityAd.showAdInterstitial")
        FrogoUnityAd.showAdInterstitial(unityAdDelegatesActivity, adInterstitialUnitId)
    }

    override fun showUnityAdInterstitial(
        adInterstitialUnitId: String,
        callback: FrogoUnityAdInterstitialCallback
    ) {
        showLogDebug("$TAG : Run From $TAG class : FrogoUnityAd.showAdInterstitial")
        FrogoUnityAd.showAdInterstitial(unityAdDelegatesActivity, adInterstitialUnitId, callback)
    }

}