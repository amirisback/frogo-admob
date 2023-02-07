package com.frogobox.unityad.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.unityad.delegate.UnityAdDelegates
import com.frogobox.unityad.delegate.UnityAdDelegatesImpl

/**
 * Created by Faisal Amir on 07/02/23
 * https://github.com/amirisback
 */


abstract class UnityAdActivity : AppCompatActivity(),
    UnityAdDelegates by UnityAdDelegatesImpl() {

    companion object {
        val TAG: String = UnityAdActivity::class.java.simpleName
    }

    open fun setupMonetized() {
        showLogDebug("$TAG : Run From $TAG class : FrogoAdmob.setupAdmobApp")
        setupUnityAdDelegates(this)
    }

    open fun setupContentView() {
        showLogDebug("$TAG : Run From $TAG class : UnityAdActivity.setupContentView")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupContentView()
        setupMonetized()
    }

}