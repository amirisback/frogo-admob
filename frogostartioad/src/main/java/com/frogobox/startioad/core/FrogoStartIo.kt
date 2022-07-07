package com.frogobox.startioad.core

import android.content.Context
import com.startapp.sdk.adsbase.SDKAdPreferences
import com.startapp.sdk.adsbase.StartAppSDK


/*
 * Created by faisalamir on 13/05/22
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

class FrogoStartIo : IFrogoStartIo {

    fun setupStartIo(context: Context, startIoAppId: String, sdkAdPreferences: SDKAdPreferences) {
        StartAppSDK.init(context, startIoAppId, sdkAdPreferences)
    }

}