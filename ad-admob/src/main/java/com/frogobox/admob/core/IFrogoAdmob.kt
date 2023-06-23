package com.frogobox.admob.core

import android.content.Context

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


interface IFrogoAdmob {

    fun setupAdmobApp(context: Context)

    // ---------------------------------------------------------------------------------------------

    fun loadRecyclerBannerAds(
        bannerAdUnitId: String,
        context: Context,
        recyclerViewDataList: MutableList<Any>
    )

    fun addBannerAds(
        bannerAdUnitId: String,
        context: Context,
        recyclerViewDataList: MutableList<Any>
    )

    fun loadBannerAd(recyclerViewDataList: MutableList<Any>, index: Int)

    // ---------------------------------------------------------------------------------------------

}