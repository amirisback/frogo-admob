package com.frogobox.admob.model

import com.google.gson.annotations.SerializedName

/*
 * Created by faisalamir on 02/03/22
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

data class FrogoAdmobId(

    @SerializedName("testAdmobAppId")
    var testAdmobAppId: String = "ca-app-pub-3940256099942544~3347511713",

    @SerializedName("testAdmobBanner")
    var testAdmobBanner: String = "ca-app-pub-3940256099942544/6300978111",

    @SerializedName("testAdmobInterstitial")
    var testAdmobInterstitial: String = "ca-app-pub-3940256099942544/1033173712",

    @SerializedName("appId")
    var appId: String,

    @SerializedName("bannerID")
    var bannerID: List<String>,

    @SerializedName("interstitialID")
    var interstitialID: List<String>

)