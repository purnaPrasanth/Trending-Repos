package com.purnaprasanth.githubrepos.di

import android.app.Application
import android.content.Context
import com.purnaprasanth.githubrepos.GithubTrendingRepoApplication
import com.purnaprasanth.githubrepos.annotations.App
import com.purnaprasanth.githubrepos.appinitializers.StethoAppInitializer
import com.purnaprasanth.githubrepos.baseandroid.AppInitializer
import com.purnaprasanth.githubrepos.baseandroid.connectivity.ConnectivityStatus
import com.purnaprasanth.githubrepos.connectivity.DetectConnectivity
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

@Module
abstract class AppModuleBinds {

    @Binds
    @App
    abstract fun bindApplicationContext(application: GithubTrendingRepoApplication): Context

    @Binds
    abstract fun bindApplication(application: GithubTrendingRepoApplication): Application

    @Binds
    abstract fun bindConnectivityStatus(detectConnectivity: DetectConnectivity): ConnectivityStatus

    @Binds
    @IntoSet
    abstract fun provideStethoInitializer(stethoAppInitializer: StethoAppInitializer): AppInitializer
}