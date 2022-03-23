package com.frogobox.admob.core

import com.frogobox.frogolog.FLog


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
        FLog.w("------------------------------------------------------------------------------------------------")
        FLog.w("You are using Frogo Admob, Created by Muhammmad Faisal Amir, Please follow github.com/amirisback")
        FLog.w("------------------------------------------------------------------------------------------------")
    }

}