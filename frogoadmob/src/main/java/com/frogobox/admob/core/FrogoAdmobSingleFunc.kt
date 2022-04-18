package com.frogobox.admob.core

import com.frogobox.admob.ext.ADMOB_MOBILE_ADS_KEY
import com.frogobox.admob.ext.GITHUB_ACCOUNT
import com.frogobox.admob.ext.LINE
import com.frogobox.log.FLog
import com.frogobox.sdk.ext.showLogDebug


/*
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

object FrogoAdmobSingleFunc {

    val TAG = FrogoAdmobSingleFunc::class.java.simpleName

    fun waterMark() {
        FLog.i("You are using Frogo Admob, Created by Muhammmad Faisal Amir")
        FLog.i(LINE)
        FLog.i("Please follow $GITHUB_ACCOUNT")
        FLog.i(LINE)
        FLog.i("Don't Forget Give Star $GITHUB_ACCOUNT/frogo-admob")
        FLog.i(LINE)
    }

    fun getInitializedState(name: String, code: Int) {
        showLogDebug(LINE)
        showLogDebug("${FrogoAdmob.TAG} >> Setup MobileAds [Key] : $ADMOB_MOBILE_ADS_KEY")
        showLogDebug("${FrogoAdmob.TAG} >> Setup MobileAds [Initialization State Name] : $name")
        showLogDebug("${FrogoAdmob.TAG} >> Setup MobileAds [Initialization State Code] : $code")
        showLogDebug(LINE)
    }

}