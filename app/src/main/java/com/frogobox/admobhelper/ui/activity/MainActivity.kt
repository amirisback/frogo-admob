package com.frogobox.admobhelper.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.frogobox.admobhelper.R
import com.frogobox.admobhelper.base.admob.BaseAdmobActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ads_phone_tab_special_smart_banner.*
import kotlinx.android.synthetic.main.toolbar_main.*

class MainActivity : BaseAdmobActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
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
            baseStartActivity<RecyclerViewActivity>()
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar_main)
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
