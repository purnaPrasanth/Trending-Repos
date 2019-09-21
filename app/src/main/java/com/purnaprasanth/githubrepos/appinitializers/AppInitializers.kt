package com.purnaprasanth.githubrepos.appinitializers

import android.app.Application
import com.purnaprasanth.githubrepos.baseandroid.AppInitializer
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-21 as a part of GithubRepos
 **/

/**
 * Single place for initializing all [AppInitializer]
 */

class AppInitializers @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards AppInitializer>
) {
    fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}