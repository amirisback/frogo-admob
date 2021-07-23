package com.frogobox.app.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.frogobox.app.core.BaseFragment
import com.frogobox.app.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }


}
