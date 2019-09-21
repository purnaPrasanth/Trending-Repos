package com.purnaprasanth.githubrepos.async

import java.util.concurrent.Executor

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * Base Executor
 */

interface AppExecutor {
    val executor: Executor
}