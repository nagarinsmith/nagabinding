package com.nagabinding.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.nagabinding.PersonItemBinding
import com.nagabinding.shared.NagaAdapter

class PersonsAdapter(private val onPersonClicked: (person: PersonItemViewModel) -> Unit) :
    NagaAdapter<PersonItemViewModel, PersonItemBinding>(diffUtilCallback) {

    override fun createBinding(parent: ViewGroup): PersonItemBinding = PersonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun bind(binding: PersonItemBinding, item: PersonItemViewModel) {
        binding.viewModel = item
        binding.container.setOnClickListener { onPersonClicked(item) }
    }

    companion object {
        private val diffUtilCallback = object : DiffUtil.ItemCallback<PersonItemViewModel>() {
            override fun areItemsTheSame(oldItem: PersonItemViewModel, newItem: PersonItemViewModel) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: PersonItemViewModel, newItem: PersonItemViewModel) = oldItem == newItem
        }
    }
}
