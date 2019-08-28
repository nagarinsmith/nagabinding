package com.nagabinding.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nagabinding.model.Person
import com.nagabinding.repository.PersonRepository
import com.nagabinding.shared.Response

class HomeViewModel(private val personRepository: PersonRepository) : ViewModel() {

    val persons = liveData {
        when (val response = personRepository.getPersons()) {
            is Response.Success -> emit(response.result.map { it.mapToPersonViewModel() })
            is Response.Error -> emit(listOf())
        }
    }

    private fun Person.mapToPersonViewModel() = PersonItemViewModel(id, name, avatar)
}
