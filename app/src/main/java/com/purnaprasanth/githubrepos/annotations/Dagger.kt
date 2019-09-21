package com.purnaprasanth.githubrepos.annotations

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Qualifier
import kotlin.reflect.KClass

/**
 * Created by Purna on 2019-09-20 as a part of GithubRepos
 **/

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class GitHub

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class App

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class Main

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class Common

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class IO

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)