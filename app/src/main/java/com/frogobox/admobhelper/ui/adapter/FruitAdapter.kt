package com.frogobox.admobhelper.ui.adapter

import android.view.View
import android.view.ViewGroup
import com.frogobox.admobhelper.R
import com.frogobox.admobhelper.base.adapter.BaseViewAdapter
import com.frogobox.admobhelper.base.adapter.BaseViewHolder
import com.frogobox.admobhelper.helper.Constant.Var.RECYCLER_VIEW_TYPE_BANNER_AD
import com.frogobox.admobhelper.helper.Constant.Var.RECYCLER_VIEW_TYPE_MENU_ITEM
import com.frogobox.admobhelper.model.Fruit
import kotlinx.android.synthetic.main.content_item_fruit.view.*

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
class FruitAdapter : BaseViewAdapter<Any>() {

    inner class FruitViewHolder(view: View) : BaseViewHolder<Any>(view) {

        val tv_name = view.tv_name
        val tv_type = view.tv_type

        override fun initComponent(data: Any) {
            super.initComponent(data)

            val fruit = data as Fruit
            tv_name.text = fruit.name
            tv_type.text = fruit.type

        }

    }

    inner class AdViewHolder(view: View) : BaseViewHolder<Any>(view) {
        override fun initComponent(data: Any) {
            super.initComponent(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        return when (viewType) {
            RECYCLER_VIEW_TYPE_MENU_ITEM -> {
                FruitViewHolder(viewLayout(parent))
            }
            RECYCLER_VIEW_TYPE_BANNER_AD -> {
                AdViewHolder(viewLayout(parent, R.layout.content_item_ad_banner))
            }
            else -> {
                AdViewHolder(viewLayout(parent, R.layout.content_item_ad_banner))
            }
        }

    }

}