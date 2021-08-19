package com.frogobox.appadmob.mvvm.main

import android.os.Bundle
import com.frogobox.appadmob.base.BaseActivity
import com.frogobox.appadmob.databinding.ActivityAboutUsBinding

class AboutUsActivity : BaseActivity<ActivityAboutUsBinding>() {

    override fun setupViewBinding(): ActivityAboutUsBinding {
        return ActivityAboutUsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDetailActivity("")
    }

}
