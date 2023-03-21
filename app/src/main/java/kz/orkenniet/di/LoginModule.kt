package kz.orkenniet.di

import kz.orkenniet.auth.data.repository.AuthRepositoryFirebase
import kz.orkenniet.auth.domain.repository.AuthRepository
import kz.orkenniet.auth.domain.usecase.LoginUseCase
import kz.orkenniet.auth.domain.usecase.RegistrationUseCase
import kz.orkenniet.auth.presentation.login.LoginViewModel
import kz.orkenniet.auth.presentation.registration.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {

    single<AuthRepository> {
        AuthRepositoryFirebase(firebaseAuth = get())
    }

    factory {
        LoginUseCase(authRepository = get())
    }

    factory {
        RegistrationUseCase(authRepository = get())
    }

    viewModel {
        LoginViewModel(loginUseCase = get())
    }

    viewModel {
        RegistrationViewModel(registrationUseCase = get())
    }
}