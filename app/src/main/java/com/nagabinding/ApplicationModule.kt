package com.nagabinding

import com.nagabinding.main.details.personDetailModule
import com.nagabinding.main.home.homeModule
import com.nagabinding.main.newperson.newPersonModule
import com.nagabinding.networking.networkModule
import com.nagabinding.repository.repositoryModule

val applicationModule = homeModule +
    repositoryModule +
    personDetailModule +
    newPersonModule +
    networkModule
