package com.frogobox.admobsample.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.frogobox.admobsample.R
import com.frogobox.admobsample.base.BaseActivity
import com.frogobox.admobsample.ui.adapter.NewsAdapter
import com.frogobox.admob.core.FrogoAdmob
import com.frogobox.frogonewsapi.ConsumeNewsApi
import com.frogobox.frogonewsapi.callback.NewsResultCallback
import com.frogobox.frogonewsapi.data.response.ArticleResponse
import com.frogobox.frogonewsapi.util.NewsConstant
import com.frogobox.frogonewsapi.util.NewsUrl
import com.frogobox.recycler.core.FrogoRecyclerViewListener

class MovieActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(recyclerViewBinding.root)
        setupDetailActivity("RecyclerView (2)")
        setupNewsApi()
    }

    private fun setupNewsApi() {
        val consumeNewsApi = ConsumeNewsApi(NewsUrl.NEWS_API_KEY) // Your API_KEY
        consumeNewsApi.usingChuckInterceptor(this) // Using Chuck Interceptor
        consumeNewsApi.getTopHeadline( // Adding Base Parameter on main function
            null,
            null,
            NewsConstant.CATEGORY_HEALTH,
            NewsConstant.COUNTRY_ID,
            null,
            null,
            object : NewsResultCallback<ArticleResponse> {
                override fun getResultData(data: ArticleResponse) {
                    data.articles?.let { arrayFrogoAdmobData.addAll(it) }
                    FrogoAdmob.RecyclerView.loadRecyclerBannerAds(
                        this@MovieActivity,
                        arrayFrogoAdmobData
                    )
                    setupRecyclerView()
                }

                override fun failedResult(statusCode: Int, errorMessage: String?) {
                    // Your failed to do
                }

                override fun onShowProgress() {
                    // Your Progress Show
                }

                override fun onHideProgress() {
                    // Your Progress Hide
                }

            })
    }

    private fun setupAdapter(): NewsAdapter {
        val adapter = NewsAdapter()
        adapter.setupRequirement(R.layout.content_item_news, arrayFrogoAdmobData, object :
            FrogoRecyclerViewListener<Any> {
            override fun onItemClicked(data: Any) {}
            override fun onItemLongClicked(data: Any) {}
        })
        return adapter
    }

    private fun setupRecyclerView() {
        recyclerViewBinding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MovieActivity, 2)
            adapter = setupAdapter()
        }
    }

}