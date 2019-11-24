package hcww.mvvm.ayounis.com.mvvmproject.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

import com.bumptech.glide.Glide

import androidx.recyclerview.widget.RecyclerView
import com.ahmed.mvvmkotlin.data.model.Articles
import com.ahmed.mvvmkotlin.ui.feed.news.NewsAdapter


/**
 * Created by Ahmed Younis on 12/30/2018.
 */
object BindingUtils {

    @BindingAdapter("adapter")
    @JvmStatic
    fun addNewsItems(recyclerView: RecyclerView, news: List<Articles>?) {
        val adapter = recyclerView.adapter as NewsAdapter?
            adapter?.clearItems()
        news?.let { adapter?.addItems(it) }
    }

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun setImageUrl(imageView: ImageView, url: String) {
        val context = imageView.context
        Glide.with(context).load(url).into(imageView)
    }

}
