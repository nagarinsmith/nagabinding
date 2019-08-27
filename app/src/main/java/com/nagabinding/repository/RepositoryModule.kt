package com.nagabinding.repository

import org.koin.dsl.module

val repositoryModule = module {
    single { PersonsRepository() }
}
