package com.frogobox.admob.source


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

interface FrogoAdmobApiResponse<T> {

    fun onSuccess(data: T)

    fun onFailed(statusCode: Int, errorMessage: String? = "")

    fun onShowProgress()

    fun onHideProgress()

}