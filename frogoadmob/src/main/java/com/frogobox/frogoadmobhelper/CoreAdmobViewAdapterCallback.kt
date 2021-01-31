package com.frogobox.frogoadmobhelper

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
interface CoreAdmobViewAdapterCallback<T> {

    fun onViewTypeMenuItem(parent: ViewGroup) : CoreAdmobViewHolder<T>

    fun onViewTypeBannerAds(parent: ViewGroup) : CoreAdmobViewHolder<T>

}