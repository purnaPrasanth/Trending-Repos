package com.purnaprasanth.githubrepos.data.datasources

import com.purnaprasanth.githubrepos.data.NetworkCallRunner
import com.purnaprasanth.githubrepos.data.NetworkError
import com.purnaprasanth.githubrepos.data.NetworkSuccess
import com.purnaprasanth.githubrepos.data.mappers.GithubTrendingRepoToTrendingRepo
import com.purnaprasanth.githubrepos.github.IGithubRepoService
import com.purnaprasanth.githubrepos.githubRepo1
import com.purnaprasanth.githubrepos.githubRepo2
import com.purnaprasanth.githubrepos.trendingRepo1
import com.purnaprasanth.githubrepos.trendingRepo2
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.io.IOException

/**
 * Created by Purna on 2019-09-21 as a part of GithubRepos
 */

@RunWith(JUnit4::class)
class GithubTrendingDataSourceTest {

    @Mock
    lateinit var githubRepoServices: IGithubRepoService

    private val networkRunner = NetworkCallRunner()

    private val githubTrendingRepoToTrendingRepo = GithubTrendingRepoToTrendingRepo()

    private lateinit var githubTrendingDataSource: GithubTrendingDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        githubTrendingDataSource = GithubTrendingDataSource(
            githubRepoServices,
            networkRunner,
            githubTrendingRepoToTrendingRepo
        )
    }

    @Test
    fun getTrendingReposSuccess() {
        runBlocking {
            `when`(githubRepoServices.getTrendingRepositories()).thenReturn(listOf(githubRepo1, githubRepo2))
            val result = githubTrendingDataSource.getTrendingRepos()

            assert(result is NetworkSuccess)
            assert(result.get() == listOf(trendingRepo1, trendingRepo2))
        }
    }

    @Test
    fun getTrendingReposError() {
        runBlocking {
            `when`(githubRepoServices.getTrendingRepositories()).thenThrow(IOException::class.java)
            val result = githubTrendingDataSource.getTrendingRepos()

            assert(result is NetworkError)
            assert((result as NetworkError).exception is IOException)
        }
    }
}