package com.frogobox.frogoadmobhelper.boilerplate.viewrclass

import com.frogobox.frogoadmobhelper.widget.FrogoAdmobRecyclerView

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 27/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.frogoadmobhelper.util
 * 
 */
interface IFrogoRvSingletonRclass<T> {

    fun initSingleton(frogoAdmobRecyclerView: FrogoAdmobRecyclerView): FrogoRvSingletonRclass<T>

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingletonRclass<T>

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingletonRclass<T>

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingletonRclass<T>

    fun createLayoutGrid(spanCount: Int): FrogoRvSingletonRclass<T>

    fun addData(listData: List<T>): FrogoRvSingletonRclass<T>

    fun addCustomView(customViewInt: Int): FrogoRvSingletonRclass<T>

    fun addEmptyView(emptyViewInt: Int?): FrogoRvSingletonRclass<T>

    fun addCallback(frogoViewAdapterCallback: FrogoViewAdapterCallback<T>): FrogoRvSingletonRclass<T>

    fun build(): FrogoRvSingletonRclass<T>

}