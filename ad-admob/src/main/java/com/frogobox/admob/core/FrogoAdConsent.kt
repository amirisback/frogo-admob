package com.frogobox.admob.core

import android.content.Context
import android.telephony.TelephonyManager
import com.frogobox.sdk.ext.showLogDebug
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

    fun getCountryCode(context: Context): String {
        val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val countryCodeValue = tm.networkCountryIso.uppercase()
        showLogDebug("FrogoAdConsent : getCountryCode : $countryCodeValue")
        return countryCodeValue
    }

    fun listEEACountry(): List<String> {
        return listOf(
            "AT", "BE", "BG", "HR", "CY", "CZ", "DK", "EE", "FI", "FR", "DE", "GR", "HU", "IE",
            "IT", "LV", "LT", "LU", "MT", "NL", "PL", "PT", "RO", "SK", "SI", "ES", "SE"
        )
    }

    fun listUKCountry(): List<String> {
        return listOf("GB", "GG", "IM", "JE")
    }

    fun listAdConsentCountry(): List<String> {
        return listEEACountry() + listUKCountry()
    }

    fun isAdConsentCountry(context: Context): Boolean {
        val isContain = listAdConsentCountry().contains(getCountryCode(context))
        showLogDebug("FrogoAdConsent : isAdConsentCountry : $isContain")
        return isContain
    }

    fun showConsent(callback: IFrogoAdConsent) {
        if (isAdConsentCountry(callback.activity())) {
            showLogDebug("FrogoAdConsent : showConsent : isAdConsentCountry")
            setupConsent(callback)
        } else {
            showLogDebug("FrogoAdConsent : showConsent : onNotUsingAdConsent")
            callback.onNotUsingAdConsent()
        }

    }

    private fun setupConsent(callback: IFrogoAdConsent) {
        val consentInformation: ConsentInformation =
            UserMessagingPlatform.getConsentInformation(callback.activity())

        // Set tag for underage of consent. false means users are not underage.
        val params = if (callback.isDebug()) {

            val debugSettings = ConsentDebugSettings.Builder(callback.activity())
                .setDebugGeography(ConsentDebugSettings.DebugGeography.DEBUG_GEOGRAPHY_EEA)
                .addTestDeviceHashedId("TEST-DEVICE-HASHED-ID")
                .setForceTesting(true)
                .build()

            ConsentRequestParameters.Builder()
                .setTagForUnderAgeOfConsent(callback.isUnderAgeAd())
                .setConsentDebugSettings(debugSettings)
                .build()

        } else {
            ConsentRequestParameters.Builder()
                .setTagForUnderAgeOfConsent(callback.isUnderAgeAd())
                .build()
        }

        consentInformation.requestConsentInfoUpdate(callback.activity(), params,
            { // The consent information state was updated.
                // You are now ready to check if a form is available.
                if (consentInformation.isConsentFormAvailable) {
                    loadForm(consentInformation, callback)
                }
            },
            {
                // Handle the error.
                callback.onConsentError(it)
            })
    }

    private fun loadForm(consentInformation: ConsentInformation, callback: IFrogoAdConsent) {
        // Loads a consent form. Must be called on the main thread.
        UserMessagingPlatform.loadConsentForm(callback.activity(), { consentForm ->
            if (consentInformation.consentStatus == ConsentInformation.ConsentStatus.REQUIRED) {
                consentForm.show(callback.activity()) { formError ->
                    if (consentInformation.consentStatus == ConsentInformation.ConsentStatus.OBTAINED) {
                        // App can start requesting ads.
                        callback.onConsentSuccess()
                    }

                    // Handle dismissal by reloading form.
                    loadForm(consentInformation, callback)
                }
            }
        }, { formError ->
            // Handle the error.
            callback.onConsentError(formError)
        })
    }

}