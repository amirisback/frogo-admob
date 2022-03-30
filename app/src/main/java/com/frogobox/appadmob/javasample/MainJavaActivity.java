package com.frogobox.appadmob.javasample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

import com.frogobox.admob.core.IFrogoAdRewarded;
import com.frogobox.appadmob.R;
import com.frogobox.appadmob.databinding.ActivityMainBinding;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.rewarded.RewardItem;

public class MainJavaActivity extends BaseJavaActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        showAdBannerContainer(getString(R.string.admob_banner), AdSize.SMART_BANNER, binding.includeAdsView.frogoAdsBanner);
        showAdBanner(binding.adsXml.adsPhoneTabSpecialSmartBanner);
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

        binding.btnInterstitial.setOnClickListener(view -> showAdInterstitial(getString(R.string.admob_interstitial)));

        binding.btnRewarded.setOnClickListener(view -> showAdRewarded(getString(R.string.admob_rewarded), new IFrogoAdRewarded() {

            @Override
            public void onUserEarnedReward(@NonNull String tag, @NonNull RewardItem rewardItem) {

            }

            @Override
            public void onAdShowed(@NonNull String tag, @NonNull String message) {

            }

            @Override
            public void onAdLoaded(@NonNull String tag, @NonNull String message) {

            }

            @Override
            public void onAdFailed(@NonNull String tag, @NonNull String errorMessage) {

            }

            @Override
            public void onAdDismissed(@NonNull String tag, @NonNull String message) {

            }
        }));

    }

}