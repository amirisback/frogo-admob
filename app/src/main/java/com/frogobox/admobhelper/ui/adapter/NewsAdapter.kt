package com.frogobox.admobhelper.ui.adapter

import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.frogobox.admobhelper.R
import com.frogobox.admobhelper.base.adapter.BaseViewAdapter
import com.frogobox.admobhelper.base.adapter.BaseViewHolder
import com.frogobox.frogoadmobhelper.util.FrogoRvConstant.RECYCLER_VIEW_TYPE_BANNER_AD
import com.frogobox.frogoadmobhelper.util.FrogoRvConstant.RECYCLER_VIEW_TYPE_MENU_ITEM
import com.frogobox.frogonewsapi.data.model.Article
import kotlinx.android.synthetic.main.content_item_news.view.*

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
class NewsAdapter : BaseViewAdapter<Any>() {

    inner class FruitViewHolder(view: View) : BaseViewHolder<Any>(view) {

        private val tv_name = view.tv_name
        private val tv_type = view.tv_type
        private val iv_poster = view.iv_poster

        override fun initComponent(data: Any) {
            super.initComponent(data)
            val article = data as Article
            Glide.with(itemView.context).load(article.urlToImage).into(iv_poster)
            tv_name.text = article.title
            tv_type.text = article.description
        }

    }

    inner class AdViewHolder(view: View) : BaseViewHolder<Any>(view) {
        override fun initComponent(data: Any) {
            super.initComponent(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        return when (viewType) {
            RECYCLER_VIEW_TYPE_MENU_ITEM -> {
                FruitViewHolder(viewLayout(parent))
            }
            RECYCLER_VIEW_TYPE_BANNER_AD -> {
                AdViewHolder(viewLayout(parent, R.layout.content_item_ad_banner))
            }
            else -> {
                AdViewHolder(viewLayout(parent, R.layout.content_item_ad_banner))
            }
        }

    }

}