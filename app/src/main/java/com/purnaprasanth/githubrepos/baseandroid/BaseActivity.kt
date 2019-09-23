package com.purnaprasanth.githubrepos.baseandroid

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.purnaprasanth.githubrepos.base.AppDispatchers
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import java.util.concurrent.CancellationException
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

/**
 * Base Class for activities across the app that heavily uses @see <a href="https://developer.android.com/topic/libraries/data-binding">Data Binding</a>
 *
 * @param BINDING type of view binding that this [DaggerAppCompatActivity] uses
 * @param layoutId the layout id for [setContentView]
 *
 * This also implements [CoroutineScope], hence acts as a parent for all the coRoutines started in this activity scope or Lifecycle
 * @property parentJob parent job for the coRoutines started in this scope
 * @property binding Binding class made available for child classes for introducing effects
 */

abstract class BaseActivity<BINDING : ViewDataBinding>(@LayoutRes val layoutId: Int) :
    DaggerAppCompatActivity(), CoroutineScope {
    protected lateinit var binding: BINDING

    private val parentJob = SupervisorJob()

    @Inject
    lateinit var dispatchers: AppDispatchers

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val coroutineContext: CoroutineContext
        get() = dispatchers.mainDispatcher + parentJob

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        AndroidInjection.inject(this)
        initUI()
    }

    override fun onDestroy() {
        super.onDestroy()
        parentJob.cancel(cause = CancellationException("Parent Scope Destroyed"))
    }

    abstract fun initUI()
}