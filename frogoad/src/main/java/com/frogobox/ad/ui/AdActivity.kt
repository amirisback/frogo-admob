package com.frogobox.ad.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.ad.delegate.FrogoAdDelegates
import com.frogobox.ad.delegate.FrogoAdDelegatesImpl
import com.frogobox.admob.delegate.AdmobDelegates
import com.frogobox.admob.delegate.AdmobDelegatesImpl
import com.frogobox.unityad.delegate.UnityAdDelegates
import com.frogobox.unityad.delegate.UnityAdDelegatesImpl

/**
 * Created by Faisal Amir on 07/02/23
 * https://github.com/amirisback
 */


abstract class AdActivity : AppCompatActivity(),
    AdmobDelegates by AdmobDelegatesImpl(),
    UnityAdDelegates by UnityAdDelegatesImpl(),
    FrogoAdDelegates by FrogoAdDelegatesImpl() {

    companion object {
        val TAG: String = AdActivity::class.java.simpleName
    }

    open fun setupMonetized() {
        setupAdmobDelegates(this)
        setupAdmobApp()
    }

    open fun setupContentView() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupContentView()
        setupMonetized()
    }

}