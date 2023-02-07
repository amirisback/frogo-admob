package com.frogobox.admob.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.delegate.AdmobDelegates
import com.frogobox.admob.delegate.AdmobDelegatesImpl
import com.frogobox.sdk.ext.showLogDebug

/**
 * Created by Faisal Amir on 07/02/23
 * https://github.com/amirisback
 */


abstract class AdmobActivity : AppCompatActivity(),
    AdmobDelegates by AdmobDelegatesImpl()  {

    companion object {
        val TAG: String = AdmobActivity::class.java.simpleName
    }

    open fun setupMonetized() {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.setupAdmobApp")
        setupAdmobDelegates(this)
        setupAdmobApp()
    }

    open fun setupContentView() {
        showLogDebug("$TAG : Run From $TAG class : AdmobActivity.setupContentView")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupContentView()
        setupMonetized()
    }

}