package com.ahmed.mvvmkotlin.data.model

import androidx.room.*
import com.google.gson.annotations.SerializedName
import hcww.mvvm.ayounis.com.mvvmproject.utils.AppConstants

/**
 * Created by Ahmed Younis on 11/4/2019.
 */

@Entity(tableName = AppConstants.DB_NAME, indices = [Index(value = ["url"], unique = true)])
class Articles {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    @SerializedName("source")
    @Ignore
    var source: Source? = null
    @SerializedName("author")
    @ColumnInfo(name = "author")
    var author: String? = null
    @SerializedName("title")
    @ColumnInfo(name = "title")
    var title: String? = null
    @SerializedName("description")
    @ColumnInfo(name = "description")
    var description: String? = null
    @SerializedName("url")
    @ColumnInfo(name = "url")
    var url: String? = null
    @SerializedName("urlToImage")
    @ColumnInfo(name = "urlToImage")
    var urlToImage: String? = null
    @SerializedName("publishedAt")
    @ColumnInfo(name = "publishedAt")
    var publishedAt: String? = null
    @SerializedName("content")
    @ColumnInfo(name = "content")
    var content: String? = null
    @ColumnInfo(name = "checked")
    var isChecked: Boolean = false
}
