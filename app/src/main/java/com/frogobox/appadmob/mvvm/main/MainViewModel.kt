package com.frogobox.appadmob.mvvm.main

import android.app.Application
import com.frogobox.appadmob.base.BaseViewModel
import com.frogobox.appadmob.source.AdmobRepository


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

class MainViewModel(
    private val context: Application,
    private val repository: AdmobRepository
) : BaseViewModel(context, repository) {

}