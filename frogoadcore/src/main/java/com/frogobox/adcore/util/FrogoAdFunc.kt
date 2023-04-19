package com.frogobox.adcore.util

import com.frogobox.adcore.util.FrogoAdConstant.ADMOB_MOBILE_ADS_KEY
import com.frogobox.adcore.util.FrogoAdConstant.LINE
import com.frogobox.sdk.ext.showLogDebug


/**
 * Created by faisalamir on 23/03/22
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


object FrogoAdFunc {

    val TAG: String = FrogoAdFunc::class.java.simpleName

    fun getInitializedState(name: String, code: Int) {
        showLogDebug(LINE)
        showLogDebug("$TAG >> Setup MobileAds [Key] : $ADMOB_MOBILE_ADS_KEY")
        showLogDebug("$TAG >> Setup MobileAds [Initialization State Name] : $name")
        showLogDebug("$TAG >> Setup MobileAds [Initialization State Code] : $code")
        showLogDebug(LINE)
    }

}