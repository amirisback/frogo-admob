package com.frogobox.admob

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.frogobox.admob.util.FrogoRvConstant
import com.frogobox.recycler.R
import com.frogobox.recycler.core.FrogoRecyclerViewListener

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
abstract class FrogoAdmobViewAdapter<T> : CoreAdmobViewAdapter<T>() {

    private var mLayoutRecyclerViewInt: Int = 0
    private var mLayoutCustomViewInt: Int = 0
    private var mLayoutEmptyViewInt: Int = R.layout.frogo_container_empty_view

    private fun verifyViewInt() {
        if (listData.isNotEmpty()) {
            mLayoutRecyclerViewInt = mLayoutCustomViewInt
        } else {
            mLayoutRecyclerViewInt = mLayoutEmptyViewInt
        }
    }

    private fun layoutHandle() {
        if (mLayoutCustomViewInt != 0) {
            verifyViewInt()
        }
    }

    private fun emptyViewHandle() {
        layoutHandle()
        notifyDataSetChanged()
    }

    fun setupEmptyView(emptyView: Int?) {
        hasEmptyView = true
        if (emptyView != null) {
            mLayoutEmptyViewInt = emptyView
        }
        emptyViewHandle()
    }

    fun setupRequirement(
        customViewInt: Int,
        listData: List<T>?,
        listener: FrogoRecyclerViewListener<T>?
    ) {

        if (listener != null) {
            viewListener = listener
        }

        this.listData.clear()
        if (listData != null) {
            this.listData.addAll(listData)
        }

        mLayoutCustomViewInt = customViewInt
        emptyViewHandle()
    }

    fun viewLayout(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(mLayoutRecyclerViewInt, parent, false)
    }

    protected fun viewLayout(parent: ViewGroup, layout: Int): View {
        return LayoutInflater.from(parent.context).inflate(layout, parent, false)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % FrogoRvConstant.RECYCLER_VIEW_ITEMS_PER_AD == 0) FrogoRvConstant.RECYCLER_VIEW_TYPE_BANNER_AD else FrogoRvConstant.RECYCLER_VIEW_TYPE_MENU_ITEM
    }



}