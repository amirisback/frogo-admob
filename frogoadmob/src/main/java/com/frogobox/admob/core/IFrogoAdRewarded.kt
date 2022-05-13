package com.frogobox.admob.core

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

@Deprecated("Please re-import to latest package and use the new one")
interface IFrogoAdRewarded : IFrogoAdInterstitial {

    fun onUserEarnedReward(tag: String, rewardItem: RewardItem)

}