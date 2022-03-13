package com.frogobox.appadmob.mvvm.main

import android.os.Bundle
import com.frogobox.admob.ui.FrogoSdkAdmobActivity
import com.frogobox.appadmob.databinding.ActivityAboutUsBinding

class AboutUsActivity : FrogoSdkAdmobActivity<ActivityAboutUsBinding>() {

    override fun setupViewBinding(): ActivityAboutUsBinding {
        return ActivityAboutUsBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }


    override fun setupOnCreate(savedInstanceState: Bundle?) {
        setupDetailActivity("About Us")
    }

}
