package com.frogobox.appadmob

import com.frogobox.appadmob.di.repositoryModule
import com.frogobox.appadmob.di.viewModelModule
import com.frogobox.sdk.FrogoApplication
import org.koin.core.KoinApplication


/*
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

class FrogoAdmobApplication : FrogoApplication() {

    override fun setupKoinModule(koinApplication: KoinApplication) {
        koinApplication.modules(listOf(viewModelModule, repositoryModule))
    }

    override fun setupOnCreate() {

    }
}