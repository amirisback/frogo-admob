package com.frogobox.admobsample.ui.adapter

import android.view.ViewGroup
import com.frogobox.admobsample.R
import com.frogobox.admob.*

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
        viewCallback = object : CoreAdmobViewAdapterCallback<Any> {
            override fun onViewTypeMenuItem(parent: ViewGroup): CoreAdmobViewHolder<Any> {
                return NewsHolder(viewLayout(parent))
            }
            override fun onViewTypeBannerAds(parent: ViewGroup): CoreAdmobViewHolder<Any> {
                return FrogoAdmobViewHolder(viewLayout(parent, R.layout.content_item_ad_banner))
            }
        }
    }

}