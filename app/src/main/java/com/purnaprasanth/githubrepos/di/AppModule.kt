package com.purnaprasanth.githubrepos.di

import com.google.gson.Gson
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
}