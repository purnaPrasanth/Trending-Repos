package com.purnaprasanth.githubrepos

import com.purnaprasanth.githubrepos.appinitializers.AppInitializers
import com.purnaprasanth.githubrepos.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

class GithubTrendingRepoApplication : DaggerApplication() {

    @Inject
    lateinit var initializers: AppInitializers

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()

        initializers.init(this)
    }
}