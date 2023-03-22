package kz.orkenniet.auth.domain.usecase

import com.google.firebase.auth.AuthResult
import kz.orkenniet.auth.domain.repository.AuthRepository
import kz.orkenniet.core.resource.Resource

class RegistrationUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun register(email: String, password: String, repeatPassword: String): Resource<AuthResult> {
        if (password != repeatPassword)
            return Resource.Error("Passwords are not same")

        return authRepository.register(email, password)
    }
}