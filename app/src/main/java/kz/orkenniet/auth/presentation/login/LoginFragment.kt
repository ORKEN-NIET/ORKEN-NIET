package kz.orkenniet.auth.presentation.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.AuthResult
import kz.orkenniet.R
import kz.orkenniet.core.extentions.collect
import kz.orkenniet.core.resource.Resource
import kz.orkenniet.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewBinding()
        collectViewModel()
    }

    private fun setupViewBinding() = with(binding) {
        btnLogin.setOnClickListener { viewModel.onLoginClicked() }
        forgotPasswordTextView.setOnClickListener { /* todo */ }
        editTextEmail.doAfterTextChanged { viewModel.inputEmail(it.toString()) }
        editTextPassword.doAfterTextChanged { viewModel.inputPassword(it.toString()) }
    }

    private fun collectViewModel() = with(viewModel) {
        authResult.collect(viewLifecycleOwner, ::render)
    }

    private fun render(result: Resource<AuthResult>) {
        when (result) {
            is Resource.Success -> {
                binding.loadingLayout.loadingLayout.isVisible = false
                Toast.makeText(requireContext(), result.message.orEmpty(), Toast.LENGTH_LONG).show()
            }
            is Resource.Error -> {
                binding.loadingLayout.loadingLayout.isVisible = false
                Toast.makeText(requireContext(), result.message.orEmpty(), Toast.LENGTH_LONG).show()
            }
            is Resource.Loading -> binding.loadingLayout.loadingLayout.isVisible = true
        }
    }
}