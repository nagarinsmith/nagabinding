package com.nagabinding.dto

import com.nagabinding.model.Person

fun PersonDto.assemble() = Person(id, name, avatar, phoneNumber)
