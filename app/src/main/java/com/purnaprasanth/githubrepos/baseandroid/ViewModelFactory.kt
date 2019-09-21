@file:Suppress("UNCHECKED_CAST")

package com.purnaprasanth.githubrepos.baseandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

@Singleton
class ViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModels[modelClass]?.get() as T
}