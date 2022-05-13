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

@Deprecated("Please re-import to latest package and use the new one")
data class FrogoAdmobId(

    @SerializedName("testAdmobAppId")
    var testAdmobAppId: String = "ca-app-pub-3940256099942544~3347511713",

    @SerializedName("testAdmobBanner")
    var testAdmobBanner: String = "ca-app-pub-3940256099942544/6300978111",

    @SerializedName("testAdmobInterstitial")
    var testAdmobInterstitial: String = "ca-app-pub-3940256099942544/1033173712",

    @SerializedName("testAdmobRewarded")
    var testAdmobRewarded: String = "ca-app-pub-3940256099942544/5224354917",

    @SerializedName("admobAppId")
    var admobAppId: String = "",

    @SerializedName("admobBannerID")
    var admobBannerID: List<String> = listOf("", "", ""),

    @SerializedName("admobInterstitialID")
    var admobInterstitialID: List<String> = listOf("", "", ""),

    @SerializedName("admobRewardedID")
    var admobRewardedID: List<String> = listOf("", "", "")

)