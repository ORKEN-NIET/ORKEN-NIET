package kz.orkenniet.auth.presentation.login

import android.content.Intent
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
import kz.orkenniet.databinding.FragmentLoginBinding
import kz.orkenniet.tabbar.presentation.MainActivity
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
        authResult.collect(viewLifecycleOwner, ::renderLoginResult)
    }

    private fun renderLoginResult(result: Resource<AuthResult>) {
        when (result) {
            is Resource.Success -> {
                binding.loadingLayout.loadingLayout.isVisible = false
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
            is Resource.Error -> {
                binding.loadingLayout.loadingLayout.isVisible = false
                showToast(result.message.orEmpty())
            }
            is Resource.Loading -> binding.loadingLayout.loadingLayout.isVisible = true
        }
    }
}