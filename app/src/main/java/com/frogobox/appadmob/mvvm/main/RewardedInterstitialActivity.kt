package com.frogobox.appadmob.mvvm.main

import android.os.Bundle
import com.frogobox.appadmob.base.BaseActivity
import com.frogobox.appadmob.databinding.ActivityRewardedInterstitialBinding

class RewardedInterstitialActivity : BaseActivity<ActivityRewardedInterstitialBinding>() {

    override fun setupViewBinding(): ActivityRewardedInterstitialBinding {
        return ActivityRewardedInterstitialBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}