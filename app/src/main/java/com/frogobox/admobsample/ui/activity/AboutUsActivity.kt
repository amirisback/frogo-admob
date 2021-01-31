package com.frogobox.admobsample.ui.activity

import android.os.Bundle
import com.frogobox.admobsample.R
import com.frogobox.admobsample.base.BaseActivity

class AboutUsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        setupDetailActivity("")
    }
}
