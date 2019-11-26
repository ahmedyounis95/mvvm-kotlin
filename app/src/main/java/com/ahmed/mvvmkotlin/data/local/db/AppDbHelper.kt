package com.ahmed.mvvmkotlin.data.local.db

import com.ahmed.mvvmkotlin.data.local.db.dao.ArticleListDao
import com.ahmed.mvvmkotlin.data.model.Articles
import javax.inject.Inject

/**
 * Created by Ahmed Younis on 11/24/2019.
 */
class AppDbHelper @Inject
constructor(private val  mArticleListDao: ArticleListDao) : DbHelper{
    override val allNews: List<Articles>
        get() = mArticleListDao.allNews
    override val allFavorites: List<Articles>
        get() = mArticleListDao.allFavorites

    override fun insertNews(articlesList: List<Articles>) {
        mArticleListDao.insertNews(articlesList)
    }

    override fun updateFavorites(articles: Boolean, id: Int) {
        mArticleListDao.update(articles,id)
    }

}