package com.frogobox.unityad.delegate

import androidx.appcompat.app.AppCompatActivity
import com.frogobox.unityad.callback.FrogoUnityAdInitializationCallback
import com.frogobox.unityad.callback.FrogoUnityAdInterstitialCallback
import com.frogobox.unityad.core.FrogoUnityAd
import com.unity3d.ads.metadata.MetaData

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
        unityAdDelegatesActivity = activity
        val gdprMetaData = MetaData(activity)
        gdprMetaData["gdpr.consent"] = true
        gdprMetaData.commit()

        val ccpaMetaData = MetaData(activity)
        ccpaMetaData["privacy.consent"] = true
        ccpaMetaData.commit()
    }

    // ---------------------------------------------------------------------------------------------


    override fun setupUnityAdApp(
        testMode: Boolean,
        unityGameId: String,
        callback: FrogoUnityAdInitializationCallback?
    ) {

        FrogoUnityAd.setupUnityAdApp(unityAdDelegatesActivity, testMode, unityGameId, callback)
    }

    // ---------------------------------------------------------------------------------------------

    override fun showUnityAdInterstitial(
        adInterstitialUnitId: String,
        callback: FrogoUnityAdInterstitialCallback?
    ) {
        FrogoUnityAd.showAdInterstitial(unityAdDelegatesActivity, adInterstitialUnitId, callback)
    }

}