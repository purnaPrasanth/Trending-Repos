package com.purnaprasanth.githubrepos.github

import android.content.Context
import coil.DefaultRequestOptions
import coil.ImageLoader
import coil.request.GetRequest
import coil.request.LoadRequest
import com.purnaprasanth.githubrepos.base.AppDispatchers
import okhttp3.OkHttpClient

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * A Github Delegate for fetching images using [ImageLoader]
 */

class CoilGithubDelegate(
    private val appContext: Context,
    okHttpClient: OkHttpClient,
    appDispatchers: AppDispatchers,
    forceCacheInterceptor: ForceCacheInterceptor
) : ImageLoader {

    private val githubOkHttp = okHttpClient.newBuilder()
        .addInterceptor(forceCacheInterceptor)
        .build()

    private val coilImageLoader: ImageLoader by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        ImageLoader(appContext) {
            crossfade(true)
            okHttpClient(githubOkHttp)
            availableMemoryPercentage(0.4)
            bitmapPoolPercentage(0.5)
            dispatcher(appDispatchers.ioDispatcher)
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