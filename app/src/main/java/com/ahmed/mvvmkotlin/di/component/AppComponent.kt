package com.ahmed.mvvmkotlin.di.component

import android.app.Application
import com.ahmed.mvvmkotlin.MvvmApp
import com.ahmed.mvvmkotlin.di.builder.ActivityBuilder
import com.ahmed.mvvmkotlin.di.module.AppModule
import com.ahmed.mvvmkotlin.di.module.NetModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Ahmed Younis on 7/27/2019.
 */
@Singleton
@Component(modules = [(AppModule::class),(NetModule::class),(ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MvvmApp)

}