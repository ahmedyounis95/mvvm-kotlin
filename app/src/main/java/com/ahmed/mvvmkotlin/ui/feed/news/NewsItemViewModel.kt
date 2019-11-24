package com.ahmed.mvvmkotlin.ui.feed.news

import androidx.databinding.ObservableField
import com.ahmed.mvvmkotlin.data.model.Articles

import hcww.mvvm.ayounis.com.mvvmproject.utils.CommonUtils

/**
 * Created by Ahmed Younis on 28/03/19.
 */

class NewsItemViewModel(private val mArticles: Articles, val mListener: NewsItemViewModelListener) {

    val description: ObservableField<String?> = ObservableField(mArticles.description)

    val imageUrl: ObservableField<String?> = ObservableField(mArticles.urlToImage)

    val publishedAt: ObservableField<String?>

    val title: ObservableField<String?> = ObservableField(mArticles.title)

    val author: ObservableField<String?> = ObservableField(mArticles.author)

    val favorite: ObservableField<Boolean?>


    init {
        this.publishedAt = ObservableField(CommonUtils.getDate(mArticles.publishedAt))
        this.favorite = ObservableField(mArticles.isChecked)
    }

    fun onItemClick() {
        mListener.onItemClick()
    }

    interface NewsItemViewModelListener {

        fun onItemClick()
    }
}
