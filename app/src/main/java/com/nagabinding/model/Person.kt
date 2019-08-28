package com.nagabinding.model

import com.nagabinding.shared.util.EMPTY_STRING

data class Person(
    val id: String = EMPTY_STRING,
    val name: String,
    val avatar: String,
    val phoneNumber: String
)
