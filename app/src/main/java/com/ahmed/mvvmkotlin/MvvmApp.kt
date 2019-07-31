package com.ahmed.mvvmkotlin

import android.app.Activity
import android.app.Application
import com.ahmed.mvvmkotlin.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import hcww.mvvm.ayounis.com.mvvmproject.utils.AppConstants
import javax.inject.Inject

/**
 * Created by Ahmed Younis on 7/27/2019.
 */
class MvvmApp : Application(), HasActivityInjector {

    @Inject
    internal lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .application(this)
            .baseUrl(AppConstants.BASE_URLS)
            .build()
            .inject(this)

    }
}