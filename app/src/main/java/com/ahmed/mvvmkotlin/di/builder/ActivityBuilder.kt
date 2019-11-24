package com.ahmed.mvvmkotlin.di.builder

import com.ahmed.mvvmkotlin.ui.feed.FeedActivity
import com.ahmed.mvvmkotlin.ui.feed.FeedActivityModule
import com.ahmed.mvvmkotlin.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news.NewsFragmentProvider

/**
 * Created by Ahmed Younis on 7/27/2019.
 */
@Module
abstract class ActivityBuilder{

    @ContributesAndroidInjector(modules = [FeedActivityModule::class, NewsFragmentProvider::class])
    internal abstract fun bindFeedActivity(): FeedActivity

    @ContributesAndroidInjector()
    abstract fun bindSplashActivity(): SplashActivity

}