package com.purnaprasanth.githubrepos.baseandroid

import android.app.Application

/**
 * Created by Purna on 2019-09-21 as a part of GithubRepos
 **/

/**
 * Base Class For App Initializer
 */

interface AppInitializer {
    fun init(application: Application)
}