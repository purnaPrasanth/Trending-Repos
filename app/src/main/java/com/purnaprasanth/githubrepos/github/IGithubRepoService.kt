package com.purnaprasanth.githubrepos.github

import com.purnaprasanth.githubrepos.github.data.GithubTrendingRepo
import retrofit2.http.GET
import java.io.IOException

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * A contract to fetch repository data from the Github API
 */

interface IGithubRepoService {

    /**
     * to fetch list of trending repositories
     *
     * @return a list of trending repository
     * @throws IOException when it fails to get data from the GitHub API
     */
    @GET("/repositories")
    @Throws(IOException::class)
    suspend fun getTrendingRepositories(): List<GithubTrendingRepo>
}