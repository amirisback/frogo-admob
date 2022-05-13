package com.frogobox.admob.widget


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.admob.core.FrogoAdmobConstant
import com.frogobox.admob.core.FrogoAdmobConstant.RECYCLER_VIEW_TYPE_BANNER_AD
import com.frogobox.admob.core.FrogoAdmobConstant.RECYCLER_VIEW_TYPE_MENU_ITEM
import com.frogobox.recycler.R
import com.frogobox.recycler.core.FrogoHolder
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener
import com.frogobox.recycler.core.FrogoRecyclerViewListener
import com.frogobox.recycler.core.FrogoRvConstant
import com.frogobox.sdk.ext.showLogDebug


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

@Deprecated("Please re-import to latest package and use the new one")
abstract class FrogoAdmobViewAdapter<T> : RecyclerView.Adapter<FrogoAdmobViewHolder<T>>() {

    protected var viewCallback: IFrogoAdmobViewAdapter<T>? = null
    protected var viewListener: FrogoRecyclerViewListener<T>? = null

    protected val frogoHolder = mutableListOf<FrogoHolder<T>>()
    protected val listData = mutableListOf<T>()
    protected var listCount = 0

    protected var hasEmptyView = false
    protected var layoutRv: Int = 0
    protected var customLayoutRestId: Int = 0
    protected var emptyLayoutResId: Int = R.layout.frogo_rv_container_empty_view

    protected var notifyListener = object : FrogoRecyclerNotifyListener<T> {

        override fun frogoNotifyData(): MutableList<T> {
            return innerFrogoNotifyData()
        }

        override fun frogoNotifyDataSetChanged() {
            innerFrogoNotifyDataSetChanged()
        }

        override fun frogoNotifyItemChanged(data: T, position: Int, payload: Any) {
            innerFrogoNotifyItemChanged(data, position, payload)
        }

        override fun frogoNotifyItemChanged(data: T, position: Int) {
            innerFrogoNotifyItemChanged(data, position)
        }

        override fun frogoNotifyItemInserted(data: T, position: Int) {
            innerFrogoNotifyItemInserted(data, position)
        }

        override fun frogoNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
            innerFrogoNotifyItemMoved(data, fromPosition, toPosition)
        }

        override fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
            innerFrogoNotifyItemRangeChanged(data, positionStart, payload)
        }

        override fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
            innerFrogoNotifyItemRangeChanged(data, positionStart)
        }

        override fun frogoNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
            innerFrogoNotifyItemRangeInserted(data, positionStart)
        }

        override fun frogoNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
            innerFrogoNotifyItemRangeRemoved(positionStart, itemCount)
        }

        override fun frogoNotifyItemRemoved(position: Int) {
            innerFrogoNotifyItemRemoved(position)
        }

    }

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
                holder.bindItem(listData[position], position, viewListener, notifyListener)
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
        return if (position % FrogoAdmobConstant.RECYCLER_VIEW_ITEMS_PER_AD == 0) RECYCLER_VIEW_TYPE_BANNER_AD else RECYCLER_VIEW_TYPE_MENU_ITEM
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
    fun innerFrogoNotifyData(): MutableList<T> {
        return listData
    }

    // Notify Data Set Changed
    fun innerFrogoNotifyDataSetChanged() {
        notifyDataSetChanged()
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyDataSetChanged")
    }

    // Notify Data Item Changed
    fun innerFrogoNotifyItemChanged(data: T, position: Int, payload: Any) {
        listData[position] = data
        notifyItemChanged(position, payload)
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemChanged")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemChanged : ${data.toString()}")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemChanged : $position")
    }

    // Notify Data Item Changed
    fun innerFrogoNotifyItemChanged(data: T, position: Int) {
        listData[position] = data
        notifyItemChanged(position)
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemChanged")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemChanged : ${data.toString()}")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemChanged : $position")
    }

    // Notify Data Item Inserted
    fun innerFrogoNotifyItemInserted(data: T, position: Int) {
        listData.add(position, data)
        notifyItemInserted(position)
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemInserted")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemInserted : ${data.toString()}")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemInserted : $position")
    }

    // Notify Data Item Moved
    fun innerFrogoNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
        listData.removeAt(fromPosition)
        listData.add(toPosition, data)
        notifyItemMoved(fromPosition, toPosition)
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemMoved")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemMoved : ${data.toString()}")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemMoved : $fromPosition")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemMoved : $toPosition")
    }

    // Notify Data Item Range Changed
    fun innerFrogoNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size, payload)
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRangeChanged")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRangeChanged : ${data.toString()}")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRangeChanged : $positionStart")
    }

    // Notify Data Item Range Changed
    fun innerFrogoNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRangeChanged")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRangeChanged : ${data.toString()}")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRangeChanged : $positionStart")
    }

    // Notify Data Item Range Inserted
    fun innerFrogoNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRangeInserted")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRangeChanged : ${data.toString()}")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRangeChanged : $positionStart")
    }

    // Notify Data Item Range Removed
    fun innerFrogoNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
        listData.subList(positionStart, (positionStart + itemCount)).clear()
        notifyItemRangeRemoved(positionStart, itemCount)
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRangeRemoved")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRangeRemoved : $positionStart")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRangeRemoved : $itemCount")
    }

    // Notify Data Item Removed
    fun innerFrogoNotifyItemRemoved(position: Int) {
        listData.removeAt(position)
        notifyItemRemoved(position)
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRemoved")
        showLogDebug("${FrogoRvConstant.FROGO_RV_TAG} - FrogoNotifyListener : frogoNotifyItemRemoved : $position")
    }


}