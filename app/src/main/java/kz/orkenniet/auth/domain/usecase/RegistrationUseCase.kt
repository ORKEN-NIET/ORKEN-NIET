package kz.orkenniet.auth.domain.usecase

import kz.orkenniet.auth.domain.repository.AuthRepository

class RegistrationUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun register(email: String, password: String) {
        authRepository.register(email, password, password)
    }
}