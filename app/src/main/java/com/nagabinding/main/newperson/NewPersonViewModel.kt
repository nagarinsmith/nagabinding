package com.nagabinding.main.newperson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nagabinding.model.PersonDetails
import com.nagabinding.repository.PersonsRepository
import com.nagabinding.shared.Response
import com.nagabinding.shared.util.initialize
import kotlinx.coroutines.launch
import java.util.Random

class NewPersonViewModel(private val repository: PersonsRepository) : ViewModel() {

    private val _event = MutableLiveData<Event>()
    val event: LiveData<Event> get() = _event

    val avatar = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val phoneNumber = MutableLiveData<String>()

    val allFieldsFilled = MediatorLiveData<Boolean>().apply {
        addSource(avatar) {
            value = validateFields(avatar.value, name.value, phoneNumber.value)
        }
        addSource(name) {
            value = validateFields(avatar.value, name.value, phoneNumber.value)
        }
        addSource(phoneNumber) {
            value = validateFields(avatar.value, name.value, phoneNumber.value)
        }
    }

    private val _isLoading = MutableLiveData<Boolean>().initialize(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private fun validateFields(vararg fields: String?): Boolean = !fields.asSequence().map(String?::isNullOrBlank).any { it }

    fun savePerson() {
        val avatar = avatar.value
        val name = name.value
        val phoneNumber = phoneNumber.value

        if (validateFields(avatar, name, phoneNumber)) {
            _isLoading.value = true
            /* This is a huge exception, normally '!!' operator should be prohibited,
            but in this case I could't write a contract for `validateFields` so the compiler
             would know that the fields are not null. If you have any idea for a clean approach please tell me :) */
            val person = PersonDetails(Random().nextInt(), name!!, avatar!!, phoneNumber!!)
            viewModelScope.launch {
                when (val response = repository.savePerson(person)) {
                    is Response.Success -> {
                        _event.value = Event.Success
                    }
                    is Response.Error -> {
                        _event.value = Event.Failure(response.throwable.message.orEmpty())
                        _isLoading.value = false
                    }
                }
            }
        }
    }

    sealed class Event {

        object Success : Event()
        class Failure(val message: String) : Event()
    }
}
