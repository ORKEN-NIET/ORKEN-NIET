package kz.orkenniet.di

import kz.orkenniet.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {

    viewModel {
        LoginViewModel()
    }
}