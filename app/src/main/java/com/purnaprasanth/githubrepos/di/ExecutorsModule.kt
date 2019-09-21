package com.purnaprasanth.githubrepos.di

import com.purnaprasanth.githubrepos.annotations.Common
import com.purnaprasanth.githubrepos.annotations.IO
import com.purnaprasanth.githubrepos.annotations.Main
import com.purnaprasanth.githubrepos.async.CommonExecutor
import com.purnaprasanth.githubrepos.async.IOExecutor
import com.purnaprasanth.githubrepos.async.MainThreadExecutor
import com.purnaprasanth.githubrepos.base.AppDispatchers
import com.purnaprasanth.githubrepos.base.AppExecutors
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.asCoroutineDispatcher
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

@Module
class ExecutorsModule {

    @Provides
    @Singleton
    fun provideAppExecutors(
        mainExecutor: MainThreadExecutor,
        ioExecutor: IOExecutor,
        commonExecutor: CommonExecutor
    ): AppExecutors {
        return AppExecutors(
            mainExecutor = mainExecutor.executor,
            ioExecutor = ioExecutor.executor,
            commonExecutor = commonExecutor.executor
        )
    }

    @Provides
    @Singleton
    fun provideAppDispatchers(appExecutors: AppExecutors): AppDispatchers {
        return AppDispatchers(
            mainDispatcher = appExecutors.mainExecutor.asCoroutineDispatcher(),
            ioDispatcher = appExecutors.ioExecutor.asCoroutineDispatcher(),
            commonDispatcher = appExecutors.commonExecutor.asCoroutineDispatcher()
        )
    }

    @Provides
    @IO
    fun provideIODispatcher(appDispatchers: AppDispatchers) = appDispatchers.ioDispatcher

    @Provides
    @Common
    fun provideCommonDispatcher(appDispatchers: AppDispatchers) = appDispatchers.commonDispatcher

    @Provides
    @Main
    fun provideMainDispatcher(appDispatchers: AppDispatchers) = appDispatchers.mainDispatcher

    @Provides
    @IO
    fun provideIOExecutor(appExecutors: AppExecutors) = appExecutors.ioExecutor

    @Provides
    @Common
    fun provideCommonExecutor(appExecutors: AppExecutors) = appExecutors.commonExecutor

    @Provides
    @Main
    fun provideMainExecutor(appExecutors: AppExecutors) = appExecutors.mainExecutor
}