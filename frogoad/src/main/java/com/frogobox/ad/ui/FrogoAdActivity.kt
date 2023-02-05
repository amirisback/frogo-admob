package com.frogobox.ad.ui

import com.frogobox.ad.delegate.FrogoAdDelegates
import com.frogobox.ad.delegate.FrogoAdDelegatesImpl
import com.frogobox.admob.delegate.AdmobDelegates
import com.frogobox.admob.delegate.AdmobDelegatesImpl
import com.frogobox.sdk.ext.showLogD
import com.frogobox.sdk.view.FrogoActivity
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


abstract class FrogoAdActivity : FrogoActivity(),
    AdmobDelegates by AdmobDelegatesImpl(),
    UnityAdDelegates by UnityAdDelegatesImpl(),
    FrogoAdDelegates by FrogoAdDelegatesImpl() {

    companion object {
        val TAG: String = FrogoAdActivity::class.java.simpleName
    }

    override fun setupMonetized() {
        super.setupMonetized()
        showLogD<FrogoAdActivity>("Run setupMonetized() From $TAG")
        setupAdmobDelegates(this)
        setupUnityAdDelegates(this)
        setupFrogoAdDelegates(this)
        setupAdmobApp()
    }

}

