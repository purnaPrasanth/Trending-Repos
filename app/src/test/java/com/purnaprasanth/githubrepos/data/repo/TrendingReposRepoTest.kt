package com.purnaprasanth.githubrepos.data.repo

import com.purnaprasanth.githubrepos.base.AppDispatchers
import com.purnaprasanth.githubrepos.data.NetworkError
import com.purnaprasanth.githubrepos.data.NetworkSuccess
import com.purnaprasanth.githubrepos.data.datasources.ITrendingRepoDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * Created by Purna on 2019-09-21 as a part of GithubRepos
 */

@RunWith(JUnit4::class)
class TrendingReposRepoTest {

    private lateinit var trendingReposRepo: TrendingReposRepo

    @Mock
    lateinit var githubTrendingDataSource: ITrendingRepoDataSource

    private val appDispatchers = AppDispatchers(
        mainDispatcher = Dispatchers.Default,
        commonDispatcher = Dispatchers.Default,
        ioDispatcher = Dispatchers.IO
    )

    @Before
    fun setUP() {
        MockitoAnnotations.initMocks(this)
        trendingReposRepo = TrendingReposRepo(
            githubTrendingDataSource,
            appDispatchers
        )
    }

    @Test
    fun getTrendingReposSuccess() {
        runBlocking {
            `when`(githubTrendingDataSource.getTrendingRepos()).thenReturn(NetworkSuccess(emptyList()))

            val result = trendingReposRepo.getTrendingRepos()

            assert(result is NetworkSuccess)
        }
    }

    @Test
    fun getTrendingError() {
        runBlocking {
            `when`(githubTrendingDataSource.getTrendingRepos()).thenReturn(NetworkError(Exception()))

            val result = trendingReposRepo.getTrendingRepos()

            assert(result is NetworkError)
        }
    }

}