package com.nagabinding.dto

import com.nagabinding.model.Person

fun Person.disassemble() = PersonDto(id, name, avatar, phoneNumber)
