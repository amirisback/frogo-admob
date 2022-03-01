package com.frogobox.appadmob.mvvm.movie

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.frogobox.admob.widget.FrogoAdmobViewHolder
import com.frogobox.appadmob.R
import com.frogobox.coreapi.movie.MovieUrl
import com.frogobox.coreapi.movie.model.TrendingMovie
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
class MovieHolder(view: View) : FrogoAdmobViewHolder<Any>(view) {

    private val tv_name = view.findViewById<TextView>(R.id.tv_name)
    private val tv_type = view.findViewById<TextView>(R.id.tv_type)
    private val iv_poster = view.findViewById<ImageView>(R.id.iv_poster)

    override fun initComponent(
        data: Any,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<Any>
    ) {
        val movie = data as TrendingMovie
        Glide.with(itemView.context).load("${MovieUrl.BASE_URL_IMAGE_ORIGNAL}${movie.poster_path}").into(iv_poster)
        tv_name.text = movie.title
        tv_type.text = movie.overview
    }

}