package com.purnaprasanth.githubrepos.connectivity

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.purnaprasanth.githubrepos.baseandroid.connectivity.ConnectivityStatus
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-21 as a part of GithubRepos
 **/

@Singleton
class DetectConnectivity @Inject constructor(private val application: Application) : ConnectivityStatus {

    private val connectivityManager = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun isConnected(): Boolean {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo

        return activeNetwork?.isConnectedOrConnecting == true
    }
}