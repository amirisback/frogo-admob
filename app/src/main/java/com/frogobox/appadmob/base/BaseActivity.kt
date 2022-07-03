package com.frogobox.appadmob.base

import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewbinding.ViewBinding
import com.frogobox.admob.deprecated.FrogoAdmobApiResponse
import com.frogobox.admob.deprecated.FrogoAdmobId
import com.frogobox.admob.deprecated.FrogoAdmobRepository
import com.frogobox.admob.ui.FrogoAdmobActivity
import com.frogobox.appadmob.BuildConfig
import com.frogobox.appadmob.R
import com.frogobox.sdk.ext.showLogDebug
import com.google.gson.Gson
import org.koin.android.ext.android.inject

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 27/11/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.admobhelper.base
 *
 */
abstract class BaseActivity<VB : ViewBinding> : FrogoAdmobActivity() {

    protected val binding: VB by lazy { setupViewBinding() }

    protected val frogoSharedPreferences: SharedPreferences by inject()

    abstract fun setupViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            setupUnityAdApp(BuildConfig.DEBUG, getString(R.string.unity_ad_game_id))
        }
    }

    protected fun requestAdmobApi() {
        val baseUrl =
            "https://raw.githubusercontent.com/amirisback/frogo-admob/master/app/src/main/assets/"
        val frogoAdmobRepository = FrogoAdmobRepository(BuildConfig.DEBUG, baseUrl)
        frogoAdmobRepository.usingClient(this)
        frogoAdmobRepository.getFrogoAdmobId(
            "admob_id.json",
            object : FrogoAdmobApiResponse<FrogoAdmobId> {
                override fun onSuccess(data: FrogoAdmobId) {
                    runOnUiThread {
                        showLogDebug(data.admobAppId)
                        showLogDebug(data.admobBannerID[0])
                        showLogDebug(data.admobInterstitialID[0])
                        showLogDebug(data.testAdmobAppId)
                        showLogDebug(data.testAdmobBanner)
                        showLogDebug(data.testAdmobInterstitial)
                    }
                }

                override fun onFailed(statusCode: Int, errorMessage: String) {
                    runOnUiThread {
                        showLogDebug(errorMessage)
                    }
                }

                override fun onFinish() {
                }

                override fun onShowProgress() {
                }

                override fun onHideProgress() {
                }
            })
    }

    protected inline fun <reified Model> baseGetExtraData(extraKey: String): Model {
        val extraIntent = intent.getStringExtra(extraKey)
        return Gson().fromJson(extraIntent, Model::class.java)
    }

    protected fun <Model, VB : ViewBinding> baseFragmentNewInstance(
        fragment: BaseFragment<VB>,
        argumentKey: String,
        extraDataResult: Model
    ) {
        fragment.baseNewInstance(argumentKey, extraDataResult)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}