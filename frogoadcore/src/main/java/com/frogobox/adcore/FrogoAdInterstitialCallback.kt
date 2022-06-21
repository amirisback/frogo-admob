package com.frogobox.adcore

// Created by KoinWorks (M. Faisal Amir) on 20/06/22.


interface FrogoAdInterstitialCallback {

    fun onShowAdRequestProgress(tag: String, message: String)

    fun onHideAdRequestProgress(tag: String, message: String)

    fun onAdDismissed(tag: String, message: String)

    fun onAdFailed(tag: String, errorMessage: String)

    fun onAdLoaded(tag: String, message: String)

    fun onAdShowed(tag: String, message: String)

}