package com.frogobox.admob


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.admob.util.FrogoRvConstant.RECYCLER_VIEW_TYPE_BANNER_AD
import com.frogobox.admob.util.FrogoRvConstant.RECYCLER_VIEW_TYPE_MENU_ITEM
import com.frogobox.recycler.core.FrogoRecyclerViewListener


/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * SpeechBooster
 * Copyright (C) 10/09/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.speechbooster.base
 *
 */

abstract class CoreAdmobViewAdapter<T> : RecyclerView.Adapter<CoreAdmobViewHolder<T>>() {

    protected var viewListener: FrogoRecyclerViewListener<T>? = null
    protected var hasEmptyView = false
    protected var viewCallback: CoreAdmobViewAdapterCallback<T>? = null

    protected val listData = mutableListOf<T>()
    protected var listCount = 0

    override fun getItemCount(): Int {
        return if (hasEmptyView) {
            listCount = if (listData.size == 0) {
                1
            } else {
                listData.size
            }
            listCount
        } else {
            listData.size
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoreAdmobViewHolder<T> {
        return when (viewType) {
            RECYCLER_VIEW_TYPE_MENU_ITEM -> {
                viewCallback!!.onViewTypeMenuItem(parent)
            }
            RECYCLER_VIEW_TYPE_BANNER_AD -> {
                viewCallback!!.onViewTypeBannerAds(parent)
            }
            else -> {
                viewCallback!!.onViewTypeBannerAds(parent)
            }
        }

    }

    override fun onBindViewHolder(holder: CoreAdmobViewHolder<T>, position: Int) {
        when (getItemViewType(position)) {
            RECYCLER_VIEW_TYPE_MENU_ITEM -> {
                holder.bindItem(listData[position], viewListener)
            }
            RECYCLER_VIEW_TYPE_BANNER_AD -> {
                holder.bindItemAdView(listData[position])
            }
            else -> {
                holder.bindItemAdView(listData[position])
            }
        }
    }

}