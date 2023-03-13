package kz.orkenniet.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private var email = ""
    private var password = ""

    val action = MutableSharedFlow<Action>()

    fun inputEmail(value: String) {
        email = value
    }

    fun inputPassword(value: String) {
        password = value
    }

    fun onLoginClicked() {
        viewModelScope.launch {
            if (email == "admin" && password == "123123") {
                action.emit(Action.Login)
            }
        }
    }

    sealed interface Action {
        object Login : Action
    }

}