package com.purnaprasanth.githubrepos.baseandroid.connectivity

/**
 * Created by Purna on 2019-09-21 as a part of GithubRepos
 **/
interface ConnectivityStatus {

    /**
     * Method to check internet connectivity
     * Returns true if internet is available,
     * & false if internet not available
     */

    fun isConnected(): Boolean
}