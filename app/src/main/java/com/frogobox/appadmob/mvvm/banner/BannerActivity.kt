package com.frogobox.appadmob.mvvm.banner

import android.os.Bundle
import com.frogobox.appadmob.base.BaseActivity
import com.frogobox.appadmob.databinding.ActivityBannerBinding

class BannerActivity : BaseActivity<ActivityBannerBinding>() {

    override fun setupViewBinding(): ActivityBannerBinding {
        return ActivityBannerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}