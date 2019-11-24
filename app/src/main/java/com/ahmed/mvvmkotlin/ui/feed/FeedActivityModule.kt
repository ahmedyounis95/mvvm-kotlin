package com.ahmed.mvvmkotlin.ui.feed

import dagger.Module
import dagger.Provides

/**
 * Created by Ahmed Younis on 10/27/2019.
 */
@Module
class FeedActivityModule {

    @Provides
    internal fun provideFeedPagerAdapter(activity: FeedActivity): FeedPagerAdapter {
        return FeedPagerAdapter(activity.supportFragmentManager)
    }

}