package com.nagabinding.shared

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class NagaListAdapter<ITEM, BINDING : ViewDataBinding>(@LayoutRes private val itemLayout: Int, diffUtil: DiffUtil.ItemCallback<ITEM>) :
    ListAdapter<ITEM, NagaListAdapter.NagaViewHolder<BINDING>>(diffUtil) {

    @CallSuper
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NagaViewHolder<BINDING> {
        val binding = DataBindingUtil.inflate<BINDING>(LayoutInflater.from(parent.context), itemLayout, parent, false)
        val viewHolder = NagaViewHolder(binding)
        initialize(viewHolder)
        return viewHolder
    }

    protected abstract fun initialize(viewHolder: NagaViewHolder<BINDING>)

    @CallSuper
    override fun onBindViewHolder(holder: NagaViewHolder<BINDING>, position: Int) {
        bind(holder.binding, getItem(position))
        holder.binding.executePendingBindings()
    }

    protected abstract fun bind(binding: BINDING, item: ITEM)

    class NagaViewHolder<out BINDING : ViewDataBinding>(val binding: BINDING) : RecyclerView.ViewHolder(binding.root)
}
