package kz.orkenniet.login.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.admin.presentation.AdminMainActivity
import kz.orkenniet.core.extentions.collect
import kz.orkenniet.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    private val viewModel: LoginViewModel by viewModels()
    private val binding: ActivityLoginBinding by viewBinding(ActivityLoginBinding::bind )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        collectViewModel()
        setupView()
    }

    private fun setupView() = with(binding) {
        btnKiru.setOnClickListener { viewModel.onLoginClicked() }
        edtEmail.doAfterTextChanged { email ->
            viewModel.inputEmail(email.toString())
        }
        edtPassword.doAfterTextChanged { password ->
            viewModel.inputPassword(password.toString())
        }
    }

    private fun collectViewModel() {
        viewModel.action.collect(this) { action ->
            when (action) {
                LoginViewModel.Action.Login -> {
                    val intent = Intent(this, AdminMainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

}