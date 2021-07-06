package com.frogobox.admobsample.ui.activity

import android.os.Bundle
import com.frogobox.admobsample.base.BaseActivity
import com.frogobox.admobsample.databinding.ActivityAboutUsBinding

class AboutUsActivity : BaseActivity<ActivityAboutUsBinding>() {

    override fun setupViewBinding(): ActivityAboutUsBinding {
        return ActivityAboutUsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDetailActivity("")
    }

}
