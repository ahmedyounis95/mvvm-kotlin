package com.ahmed.mvvmkotlin.ui.feed

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news.NewsFragment

/**
 * Created by Ahmed Younis on 10/27/2019.
 */
class FeedPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {


    private var mTabCount: Int = 0

    init {
        this.mTabCount = 0
    }

    override fun getCount(): Int {
        return mTabCount
    }

    fun setCount(count: Int) {
        mTabCount = count
    }

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return NewsFragment.newInstance()
            1 -> return NewsFragment.newInstance()
            else -> return null
        }
    }
}