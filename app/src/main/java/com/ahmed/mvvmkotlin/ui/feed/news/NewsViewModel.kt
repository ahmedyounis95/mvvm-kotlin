package com.ahmed.mvvmkotlin.ui.feed.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ahmed.mvvmkotlin.data.DataManager
import com.ahmed.mvvmkotlin.data.model.Articles
import com.ahmed.mvvmkotlin.ui.base.BaseViewModel
import com.ahmed.mvvmkotlin.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Ahmed Younis on 11/4/2019.
 */
class NewsViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<NewsNavigator>(dataManager, schedulerProvider) {

    private val newsItemsLiveData: MutableLiveData<List<Articles>> = MutableLiveData()

    private var pageNumber = 1

    init {
        fetchRepos()
    }

    fun fetchRepos() {
        setIsLoading(true)
        CompositeDisposable().add(dataManager
            .getNews("dcf37b3045e542df970986c1114eb3ea", "news", "day", pageNumber, "USA Today", "en")
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({ news ->
                if (news != null && news.body()?.articles != null) {
                    dataManager.insertNews(news.body()?.articles!!)
                    newsItemsLiveData.value = dataManager.allNews
                }
                setIsLoading(false)
            }, { throwable ->
                setIsLoading(false)
                navigator?.handleError(throwable)
            }))

        pageNumber++
    }
    fun getNewsItemsLiveData(): LiveData<List<Articles>> {
        return newsItemsLiveData
    }
}