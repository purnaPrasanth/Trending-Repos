package com.purnaprasanth.githubrepos.main

import android.app.Activity
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

@Module
abstract class MainActivityModuleBinds {

    @Binds
    abstract fun provideActivityContext(activity: MainActivity): Context

    @Binds
    abstract fun provideActivity(activity: MainActivity): Activity

}