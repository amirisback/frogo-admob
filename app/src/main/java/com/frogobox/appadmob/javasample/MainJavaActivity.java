package com.frogobox.appadmob.javasample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

import com.frogobox.admob.core.IFrogoAdmob;
import com.frogobox.appadmob.databinding.ActivityMainBinding;
import com.google.android.gms.ads.rewarded.RewardItem;

public class MainJavaActivity extends BaseJavaActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        setupShowAdsBanner(binding.includeAdsView.adsPhoneTabSpecialSmartBanner);
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

        binding.btnInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupShowAdsInterstitial();
            }
        });

        binding.btnRewarded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupShowAdsRewarded(new IFrogoAdmob.UserEarned() {
                    @Override
                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                    }
                });
            }
        });

        binding.btnRewardedInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupShowAdsRewardedInterstitial(new IFrogoAdmob.UserEarned() {
                    @Override
                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                    }
                });
            }
        });

    }

}