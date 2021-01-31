package com.frogobox.admobhelper.base

import com.google.gson.Gson

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * SpeechBooster
 * Copyright (C) 14/09/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.speechbooster.base
 *
 */
open class BaseHelper {

    fun <T> baseToJson(model: T) : String? {
        return Gson().toJson(model)
    }

    inline fun <reified T> baseFromJson(word: String?) : T {
        return Gson().fromJson<T>(word, T::class.java)
    }

}