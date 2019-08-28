package com.nagabinding.networking

import com.nagabinding.dto.PersonDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NagaApi {

    @GET("person")
    suspend fun getPersons(): List<PersonDto>

    @GET("person/{id}")
    suspend fun getPersonById(@Path("id") id: String): PersonDto

    @POST("person")
    suspend fun addPerson(@Body person: PersonDto): PersonDto
}
