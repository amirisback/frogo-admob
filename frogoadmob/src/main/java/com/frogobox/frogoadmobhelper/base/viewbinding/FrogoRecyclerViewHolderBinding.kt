package com.frogobox.frogoadmobhelper.base.viewbinding

import androidx.viewbinding.ViewBinding
import com.frogobox.frogoadmobhelper.base.parent.ParentFrogoRecyclerViewHolder

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 29/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.frogoadmobhelper.base
 * 
 */
abstract class FrogoRecyclerViewHolderBinding<T, V : ViewBinding>(viewBinding: V) :
    ParentFrogoRecyclerViewHolder<T>(viewBinding.root) {

}