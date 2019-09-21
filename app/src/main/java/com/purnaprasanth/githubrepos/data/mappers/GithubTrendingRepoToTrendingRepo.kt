package com.purnaprasanth.githubrepos.data.mappers

import com.purnaprasanth.githubrepos.data.Mapper
import com.purnaprasanth.githubrepos.data.model.TrendingRepo
import com.purnaprasanth.githubrepos.github.data.GithubTrendingRepo
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * A mapper to map GithubRepo data [GithubTrendingRepo] to the contract that app depends on [TrendingRepo]
 */

class GithubTrendingRepoToTrendingRepo @Inject constructor() : Mapper<GithubTrendingRepo, TrendingRepo> {
    override suspend fun map(from: GithubTrendingRepo) = TrendingRepo(
        author = from.author,
        name = from.name,
        avatar = from.avatar,
        url = from.url,
        description = from.description,
        stars = from.stars,
        fork = from.forks,
        language = from.language,
        languageColor = from.languageColor
    )
}