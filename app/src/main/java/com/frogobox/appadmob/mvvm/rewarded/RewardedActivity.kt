package com.frogobox.appadmob.mvvm.rewarded

import android.os.Bundle
import com.frogobox.admob.core.IFrogoAdRewarded
import com.frogobox.appadmob.R
import com.frogobox.appadmob.base.BaseActivity
import com.frogobox.appadmob.databinding.ActivityRewardedBinding
import com.frogobox.sdk.ext.gone
import com.frogobox.sdk.ext.visible
import com.google.android.gms.ads.rewarded.RewardItem

class RewardedActivity : BaseActivity<ActivityRewardedBinding>(), IFrogoAdRewarded {

    private fun getKeyword(): MutableList<String> {
        val keywords = mutableListOf<String>()
        keywords.add("Kids")
        keywords.add("Toys")
        keywords.add("Game")
        keywords.add("Music")
        keywords.add("Piano")
        return keywords
    }

    private val HTTP_TIMEOUT_MILLIS = 30000

    override fun setupViewBinding(): ActivityRewardedBinding {
        return ActivityRewardedBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDetailActivity("Rewarded Activity")
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnAdmobRewarded.setOnClickListener {
                showAdRewarded(getString(R.string.admob_rewarded), this@RewardedActivity)
            }

            btnAdmobRewardedTimeout.setOnClickListener {
                showAdRewarded(
                    getString(R.string.admob_rewarded),
                    HTTP_TIMEOUT_MILLIS,
                    this@RewardedActivity
                )
            }

            btnAdmobRewardedKeyword.setOnClickListener {
                showAdRewarded(
                    getString(R.string.admob_rewarded),
                    getKeyword(),
                    this@RewardedActivity
                )
            }

            btnAdmobRewardedTimeoutKeyword.setOnClickListener {
                showAdRewarded(
                    getString(R.string.admob_rewarded),
                    HTTP_TIMEOUT_MILLIS,
                    getKeyword(),
                    this@RewardedActivity
                )
            }


            btnAdmobRewardedInterstitial.setOnClickListener {
                showAdRewardedInterstitial(
                    getString(R.string.admob_rewarded_interstitial),
                    this@RewardedActivity
                )
            }

            btnAdmobRewardedInterstitialTimeout.setOnClickListener {
                showAdRewardedInterstitial(
                    getString(R.string.admob_rewarded_interstitial),
                    HTTP_TIMEOUT_MILLIS,
                    this@RewardedActivity
                )
            }

            btnAdmobRewardedInterstitialKeyword.setOnClickListener {
                showAdRewardedInterstitial(
                    getString(R.string.admob_rewarded_interstitial),
                    getKeyword(),
                    this@RewardedActivity
                )
            }

            btnAdmobRewardedInterstitialTimeoutKeyword.setOnClickListener {
                showAdRewardedInterstitial(
                    getString(R.string.admob_rewarded_interstitial),
                    HTTP_TIMEOUT_MILLIS,
                    getKeyword(),
                    this@RewardedActivity
                )
            }
        }
    }

    override fun onUserEarnedReward(tag: String, rewardItem: RewardItem) {
        showToast("${rewardItem.amount}")
    }

    override fun onShowAdRequestProgress(tag: String, message: String) {
        binding.ivProgress.visible()
    }

    override fun onHideAdRequestProgress(tag: String, message: String) {
        binding.ivProgress.gone()
    }

    override fun onAdDismissed(tag: String, message: String) {
        showToast(message)
    }

    override fun onAdFailed(tag: String, errorMessage: String) {
        showToast(errorMessage)
    }

    override fun onAdLoaded(tag: String, message: String) {}

    override fun onAdShowed(tag: String, message: String) {}

}