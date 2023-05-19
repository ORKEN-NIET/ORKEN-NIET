package kz.orkenniet.auth.domain.repository

import com.google.firebase.auth.AuthResult
import kz.orkenniet.core.resource.Resource

interface AuthRepository {

    suspend fun login(email: String, password: String): Resource<AuthResult>
    suspend fun register(email: String, password: String): Resource<AuthResult>
    fun isLoggedIn(): Boolean
}