package com.frogobox.appadmob.mvvm.main

import android.os.Bundle
import com.frogobox.admob.core.IFrogoInterstitialCallback
import com.frogobox.admob.ui.FrogoSdkAdmobActivity2
import com.frogobox.appadmob.R
import com.frogobox.appadmob.databinding.ActivityAboutUsBinding
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd

class AboutUsActivity : FrogoSdkAdmobActivity2<ActivityAboutUsBinding>() {

    override fun setupViewBinding(): ActivityAboutUsBinding {
        return ActivityAboutUsBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }


    override fun setupOnCreate(savedInstanceState: Bundle?) {
        setupDetailActivity("")
    }

}
