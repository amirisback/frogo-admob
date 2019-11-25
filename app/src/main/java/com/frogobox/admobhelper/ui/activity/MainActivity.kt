package com.frogobox.admobhelper.ui.activity

import android.os.Bundle
import com.frogobox.admobhelper.R
import com.frogobox.admobhelper.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ads_phone_tab_banner.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_interstitial.setOnClickListener {
            setupShowAdsInterstitial()
        }

        setupShowAdsBanner(ads_phone_tab_banner)

    }
}
