package kz.orkenniet.auth.domain.usecase

import kz.orkenniet.auth.domain.repository.AuthRepository

class IsLoggedInUseCase(
    private val authRepository: AuthRepository
) {

    operator fun invoke(): Boolean {
        return authRepository.isLoggedIn()
    }
}
