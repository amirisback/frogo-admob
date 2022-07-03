package com.frogobox.unityad.callback

import com.frogobox.adcore.callback.FrogoAdCoreInterstitialCallback


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


interface FrogoUnityAdInterstitialCallback : FrogoAdCoreInterstitialCallback {

    fun onClicked(tag: String, message: String)

}