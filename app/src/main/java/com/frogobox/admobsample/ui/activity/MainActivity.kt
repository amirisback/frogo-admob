package com.frogobox.admobsample.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.frogobox.admobsample.R
import com.frogobox.admobsample.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ads_phone_tab_special_smart_banner.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupButtonClick()
        setupShowAdsBanner(ads_phone_tab_special_smart_banner)
    }

    private fun setupButtonClick() {
        btn_interstitial.setOnClickListener {
            setupShowAdsInterstitial()
        }
        btn_rewarded.setOnClickListener {

        }

        btn_recycler_view.setOnClickListener {
            baseStartActivity<NewsActivity>()
        }

        btn_recycler_view_2.setOnClickListener {
            baseStartActivity<MovieActivity>()
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
