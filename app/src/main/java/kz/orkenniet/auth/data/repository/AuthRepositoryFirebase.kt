package kz.orkenniet.auth.data.repository

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import kz.orkenniet.auth.domain.repository.AuthRepository
import kz.orkenniet.core.resource.Resource
import kz.orkenniet.core.resource.safeCall

class AuthRepositoryFirebase(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseDatabase: FirebaseDatabase,
) : AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResult> {
        return withContext(Dispatchers.IO) {
            safeCall {
                val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
                Resource.Success(result)
            }
        }
    }

    override suspend fun register(email: String, password: String): Resource<AuthResult> {
        return withContext(Dispatchers.IO) {
            safeCall {
                val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                Resource.Success(result)
            }
        }
    }

    override fun isLoggedIn(): Boolean {
        val databaseReference = firebaseDatabase.getReference("users")
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            databaseReference.child(currentUser.uid).child("isLoggedIn").setValue(true)
        }
        return currentUser != null
    }
}