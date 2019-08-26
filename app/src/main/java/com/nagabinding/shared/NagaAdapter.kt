package com.nagabinding.shared

import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class NagaAdapter<TYPE, BINDING : ViewDataBinding>(diffUtil: DiffUtil.ItemCallback<TYPE>) : ListAdapter<TYPE, NagaViewHolder<BINDING>>(diffUtil) {

    @CallSuper
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NagaViewHolder<BINDING> {
        return NagaViewHolder(createBinding(parent))
    }

    protected abstract fun createBinding(parent: ViewGroup): BINDING

    @CallSuper
    override fun onBindViewHolder(holder: NagaViewHolder<BINDING>, position: Int) {
        bind(holder.binding, getItem(position))
        holder.binding.executePendingBindings()
    }

    protected abstract fun bind(binding: BINDING, item: TYPE)
}

class NagaViewHolder<out BINDING : ViewDataBinding> constructor(val binding: BINDING) : RecyclerView.ViewHolder(binding.root)