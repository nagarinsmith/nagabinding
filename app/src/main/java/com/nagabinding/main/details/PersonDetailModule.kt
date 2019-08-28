package com.nagabinding.main.details

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val personDetailModule = module {
    viewModel { (personId: String) -> PersonDetailViewModel(personId, get()) }
}
