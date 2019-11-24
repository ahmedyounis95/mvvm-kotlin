package com.ahmed.mvvmkotlin.ui.feed.news

/**
 * Created by Ahmed Younis on 28/03/19.
 */

class NewsEmptyItemViewModel(private val mListener: NewsEmptyItemViewModelListener) {

    fun onRetryClick() {
        mListener.onRetryClick()
    }

    interface NewsEmptyItemViewModelListener {

        fun onRetryClick()
    }
}
