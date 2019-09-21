package com.purnaprasanth.githubrepos.data.model

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * The Trending Repo Contract that Application depends on
 *
 * @param author Author of the Repository
 * @param name Name of the Repository
 * @param avatar an URL for the avatar resource
 * @param url a url to the repository
 * @param description aDescription of the Repository
 * @param stars number of stars to this repo
 * @param fork number of stars to this repo
 * @param language language used in Repository
 * @param languageColor the color code for the Repository
 */

data class TrendingRepo(
    val author: String,
    val name: String,
    val avatar: String,
    val url: String,
    val description: String,
    val stars: Int,
    val fork: Int,
    val language: String?,
    val languageColor: String?
)