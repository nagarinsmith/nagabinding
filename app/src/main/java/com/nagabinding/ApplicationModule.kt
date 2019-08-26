package com.nagabinding

import com.nagabinding.main.details.personDetailModule
import com.nagabinding.main.home.homeModule
import com.nagabinding.repository.repositoryModule

val applicationModule = homeModule +
        repositoryModule +
        personDetailModule
