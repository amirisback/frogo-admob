package com.frogobox.admobhelper.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.frogobox.admobhelper.base.adapter.BaseViewAdapter
import com.frogobox.admobhelper.base.adapter.BaseViewHolder
import com.frogobox.admobhelper.base.adapter.BaseViewListener
import com.frogobox.admobhelper.model.Fruit

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 27/11/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.admobhelper.ui.adapter
 *
 */
class FruitAdapter : BaseViewAdapter<Fruit, FruitAdapter.FruitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FruitViewHolder(
            LayoutInflater.from(mContext).inflate(
                mRecyclerViewLayout,
                parent,
                false
            )
        )

    inner class FruitViewHolder(view: View) : BaseViewHolder<Fruit>(view) {

        override fun initComponent(data: Fruit) {
            super.initComponent(data)
        }

    }


}