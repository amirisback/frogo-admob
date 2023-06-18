package com.frogobox.appadmob.mvvm.main

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.frogobox.admob.core.IFrogoAdConsent
import com.frogobox.appadmob.BuildConfig
import com.frogobox.appadmob.R
import com.frogobox.appadmob.base.BaseActivity
import com.frogobox.appadmob.databinding.ActivityMainBinding
import com.frogobox.appadmob.mvvm.appopenad.AppOpenAdActivity
import com.frogobox.appadmob.mvvm.interstitial.InterstitialActivity
import com.frogobox.appadmob.mvvm.movie.MovieActivity
import com.frogobox.appadmob.mvvm.news.NewsActivity
import com.frogobox.appadmob.mvvm.rewarded.RewardedActivity
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.sdk.ext.startActivityExt
import com.google.android.gms.ads.AdSize
import com.google.android.ump.FormError

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreateExt(savedInstanceState: Bundle?) {
        super.onCreateExt(savedInstanceState)

        showAdConsent(object : IFrogoAdConsent {

            override fun activity(): Activity {
                return this@MainActivity
            }

            override fun isDebug(): Boolean {
                return BuildConfig.DEBUG
            }

            override fun isUnderAgeAd(): Boolean {
                return false
            }

            override fun onConsentSuccess() {
                requestAdmobApi()
                setupButtonClick()
                setupBannerAds()
            }

            override fun onConsentError(formError: FormError) {
                showLogDebug("onConsentError ${formError.message}")
            }

        })

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
                startActivityExt<InterstitialActivity>()
            }

            btnRewarded.setOnClickListener {
                startActivityExt<RewardedActivity>()
            }

            btnRecyclerView.setOnClickListener {
                startActivityExt<NewsActivity>()
            }

            btnRecyclerView2.setOnClickListener {
                startActivityExt<MovieActivity>()
            }

            btnJavaSampleActivity.setOnClickListener {
                startActivityExt<MainJavaActivity>()
            }

            btnAppOpenAd.setOnClickListener {
                startActivityExt<AppOpenAdActivity>()
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
                startActivityExt<AboutUsActivity>()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}