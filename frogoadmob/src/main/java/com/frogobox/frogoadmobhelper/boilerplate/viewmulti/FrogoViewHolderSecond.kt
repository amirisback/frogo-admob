package com.frogobox.frogoadmobhelper.boilerplate.viewmulti

import android.view.View
import com.frogobox.frogoadmobhelper.base.viewmulti.FrogoRecyclerViewHolderMulti

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
 * com.frogobox.frogoadmobhelper.boilerplate.holder
 * 
 */
class FrogoViewHolderSecond<T>(
    view: View,
    private val frogoViewHolderMultiCallback: FrogoViewHolderMultiCallback<T>
) :
    FrogoRecyclerViewHolderMulti<T>(view) {

    override fun initComponent(data: T) {
        frogoViewHolderMultiCallback.setupInitComponent(itemView, data)
    }

}