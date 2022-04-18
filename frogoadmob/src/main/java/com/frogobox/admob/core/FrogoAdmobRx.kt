package com.frogobox.admob.core

import androidx.appcompat.app.AppCompatActivity
import com.frogobox.admob.ext.executeAd
import com.frogobox.coresdk.response.FrogoStateResponse
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.sdk.ext.showLogError
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import io.reactivex.rxjava3.core.Completable


/*
 * Created by faisalamir on 18/04/22
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

