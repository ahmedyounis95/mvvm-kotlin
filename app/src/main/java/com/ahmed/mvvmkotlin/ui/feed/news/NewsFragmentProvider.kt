package hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news

import com.ahmed.mvvmkotlin.ui.feed.news.NewsFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Ahmed Younis on 28/03/19.
 */
@Module
abstract class NewsFragmentProvider {

    @ContributesAndroidInjector(modules = [NewsFragmentModule::class])
    internal abstract fun provideNewsFragmentFactory(): NewsFragment
}
