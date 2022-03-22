package com.frogobox.admob.source

import com.frogobox.admob.model.FrogoAdmobId
import com.frogobox.admob.model.FrogoMonetizeId
import com.frogobox.admob.model.FrogoUnityId
import okhttp3.Interceptor


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

    // Switch For Using OkHttpClient Interceptor
    fun usingClient(chuckInterceptor: Interceptor)

    // Callback Get FrogoAdmobId
    fun getFrogoAdmobId(jsonFileName: String, callback: FrogoAdmobApiResponse<FrogoAdmobId>)

    // Callback Get FrogoMonetizeId
    fun getFrogoMonetizeId(jsonFileName: String, callback: FrogoAdmobApiResponse<FrogoMonetizeId>)

    // Callback Get FrogoUnityId
    fun getFrogoUnityId(jsonFileName: String, callback: FrogoAdmobApiResponse<FrogoUnityId>)

}