package com.frogobox.appadmob.mvvm.main

import android.os.Bundle
import com.frogobox.appadmob.base.BaseActivity
import com.frogobox.appadmob.databinding.ActivityRewardedBinding

class RewardedActivity : BaseActivity<ActivityRewardedBinding>() {

    override fun setupViewBinding(): ActivityRewardedBinding {
        return ActivityRewardedBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}