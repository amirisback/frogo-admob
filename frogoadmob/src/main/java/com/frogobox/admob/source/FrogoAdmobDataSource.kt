package com.frogobox.admob.source

import com.frogobox.admob.model.FrogoAdmobId


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

interface FrogoAdmobDataSource {

    // Switch For Using OkHttpClient Interceptor
    fun usingClient()

    // Callback Get FrogoAdmobId
    fun getFrogoAdmobId(jsonFileName: String, callback: FrogoAdmobApiResponse<FrogoAdmobId>)

}