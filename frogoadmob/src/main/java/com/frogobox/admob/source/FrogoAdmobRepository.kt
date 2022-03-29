package com.frogobox.admob.source

import com.frogobox.admob.model.FrogoAdmobId
import com.frogobox.admob.model.FrogoMonetizeId
import com.frogobox.admob.model.FrogoUnityId
import com.frogobox.coresdk.FrogoApiClient
import com.frogobox.coresdk.FrogoApiObserver
import com.frogobox.log.FLog
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
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
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .subscribe(object : FrogoApiObserver<FrogoAdmobId>() {
                override fun onSuccess(data: FrogoAdmobId) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun getFrogoMonetizeId(
        jsonFileName: String,
        callback: FrogoAdmobApiResponse<FrogoMonetizeId>
    ) {
        FLog.d("$TAG : Get Data From Json Server FrogoMonetizeId")
        frogoAdmobApiService.getMonetizeId(jsonFileName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .subscribe(object : FrogoApiObserver<FrogoMonetizeId>() {
                override fun onSuccess(data: FrogoMonetizeId) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun getFrogoUnityId(
        jsonFileName: String,
        callback: FrogoAdmobApiResponse<FrogoUnityId>
    ) {
        FLog.d("$TAG : Get Data From Json Server FrogoUnityId")
        frogoAdmobApiService.getUnityId(jsonFileName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .subscribe(object : FrogoApiObserver<FrogoUnityId>() {
                override fun onSuccess(data: FrogoUnityId) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }
}