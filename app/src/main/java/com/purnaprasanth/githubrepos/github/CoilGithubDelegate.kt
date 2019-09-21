package com.purnaprasanth.githubrepos.github

import android.content.Context
import coil.DefaultRequestOptions
import coil.ImageLoader
import coil.request.GetRequest
import coil.request.LoadRequest
import okhttp3.OkHttpClient

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * A Github Delegate for fetching images using [ImageLoader]
 */

class CoilGithubDelegate(
    private val appContext: Context,
    okHttpClient: OkHttpClient
) : ImageLoader {

    private val githubOkHttp = okHttpClient.newBuilder().build()

    private val coilImageLoader: ImageLoader by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        ImageLoader.invoke(appContext) {
            crossfade(true)
            okHttpClient(githubOkHttp)
        }
    }

    override val defaults: DefaultRequestOptions
        get() = coilImageLoader.defaults

    override fun clearMemory() {
        coilImageLoader.clearMemory()
    }

    override suspend fun get(request: GetRequest) = coilImageLoader.get(request)

    override fun load(request: LoadRequest) = coilImageLoader.load(request)

    override fun shutdown() {
        coilImageLoader.shutdown()
    }
}