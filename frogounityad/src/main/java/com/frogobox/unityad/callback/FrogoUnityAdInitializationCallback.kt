package com.frogobox.unityad.callback


/**
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

interface FrogoUnityAdInitializationCallback {

    fun onInitializationComplete(tag: String, message: String)

    fun onInitializationFailed(tag: String, message: String)

}