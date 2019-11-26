package com.ahmed.mvvmkotlin.data

import com.ahmed.mvvmkotlin.data.local.db.AppDbHelper
import com.ahmed.mvvmkotlin.data.local.db.DbHelper
import com.ahmed.mvvmkotlin.data.model.Articles
import com.ahmed.mvvmkotlin.data.model.NewsData
import com.ahmed.mvvmkotlin.data.remote.ApiHelper
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ahmed Younis on 7/29/2019.
 */
@Singleton
class AppDataManager @Inject constructor(private val mApiHelper: ApiHelper,private val mAppDbHelper: AppDbHelper) : DataManager {
    override val allNews: List<Articles>
        get() = mAppDbHelper.allNews
    override val allFavorites: List<Articles>
        get() = mAppDbHelper.allFavorites

    override fun insertNews(articlesList: List<Articles>) {
        mAppDbHelper.insertNews(articlesList)
    }

    override fun updateFavorites(articles: Boolean, id: Int) {
        mAppDbHelper.updateFavorites(articles,id)
    }

    override fun getNews(
        apiKey: String,
        query: String,
        groupBy: String,
        page: Int,
        source: String,
        language: String
    ): Single<Response<NewsData>> {
        return mApiHelper.getNews(apiKey, query, groupBy, page, source, language)
    }
}