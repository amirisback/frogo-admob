package com.frogobox.appadmob.mvvm.news

import android.view.ViewGroup
import com.frogobox.admob.widget.AdmobViewHolder
import com.frogobox.admob.widget.FrogoAdmobViewAdapter
import com.frogobox.admob.widget.FrogoAdmobViewHolder
import com.frogobox.admob.widget.IFrogoAdmobViewAdapter
import com.frogobox.appadmob.R

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
        viewCallback = object : IFrogoAdmobViewAdapter<Any> {
            override fun onViewTypeMenuItem(parent: ViewGroup): FrogoAdmobViewHolder<Any> {
                return NewsHolder(viewLayout(parent))
            }

            override fun onViewTypeBannerAds(parent: ViewGroup): FrogoAdmobViewHolder<Any> {
                return AdmobViewHolder(viewLayout(parent, R.layout.content_item_ad_banner))
            }
        }
    }

}