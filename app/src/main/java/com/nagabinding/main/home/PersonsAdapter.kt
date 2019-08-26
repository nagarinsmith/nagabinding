package com.nagabinding.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.nagabinding.PersonItemBinding
import com.nagabinding.model.Person
import com.nagabinding.shared.NagaAdapter

class PersonsAdapter(private val onPersonClicked: (person: Person) -> Unit) : NagaAdapter<Person, PersonItemBinding>(diffUtilCallback) {

    override fun createBinding(parent: ViewGroup): PersonItemBinding = PersonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun bind(binding: PersonItemBinding, item: Person) {
        binding.viewModel = item
        binding.container.setOnClickListener { onPersonClicked(item) }
    }

    companion object {
        private val diffUtilCallback = object : DiffUtil.ItemCallback<Person>() {
            override fun areItemsTheSame(oldItem: Person, newItem: Person) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Person, newItem: Person) = oldItem == newItem
        }
    }
}