package com.frogobox.admob.core

import com.google.android.ump.FormError

/**
 * Created by Amir on 06/18/23
 * FrogoAdmob Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2023 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface IFrogoAdConsent {

    fun onConsentSuccess()

    fun onConsentError(formError: FormError)

}