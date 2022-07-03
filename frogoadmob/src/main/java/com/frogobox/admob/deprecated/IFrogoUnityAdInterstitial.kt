package com.frogobox.admob.deprecated


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

@Deprecated(
    "Please re-import to latest package and use the new one",
    ReplaceWith("FrogoUnityAdInterstitialCallback")
)
interface IFrogoUnityAdInterstitial : IFrogoAdInterstitial {

    fun onClicked(tag: String, message: String)

}