package com.frogobox.appadmob.mvvm.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.frogobox.admob.core.IFrogoAdRewarded
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
                baseStartActivity<InterstitialActivity>()
            }

            btnRewarded.setOnClickListener {
                showAdRewarded(getString(R.string.admob_rewarded), object : IFrogoAdRewarded {
                    override fun onUserEarnedReward(rewardItem: RewardItem) {
                        // TODO("Not yet implemented")
                    }

                    override fun onAdDismissed(message: String) {
                        // TODO("Not yet implemented")
                    }

                    override fun onAdFailedToLoad(errorMessage: String) {
                        // TODO("Not yet implemented")
                    }

                    override fun onAdFailedToShow(errorMessage: String) {
                        // TODO("Not yet implemented")
                    }

                    override fun onAdLoaded(message: String) {
                        // TODO("Not yet implemented")
                    }

                    override fun onAdShowed(message: String) {
                        // TODO("Not yet implemented")
                    }

                })
            }

            btnRewardedInterstitial.setOnClickListener {
                showAdRewardedInterstitial(getString(R.string.admob_rewarded_interstitial),
                    object : IFrogoAdRewarded {
                        override fun onUserEarnedReward(rewardItem: RewardItem) {
                            // TODO("Not yet implemented")
                        }

                        override fun onAdDismissed(message: String) {
                            // TODO("Not yet implemented")
                        }

                        override fun onAdFailedToLoad(errorMessage: String) {
                            // TODO("Not yet implemented")
                        }

                        override fun onAdFailedToShow(errorMessage: String) {
                            // TODO("Not yet implemented")
                        }

                        override fun onAdLoaded(message: String) {
                            // TODO("Not yet implemented")
                        }

                        override fun onAdShowed(message: String) {
                            // TODO("Not yet implemented")
                        }

                    })
            }

            btnRecyclerView.setOnClickListener {
                baseStartActivity<NewsActivity>()
            }

            btnRecyclerView2.setOnClickListener {
                baseStartActivity<MovieActivity>()
            }

            btnComposeActivity.setOnClickListener {
                baseStartActivity<ComposeActivity>()
            }

            btnHybridActivity.setOnClickListener {
                baseStartActivity<HybridActivity>()
            }

            btnJavaSampleActivity.setOnClickListener {
                baseStartActivity<MainJavaActivity>()
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
                baseStartActivity<AboutUsActivity>()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
