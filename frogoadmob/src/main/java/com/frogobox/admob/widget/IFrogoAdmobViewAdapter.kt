package com.frogobox.admob.widget

import android.view.ViewGroup

/*
 * Created by Faisal Amir on 31/01/2021
 * AdmobSamples Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

@Deprecated("Please re-import to latest package and use the new one")
interface IFrogoAdmobViewAdapter<T> {

    fun onViewTypeMenuItem(parent: ViewGroup): FrogoAdmobViewHolder<T>

    fun onViewTypeBannerAds(parent: ViewGroup): FrogoAdmobViewHolder<T>

}