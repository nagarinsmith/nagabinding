package com.nagabinding.repository

import com.nagabinding.dto.PersonDto
import com.nagabinding.dto.assemble
import com.nagabinding.dto.disassemble
import com.nagabinding.model.Person
import com.nagabinding.networking.NagaApi
import com.nagabinding.shared.Response

class PersonRepository(private val personApi: NagaApi) {

    suspend fun getPersons(): Response<List<Person>> = try {
        Response.Success(personApi.getPersons().map(PersonDto::assemble))
    } catch (throwable: Throwable) {
        Response.Error(throwable)
    }

    suspend fun getPersonById(id: String): Response<Person> = try {
        Response.Success(personApi.getPersonById(id).assemble())
    } catch (throwable: Throwable) {
        Response.Error(throwable)
    }

    suspend fun addPerson(person: Person): Response<Person> = try {
        Response.Success(personApi.addPerson(person.disassemble()))
    } catch (throwable: Throwable) {
        Response.Error(throwable)
    }
}
