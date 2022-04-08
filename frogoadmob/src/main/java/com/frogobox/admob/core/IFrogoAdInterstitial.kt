package com.frogobox.admob.core


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

    fun onShowAdRequestProgress(tag: String, message: String)

    fun onHideAdRequestProgress(tag: String, message: String)

    fun onAdDismissed(tag: String, message: String)

    fun onAdFailed(tag: String, errorMessage: String)

    fun onAdLoaded(tag: String, message: String)

    fun onAdShowed(tag: String, message: String)

}