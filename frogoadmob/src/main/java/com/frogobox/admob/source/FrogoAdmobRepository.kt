package com.frogobox.admob.source

import com.frogobox.admob.model.FrogoAdmobId
import com.frogobox.coresdk.FrogoApiClient
import com.frogobox.coresdk.FrogoApiObserver
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


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

    private val TAG = FrogoAdmobRepository::class.java.simpleName
    private var frogoAdmobApiService = FrogoApiClient.create<FrogoAdmobApiService>(baseUrl)

    override fun usingClient() {
        frogoAdmobApiService = FrogoApiClient.createWithClient(baseUrl)
    }

    override fun getFrogoAdmobId(
        jsonFileName: String,
        callback: FrogoAdmobApiResponse<FrogoAdmobId>
    ) {
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

}