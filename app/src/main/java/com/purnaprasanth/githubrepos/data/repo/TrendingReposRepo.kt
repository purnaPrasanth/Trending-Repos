package com.purnaprasanth.githubrepos.data.repo

import com.purnaprasanth.githubrepos.annotations.GitHub
import com.purnaprasanth.githubrepos.base.AppDispatchers
import com.purnaprasanth.githubrepos.data.datasources.ITrendingRepoDataSource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * A Repository for communication between ViewLayer and the Data Layer
 *
 * @param githubITrendingRepoDataSource a data source to fetch data from github data source
 * @param appDispatchers dispatchers to offload tasks from main thread
 */

@Singleton
class TrendingReposRepo @Inject constructor(
    @GitHub private val githubITrendingRepoDataSource: ITrendingRepoDataSource,
    private val appDispatchers: AppDispatchers
) {
    suspend fun getTrendingRepos() = coroutineScope {
        withContext(appDispatchers.ioDispatcher) {
            githubITrendingRepoDataSource.getTrendingRepos()
        }
    }
}