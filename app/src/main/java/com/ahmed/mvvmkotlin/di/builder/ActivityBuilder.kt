package com.ahmed.mvvmkotlin.di.builder

import com.ahmed.mvvmkotlin.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Ahmed Younis on 7/27/2019.
 */
@Module
abstract class ActivityBuilder{

    @ContributesAndroidInjector()
    abstract fun bindSplashActivity(): SplashActivity

}