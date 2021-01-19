package com.frogobox.admobhelper.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.admobhelper.R
import com.frogobox.admobhelper.base.adapter.BaseViewListener
import com.frogobox.admobhelper.base.ui.BaseActivityRecycler
import com.frogobox.admobhelper.model.Fruit
import com.frogobox.admobhelper.ui.adapter.FruitAdapter
import com.frogobox.frogoadmobhelper.FrogoAdmobHelper.RecyclerView.loadRecyclerBannerAds
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : BaseActivityRecycler(), BaseViewListener<Any> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setupDetailActivity("")

        createArrayFruit()
        loadRecyclerBannerAds(this, arrayRecyclerView)

        setupRecyclerView()
    }

    private fun createArrayFruit() {
        arrayRecyclerView.add(Fruit("Apple", "Fresh"))
        arrayRecyclerView.add(Fruit("Grape", "Fresh"))
        arrayRecyclerView.add(Fruit("Water Melon", "Fresh"))
        arrayRecyclerView.add(Fruit("Blackberry", "Fresh"))
        arrayRecyclerView.add(Fruit("Banana", "Fresh"))
    }

    private fun setupAdapter(): FruitAdapter {
        val adapter = FruitAdapter()
        adapter.setupRequirement(this, arrayRecyclerView, R.layout.content_item_fruit)
        return adapter
    }

    private fun setupRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = setupAdapter()
    }

    override fun onItemClicked(data: Any) {}

    override fun onItemLongClicked(data: Any) {}

}