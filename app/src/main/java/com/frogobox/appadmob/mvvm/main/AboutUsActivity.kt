package com.frogobox.appadmob.mvvm.main

import android.os.Bundle
import com.frogobox.ad.ui.FrogoAdBindActivity
import com.frogobox.sdk.databinding.ActivityFrogoAboutUsBinding

class AboutUsActivity : FrogoAdBindActivity<ActivityFrogoAboutUsBinding>() {

    override fun setupViewBinding(): ActivityFrogoAboutUsBinding {
        return ActivityFrogoAboutUsBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }


    override fun onCreateExt(savedInstanceState: Bundle?) {
        setupDetailActivity("About Us")
    }

}
