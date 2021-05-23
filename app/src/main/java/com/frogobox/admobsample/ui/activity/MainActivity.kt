package com.frogobox.admobsample.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.frogobox.admobsample.R
import com.frogobox.admobsample.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)
        setupButtonClick()
        setupShowAdsBanner(mainBinding.includeAdsView.adsPhoneTabSpecialSmartBanner)
    }

    private fun setupButtonClick() {

        mainBinding.apply {

            btnInterstitial.setOnClickListener {
                setupShowAdsInterstitial()
            }
            btnRewarded.setOnClickListener {

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
