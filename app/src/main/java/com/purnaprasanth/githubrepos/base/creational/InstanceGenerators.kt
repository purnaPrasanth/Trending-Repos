package com.purnaprasanth.githubrepos.base.creational

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * Base Generator Wrapper for any instance of type [T]
 * @param T The Type of Instance to be provided by this generator
 *
 * see [Single] & [Factory]
 */

interface BaseGenerator<T> {
    fun getInstance(): T
}

/**
 * Singleton Wrapper for any instance of type [T]
 * @param T The Type of Instance to be provided by this generator
 *
 * return the same instance for all the requests
 */
class Single<T>(generatingBlock: () -> T) : BaseGenerator<T> {
    private val _instance: T by lazy { generatingBlock() }

    override fun getInstance() = _instance
}

/**
 * Factory Wrapper for any instance of type [T]
 * @param T The Type of Instance to be provided by this generator
 *
 * return the different instance for each request
 */
class Factory<T>(val generatingBlock: () -> T) : BaseGenerator<T> {
    override fun getInstance() = generatingBlock()
}