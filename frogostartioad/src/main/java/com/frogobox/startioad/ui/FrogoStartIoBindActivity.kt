package com.frogobox.startioad.ui

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.frogobox.sdk.ext.showLogD
import com.frogobox.sdk.view.FrogoBindActivity
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


abstract class FrogoStartIoBindActivity<VB : ViewBinding> : FrogoBindActivity<VB>(),
    StartIoDelegates by StartIoDelegatesImpl() {

    companion object {
        val TAG: String = FrogoStartIoBindActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            showLogD<FrogoStartIoBindActivity<VB>>("Run onCreate() From $TAG")
            setupStartIoDelegates(this)
        }
    }

}