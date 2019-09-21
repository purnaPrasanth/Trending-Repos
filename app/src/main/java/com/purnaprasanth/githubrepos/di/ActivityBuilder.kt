package com.purnaprasanth.githubrepos.di

import com.purnaprasanth.githubrepos.main.MainActivity
import com.purnaprasanth.githubrepos.main.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindMainActivity(factory: MainActivityComponent.Factory): AndroidInjector.Factory<*>
}