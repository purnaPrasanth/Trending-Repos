package com.purnaprasanth.githubrepos.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.purnaprasanth.githubrepos.annotations.IO
import com.purnaprasanth.githubrepos.github.IGithubServices
import com.purnaprasanth.githubrepos.github.OkhttpGithubServices
import dagger.Module
import dagger.Provides
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

@Module(includes = [NetworkModuleBinds::class])
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkhttp(@IO ioExecutor: Executor) = OkHttpClient.Builder()
        .dispatcher(Dispatcher(ioExecutor as ExecutorService))
        .connectTimeout(20, TimeUnit.SECONDS)
        .callTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addNetworkInterceptor(StethoInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideOkHttpGithubServices(okHttpClient: OkHttpClient, gson: Gson) = OkhttpGithubServices(okHttpClient, gson)

    @Provides
    fun provideIGithubTrendingRepoServices(githubServices: IGithubServices) = githubServices.githubRepoServices
}