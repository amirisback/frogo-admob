package com.frogobox.admob.core

import android.app.Activity
import com.google.android.ump.ConsentDebugSettings
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters
import com.google.android.ump.UserMessagingPlatform


/**
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


object FrogoAdConsent {

    fun showConsent(activity: Activity, isDebug: Boolean, callback: IFrogoAdConsent) {

        val consentInformation: ConsentInformation = UserMessagingPlatform.getConsentInformation(activity)

        val debugSettings = ConsentDebugSettings.Builder(activity)
            .setDebugGeography(ConsentDebugSettings.DebugGeography.DEBUG_GEOGRAPHY_EEA)
            .addTestDeviceHashedId("TEST-DEVICE-HASHED-ID")
            .setForceTesting(true)
            .build()

        // Set tag for underage of consent. false means users are not underage.
        val params = if (isDebug) {
            ConsentRequestParameters.Builder()
                .setTagForUnderAgeOfConsent(false)
                .setConsentDebugSettings(debugSettings)
                .build()
        } else {
            ConsentRequestParameters.Builder()
                .setTagForUnderAgeOfConsent(false)
                .build()
        }

        consentInformation.requestConsentInfoUpdate(activity, params,
            { // The consent information state was updated.
                // You are now ready to check if a form is available.
                if (consentInformation.isConsentFormAvailable) {
                    loadForm(activity, consentInformation, callback)
                }
            },
            {
                // Handle the error.
                callback.onConsentError(it)
            })
    }

    private fun loadForm(activity: Activity, consentInformation: ConsentInformation, callback: IFrogoAdConsent) {
        // Loads a consent form. Must be called on the main thread.
        UserMessagingPlatform.loadConsentForm(
            activity,
            {
                if (consentInformation.consentStatus == ConsentInformation.ConsentStatus.REQUIRED) {
                    it.show(activity) {
                        if (consentInformation.consentStatus == ConsentInformation.ConsentStatus.OBTAINED) {
                            // App can start requesting ads.
                            callback.onConsentSuccess()
                        }

                        // Handle dismissal by reloading form.
                        loadForm(activity, consentInformation, callback)
                    }
                }
            },
            {
                // Handle the error.
                callback.onConsentError(it)
            }
        )
    }

}