package com.frogobox.appadmob.mvvm.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.frogobox.admob.core.IFrogoAdRewarded
import com.frogobox.appadmob.BuildConfig
import com.frogobox.appadmob.R
import com.frogobox.appadmob.base.BaseActivity
import com.frogobox.appadmob.databinding.ActivityMainBinding
import com.frogobox.appadmob.javasample.MainJavaActivity
import com.frogobox.appadmob.mvvm.compose.ComposeActivity
import com.frogobox.appadmob.mvvm.compose.HybridActivity
import com.frogobox.appadmob.mvvm.movie.MovieActivity
import com.frogobox.appadmob.mvvm.news.NewsActivity
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.rewarded.RewardItem

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestAdmobApi()
        setupButtonClick()
        setupBannerAds()
    }

    private fun setupBannerAds() {
        showAdBanner(binding.adsXml.adsPhoneTabSpecialSmartBanner)
        showAdBannerContainer(
            getString(R.string.admob_banner),
            AdSize.SMART_BANNER,
            binding.includeAdsView.frogoAdsBanner
        )
    }

    private fun setupButtonClick() {

        binding.apply {

            btnInterstitial.setOnClickListener {
                frogoStartActivity<InterstitialActivity>()
            }

            btnRewarded.setOnClickListener {
                showAdRewarded(getString(R.string.admob_rewarded), object : IFrogoAdRewarded {

                    override fun onUserEarnedReward(tag: String, rewardItem: RewardItem) {}

                    override fun onAdDismissed(tag: String, message: String) {}

                    override fun onAdFailed(tag: String, errorMessage: String) {}

                    override fun onAdLoaded(tag: String, message: String) {}

                    override fun onAdShowed(tag: String, message: String) {}

                })
            }

            btnRewardedInterstitial.setOnClickListener {
                showAdRewardedInterstitial(getString(R.string.admob_rewarded_interstitial),
                    object : IFrogoAdRewarded {

                        override fun onUserEarnedReward(tag: String, rewardItem: RewardItem) {}

                        override fun onAdDismissed(tag: String, message: String) {}

                        override fun onAdFailed(tag: String, errorMessage: String) {}

                        override fun onAdLoaded(tag: String, message: String) {}

                        override fun onAdShowed(tag: String, message: String) {}

                    })
            }

            btnRecyclerView.setOnClickListener {
                frogoStartActivity<NewsActivity>()
            }

            btnRecyclerView2.setOnClickListener {
                frogoStartActivity<MovieActivity>()
            }

            btnComposeActivity.setOnClickListener {
                frogoStartActivity<ComposeActivity>()
            }

            btnHybridActivity.setOnClickListener {
                frogoStartActivity<HybridActivity>()
            }

            btnJavaSampleActivity.setOnClickListener {
                frogoStartActivity<MainJavaActivity>()
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.toolbar_menu_about -> {
                frogoStartActivity<AboutUsActivity>()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}