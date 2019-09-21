package com.purnaprasanth.githubrepos.github

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * An utility interface to provide a family of implementations of GitHub API data services
 */

interface IGithubServices {

    /**
     * To provide a solid implementation for [IGithubRepoService] for this family of Services
     */
    val githubRepoServices: IGithubRepoService
}