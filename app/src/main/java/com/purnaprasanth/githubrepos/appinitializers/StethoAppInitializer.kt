package com.purnaprasanth.githubrepos.appinitializers

import android.app.Application
import com.facebook.stetho.Stetho
import com.purnaprasanth.githubrepos.BuildConfig
import com.purnaprasanth.githubrepos.baseandroid.AppInitializer
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-21 as a part of GithubRepos
 **/

/**
 * [AppInitializer] for initializaing Stetho
 */

class StethoAppInitializer @Inject constructor() : AppInitializer {
    override fun init(application: Application) {
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(application)
    }
}