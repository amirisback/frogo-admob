package com.frogobox.admobhelper.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.frogoadmobhelper.util.FrogoRvConstant.RECYCLER_VIEW_ITEMS_PER_AD
import com.frogobox.frogoadmobhelper.util.FrogoRvConstant.RECYCLER_VIEW_TYPE_BANNER_AD
import com.frogobox.frogoadmobhelper.util.FrogoRvConstant.RECYCLER_VIEW_TYPE_MENU_ITEM


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

abstract class BaseViewAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    private lateinit var mViewListener: BaseViewListener<T>

    private val mRecyclerViewDataList = mutableListOf<T>()
    private var mRecyclerViewLayout: Int = 0

    fun setupRequirement(dataList: List<T>, layoutItem: Int, viewListener: BaseViewListener<T>) {

        mRecyclerViewLayout = layoutItem
        mViewListener = viewListener

        mRecyclerViewDataList.clear()
        mRecyclerViewDataList.addAll(dataList)
        notifyDataSetChanged()
    }

    protected fun viewLayout(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(mRecyclerViewLayout, parent, false)
    }

    protected fun viewLayout(parent: ViewGroup, layout: Int): View {
        return LayoutInflater.from(parent.context).inflate(layout, parent, false)
    }

    override fun getItemCount(): Int = mRecyclerViewDataList.size

    override fun getItemViewType(position: Int): Int {
        return if (position % RECYCLER_VIEW_ITEMS_PER_AD == 0) RECYCLER_VIEW_TYPE_BANNER_AD else RECYCLER_VIEW_TYPE_MENU_ITEM
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        when (getItemViewType(position)) {
            RECYCLER_VIEW_TYPE_MENU_ITEM -> {
                holder.bindItem(mRecyclerViewDataList[position], mViewListener)
            }
            RECYCLER_VIEW_TYPE_BANNER_AD -> {
                holder.bindItemAdd(mRecyclerViewDataList[position])
            }
            else -> {
                holder.bindItemAdd(mRecyclerViewDataList[position])
            }
        }
    }


}