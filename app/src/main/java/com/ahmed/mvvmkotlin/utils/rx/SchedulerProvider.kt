package com.ahmed.mvvmkotlin.utils.rx

import io.reactivex.Scheduler

/**
 * Created by Ahmed Younis on 12/30/2018.
 */
interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler

}
