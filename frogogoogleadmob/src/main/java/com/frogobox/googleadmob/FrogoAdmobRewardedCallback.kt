package com.frogobox.googleadmob

import com.frogobox.adcore.FrogoAdInterstitialCallback
import com.google.android.gms.ads.rewarded.RewardItem


/*
 * Created by faisalamir on 13/03/22
 * FrogoAdmob
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Frogobox Media Inc.      
 * All rights reserved
 *
 */

interface FrogoAdmobRewardedCallback : FrogoAdInterstitialCallback {

    fun onUserEarnedReward(tag: String, rewardItem: RewardItem)

}