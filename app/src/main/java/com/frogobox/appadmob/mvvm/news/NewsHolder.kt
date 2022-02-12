package com.frogobox.appadmob.mvvm.news

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.frogobox.admob.widget.FrogoAdmobViewHolder
import com.frogobox.api.news.model.Article
import com.frogobox.appadmob.R
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener

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
class NewsHolder(view: View) : FrogoAdmobViewHolder<Any>(view) {

    private val tv_name = view.findViewById<TextView>(R.id.tv_name)
    private val tv_type = view.findViewById<TextView>(R.id.tv_type)
    private val iv_poster = view.findViewById<ImageView>(R.id.iv_poster)

    override fun initComponent(
        data: Any,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<Any>
    ) {
        val article = data as Article
        Glide.with(itemView.context).load(article.urlToImage).into(iv_poster)
        tv_name.text = article.title
        tv_type.text = article.description
    }

}