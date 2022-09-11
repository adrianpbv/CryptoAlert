package com.example.android.cryptoalert.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.cryptoalert.ui.adapters.BaseRecyclerViewAdapter

object BindingAdapters {

    @Suppress("UNCHECKED_CAST")
    @BindingAdapter("dataList")
    @JvmStatic
    fun <T> bindDataList(recyclerView: RecyclerView, data: List<T>?){
        data?.let { itemList ->
            (recyclerView.adapter as? BaseRecyclerViewAdapter<T>)?.apply {
                clear()
                addData(itemList)
            }
        }
    }
}