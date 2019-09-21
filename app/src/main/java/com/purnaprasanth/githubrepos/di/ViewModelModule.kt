package com.purnaprasanth.githubrepos.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.purnaprasanth.githubrepos.annotations.ViewModelKey
import com.purnaprasanth.githubrepos.baseandroid.ViewModelFactory
import com.purnaprasanth.githubrepos.main.TrendingRepoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TrendingRepoViewModel::class)
    internal abstract fun provideTrendingReposVM(viewModel: TrendingRepoViewModel): ViewModel
}