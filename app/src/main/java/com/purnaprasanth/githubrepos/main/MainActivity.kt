package com.purnaprasanth.githubrepos.main

import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.purnaprasanth.githubrepos.R
import com.purnaprasanth.githubrepos.baseandroid.BaseActivity
import com.purnaprasanth.githubrepos.baseandroid.ErrorViewState
import com.purnaprasanth.githubrepos.baseandroid.LoadingViewState
import com.purnaprasanth.githubrepos.baseandroid.SuccessViewState
import com.purnaprasanth.githubrepos.databinding.ActivityMainBinding
import com.purnaprasanth.githubrepos.view.RetryListener
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main),
    SwipeRefreshLayout.OnRefreshListener, RetryListener {

    private val trendingRepoViewModel: TrendingRepoViewModel by lazy {
        viewModelProvider.get(TrendingRepoViewModel::class.java)
    }

    @Inject
    lateinit var trendingRepoRvAdapter: TrendingRepoRvAdapter

    override fun initUI() {
        binding.trendingRepoList.adapter = trendingRepoRvAdapter
        binding.trendingRepoList.layoutManager = LinearLayoutManager(this)
        binding.pullToRefresh.setOnRefreshListener(this)
        binding.errorView.retryListener = this
        binding.toolbar.toolbarTitle.text = getString(R.string.trending)
        Log.d("MainActivity", trendingRepoViewModel.toString())
        trendingRepoViewModel.trendingReposViewState.observe(this, Observer {
            when (it) {
                is ErrorViewState -> {
                    binding.pullToRefresh.isRefreshing = true
                    binding.pullToRefresh.visibility = GONE
                    binding.errorView.visibility = VISIBLE
                }
                is SuccessViewState -> {
                    binding.pullToRefresh.isRefreshing = false
                    trendingRepoRvAdapter.submitList(it.data)
                    binding.pullToRefresh.visibility = VISIBLE
                    binding.errorView.visibility = GONE
                }
                is LoadingViewState -> {
                    binding.pullToRefresh.isRefreshing = true
                    binding.pullToRefresh.visibility = VISIBLE
                    binding.errorView.visibility = GONE
                }
            }
        })
    }

    override fun onRefresh() {
        trendingRepoViewModel.getTrendingRepo()
    }

    override fun onRetry() {
        trendingRepoViewModel.getTrendingRepo()
    }
}
