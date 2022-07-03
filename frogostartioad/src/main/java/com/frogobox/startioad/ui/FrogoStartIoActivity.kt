package com.frogobox.startioad.ui

import android.os.Bundle
import com.frogobox.sdk.ext.showLogD
import com.frogobox.sdk.view.FrogoActivity
import com.frogobox.startioad.delegate.StartIoDelegates
import com.frogobox.startioad.delegate.StartIoDelegatesImpl

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


abstract class FrogoStartIoActivity : FrogoActivity(),
    StartIoDelegates by StartIoDelegatesImpl() {

    companion object {
        val TAG: String = FrogoStartIoActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            showLogD<FrogoStartIoActivity>("Run onCreate() From $TAG")
            setupStartIoDelegates(this)
        }
    }

}