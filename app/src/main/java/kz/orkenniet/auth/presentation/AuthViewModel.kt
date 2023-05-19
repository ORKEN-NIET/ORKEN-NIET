package kz.orkenniet.auth.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kz.orkenniet.auth.domain.usecase.IsLoggedInUseCase

class AuthViewModel(
    private val isLoggedInUseCase: IsLoggedInUseCase
) : ViewModel() {

    private val _isLoggedInFlow = MutableStateFlow(false)
    val isLoggedInFlow = _isLoggedInFlow.asStateFlow()

    init {
        checkLoggedIn()
    }

    private fun checkLoggedIn() {
        _isLoggedInFlow.value = isLoggedInUseCase()
    }
}
