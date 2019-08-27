package com.nagabinding.main.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nagabinding.model.PersonDetails
import com.nagabinding.repository.PersonsRepository

class PersonDetailViewModel(private val personId: Int, private val repository: PersonsRepository) : ViewModel() {

    private val _person = MutableLiveData<PersonDetails>()
    val person: LiveData<PersonDetails> get() = _person

    init {
        _person.value = repository.getPersonDetailById(personId)
    }
}
