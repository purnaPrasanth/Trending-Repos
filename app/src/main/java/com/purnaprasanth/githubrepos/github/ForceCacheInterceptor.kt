package com.purnaprasanth.githubrepos.github

import com.purnaprasanth.githubrepos.baseandroid.connectivity.ConnectivityStatus
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-21 as a part of GithubRepos
 **/

class ForceCacheInterceptor @Inject constructor(private val connectivityStatus: ConnectivityStatus) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        if (!connectivityStatus.isConnected()) {
            builder.cacheControl(CacheControl.FORCE_CACHE)
        }
        return chain.proceed(builder.build())
    }
}