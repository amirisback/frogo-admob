package com.frogobox.admobhelper.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.admobhelper.R
import com.frogobox.admobhelper.base.adapter.BaseViewListener
import com.frogobox.admobhelper.base.ui.BaseActivity
import com.frogobox.admobhelper.model.Fruit
import com.frogobox.admobhelper.ui.adapter.FruitAdapter
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : BaseActivity(), BaseViewListener<Fruit> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setupDetailActivity("")
        setupRecyclerView()
    }

    private fun arrayFruit() : MutableList<Fruit> {
        val dataList = mutableListOf<Fruit>()
        dataList.add(Fruit("Apple", "Fresh"))
        dataList.add(Fruit("Grape", "Fresh"))
        dataList.add(Fruit("Water Melon", "Fresh"))
        dataList.add(Fruit("Blackberry", "Fresh"))
        dataList.add(Fruit("Banana", "Fresh"))
        return dataList
    }

    private fun setupRecyclerView(){
        val adapter = FruitAdapter()
        adapter.setRecyclerViewLayout(this, R.layout.content_item_fruit)
        adapter.setRecyclerViewListener(this)
        adapter.setRecyclerViewData(arrayFruit())
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onItemClicked(data: Fruit) {

    }

    override fun onItemLongClicked(data: Fruit) {

    }
}
