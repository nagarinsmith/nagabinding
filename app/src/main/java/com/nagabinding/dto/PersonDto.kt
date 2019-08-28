package com.nagabinding.dto

import com.squareup.moshi.Json

data class PersonDto(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "avatar") val avatar: String,
    @field:Json(name = "phone_number") val phoneNumber: String
)
