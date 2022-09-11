package com.example.android.cryptoalert.ui.adapters

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView

/**
 * View Holder for the Recycler View to bind the data item to the UI
 */
class DataBindingViewHolder<T>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(dataBindingVariable: Int, item: T) {
        binding.setVariable(dataBindingVariable , item)
        binding.executePendingBindings()
    }
}