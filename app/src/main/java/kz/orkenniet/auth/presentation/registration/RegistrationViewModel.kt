package kz.orkenniet.auth.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kz.orkenniet.auth.domain.usecase.RegistrationUseCase
import kz.orkenniet.core.resource.Resource
import kz.orkenniet.core.resource.doOnSuccess

class RegistrationViewModel(
    private val registrationUseCase: RegistrationUseCase
) : ViewModel() {

    private var email = ""
    private var password = ""
    private var repeatPassword = ""

    val registrationResult = MutableSharedFlow<Resource<AuthResult>>()

    fun inputEmail(value: String) {
        email = value
    }

    fun inputPassword(value: String) {
        password = value
    }

    fun inputRepeatedPassword(value: String) {
        repeatPassword = value
    }

    fun onRegisterClicked() {
        viewModelScope.launch {
            registrationResult.emit(Resource.Loading())
            registrationResult.emit(registrationUseCase.register(email, password, repeatPassword))
        }
    }
}