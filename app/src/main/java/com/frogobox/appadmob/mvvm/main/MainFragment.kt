package com.frogobox.appadmob.mvvm.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.frogobox.appadmob.base.BaseFragment
import com.frogobox.appadmob.databinding.FragmentMainBinding

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
