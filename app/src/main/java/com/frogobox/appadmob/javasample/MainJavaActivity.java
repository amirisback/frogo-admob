package com.frogobox.appadmob.javasample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.frogobox.appadmob.R;
import com.frogobox.appadmob.databinding.ActivityMainBinding;
import com.google.android.gms.ads.AdSize;

public class MainJavaActivity extends BaseJavaActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        showBannerContainer(getString(R.string.admob_banner), AdSize.SMART_BANNER, binding.includeAdsView.frogoAdsBanner);
        showBanner(binding.adsXml.adsPhoneTabSpecialSmartBanner);
        hideButton();
        setupButtonClick();
    }

    private void hideButton() {
        binding.btnRecyclerView.setVisibility(View.GONE);
        binding.btnRecyclerView2.setVisibility(View.GONE);
        binding.btnComposeActivity.setVisibility(View.GONE);
        binding.btnHybridActivity.setVisibility(View.GONE);
        binding.btnJavaSampleActivity.setVisibility(View.GONE);
    }

    private void setupButtonClick() {

        binding.btnInterstitial.setOnClickListener(view -> showInterstitial(getString(R.string.admob_interstitial)));

        binding.btnRewarded.setOnClickListener(view -> setupShowAdsRewarded(rewardItem -> {

        }));

        binding.btnRewardedInterstitial.setOnClickListener(view -> setupShowAdsRewardedInterstitial(rewardItem -> {

        }));

    }

}