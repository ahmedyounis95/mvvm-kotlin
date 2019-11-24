package com.ahmed.mvvmkotlin.ui.feed

import com.ahmed.mvvmkotlin.data.DataManager
import com.ahmed.mvvmkotlin.ui.base.BaseViewModel
import com.ahmed.mvvmkotlin.utils.rx.SchedulerProvider

/**
 * Created by Ahmed Younis on 10/27/2019.
 */
class FeedViewModel(dataManager: DataManager,schedulerProvider: SchedulerProvider) : BaseViewModel<Any>(dataManager,schedulerProvider)