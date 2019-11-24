package com.ahmed.mvvmkotlin.data

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
class AppDataManager @Inject constructor(private val mApiHelper: ApiHelper) : DataManager {
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