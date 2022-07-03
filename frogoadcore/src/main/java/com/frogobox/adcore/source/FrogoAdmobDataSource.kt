package com.frogobox.adcore.source

import android.content.Context
import com.frogobox.adcore.model.FrogoAdmobId
import com.frogobox.adcore.model.FrogoMonetizeId
import com.frogobox.adcore.model.FrogoUnityId

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
    fun usingClient(context: Context)

    // Callback Get FrogoAdmobId
    fun getFrogoAdmobId(jsonFileName: String, callback: FrogoAdmobApiResponse<FrogoAdmobId>)

    // Callback Get FrogoMonetizeId
    fun getFrogoMonetizeId(jsonFileName: String, callback: FrogoAdmobApiResponse<FrogoMonetizeId>)

    // Callback Get FrogoUnityId
    fun getFrogoUnityId(jsonFileName: String, callback: FrogoAdmobApiResponse<FrogoUnityId>)

}