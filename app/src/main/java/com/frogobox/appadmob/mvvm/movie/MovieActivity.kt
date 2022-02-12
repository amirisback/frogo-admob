package com.frogobox.appadmob.mvvm.movie

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.frogobox.admob.core.FrogoAdmob
import com.frogobox.api.core.ConsumeApiResponse
import com.frogobox.api.movie.ConsumeMovieApi
import com.frogobox.api.movie.model.TrendingMovie
import com.frogobox.api.movie.response.Trending
import com.frogobox.api.movie.util.MovieUrl
import com.frogobox.appadmob.R
import com.frogobox.appadmob.base.BaseActivity
import com.frogobox.appadmob.databinding.ActivityRecyclerViewBinding
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener
import com.frogobox.recycler.core.FrogoRecyclerViewListener

class MovieActivity : BaseActivity<ActivityRecyclerViewBinding>() {

    override fun setupViewBinding(): ActivityRecyclerViewBinding {
        return ActivityRecyclerViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDetailActivity("RecyclerView (2)")
        setupNewsApi()
    }

    private fun setupNewsApi() {
        val consumeMovieApi = ConsumeMovieApi(MovieUrl.API_KEY) // Your API_KEY
        consumeMovieApi.usingChuckInterceptor(this) // Using Chuck Interceptor
        consumeMovieApi.getTrendingMovieWeek( // Adding Base Parameter on main function

            object : ConsumeApiResponse<Trending<TrendingMovie>> {

                override fun onShowProgress() {
                    // Your Progress Show
                }

                override fun onHideProgress() {
                    // Your Progress Hide
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    // Your failed to do
                }

                override fun onSuccess(data: Trending<TrendingMovie>) {
                    data.results?.let { arrayFrogoAdmobData.addAll(it) }
                    FrogoAdmob.RecyclerView.loadRecyclerBannerAds(
                        this@MovieActivity,
                        arrayFrogoAdmobData
                    )
                    setupRecyclerView()
                }

            })
    }

    private fun setupAdapter(): MovieAdapter {
        val adapter = MovieAdapter()
        adapter.setupRequirement(R.layout.content_item_news, arrayFrogoAdmobData, object :
            FrogoRecyclerViewListener<Any> {
            override fun onItemClicked(
                view: View,
                data: Any,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Any>
            ) {
            }

            override fun onItemLongClicked(
                view: View,
                data: Any,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Any>
            ) {
            }
        })
        return adapter
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MovieActivity, 2)
            adapter = setupAdapter()
        }
    }

}