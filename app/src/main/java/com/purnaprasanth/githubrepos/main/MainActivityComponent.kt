package com.purnaprasanth.githubrepos.main

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}