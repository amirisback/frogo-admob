package com.frogobox.appadmob.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.frogobox.admob.core.IFrogoAdmob
import com.frogobox.appadmob.R
import com.frogobox.appadmob.core.BaseActivity
import com.frogobox.appadmob.databinding.ActivityMainBinding
import com.frogobox.appadmob.ui.movie.MovieActivity
import com.frogobox.appadmob.ui.news.NewsActivity
import com.google.android.gms.ads.rewarded.RewardItem

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupButtonClick()
        setupShowAdsBanner(binding.includeAdsView.adsPhoneTabSpecialSmartBanner)
    }

    private fun setupButtonClick() {

        binding.apply {

            btnInterstitial.setOnClickListener {
                setupShowAdsInterstitial()
            }

            btnRewarded.setOnClickListener {
                setupShowAdsRewarded(object : IFrogoAdmob.UserEarned {
                    override fun onUserEarnedReward(rewardItem: RewardItem) {
                        // TODO User Get Reward
                    }
                })
            }

            btnRewardedInterstitial.setOnClickListener {
                setupShowAdsRewardedInterstitial(object : IFrogoAdmob.UserEarned {
                    override fun onUserEarnedReward(rewardItem: RewardItem) {
                        // TODO User Get Reward
                    }
                })
            }

            btnRecyclerView.setOnClickListener {
                baseStartActivity<NewsActivity>()
            }

            btnRecyclerView2.setOnClickListener {
                baseStartActivity<MovieActivity>()
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
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
