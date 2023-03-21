package kz.orkenniet.auth.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kz.orkenniet.auth.domain.usecase.LoginUseCase
import kz.orkenniet.core.resource.Resource

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private var email = ""
    private var password = ""

    val authResult = MutableSharedFlow<Resource<AuthResult>>()

    fun inputEmail(value: String) {
        email = value
    }

    fun inputPassword(value: String) {
        password = value
    }

    fun onLoginClicked() {
        viewModelScope.launch {
            authResult.emit(Resource.Loading())
            authResult.emit(loginUseCase.login(email, password))
        }
    }
}