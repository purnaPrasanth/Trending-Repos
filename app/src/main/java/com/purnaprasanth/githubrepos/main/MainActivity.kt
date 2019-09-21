package com.purnaprasanth.githubrepos.main

import android.util.Log
import androidx.lifecycle.Observer
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

    override fun initUI() {
        trendingRepoViewModel.trendingReposViewState.observe(this, Observer {
            when (it) {
                is ErrorViewState -> {
                    Log.d("MainActivity", it.exception.message.orEmpty())
                    it.exception.printStackTrace()
                }
                is SuccessViewState -> {
                    Log.d("MainActivity", it.data.toString())
                    it.data.toString()
                }
                is LoadingViewState -> {
                    Log.d("MainActivity", "loading")
                }
            }
        })
    }
}
