package com.purnaprasanth.githubrepos.data.mappers

import com.purnaprasanth.githubrepos.data.toListMapper
import com.purnaprasanth.githubrepos.githubRepo1
import com.purnaprasanth.githubrepos.githubRepo2
import com.purnaprasanth.githubrepos.trendingRepo1
import com.purnaprasanth.githubrepos.trendingRepo2
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Purna on 2019-09-21 as a part of GithubRepos
 */

@RunWith(JUnit4::class)
class GithubTrendingRepoToTrendingRepoTest {

    private val gitHubRepo = githubRepo1
    private val trendingRepo = trendingRepo1

    private lateinit var githubTrendingRepoToTrendingRepo: GithubTrendingRepoToTrendingRepo

    @Before
    fun setUP() {
        githubTrendingRepoToTrendingRepo = GithubTrendingRepoToTrendingRepo()
    }

    @Test
    fun map() {
        runBlocking {
            val mappedTrendingRepo = githubTrendingRepoToTrendingRepo.map(gitHubRepo)
            assert(mappedTrendingRepo == trendingRepo)
        }
    }

    @Test
    fun listMap() {
        runBlocking {
            val mappedTrendingRepos =
                githubTrendingRepoToTrendingRepo.toListMapper().map(listOf(githubRepo1, githubRepo2))

            assert(mappedTrendingRepos == listOf(trendingRepo1, trendingRepo2))
        }
    }
}