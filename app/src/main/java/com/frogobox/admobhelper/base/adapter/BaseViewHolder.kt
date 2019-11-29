package com.frogobox.admobhelper.base.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdView

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
 * com.frogobox.speechbooster.cheery
 *
 */

open class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    fun bindItem(data: T, viewListener: BaseViewListener<T>) {
        onItemViewClicked(data, viewListener)
        initComponent(data)
    }

    fun bindItemAdd(data: T) {
        val adView = data as AdView
        val adCardView = itemView as ViewGroup

        if (adCardView.childCount > 0) {
            adCardView.removeAllViews()
        }
        if (adView.parent != null) {
            (adView.parent as ViewGroup).removeView(adView)
        }

        adCardView.addView(adView)
    }

    private fun onItemViewClicked(data: T, viewListener: BaseViewListener<T>) {
        itemView.setOnClickListener {
            viewListener.onItemClicked(data)
        }

        itemView.setOnLongClickListener {
            viewListener.onItemLongClicked(data)
            true
        }
    }

    open fun initComponent(data: T) {
        // component view
    }

}