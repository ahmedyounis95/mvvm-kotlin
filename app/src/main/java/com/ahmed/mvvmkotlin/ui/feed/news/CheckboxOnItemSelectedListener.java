package com.ahmed.mvvmkotlin.ui.feed.news;


import com.ahmed.mvvmkotlin.data.model.Articles;

public interface CheckboxOnItemSelectedListener {
    void onItemSelected(Articles articles, boolean checked) ;
}
