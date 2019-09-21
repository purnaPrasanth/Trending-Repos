package com.purnaprasanth.githubrepos.data.datasources

import com.purnaprasanth.githubrepos.data.NetworkResult
import com.purnaprasanth.githubrepos.data.model.TrendingRepo

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * A Contract to be implemented by multiple data sources of Trending Repos into the App
 */

interface ITrendingRepoDataSource {

    /**
     * Get Trending Repos from a Repos DataSource
     *
     * @return  [NetworkSuccess] if Data Source succeeds in fetching the data from Source of Data
     * [NetworkError] if Data Source fails in fetching the data from Source of Data
     */
    suspend fun getTrendingRepos(): NetworkResult<List<TrendingRepo>>
}