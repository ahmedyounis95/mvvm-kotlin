package com.ahmed.mvvmkotlin.data.remote

import com.ahmed.mvvmkotlin.data.model.NewsData
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Ahmed Younis on 11/4/2019.
 */
class AppApiHelper @Inject
constructor(private val mRetrofit: Retrofit) : ApiHelper{

    override fun getNews(apiKey: String, query: String, groupBy: String, page: Int, source: String, language: String): Single<Response<NewsData>> {
        return mRetrofit.create(ApiHelper::class.java).getNews(apiKey, query, groupBy, page, source, language)
    }

}
