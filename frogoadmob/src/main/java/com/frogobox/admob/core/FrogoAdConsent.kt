package com.frogobox.admob.core

import android.app.Activity
import com.google.android.ump.ConsentDebugSettings
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters
import com.google.android.ump.UserMessagingPlatform


/*
 * Created by faisalamir on 26/03/22
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

@Deprecated("Please re-import to latest package and use the new one")
object FrogoAdConsent {

    fun showConsent(activity: Activity) {

        val consentInformation: ConsentInformation =
            UserMessagingPlatform.getConsentInformation(activity)

        val debugSettings = ConsentDebugSettings.Builder(activity)
            .setDebugGeography(ConsentDebugSettings.DebugGeography.DEBUG_GEOGRAPHY_EEA)
            .addTestDeviceHashedId("TEST-DEVICE-HASHED-ID")
            .build()

        // Set tag for underage of consent. false means users are not underage.
        val params = ConsentRequestParameters.Builder()
            .setTagForUnderAgeOfConsent(false)
            .setConsentDebugSettings(debugSettings)
            .build()

        consentInformation.requestConsentInfoUpdate(activity, params,
            { // The consent information state was updated.
                // You are now ready to check if a form is available.
                if (consentInformation.isConsentFormAvailable) {
                    loadForm(activity, consentInformation)
                }
            },
            {
                // Handle the error.
            })
    }


    fun loadForm(activity: Activity, consentInformation: ConsentInformation) {
        UserMessagingPlatform.loadConsentForm(
            activity,
            {
                if (consentInformation.consentStatus == ConsentInformation.ConsentStatus.REQUIRED) {
                    it.show(activity) { // Handle dismissal by reloading form.
                        loadForm(activity, consentInformation)
                    }
                }
            }
        ) {
            /// Handle Error.
        }
    }

}