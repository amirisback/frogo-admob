package com.frogobox.admobhelper.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.admobhelper.R
import com.frogobox.admobhelper.base.adapter.BaseViewListener
import com.frogobox.admobhelper.base.ui.BaseActivity
import com.frogobox.admobhelper.model.Fruit
import com.frogobox.admobhelper.ui.adapter.FruitAdapter
import com.frogobox.frogoadmobhelper.FrogoAdmobHelper.RecyclerView.loadRecyclerBannerAds
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : BaseActivity(), BaseViewListener<Any> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        setupDetailActivity("")
        createArrayFruit()
        setupRecyclerView()
    }

    private fun createArrayFruit() {
        arrayFrogoAdmobData.add(Fruit("Apple", "Fresh"))
        arrayFrogoAdmobData.add(Fruit("Grape", "Fresh"))
        arrayFrogoAdmobData.add(Fruit("Water Melon", "Fresh"))
        arrayFrogoAdmobData.add(Fruit("Blackberry", "Fresh"))
        arrayFrogoAdmobData.add(Fruit("Banana", "Fresh"))
        loadRecyclerBannerAds(this, arrayFrogoAdmobData)
    }

    private fun setupAdapter(): FruitAdapter {
        val adapter = FruitAdapter()
        adapter.setupRequirement(this, arrayFrogoAdmobData, R.layout.content_item_fruit)
        return adapter
    }

    private fun setupRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = setupAdapter()
    }

    override fun onItemClicked(data: Any) {}

    override fun onItemLongClicked(data: Any) {}

}