package com.frogobox.appadmob

import android.content.Context
import com.frogobox.admob.FrogoAdmobKoinApplication
import com.frogobox.appadmob.di.repositoryModule
import com.frogobox.appadmob.di.viewModelModule
import com.frogobox.appadmob.util.AdHelper
import org.koin.core.KoinApplication


/**
 * Created by faisalamir on 19/04/22
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

class SampleAdmobApplication : FrogoAdmobKoinApplication() {

    override fun setupKoinModule(koinApplication: KoinApplication) {
        koinApplication.modules(listOf(viewModelModule, repositoryModule))
    }

    override fun onCreateExt() {
        super.onCreateExt()
    }

    override fun getAdOpenAppUnitId(context: Context?): String {
        return AdHelper.getAdOpenAppUnitId(context)
    }

}