package com.purnaprasanth.githubrepos.data

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * Base class for NetworkResult of a Network Call
 * @param T the data that this is holding
 */
sealed class NetworkResult<T> {
    abstract fun get(): T?
}

/**
 * Success implementation of Network Result [NetworkResult]
 * @param T data that this Success result holds
 */
data class NetworkSuccess<T>(val data: T) : NetworkResult<T>() {
    override fun get() = data
}

/**
 * Error implementation of Network Result [NetworkResult]
 * @param exception Error Details for Failure
 */
data class NetworkError<T>(val exception: Exception) : NetworkResult<T>() {
    override fun get() = null
}