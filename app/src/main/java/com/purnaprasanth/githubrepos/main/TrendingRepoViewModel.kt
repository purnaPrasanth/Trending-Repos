package com.purnaprasanth.githubrepos.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.purnaprasanth.githubrepos.base.AppDispatchers
import com.purnaprasanth.githubrepos.baseandroid.*
import com.purnaprasanth.githubrepos.data.NetworkError
import com.purnaprasanth.githubrepos.data.NetworkSuccess
import com.purnaprasanth.githubrepos.data.model.TrendingRepo
import com.purnaprasanth.githubrepos.data.repo.TrendingReposRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

class TrendingRepoViewModel @Inject constructor(
    application: Application,
    appDispatchers: AppDispatchers,
    private val trendingReposRepo: TrendingReposRepo
) : BaseViewModel(application, appDispatchers) {

    private val _trendingReposViewState = MutableLiveData<ViewState<List<TrendingRepo>>>()

    val trendingReposViewState: LiveData<ViewState<List<TrendingRepo>>>
        get() = _trendingReposViewState

    init {
        getTrendingRepo()
    }

    fun getTrendingRepo() {
        launch(appDispatchers.mainDispatcher) {
            _trendingReposViewState.value = (LoadingViewState())
            when (val result = trendingReposRepo.getTrendingRepos()) {
                is NetworkSuccess -> {
                    _trendingReposViewState.value = (SuccessViewState(result.data))
                }
                is NetworkError -> {
                    _trendingReposViewState.value = (ErrorViewState(result.exception))
                }
            }
        }
    }
}