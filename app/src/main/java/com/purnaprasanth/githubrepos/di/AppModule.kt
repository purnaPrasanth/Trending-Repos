package com.purnaprasanth.githubrepos.di

import android.app.Application
import com.google.gson.Gson
import com.purnaprasanth.githubrepos.connectivity.DetectConnectivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

@Module(includes = [AppModuleBinds::class])
class AppModule {

    @Provides
    @Singleton
    fun provideGSon() = Gson()

    @Provides
    @Singleton
    fun provideDetectConnectivity(application: Application) = DetectConnectivity(application)
}