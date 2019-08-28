package com.nagabinding.repository

import org.koin.dsl.module

val repositoryModule = module {
    factory { PersonRepository(get()) }
}
