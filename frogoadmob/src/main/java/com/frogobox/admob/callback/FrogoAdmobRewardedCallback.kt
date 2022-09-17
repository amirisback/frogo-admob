package com.frogobox.admob.callback

import com.frogobox.adcore.callback.FrogoAdCoreInterstitialCallback
import com.google.android.gms.ads.rewarded.RewardItem


/**
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

interface FrogoAdmobRewardedCallback : FrogoAdCoreInterstitialCallback {

    fun onUserEarnedReward(tag: String, rewardItem: RewardItem)

}