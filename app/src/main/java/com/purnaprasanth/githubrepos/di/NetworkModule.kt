package com.purnaprasanth.githubrepos.di

import android.app.Application
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.purnaprasanth.githubrepos.annotations.IO
import com.purnaprasanth.githubrepos.base.AppDispatchers
import com.purnaprasanth.githubrepos.baseandroid.util.createDefaultCacheDir
import com.purnaprasanth.githubrepos.github.CoilGithubDelegate
import com.purnaprasanth.githubrepos.github.ForceCacheInterceptor
import com.purnaprasanth.githubrepos.github.IGithubServices
import com.purnaprasanth.githubrepos.github.OkhttpGithubServices
import dagger.Module
import dagger.Provides
import okhttp3.Cache
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
    fun provideOkhttp(@IO ioExecutor: Executor, application: Application) = OkHttpClient.Builder()
        .dispatcher(Dispatcher(ioExecutor as ExecutorService))
        .connectTimeout(20, TimeUnit.SECONDS)
        .callTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addNetworkInterceptor(StethoInterceptor())
        .cache(Cache(createDefaultCacheDir(application, "okhttp-cache"), 50 * 1024 * 1024)) // 50MB cache
        .build()

    @Provides
    @Singleton
    fun provideCoilGithubDelegate(
        app: Application,
        okhttp: OkHttpClient,
        appDispatchers: AppDispatchers,
        forceCacheInterceptor: ForceCacheInterceptor
    ) = CoilGithubDelegate(app, okhttp, appDispatchers, forceCacheInterceptor)

    @Provides
    @Singleton
    fun provideOkHttpGithubServices(
        okHttpClient: OkHttpClient,
        gson: Gson,
        forceCacheInterceptor: ForceCacheInterceptor
    ) = OkhttpGithubServices(okHttpClient, gson, forceCacheInterceptor)

    @Provides
    fun provideIGithubTrendingRepoServices(githubServices: IGithubServices) = githubServices.githubRepoServices
}