package com.frogobox.admobsample.ui.adapter

import android.view.ViewGroup
import com.frogobox.admobsample.R
import com.frogobox.admob.core.AdmobViewHolder
import com.frogobox.admob.core.FrogoAdmobViewAdapter
import com.frogobox.admob.core.FrogoAdmobViewHolder
import com.frogobox.admob.core.ICoreAdmobViewAdapter

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 27/11/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.admobhelper.ui.adapter
 *
 */
class NewsAdapter : FrogoAdmobViewAdapter<Any>() {

    init {
        viewCallback = object : ICoreAdmobViewAdapter<Any> {
            override fun onViewTypeMenuItem(parent: ViewGroup): FrogoAdmobViewHolder<Any> {
                return NewsHolder(viewLayout(parent))
            }
            override fun onViewTypeBannerAds(parent: ViewGroup): FrogoAdmobViewHolder<Any> {
                return AdmobViewHolder(viewLayout(parent, R.layout.content_item_ad_banner))
            }
        }
    }

}