package com.frogobox.admob.model

import com.google.gson.annotations.SerializedName


/*
 * Created by faisalamir on 22/03/22
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

data class FrogoMonetizeId(

    @SerializedName("testAdmobAppId")
    var testAdmobAppId: String = "ca-app-pub-3940256099942544~3347511713",

    @SerializedName("testAdmobBanner")
    var testAdmobBanner: String = "ca-app-pub-3940256099942544/6300978111",

    @SerializedName("testAdmobInterstitial")
    var testAdmobInterstitial: String = "ca-app-pub-3940256099942544/1033173712",

    @SerializedName("testAdmobRewarded")
    var testAdmobRewarded: String = "ca-app-pub-3940256099942544/5224354917",

    @SerializedName("admobAppId")
    var admobAppId: String,

    @SerializedName("admobBannerID")
    var admobBannerID: List<String>,

    @SerializedName("admobInterstitialID")
    var admobInterstitialID: List<String>,

    @SerializedName("admobRewardedID")
    var admobRewardedID: List<String>,

    @SerializedName("unityGameID")
    var unityGameID: String,

    @SerializedName("unityInterstitialID")
    var unityInterstitialID: List<String>,

    @SerializedName("unityBannerId")
    var unityBannerId: List<String>,

    @SerializedName("unityRewardedID")
    var unityRewardedID: List<String>

)