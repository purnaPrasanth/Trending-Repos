package com.purnaprasanth.githubrepos.base.util

import java.util.concurrent.ThreadFactory

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

fun threadFactory(name: String, daemon: Boolean): ThreadFactory {
    return ThreadFactory { r ->
        val result = Thread(r, name)
        result.isDaemon = daemon
        result
    }
}