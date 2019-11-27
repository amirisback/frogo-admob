package com.frogobox.admobhelper.ui.activity

import android.os.Bundle
import com.frogobox.admobhelper.R
import com.frogobox.admobhelper.base.ui.BaseActivity

class AboutUsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        setupDetailActivity("")
    }
}
