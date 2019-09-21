package com.purnaprasanth.githubrepos.github

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * [OkHttpClient] client implementation for [IGithubServices]. This internally uses Retrofit to Generate implementations for Services
 *
 * @param okhttp
 * @param gson
 */

class OkhttpGithubServices(
    okhttp: OkHttpClient,
    gson: Gson
) : IGithubServices {

    private val githubOkHttpClient: OkHttpClient = okhttp.newBuilder().build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://github-trending-api.now.sh/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(githubOkHttpClient)
        .build()

    override val githubRepoServices: IGithubRepoService
        get() = retrofit.create(IGithubRepoService::class.java)
}