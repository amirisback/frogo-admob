package com.frogobox.admob.core

import com.google.android.gms.ads.LoadAdError


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

interface IFrogoAdBanner {
    // Code to be executed when an ad finishes loading.
    // The onAdLoaded() method is executed when an ad has finished loading.
    // If you want to delay adding the AdView to your activity or fragment until you're sure an ad will be loaded,
    // for example, you can do so here.
    fun onAdLoaded(message: String)

    // Code to be executed when an ad request fails.
    // The onAdFailedToLoad() method is the only one that includes a parameter.
    // The error parameter of type LoadAdError describes what error occurred.
    // For more information, refer to the Debugging Ad Load Errors documentation.
    fun onAdFailedToLoad(errorCode: String, errorMessage: String)

    // Code to be executed when an ad opens an overlay that
    // covers the screen.
    // This method is invoked when the user taps on an ad.
    fun onAdOpened(message: String)

    // Code to be executed when the user clicks on an ad.
    fun onAdClicked(message: String)

    // Code to be executed when the user is about to return
    // to the app after tapping on an ad.
    // When a user returns to the app after viewing an ad's destination URL, this method is invoked.
    // Your app can use it to resume suspended activities or perform any other work necessary to make itself ready for interaction.
    // Refer to the AdMob AdListener example for an implementation of the ad listener methods in the Android API Demo app.
    fun onAdClosed(message: String)
}