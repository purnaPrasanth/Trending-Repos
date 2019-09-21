package com.purnaprasanth.githubrepos.data.datasources

import com.purnaprasanth.githubrepos.data.NetworkCallRunner
import com.purnaprasanth.githubrepos.data.NetworkResult
import com.purnaprasanth.githubrepos.data.mappers.GithubTrendingRepoToTrendingRepo
import com.purnaprasanth.githubrepos.data.model.TrendingRepo
import com.purnaprasanth.githubrepos.data.toListMapper
import com.purnaprasanth.githubrepos.github.IGithubRepoService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * A [ITrendingRepoDataSource] implementation to fetch data from GithubRepo
 *
 * @param githubIGithubRepoService An Implementation of [IGithubRepoService] to communicate with Github API
 * @param networkCallRunner [NetworkCallRunner] to run a network call
 * @param githubTrendingRepoToTrendingRepo a mapper to map GithubRepo data to the contract that app depends on [TrendingRepo]
 */

@Singleton
class GithubTrendingDataSource @Inject constructor(
    private val githubIGithubRepoService: IGithubRepoService,
    private val networkCallRunner: NetworkCallRunner,
    private val githubTrendingRepoToTrendingRepo: GithubTrendingRepoToTrendingRepo
) : ITrendingRepoDataSource {
    override suspend fun getTrendingRepos(): NetworkResult<List<TrendingRepo>> {
        return networkCallRunner.executeForResponse(
            mapper = githubTrendingRepoToTrendingRepo.toListMapper(),
            request = { githubIGithubRepoService.getTrendingRepositories() }
        )
    }
}