package com.frogobox.admob.core

import androidx.appcompat.app.AppCompatActivity


/*
 * Created by faisalamir on 10/03/22
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

interface IAdInterstitial {

    fun showInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String
    )

    fun showInterstitial(
        activity: AppCompatActivity,
        interstitialAdUnitId: String,
        callback: IFrogoInterstitialCallback
    )

}