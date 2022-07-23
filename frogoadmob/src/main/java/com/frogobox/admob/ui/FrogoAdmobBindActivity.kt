package com.frogobox.admob.ui

import androidx.viewbinding.ViewBinding
import com.frogobox.admob.delegate.AdmobDelegates
import com.frogobox.admob.delegate.AdmobDelegatesImpl
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.sdk.view.FrogoBindActivity
import com.google.android.gms.ads.AdView


/*
 * Created by faisalamir on 01/03/22
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


abstract class FrogoAdmobBindActivity<VB : ViewBinding> : FrogoBindActivity<VB>(),
    AdmobDelegates by AdmobDelegatesImpl() {

    companion object {
        val TAG: String = FrogoAdmobBindActivity::class.java.simpleName
    }

    protected val arrayFrogoAdmobData = mutableListOf<Any>()

    override fun setupMonetized() {
        super.setupMonetized()
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.setupAdmobApp")
        setupAdmobDelegates(this)
        setupAdmobApp()
    }

    override fun onResume() {
        super.onResume()
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.resume()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.pause()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.destroy()
            }
        }
    }

}