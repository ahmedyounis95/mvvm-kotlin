package com.ahmed.mvvmkotlin


import javax.inject.Inject
import javax.inject.Singleton

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahmed.mvvmkotlin.data.DataManager
import com.ahmed.mvvmkotlin.ui.splash.SplashViewModel
import com.ahmed.mvvmkotlin.utils.rx.SchedulerProvider

@Singleton
class ViewModelProviderFactory @Inject
constructor(private val dataManager: DataManager,
            private val schedulerProvider: SchedulerProvider
) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {

            return SplashViewModel(dataManager, schedulerProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }


}
