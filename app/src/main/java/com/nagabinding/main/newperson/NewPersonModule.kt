package com.nagabinding.main.newperson

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newPersonModule = module {
    viewModel { NewPersonViewModel(get()) }
}
