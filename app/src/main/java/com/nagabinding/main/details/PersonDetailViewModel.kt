package com.nagabinding.main.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nagabinding.repository.PersonRepository
import com.nagabinding.shared.Response

class PersonDetailViewModel(private val personId: String, private val repository: PersonRepository) : ViewModel() {

    val person = liveData {
        when (val response = repository.getPersonById(personId)) {
            is Response.Success -> emit(response.result)
        }
    }
}
