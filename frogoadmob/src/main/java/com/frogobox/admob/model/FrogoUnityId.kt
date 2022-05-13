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

@Deprecated("Please re-import to latest package and use the new one")
data class FrogoUnityId(

    @SerializedName("unityGameID")
    var unityGameID: String = "",

    @SerializedName("unityInterstitialID")
    var unityInterstitialID: List<String> = listOf("", "", ""),

    @SerializedName("unityBannerId")
    var unityBannerId: List<String> = listOf("", "", ""),

    @SerializedName("unityRewardedID")
    var unityRewardedID: List<String> = listOf("", "", "")

)
