package com.purnaprasanth.githubrepos.baseandroid.util

import android.app.Application
import java.io.File

/**
 * Created by Purna on 2019-09-21 as a part of GithubRepos
 **/

fun createDefaultCacheDir(application: Application, name: String): File {
    val cache = File(application.cacheDir, name)
    if (!cache.exists()) {
        cache.mkdirs()
    }
    return cache
}