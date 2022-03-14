package com.frogobox.admob.core

import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd


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

interface IFrogoAdInterstitial {

    fun onAdDismissed(message: String)

    fun onAdFailedToLoad(errorMessage: String)

    fun onAdFailedToShow(errorMessage: String)

    fun onAdLoaded(message: String)

    fun onAdShowed(message: String)

    fun onAdNotReady(message: String)

}