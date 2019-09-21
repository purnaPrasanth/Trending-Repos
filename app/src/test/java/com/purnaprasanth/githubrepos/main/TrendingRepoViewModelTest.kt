package com.purnaprasanth.githubrepos.main

import android.app.Application
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jraska.livedata.TestObserver
import com.jraska.livedata.test
import com.purnaprasanth.githubrepos.base.AppDispatchers
import com.purnaprasanth.githubrepos.baseandroid.ErrorViewState
import com.purnaprasanth.githubrepos.baseandroid.LoadingViewState
import com.purnaprasanth.githubrepos.baseandroid.SuccessViewState
import com.purnaprasanth.githubrepos.baseandroid.ViewState
import com.purnaprasanth.githubrepos.data.NetworkError
import com.purnaprasanth.githubrepos.data.NetworkSuccess
import com.purnaprasanth.githubrepos.data.model.TrendingRepo
import com.purnaprasanth.githubrepos.data.repo.TrendingReposRepo
import com.purnaprasanth.githubrepos.trendingRepo1
import com.purnaprasanth.githubrepos.trendingRepo2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 */

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE, sdk = [Build.VERSION_CODES.O_MR1])
class TrendingRepoViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var trendingReposRepo: TrendingReposRepo

    private var appDispatchers: AppDispatchers = AppDispatchers(
        mainDispatcher = Dispatchers.Main,
        commonDispatcher = Dispatchers.Default,
        ioDispatcher = Dispatchers.Default
    )

    private lateinit var viewModel: TrendingRepoViewModel

    private val applicationMock = Mockito.mock(Application::class.java)

    private lateinit var testObserver: TestObserver<ViewState<List<TrendingRepo>>>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = TrendingRepoViewModel(applicationMock, appDispatchers, trendingReposRepo)
        testObserver = viewModel.trendingReposViewState.test()
    }

    @Test
    fun testSuccess() {
        runBlocking {
            `when`(trendingReposRepo.getTrendingRepos()).thenReturn(
                NetworkSuccess(
                    listOf(
                        trendingRepo1,
                        trendingRepo2
                    )
                )
            )

            viewModel.getTrendingRepo()

            testObserver.assertValue {
                it is SuccessViewState
            }
        }
    }

    @Test
    fun testError() {
        runBlocking {
            `when`(trendingReposRepo.getTrendingRepos()).thenReturn(NetworkError(Exception()))

            viewModel.getTrendingRepo()

            testObserver
                .assertValue {
                    it is ErrorViewState
                }
        }
    }

    @Test
    fun testLoading() {
        runBlocking {
            `when`(trendingReposRepo.getTrendingRepos()).thenReturn(NetworkError(Exception()))

            val startSize = testObserver.valueHistory().size

            viewModel.getTrendingRepo()

            val endSize = testObserver.valueHistory().size

            assert(
                (testObserver.assertHistorySize(startSize + 2)
                    .valueHistory().subList(startSize - 1, endSize)
                    .first()) is LoadingViewState
            )
        }
    }

    @After
    fun tearDown() {
    }
}