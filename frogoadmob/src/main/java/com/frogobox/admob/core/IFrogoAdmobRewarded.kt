package com.frogobox.admob.core

import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.callback.FrogoAdmobRewardedCallback

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 10/02/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.admob
 *
 */


interface IFrogoAdmobRewarded {

    fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: FrogoAdmobRewardedCallback
    )

    fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        callback: FrogoAdmobRewardedCallback
    )

    fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobRewardedCallback
    )

    fun showAdRewarded(
        activity: AppCompatActivity,
        mAdUnitIdRewarded: String,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    )

    // ---------------------------------------------------------------------------------------------

    fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int?,
        keyword: List<String>?,
        callback: FrogoAdmobRewardedCallback
    )

    fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        callback: FrogoAdmobRewardedCallback
    )

    fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        timeoutMilliSecond: Int,
        callback: FrogoAdmobRewardedCallback
    )

    fun showAdRewardedInterstitial(
        activity: AppCompatActivity,
        mAdUnitIdRewardedInterstitial: String,
        keyword: List<String>,
        callback: FrogoAdmobRewardedCallback
    )

}