package com.ahmed.mvvmkotlin.di.module

import android.app.Application
import dagger.Module
import dagger.Provides

/**
 * Created by Ahmed Younis on 7/27/2019.
 */
@Module
class AppModule(private val mApplication: Application) {

    @Provides
    internal fun provideContext() = mApplication


}