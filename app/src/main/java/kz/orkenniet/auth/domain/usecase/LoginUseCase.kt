package kz.orkenniet.auth.domain.usecase

import com.google.firebase.auth.AuthResult
import kz.orkenniet.auth.domain.repository.AuthRepository
import kz.orkenniet.core.resource.Resource

class LoginUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun login(email: String, password: String): Resource<AuthResult> {
        return authRepository.login(email,  password)
    }
}