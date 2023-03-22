package kz.orkenniet.auth.presentation.registration

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.AuthResult
import kz.orkenniet.R
import kz.orkenniet.core.extentions.collect
import kz.orkenniet.core.extentions.showToast
import kz.orkenniet.core.resource.Resource
import kz.orkenniet.databinding.FragmentRegistrationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private val binding: FragmentRegistrationBinding by viewBinding(FragmentRegistrationBinding::bind)
    private val viewModel: RegistrationViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewBinding()
        collectViewModel()
    }

    private fun setupViewBinding() = with(binding) {
        regitrationButton.setOnClickListener { viewModel.onRegisterClicked() }
        emailEditText.doAfterTextChanged { viewModel.inputEmail(it.toString()) }
        passwordEditText.doAfterTextChanged { viewModel.inputPassword(it.toString()) }
        repeatPasswordEditText.doAfterTextChanged { viewModel.inputRepeatedPassword(it.toString()) }
        hasAccountTextView.setOnClickListener { /* todo */ }
    }

    private fun collectViewModel() = with(viewModel) {
        registrationResult.collect(viewLifecycleOwner, ::renderRegistrationResult)
    }

    private fun renderRegistrationResult(result: Resource<AuthResult>) {
        when (result) {
            is Resource.Error -> {
                binding.loadingLayout.loadingLayout.isVisible = false
                showToast(result.message.orEmpty())
            }
            is Resource.Loading -> {
                binding.loadingLayout.loadingLayout.isVisible = true
            }
            is Resource.Success -> {
                binding.emailEditText.setText("")
                binding.passwordEditText.setText("")
                binding.repeatPasswordEditText.setText("")
                binding.loadingLayout.loadingLayout.isVisible = false
                showToast("Registration Success")
            }
        }
    }
}