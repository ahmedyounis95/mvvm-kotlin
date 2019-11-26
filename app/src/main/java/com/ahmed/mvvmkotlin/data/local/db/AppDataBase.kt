package com.ahmed.mvvmkotlin.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahmed.mvvmkotlin.data.local.db.dao.ArticleListDao
import com.ahmed.mvvmkotlin.data.model.Articles


@Database(entities = [Articles::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun dbHelper(): ArticleListDao

}

