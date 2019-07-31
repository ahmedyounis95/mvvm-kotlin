package com.ahmed.mvvmkotlin.di.module

import android.app.Application
import android.content.Context
import com.ahmed.mvvmkotlin.data.AppDataManager
import com.ahmed.mvvmkotlin.data.DataManager
import com.ahmed.mvvmkotlin.utils.rx.AppSchedulerProvider
import com.ahmed.mvvmkotlin.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Ahmed Younis on 7/27/2019.
 */
@Module
class AppModule() {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()



}