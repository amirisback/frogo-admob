package com.frogobox.admobhelper.base.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

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

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    open fun bindItem(data: T, viewListener: BaseViewListener<T>){
        onItemViewClicked(data, viewListener)
        initComponent(data)
    }

    private fun onItemViewClicked(data: T, viewListener: BaseViewListener<T>){
        itemView.setOnClickListener {
            viewListener.onItemClicked(data)
        }

        itemView.setOnLongClickListener {
            viewListener.onItemLongClicked(data)
            true
        }
    }

    open fun initComponent(data: T){
        // component view
    }

}