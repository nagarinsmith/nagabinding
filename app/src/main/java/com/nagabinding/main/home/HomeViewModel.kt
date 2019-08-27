package com.nagabinding.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nagabinding.model.Person
import com.nagabinding.repository.PersonsRepository

class HomeViewModel(private val personsRepository: PersonsRepository) : ViewModel() {

    private val _persons = MutableLiveData<List<Person>>()
    val persons: LiveData<List<Person>> get() = _persons

    init {
        loadPersons()
    }

    fun loadPersons() {
        _persons.value = personsRepository.getPersons()
    }
}
