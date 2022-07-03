package com.frogobox.ad.ui

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.frogobox.ad.delegate.FrogoAdDelegates
import com.frogobox.ad.delegate.FrogoAdDelegatesImpl
import com.frogobox.admob.delegate.AdmobDelegates
import com.frogobox.admob.delegate.AdmobDelegatesImpl
import com.frogobox.sdk.ext.showLogD
import com.frogobox.sdk.view.FrogoBindActivity
import com.frogobox.startioad.delegate.StartIoDelegates
import com.frogobox.startioad.delegate.StartIoDelegatesImpl
import com.frogobox.unityad.delegate.UnityAdDelegates
import com.frogobox.unityad.delegate.UnityAdDelegatesImpl
import com.google.android.gms.ads.AdView

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 31/10/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.admobhelper
 *
 */


abstract class FrogoAdBindActivity<VB : ViewBinding> : FrogoBindActivity<VB>(),
    AdmobDelegates by AdmobDelegatesImpl(),
    UnityAdDelegates by UnityAdDelegatesImpl(),
    StartIoDelegates by StartIoDelegatesImpl(),
    FrogoAdDelegates by FrogoAdDelegatesImpl() {

    companion object {
        val TAG: String = FrogoAdBindActivity::class.java.simpleName
    }

    protected val arrayFrogoAdmobData = mutableListOf<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            showLogD<FrogoAdBindActivity<VB>>("Run onCreate() From $TAG")
            setupAdmobDelegates(this)
            setupUnityAdDelegates(this)
            setupStartIoDelegates(this)
            setupFrogoAdDelegates(this)
            setupAdmobApp()
        }
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

