package com.purnaprasanth.githubrepos.di

import com.purnaprasanth.githubrepos.annotations.GitHub
import com.purnaprasanth.githubrepos.data.datasources.GithubTrendingDataSource
import com.purnaprasanth.githubrepos.data.datasources.ITrendingRepoDataSource
import com.purnaprasanth.githubrepos.github.IGithubServices
import com.purnaprasanth.githubrepos.github.OkhttpGithubServices
import dagger.Binds
import dagger.Module

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

@Module
abstract class NetworkModuleBinds {

    @Binds
    abstract fun bindGithubServices(okhttpService: OkhttpGithubServices): IGithubServices

    @Binds
    @GitHub
    abstract fun bindGitHubDataSource(gitHubTrendingRepoDataSource: GithubTrendingDataSource): ITrendingRepoDataSource
}