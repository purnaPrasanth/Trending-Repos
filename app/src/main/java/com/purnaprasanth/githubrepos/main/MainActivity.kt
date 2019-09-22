package com.purnaprasanth.githubrepos.main

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.purnaprasanth.githubrepos.R
import com.purnaprasanth.githubrepos.baseandroid.BaseActivity
import com.purnaprasanth.githubrepos.baseandroid.ErrorViewState
import com.purnaprasanth.githubrepos.baseandroid.LoadingViewState
import com.purnaprasanth.githubrepos.baseandroid.SuccessViewState
import com.purnaprasanth.githubrepos.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    @Inject
    lateinit var trendingRepoViewModel: TrendingRepoViewModel

    @Inject
    lateinit var trendingRepoRvAdapter: TrendingRepoRvAdapter

    override fun initUI() {
        binding.trendingRepoList.adapter = trendingRepoRvAdapter
        binding.trendingRepoList.layoutManager = LinearLayoutManager(this)
        trendingRepoViewModel.trendingReposViewState.observe(this, Observer {
            when (it) {
                is ErrorViewState -> {
                    it.exception.printStackTrace()
                }
                is SuccessViewState -> {
                    trendingRepoRvAdapter.submitList(it.data)
                }
                is LoadingViewState -> {
                }
            }
        })
    }
}
