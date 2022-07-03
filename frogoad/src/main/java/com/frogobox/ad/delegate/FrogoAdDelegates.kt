package com.frogobox.ad.delegate

import androidx.appcompat.app.AppCompatActivity
import com.frogobox.ad.callback.FrogoAdInterstitialCallback

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


interface FrogoAdDelegates {

    fun setupFrogoAdDelegates(activity: AppCompatActivity)

    fun showAdmobXUnityAdInterstitial(
        admobInterstitialId: String,
        unityInterstitialId: String,
        callback: FrogoAdInterstitialCallback
    )

    fun showUnityXAdmobAdInterstitial(
        admobInterstitialId: String,
        unityInterstitialId: String,
        callback: FrogoAdInterstitialCallback
    )


}