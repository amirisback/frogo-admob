package com.frogobox.unityad

import com.frogobox.adcore.FrogoAdInterstitialCallback


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


interface FrogoUnityAdInterstitialCallback : FrogoAdInterstitialCallback {

    fun onClicked(tag: String, message: String)

}