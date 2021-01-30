package com.frogobox.frogoadmobhelper.boilerplate.viewrclass

import android.view.View
import com.frogobox.frogoadmobhelper.base.viewrclass.FrogoRecyclerViewHolder

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 26/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.frogoadmobhelper
 * 
 */
class FrogoViewHolder<T>(view: View, private val frogoViewHolderCallback: FrogoViewHolderCallback<T>) :
    FrogoRecyclerViewHolder<T>(view) {

    override fun initComponent(data: T) {
        frogoViewHolderCallback.setupInitComponent(itemView, data)
    }

}