package com.frogobox.admob.ext

import com.frogobox.coresdk.response.FrogoStateResponse
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.sdk.ext.showLogError
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers


/*
 * Created by faisalamir on 18/04/22
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

fun Completable.executeAd(callback: FrogoStateResponse) {
    subscribeOn(Schedulers.io())
        .doOnSubscribe {
            showLogDebug("executeAction : onLocalSuccess / onShowProgress")
            callback.onShowProgress()
        }
        .doOnTerminate {
            showLogDebug("executeAction : doOnTerminate / onHideProgress")
            callback.onHideProgress()
        }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            showLogDebug("executeAction : onLocalSuccess / onSuccess")
            callback.onSuccess()

            showLogDebug("executeAction : onLocalFinish / onFinish")
            callback.onFinish()
        }) {
            showLogError("executeAction : onLocalFailure / onFailed")
            it.message?.let { it1 -> callback.onFailed(200, it1) }

            showLogError("executeAction : onLocalFinish / onFinish")
            callback.onFinish()
        }
}