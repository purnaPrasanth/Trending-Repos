package com.purnaprasanth.githubrepos.di

import com.purnaprasanth.githubrepos.GithubTrendingRepoApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        NetworkModule::class,
        ExecutorsModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<GithubTrendingRepoApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: GithubTrendingRepoApplication): AppComponent
    }
}