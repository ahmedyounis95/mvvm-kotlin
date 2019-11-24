package com.ahmed.mvvmkotlin.ui.feed.news

import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmed.mvvmkotlin.data.model.Articles
import dagger.Module
import dagger.Provides
import hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news.NewsFragment

/**
 * Created by Ahmed Younis on 11/6/2019.
 */
@Module
class NewsFragmentModule {
    @Provides
    internal fun provideLinearLayoutManager(fragment : NewsFragment) : LinearLayoutManager {
        return LinearLayoutManager(fragment.activity)
    }

    @Provides
    internal fun provideNewsAdapter():NewsAdapter{
        return NewsAdapter(ArrayList<Articles>())
    }
}