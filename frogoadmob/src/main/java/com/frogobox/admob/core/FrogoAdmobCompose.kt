package com.frogobox.admob.core

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView


/*
 * Created by faisalamir on 22/09/21
 * FrogoAdmob
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

val adsize_banner: AdSize = AdSize.BANNER
val adsize_full_banner: AdSize = AdSize.FULL_BANNER
val adsize_large_banner: AdSize = AdSize.LARGE_BANNER
val adsize_smart_banner: AdSize = AdSize.SMART_BANNER
val adsize_medium_rectangle: AdSize = AdSize.MEDIUM_RECTANGLE
val adsize_wide_skycraper: AdSize = AdSize.WIDE_SKYSCRAPER

@Composable
fun FrogoAdmobBannerView(
    mAdUnitID: String,
    mAdSize: AdSize,
    modifier: Modifier = Modifier
) {
    AndroidView(
        modifier = modifier.fillMaxWidth(),
        factory = { context ->
            AdView(context).apply {
                adSize = mAdSize
                adUnitId = mAdUnitID
                loadAd(AdRequest.Builder().build())
            }
        }
    )
}