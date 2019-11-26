package com.ahmed.mvvmkotlin.data.local.db.dao

/**
 * Created by Ahmed Younis on 11/24/2019.
 */
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahmed.mvvmkotlin.data.model.Articles
import hcww.mvvm.ayounis.com.mvvmproject.utils.AppConstants


@Dao
interface ArticleListDao {

    @get:Query("SELECT * FROM `news.db`")
    val allNews: List<Articles>

    @get:Query("SELECT * FROM `news.db` WHERE checked = 1")
    val allFavorites: List<Articles>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNews(articlesList: List<Articles>)

    @Query("UPDATE `news.db` SET checked = :articles WHERE id = :id")
    fun update(articles: Boolean, id: Int)

}
