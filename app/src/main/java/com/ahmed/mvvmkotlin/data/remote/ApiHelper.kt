package com.ahmed.mvvmkotlin.data.remote

import com.ahmed.mvvmkotlin.data.model.NewsData
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Ahmed Younis on 11/4/2019.
 */

interface ApiHelper{

    @GET("v2/everything")
    fun getNews(@Query("apikey") apiKey: String,
                @Query("q") query: String,
                @Query("grouped") groupBy: String,
                @Query("page") page: Int,
                @Query("source") source: String,
                @Query("language") language: String): Single<Response<NewsData>>
}