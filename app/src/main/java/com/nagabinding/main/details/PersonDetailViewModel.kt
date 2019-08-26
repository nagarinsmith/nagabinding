package com.nagabinding.main.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nagabinding.model.PersonDetails
import com.nagabinding.repository.PersonsRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PersonDetailViewModel(private val personId: Int, private val repository: PersonsRepository) : ViewModel() {

    private val _person = MutableLiveData<PersonDetails>()
    val person: LiveData<PersonDetails> get() = _person

    init {
        viewModelScope.launch { repository.getPersonDetailById(personId).collect { _person.postValue(it) } }
    }
}