package com.ahmed.mvvmkotlin.ui.splash

import com.ahmed.mvvmkotlin.data.DataManager
import com.ahmed.mvvmkotlin.ui.base.BaseViewModel
import com.ahmed.mvvmkotlin.utils.rx.SchedulerProvider

/**
 * Created by Ahmed Younis on 7/31/2019.
 */

class SplashViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<SplashNavigator>(dataManager, schedulerProvider) {


    private fun decideNextActivity() {
        navigator?.openMainActivity()
    }
}
