package com.purnaprasanth.githubrepos.base

import java.util.concurrent.Executor

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * Executors to be used across App
 * @param mainExecutor The Executor for Operations on Main Thread
 * @param ioExecutor The Executor for IO Operations
 * @param commonExecutor The Executor for Common Computational Operations
 *
 * Usually Used to create [AppDispatchers]
 */
data class AppExecutors(
    val mainExecutor: Executor,
    val ioExecutor: Executor,
    val commonExecutor: Executor
)