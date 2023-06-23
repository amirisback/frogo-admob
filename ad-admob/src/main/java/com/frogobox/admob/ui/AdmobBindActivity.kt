package com.frogobox.admob.ui

import androidx.viewbinding.ViewBinding

/**
 * Created by Faisal Amir on 07/02/23
 * https://github.com/amirisback
 */


abstract class AdmobBindActivity<VB: ViewBinding> : AdmobActivity()  {

    companion object {
        val TAG: String = AdmobBindActivity::class.java.simpleName
    }

    protected val binding: VB by lazy { setupViewBinding() }

    abstract fun setupViewBinding(): VB

    override fun setupContentView() {
        setContentView(binding.root)
    }

}