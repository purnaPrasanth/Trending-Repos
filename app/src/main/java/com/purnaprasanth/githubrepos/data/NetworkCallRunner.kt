package com.purnaprasanth.githubrepos.data

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * A class for Running Network Calls in App
 *
 * Usually Singleton instance across the app
 */

@Singleton
class NetworkCallRunner @Inject constructor() {

    /**
     * Handy Method to execute Network Instructions
     * @param request Network Request to be run
     * @param T Network entity returned from Network
     * @param E App Entity to be created from Network Entity[T]
     * @param mapper for mapping Network Entity[T] to App Entity[E]
     * @return NetworkResult of the Network Call mapped to App Entity
     * For details on the returned type See [NetworkSuccess] & [NetworkError]
     */
    suspend fun <T, E> executeForResponse(mapper: Mapper<T, E>, request: suspend () -> T): NetworkResult<E> {
        return try {
            val response = request()
            NetworkSuccess(mapper.map(response))
        } catch (e: Exception) {
            NetworkError(e)
        }
    }

    /**
     * Handy Method to execute Network Instructions and return data as is
     * @param request Network Request to be run
     * @param T Network entity returned from Network
     * @return NetworkResult of the Network Call mapped to App Entity
     * For details on the returned type See [NetworkSuccess] & [NetworkError]
     */
    suspend fun <T> executeForResponse(request: suspend () -> T): NetworkResult<T> {
        return try {
            NetworkSuccess(request())
        } catch (e: Exception) {
            NetworkError(e)
        }
    }
}