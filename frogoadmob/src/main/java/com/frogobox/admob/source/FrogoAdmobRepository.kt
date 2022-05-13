package com.frogobox.admob.source

import android.content.Context
import com.frogobox.admob.model.FrogoAdmobId
import com.frogobox.admob.model.FrogoMonetizeId
import com.frogobox.admob.model.FrogoUnityId
import com.frogobox.coresdk.source.FrogoApiClient
import com.frogobox.sdk.ext.doApiRequest
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.sdk.ext.usingChuck


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

@Deprecated("Please re-import to latest package and use the new one")
class FrogoAdmobRepository(
    private val isDebug: Boolean,
    private val baseUrl: String
) : FrogoAdmobDataSource {

    companion object {
        val TAG = FrogoAdmobRepository::class.java.simpleName
    }

    private var frogoAdmobApiService = FrogoApiClient.create<FrogoAdmobApiService>(baseUrl, isDebug)

    override fun usingClient(context: Context) {
        showLogDebug("$TAG : Using Client OkHttp Client + Chuck Interceptor")
        frogoAdmobApiService = FrogoApiClient.create(baseUrl, isDebug, context.usingChuck())
    }

    override fun getFrogoAdmobId(
        jsonFileName: String,
        callback: FrogoAdmobApiResponse<FrogoAdmobId>
    ) {
        showLogDebug("$TAG : Get Data From Json Server FrogoAdmobId")
        frogoAdmobApiService.getFrogoAdmobId(jsonFileName).doApiRequest(callback) {}
    }

    override fun getFrogoMonetizeId(
        jsonFileName: String,
        callback: FrogoAdmobApiResponse<FrogoMonetizeId>
    ) {
        showLogDebug("$TAG : Get Data From Json Server FrogoMonetizeId")
        frogoAdmobApiService.getMonetizeId(jsonFileName).doApiRequest(callback) {}
    }

    override fun getFrogoUnityId(
        jsonFileName: String,
        callback: FrogoAdmobApiResponse<FrogoUnityId>
    ) {
        showLogDebug("$TAG : Get Data From Json Server FrogoUnityId")
        frogoAdmobApiService.getUnityId(jsonFileName).doApiRequest(callback) {}
    }
}