package com.frogobox.appadmob.source


/**
 * Created by faisalamir on 19/04/22
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

interface AdmobCallback {

    fun onShowAdRequestProgress()

    fun onHideAdRequestProgress()

    fun onAdDismissed()

    fun onAdFailed(tag: String, errorMessage: String)

    fun onAdLoaded()

    fun onAdShowed()

}