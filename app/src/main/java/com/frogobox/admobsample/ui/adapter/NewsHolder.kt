package com.frogobox.admobsample.ui.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.frogobox.admob.CoreAdmobViewHolder
import com.frogobox.frogonewsapi.data.model.Article
import kotlinx.android.synthetic.main.content_item_news.view.*

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
class NewsHolder(view: View) : CoreAdmobViewHolder<Any>(view) {

    private val tv_name = view.tv_name
    private val tv_type = view.tv_type
    private val iv_poster = view.iv_poster

    override fun initComponent(data: Any) {
        val article = data as Article
        Glide.with(itemView.context).load(article.urlToImage).into(iv_poster)
        tv_name.text = article.title
        tv_type.text = article.description
    }

}