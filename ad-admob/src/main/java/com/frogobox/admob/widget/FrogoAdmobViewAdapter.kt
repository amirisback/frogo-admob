package com.frogobox.admob.widget


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.adcore.util.FrogoAdConstant
import com.frogobox.adcore.util.FrogoAdConstant.RECYCLER_VIEW_TYPE_BANNER_AD
import com.frogobox.adcore.util.FrogoAdConstant.RECYCLER_VIEW_TYPE_MENU_ITEM
import com.frogobox.recycler.R
import com.frogobox.recycler.core.FrogoHolder
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener
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
 *
 *
 */


abstract class FrogoAdmobViewAdapter<T> : RecyclerView.Adapter<FrogoAdmobViewHolder<T>>(), FrogoRecyclerNotifyListener<T> {

    protected var viewCallback: IFrogoAdmobViewAdapter<T>? = null
    protected var viewListener: FrogoRecyclerViewListener<T>? = null

    protected val frogoHolder = mutableListOf<FrogoHolder<T>>()
    protected val listData = mutableListOf<T>()
    protected var listCount = 0

    protected var hasEmptyView = false
    protected var layoutRv: Int = 0
    protected var customLayoutRestId: Int = 0
    protected var emptyLayoutResId: Int = R.layout.frogo_rv_container_empty_view

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrogoAdmobViewHolder<T> {
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

    override fun onBindViewHolder(holder: FrogoAdmobViewHolder<T>, position: Int) {
        when (getItemViewType(position)) {
            RECYCLER_VIEW_TYPE_MENU_ITEM -> {
                holder.bindItem(listData[position], position, viewListener, this)
            }
            RECYCLER_VIEW_TYPE_BANNER_AD -> {
                holder.bindItemAdView(listData[position])
            }
            else -> {
                holder.bindItemAdView(listData[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % FrogoAdConstant.RECYCLER_VIEW_ITEMS_PER_AD == 0) RECYCLER_VIEW_TYPE_BANNER_AD else RECYCLER_VIEW_TYPE_MENU_ITEM
    }

    protected fun viewLayout(parent: ViewGroup, layout: Int): View {
        return LayoutInflater.from(parent.context).inflate(layout, parent, false)
    }


    private fun verifyViewInt() {
        if (listData.isNotEmpty()) {
            layoutRv = customLayoutRestId
        } else {
            layoutRv = emptyLayoutResId
        }
    }

    private fun layoutHandle() {
        if (customLayoutRestId != 0) {
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
            emptyLayoutResId = emptyView
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

        customLayoutRestId = customViewInt
        emptyViewHandle()
    }

    fun viewLayout(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(layoutRv, parent, false)
    }

    // Notify Data List
    override fun frogoNotifyData(): MutableList<T> {
        return listData
    }

    // Notify Data Set Changed
    override fun frogoNotifyDataSetChanged() {
        notifyDataSetChanged()
    }

    // Notify Data Item Changed
    override fun frogoNotifyItemChanged(data: T, position: Int, payload: Any) {
        listData[position] = data
        notifyItemChanged(position, payload)
    }

    // Notify Data Item Changed
    override fun frogoNotifyItemChanged(data: T, position: Int) {
        listData[position] = data
        notifyItemChanged(position)
    }

    // Notify Data Item Inserted
    override fun frogoNotifyItemInserted(data: T, position: Int) {
        listData.add(position, data)
        notifyItemInserted(position)
    }

    // Notify Data Item Moved
    override fun frogoNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
        listData.removeAt(fromPosition)
        listData.add(toPosition, data)
        notifyItemMoved(fromPosition, toPosition)
    }

    // Notify Data Item Range Changed
    override fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size, payload)
    }

    // Notify Data Item Range Changed
    override fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
    }

    // Notify Data Item Range Inserted
    override fun frogoNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
    }

    // Notify Data Item Range Removed
    override fun frogoNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
        listData.subList(positionStart, (positionStart + itemCount)).clear()
        notifyItemRangeRemoved(positionStart, itemCount)
    }

    // Notify Data Item Removed
    override fun frogoNotifyItemRemoved(item: T) {
        val index = listData.indexOf(item)
        listData.remove(item)
        notifyItemRemoved(index)
    }


}