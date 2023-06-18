package com.frogobox.unityad.ui

import androidx.viewbinding.ViewBinding

/**
 * Created by Faisal Amir on 07/02/23
 * https://github.com/amirisback
 */


abstract class UnityAdBindActivity<VB: ViewBinding> : UnityAdActivity() {

    companion object {
        val TAG: String = UnityAdBindActivity::class.java.simpleName
    }

    protected val binding: VB by lazy { setupViewBinding() }

    abstract fun setupViewBinding(): VB

    override fun setupContentView() {
        setContentView(binding.root)
    }

}