package com.frogobox.appadmob

import com.frogobox.sdk.FrogoApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


/**
 * Created by faisalamir on 26/07/21
 * FrogoSDK
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

abstract class FrogoKoinApplication : FrogoApplication() {

    open fun setupKoinModule(koinApplication: KoinApplication) {}

    override fun onCreateExt() {
        super.onCreateExt()
        startKoin {
            androidContext(this@FrogoKoinApplication)
            androidLogger(
                if (isDebugMode()) {
                    Level.DEBUG
                } else {
                    Level.ERROR
                }
            )
            setupKoinModule(this)
        }
    }

}