package com.ahmed.mvvmkotlin.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Ahmed Younis on 7/31/2019.
 */
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(position: Int)
}
