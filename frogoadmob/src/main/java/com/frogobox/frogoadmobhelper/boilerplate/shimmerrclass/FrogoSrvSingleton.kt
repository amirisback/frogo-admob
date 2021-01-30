package com.frogobox.frogoadmobhelper.boilerplate.shimmerrclass

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.frogobox.frogoadmobhelper.R
import com.frogobox.frogoadmobhelper.base.parent.FrogoRecyclerViewListener
import com.frogobox.frogoadmobhelper.boilerplate.viewrclass.FrogoViewAdapter
import com.frogobox.frogoadmobhelper.boilerplate.viewrclass.FrogoViewAdapterCallback
import com.frogobox.frogoadmobhelper.boilerplate.viewrclass.FrogoViewHolderCallback
import com.frogobox.frogoadmobhelper.util.FrogoRvConstant
import com.frogobox.frogoadmobhelper.widget.FrogoAdmobRecyclerView

/*
 * Created by Faisal Amir on 02/06/2020
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

class FrogoSrvSingleton<T> : IFrogoSrvSingleton<T> {

    private lateinit var mFrogoAdmobRecyclerView: FrogoAdmobRecyclerView
    private lateinit var rvFrogoAdapterCallback: FrogoViewAdapterCallback<T>
    private lateinit var rvFrogoViewAdapter: FrogoViewAdapter<T>

    private lateinit var mFrogoShimmerAdmobRecyclerView: FrogoAdmobRecyclerView
    private lateinit var srvFrogoAdapterCallback: FrogoViewAdapterCallback<String>
    private lateinit var srvFrogoViewAdapter: FrogoViewAdapter<String>

    private var emptyViewInt: Int = R.layout.frogo_container_empty_view
    private var layoutSpanCount = 0
    private var optionLayoutManager = ""
    private var optionDividerItem = false
    private var optionAdapter = ""

    private var rvCustomViewInt: Int = 0
    private var rvListData: List<T>? = null

    private var srvSumListItem: Int = 2
    private var srvCustomViewInt: Int = 0

    private fun srvListData(): MutableList<String> {
        val listdata = mutableListOf<String>()
        for (i in 1..srvSumListItem) {
            listdata.add("place-holder-shimmer")
        }
        return listdata
    }

    override fun initSingleton(
        frogoAdmobRecyclerView: FrogoAdmobRecyclerView,
        frogoShimmerAdmobRecyclerView: FrogoAdmobRecyclerView
    ): FrogoSrvSingleton<T> {
        mFrogoAdmobRecyclerView = frogoAdmobRecyclerView
        mFrogoShimmerAdmobRecyclerView = frogoShimmerAdmobRecyclerView
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSrvSingleton<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSrvSingleton<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoSrvSingleton<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoSrvSingleton<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun addData(listData: List<T>): FrogoSrvSingleton<T> {
        rvListData = listData
        Log.d("injector-listData", rvListData.toString())
        return this
    }

    override fun addCustomView(customViewInt: Int): FrogoSrvSingleton<T> {
        rvCustomViewInt = customViewInt
        Log.d("injector-customView", rvCustomViewInt.toString())
        return this
    }

    override fun addEmptyView(emptyViewInt: Int?): FrogoSrvSingleton<T> {
        if (emptyViewInt != null) this.emptyViewInt = emptyViewInt
        Log.d("injector-emptyView", this.emptyViewInt.toString())
        return this
    }

    override fun addCallback(frogoViewAdapterCallback: FrogoViewAdapterCallback<T>): FrogoSrvSingleton<T> {
        rvFrogoAdapterCallback = frogoViewAdapterCallback
        Log.d("injector-adaptCallback", rvFrogoAdapterCallback.toString())
        return this
    }

    override fun addShimmerViewPlaceHolder(customViewInt: Int): FrogoSrvSingleton<T> {
        srvCustomViewInt = customViewInt
        Log.d("injector-shimmerView", srvCustomViewInt.toString())
        return this
    }

    override fun addShimmerSumOfItemLoading(sumItem: Int): FrogoSrvSingleton<T> {
        srvSumListItem = sumItem
        Log.d("injector-sumItem", srvSumListItem.toString())
        return this
    }

    private fun setupLayoutManager() {
        Log.d("injector-option", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        Log.d("injector-spanCount", layoutSpanCount.toString())

        if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_VERTICAL)) {
            mFrogoAdmobRecyclerView.layoutManager = LinearLayoutManager(mFrogoAdmobRecyclerView.context, LinearLayoutManager.VERTICAL, false)
            mFrogoShimmerAdmobRecyclerView.layoutManager = LinearLayoutManager(mFrogoShimmerAdmobRecyclerView.context, LinearLayoutManager.VERTICAL, false)
            if (optionDividerItem) {
                mFrogoAdmobRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoAdmobRecyclerView.context, LinearLayoutManager.VERTICAL))
                mFrogoShimmerAdmobRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoShimmerAdmobRecyclerView.context, LinearLayoutManager.VERTICAL))
            }
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL)) {
            mFrogoAdmobRecyclerView.layoutManager = LinearLayoutManager(mFrogoAdmobRecyclerView.context, LinearLayoutManager.HORIZONTAL, false)
            mFrogoShimmerAdmobRecyclerView.layoutManager = LinearLayoutManager(mFrogoShimmerAdmobRecyclerView.context, LinearLayoutManager.HORIZONTAL, false)
            if (optionDividerItem) {
                mFrogoAdmobRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoAdmobRecyclerView.context, LinearLayoutManager.HORIZONTAL))
                mFrogoShimmerAdmobRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoShimmerAdmobRecyclerView.context, LinearLayoutManager.HORIZONTAL))
            }
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_STAGGERED_GRID)) {
            mFrogoAdmobRecyclerView.layoutManager = StaggeredGridLayoutManager(layoutSpanCount, StaggeredGridLayoutManager.VERTICAL)
            mFrogoShimmerAdmobRecyclerView.layoutManager = StaggeredGridLayoutManager(layoutSpanCount, StaggeredGridLayoutManager.VERTICAL)
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_GRID)) {
            mFrogoAdmobRecyclerView.layoutManager = GridLayoutManager(mFrogoAdmobRecyclerView.context, layoutSpanCount)
            mFrogoShimmerAdmobRecyclerView.layoutManager = GridLayoutManager(mFrogoShimmerAdmobRecyclerView.context, layoutSpanCount)
        }

    }

    private fun createRvAdapter() {
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS
        rvFrogoViewAdapter = FrogoViewAdapter(object : FrogoViewHolderCallback<T> {
                override fun setupInitComponent(view: View, data: T) {
                    rvFrogoAdapterCallback.setupInitComponent(view, data)
                }
            })

        rvFrogoViewAdapter.setupRequirement(rvCustomViewInt, rvListData,
            object :
                FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    rvFrogoAdapterCallback.onItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    rvFrogoAdapterCallback.onItemLongClicked(data)
                }
            })

        rvFrogoViewAdapter.setupEmptyView(emptyViewInt)

    }

    private fun createShimmerRvAdapter() {
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS

        srvFrogoAdapterCallback = object : FrogoViewAdapterCallback<String>{
            override fun setupInitComponent(view: View, data: String) {}
            override fun onItemClicked(data: String) {}
            override fun onItemLongClicked(data: String) {}
        }

        srvFrogoViewAdapter = FrogoViewAdapter(object : FrogoViewHolderCallback<String> {
            override fun setupInitComponent(view: View, data: String) {
                srvFrogoAdapterCallback.setupInitComponent(view, data)
            }
        })

        srvFrogoViewAdapter.setupRequirement(srvCustomViewInt, srvListData(),
            object :
                FrogoRecyclerViewListener<String> {
                override fun onItemClicked(data: String) {
                    srvFrogoAdapterCallback.onItemClicked(data)
                }

                override fun onItemLongClicked(data: String) {
                    srvFrogoAdapterCallback.onItemLongClicked(data)
                }
            })

        srvFrogoViewAdapter.setupEmptyView(emptyViewInt)
    }

    private fun setupInnerAdapter() {
        Log.d("injector-optionAdapter", optionAdapter)
        mFrogoAdmobRecyclerView.adapter = rvFrogoViewAdapter
        mFrogoShimmerAdmobRecyclerView.adapter = srvFrogoViewAdapter
    }

    override fun build(): FrogoSrvSingleton<T> {
        createRvAdapter()
        createShimmerRvAdapter()
        setupLayoutManager()
        setupInnerAdapter()
        return this
    }
}