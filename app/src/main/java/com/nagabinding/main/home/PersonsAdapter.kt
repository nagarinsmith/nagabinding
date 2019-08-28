package com.nagabinding.main.home

import androidx.recyclerview.widget.DiffUtil
import com.nagabinding.PersonItemBinding
import com.nagabinding.R
import com.nagabinding.shared.NagaListAdapter

class PersonsAdapter(private val onPersonClicked: (person: PersonItemViewModel) -> Unit) :
    NagaListAdapter<PersonItemViewModel, PersonItemBinding>(R.layout.item_person, object : DiffUtil.ItemCallback<PersonItemViewModel>() {
        override fun areItemsTheSame(oldItem: PersonItemViewModel, newItem: PersonItemViewModel) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: PersonItemViewModel, newItem: PersonItemViewModel) = oldItem == newItem
    }) {

    override fun initialize(viewHolder: NagaViewHolder<PersonItemBinding>) {
        viewHolder.binding.container.setOnClickListener { onPersonClicked(getItem(viewHolder.adapterPosition)) }
    }

    override fun bind(binding: PersonItemBinding, item: PersonItemViewModel) {
        binding.viewModel = item
    }
}
