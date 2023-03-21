package kz.orkenniet.auth.data.repository

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import kz.orkenniet.auth.domain.repository.AuthRepository
import kz.orkenniet.core.resource.Resource
import kz.orkenniet.core.resource.safeCall

class AuthRepositoryFirebase(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResult> {
        return withContext(Dispatchers.IO) {
            safeCall {
                val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
                Resource.Success(result)
            }
        }
    }

    override suspend fun register(email: String, password: String, repeatPassword: String) {
    }
}