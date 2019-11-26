package com.ahmed.mvvmkotlin.data.local.db

import com.ahmed.mvvmkotlin.data.model.Articles

/**
 * Created by Ahmed Younis on 11/24/2019.
 */
interface DbHelper {

    val allNews: List<Articles>

    val allFavorites: List<Articles>

    fun insertNews(articlesList: List<Articles>)

    fun updateFavorites(articles: Boolean, id: Int)
}