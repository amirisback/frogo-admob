package com.frogobox.app.ui.news

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.app.R
import com.frogobox.app.core.BaseActivity
import com.frogobox.app.core.FrogoAdmob.RecyclerView.loadRecyclerBannerAds
import com.frogobox.app.databinding.ActivityRecyclerViewBinding
import com.frogobox.frogoconsumeapi.news.ConsumeNewsApi
import com.frogobox.frogoconsumeapi.news.response.ArticleResponse
import com.frogobox.frogoconsumeapi.news.util.NewsConstant
import com.frogobox.frogoconsumeapi.news.util.NewsUrl
import com.frogobox.frogosdk.core.FrogoResponseCallback
import com.frogobox.recycler.core.FrogoRecyclerViewListener

class NewsActivity : BaseActivity<ActivityRecyclerViewBinding>() {

    override fun setupViewBinding(): ActivityRecyclerViewBinding {
        return ActivityRecyclerViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDetailActivity("RecyclerView (1)")
        setupNewsApi()
    }

    private fun setupNewsApi() {
        val consumeNewsApi = ConsumeNewsApi(NewsUrl.API_KEY) // Your API_KEY
        consumeNewsApi.usingChuckInterceptor(this) // Using Chuck Interceptor
        consumeNewsApi.getTopHeadline( // Adding Base Parameter on main function
            null,
            null,
            NewsConstant.CATEGORY_HEALTH,
            NewsConstant.COUNTRY_ID,
            null,
            null,
            object : FrogoResponseCallback<ArticleResponse> {

                override fun onShowProgress() {
                    // Your Progress Show
                }

                override fun onHideProgress() {
                    // Your Progress Hide
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    // Your failed to do
                }

                override fun onSuccess(data: ArticleResponse) {
                    data.articles?.let { arrayFrogoAdmobData.addAll(it) }
                    loadRecyclerBannerAds(this@NewsActivity, arrayFrogoAdmobData)
                    setupRecyclerView()
                }

            })
    }

    private fun setupAdapter(): NewsAdapter {
        val adapter = NewsAdapter()
        adapter.setupRequirement(R.layout.content_item_news, arrayFrogoAdmobData, object : FrogoRecyclerViewListener<Any> {
            override fun onItemClicked(data: Any) {}
            override fun onItemLongClicked(data: Any) {}
        })
        return adapter
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@NewsActivity, LinearLayoutManager.VERTICAL, false)
            adapter = setupAdapter()
        }
    }

}