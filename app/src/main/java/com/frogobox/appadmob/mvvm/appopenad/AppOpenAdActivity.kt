package com.frogobox.appadmob.mvvm.appopenad

import android.os.Bundle
import com.frogobox.ad.ui.FrogoAdBindActivity
import com.frogobox.admob.callback.FrogoAdmobAppOpenAdCallback
import com.frogobox.appadmob.databinding.ActivityAppOpenAdBinding
import com.frogobox.appadmob.databinding.ActivityInterstitialBinding

/**
 * Created by Faisal Amir on 24/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */


class AppOpenAdActivity : FrogoAdBindActivity<ActivityAppOpenAdBinding>(),
    FrogoAdmobAppOpenAdCallback {

    override fun setupViewBinding(): ActivityAppOpenAdBinding {
        return ActivityAppOpenAdBinding.inflate(layoutInflater)
    }

    override fun onCreateExt(savedInstanceState: Bundle?) {
        super.onCreateExt(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnAdmobAppOpenAd.setOnClickListener {

            }
        }
    }


    override fun onAdDismissed(tag: String, message: String) {

    }

    override fun onAdShowed(tag: String, message: String) {

    }

}