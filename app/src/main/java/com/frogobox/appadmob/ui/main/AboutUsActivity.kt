package com.frogobox.appadmob.ui.main

import android.os.Bundle
import com.frogobox.appadmob.core.BaseActivity
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
