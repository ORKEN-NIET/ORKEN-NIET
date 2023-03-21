package kz.orkenniet.auth.presentation.registration

import androidx.lifecycle.ViewModel
import kz.orkenniet.auth.domain.usecase.RegistrationUseCase

class RegistrationViewModel(
    private val registrationUseCase: RegistrationUseCase
) : ViewModel() {
}