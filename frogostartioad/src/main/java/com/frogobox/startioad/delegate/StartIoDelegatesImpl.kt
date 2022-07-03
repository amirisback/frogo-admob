package com.frogobox.startioad.delegate

import androidx.appcompat.app.AppCompatActivity
import com.frogobox.sdk.ext.showLogD


/*
 * Created by faisalamir on 13/05/22
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

class StartIoDelegatesImpl : StartIoDelegates {

    companion object {
        val TAG: String = StartIoDelegatesImpl::class.java.simpleName
    }

    private lateinit var startIoDelegatesActivity: AppCompatActivity

    override fun setupStartIoDelegates(activity: AppCompatActivity) {
        showLogD<StartIoDelegatesImpl>("activity: $activity")
        startIoDelegatesActivity = activity
    }

}