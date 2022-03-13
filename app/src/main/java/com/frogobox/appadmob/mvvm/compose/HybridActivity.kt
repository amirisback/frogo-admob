package com.frogobox.appadmob.mvvm.compose

import android.os.Bundle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.frogobox.appadmob.base.BaseActivity
import com.frogobox.appadmob.databinding.ActivityHybridBinding

class HybridActivity : BaseActivity<ActivityHybridBinding>() {

    override fun setupViewBinding(): ActivityHybridBinding {
        return ActivityHybridBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            composeView.setContent {
                Greeting("FrogoAdmob")
            }

            showAdBanner(includeAdsView.adsPhoneTabSpecialSmartBanner)
        }

    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

}