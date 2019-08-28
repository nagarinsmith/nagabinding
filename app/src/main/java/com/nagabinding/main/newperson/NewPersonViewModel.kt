package com.nagabinding.main.newperson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nagabinding.model.Person
import com.nagabinding.repository.PersonRepository
import com.nagabinding.shared.Response
import com.nagabinding.shared.event.BaseEvent
import com.nagabinding.shared.event.EventWrapper
import com.nagabinding.shared.event.wrap
import com.nagabinding.shared.util.initialize
import kotlinx.coroutines.launch

class NewPersonViewModel(private val repository: PersonRepository) : ViewModel() {

    private val _event = MutableLiveData<EventWrapper<Event>>()
    val event: LiveData<EventWrapper<Event>> get() = _event

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

    private fun validateFields(vararg fields: String?): Boolean = fields.asSequence().map(String?::isNullOrBlank).all { !it }

    fun savePerson() {
        val avatar = avatar.value ?: return
        val name = name.value ?: return
        val phoneNumber = phoneNumber.value ?: return

        if (validateFields(avatar, name, phoneNumber)) {
            _isLoading.value = true
            val person = Person(avatar = avatar, name = name, phoneNumber = phoneNumber)
            viewModelScope.launch {
                when (val response = repository.addPerson(person)) {
                    is Response.Success -> {
                        _event.value = Event.Success.wrap()
                    }
                    is Response.Error -> {
                        _event.value = Event.Failure(response.throwable.message.orEmpty()).wrap()
                        _isLoading.value = false
                    }
                }
            }
        }
    }

    sealed class Event : BaseEvent {

        object Success : Event()
        class Failure(val message: String) : Event()
    }
}
