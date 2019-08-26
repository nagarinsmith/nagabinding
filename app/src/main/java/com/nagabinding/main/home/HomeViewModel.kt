package com.nagabinding.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nagabinding.model.Person
import com.nagabinding.repository.PersonsRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(personsRepository: PersonsRepository) : ViewModel() {

    private val _persons = MutableLiveData<List<Person>>()
    val persons: LiveData<List<Person>> get() = _persons

    init {
        viewModelScope.launch { personsRepository.getPersons().collect { _persons.value = it } }
    }
}
