package com.frogobox.admob.source

import com.frogobox.admob.model.FrogoAdmobId
import com.frogobox.admob.model.FrogoMonetizeId
import com.frogobox.admob.model.FrogoUnityId
import com.frogobox.coresdk.FrogoApiClient
import com.frogobox.coresdk.ext.doApiRequest
import com.frogobox.log.FLog
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
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

class FrogoAdmobRepository(private val baseUrl: String) : FrogoAdmobDataSource {

    companion object {
        val TAG = FrogoAdmobRepository::class.java.simpleName
    }

    private var frogoAdmobApiService = FrogoApiClient.create<FrogoAdmobApiService>(baseUrl)

    override fun usingClient() {
        FLog.d("$TAG : Using Client OkHttp Client")
        frogoAdmobApiService = FrogoApiClient.createWithInterceptor(baseUrl)
    }

    override fun usingClient(chuckInterceptor: Interceptor) {
        FLog.d("$TAG : Using Client OkHttp Client + Chuck Interceptor")
        frogoAdmobApiService = FrogoApiClient.createWithInterceptor(baseUrl, chuckInterceptor)
    }

    override fun getFrogoAdmobId(
        jsonFileName: String,
        callback: FrogoAdmobApiResponse<FrogoAdmobId>
    ) {
        FLog.d("$TAG : Get Data From Json Server FrogoAdmobId")
        frogoAdmobApiService.getFrogoAdmobId(jsonFileName)
            .doApiRequest(AndroidSchedulers.mainThread(), callback)
    }

    override fun getFrogoMonetizeId(
        jsonFileName: String,
        callback: FrogoAdmobApiResponse<FrogoMonetizeId>
    ) {
        FLog.d("$TAG : Get Data From Json Server FrogoMonetizeId")
        frogoAdmobApiService.getMonetizeId(jsonFileName)
            .doApiRequest(AndroidSchedulers.mainThread(), callback)
    }

    override fun getFrogoUnityId(
        jsonFileName: String,
        callback: FrogoAdmobApiResponse<FrogoUnityId>
    ) {
        FLog.d("$TAG : Get Data From Json Server FrogoUnityId")
        frogoAdmobApiService.getUnityId(jsonFileName)
            .doApiRequest(AndroidSchedulers.mainThread(), callback)
    }
}