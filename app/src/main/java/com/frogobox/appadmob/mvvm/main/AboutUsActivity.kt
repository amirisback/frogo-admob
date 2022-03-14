package com.frogobox.appadmob.mvvm.main

import android.os.Bundle
import com.frogobox.admob.ui.FrogoSdkAdmobActivity
import com.frogobox.sdk.databinding.ActivityFrogoAboutUsBinding

class AboutUsActivity : FrogoSdkAdmobActivity<ActivityFrogoAboutUsBinding>() {

    override fun setupViewBinding(): ActivityFrogoAboutUsBinding {
        return ActivityFrogoAboutUsBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }


    override fun setupOnCreate(savedInstanceState: Bundle?) {
        setupDetailActivity("About Us")
    }

}
