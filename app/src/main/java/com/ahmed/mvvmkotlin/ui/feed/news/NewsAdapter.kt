package com.ahmed.mvvmkotlin.ui.feed.news

import android.content.Intent
import android.net.Uri
import android.net.sip.SipSession
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.mvvmkotlin.data.model.Articles
import com.ahmed.mvvmkotlin.databinding.ItemNewsEmptyViewBinding
import com.ahmed.mvvmkotlin.databinding.ItemNewsViewBinding
import com.ahmed.mvvmkotlin.ui.base.BaseViewHolder
import hcww.mvvm.ayounis.com.mvvmproject.utils.AppLogger

/**
 * Created by Ahmed Younis on 11/4/2019.
 */
class NewsAdapter(private val mArticlesList: MutableList<Articles>) :
    RecyclerView.Adapter<BaseViewHolder>() {

    private var mListener: NewsAdapterListener? = null
    private var checkboxOnItemSelectedListener: CheckboxOnItemSelectedListener? = null


    override fun getItemCount(): Int {
        return if (mArticlesList.isNotEmpty()) {
            mArticlesList.size
        } else {
            1
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (mArticlesList.isNotEmpty()) {
            VIEW_TYPE_NORMAL
        } else {
            VIEW_TYPE_EMPTY
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val newsViewBinding = ItemNewsViewBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                return NewsItemViewHolder(newsViewBinding)
            }
            VIEW_TYPE_EMPTY -> {
                val emptyViewBinding = ItemNewsEmptyViewBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                return EmptyViewHolder(emptyViewBinding)
            }
            else -> {
                val emptyViewBinding = ItemNewsEmptyViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return EmptyViewHolder(emptyViewBinding)
            }
        }
    }

    fun addItems(articlesList: List<Articles>) {
        mArticlesList.addAll(articlesList)
        notifyDataSetChanged()
    }


    fun clearItems() {
        mArticlesList.clear()
    }

    fun setListener(listener: NewsAdapterListener) {
        this.mListener = listener
    }

    fun setCheckboxOnItemSelectedListener(checkboxOnItemSelectedListener: CheckboxOnItemSelectedListener) {
        this.checkboxOnItemSelectedListener = checkboxOnItemSelectedListener
    }
    interface NewsAdapterListener {

        fun onRetryClick()
    }

    inner class EmptyViewHolder(private val mBinding:ItemNewsEmptyViewBinding): BaseViewHolder(mBinding.root),NewsEmptyItemViewModel.NewsEmptyItemViewModelListener{
        override fun onBind(position: Int) {
            val emptyItemViewModel = NewsEmptyItemViewModel(this)
            mBinding.viewModel = emptyItemViewModel
        }

        override fun onRetryClick() {
            mListener!!.onRetryClick()
        }

    }

    inner class NewsItemViewHolder(private val mBinding: ItemNewsViewBinding) : BaseViewHolder(mBinding.root), NewsItemViewModel.NewsItemViewModelListener{

        private var mNewsItemViewModel: NewsItemViewModel? = null

        override fun onBind(position: Int) {
            val mNewsItemViewModel = mArticlesList[position]
            this.mNewsItemViewModel = NewsItemViewModel(mNewsItemViewModel, this)
            mBinding.viewModel = this.mNewsItemViewModel

            if(mNewsItemViewModel.isChecked){
                mBinding.favoriteCheckBox.isChecked = true
            }else if(!mNewsItemViewModel.isChecked){
                mBinding.favoriteCheckBox.isChecked = false
            }
            mBinding.favoriteCheckBox.setOnClickListener {
                if (mBinding.favoriteCheckBox.isChecked) {
                    mNewsItemViewModel.isChecked = true
                    mBinding.favoriteCheckBox.isChecked = true
                    if (checkboxOnItemSelectedListener != null) {
                        checkboxOnItemSelectedListener?.onItemSelected(
                            mArticlesList[position], true
                        )
                    }
                } else if (!mBinding.favoriteCheckBox.isChecked) {
                    mNewsItemViewModel.isChecked = false
                    mBinding.favoriteCheckBox.isChecked = false
                    if (checkboxOnItemSelectedListener != null) {
                        checkboxOnItemSelectedListener?.onItemSelected(
                            mArticlesList[position], false
                        )
                    }
                }
            }
            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings()
        }


        override fun onItemClick() {
            if (mArticlesList[adapterPosition].url != null) {
                try {
                    val intent = Intent()
                    intent.action = Intent.ACTION_VIEW
                    intent.addCategory(Intent.CATEGORY_BROWSABLE)
                    intent.data = Uri.parse(mArticlesList[adapterPosition].url)
                    itemView.context.startActivity(intent)
                } catch (e: Exception) {
                    AppLogger.d("url error")
                }

            }
        }
    }
    companion object {

        val VIEW_TYPE_EMPTY = 0

        val VIEW_TYPE_NORMAL = 1
    }
}