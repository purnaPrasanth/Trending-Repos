package com.purnaprasanth.githubrepos.data

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * Base class for mapping on type of data to other
 *
 * @param F The type of the input data
 * @param T the type of the data to be returned
 */

interface Mapper<F, T> {
    suspend fun map(from: F): T
}

/**
 * Base Mapper for a list of items of one type to a different type
 *
 * @param F The type of the input data
 * @param T the type of the data to be returned
 */
private class MapperToListMapper<F, T>(val singleMapper: Mapper<F, T>) : Mapper<List<F>, List<T>> {
    override suspend fun map(from: List<F>): List<T> = from.map { singleMapper.map(it) }
}

/**
 * Base Mapper for a list of items of one type to a different type with Async Processing for each item
 *
 * @param F The type of the input data
 * @param T the type of the data to be returned
 */
private class MapperToAsyncListMapper<F, T>(val singleMapper: Mapper<F, T>) : Mapper<List<F>, List<T>> {
    override suspend fun map(from: List<F>): List<T> = coroutineScope {
        val asynTasks = from.map {
            async { singleMapper.map(it) }
        }

        return@coroutineScope asynTasks.map {
            it.await()
        }
    }
}

class SelfMapper<T> : Mapper<T, T> {
    override suspend fun map(from: T) = from
}

/**
 * Handy Entension for converting [Mapper] to [MapperToListMapper]
 */
fun <F, T> Mapper<F, T>.toListMapper(): Mapper<List<F>, List<T>> = MapperToListMapper(this)

/**
 * Handy Entension for converting [Mapper] to [MapperToAsyncListMapper]
 */
fun <F, T> Mapper<F, T>.toAsyncListMapper(): Mapper<List<F>, List<T>> = MapperToAsyncListMapper(this)