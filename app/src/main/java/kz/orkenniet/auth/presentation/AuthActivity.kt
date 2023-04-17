package kz.orkenniet.auth.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import kz.orkenniet.R
import kz.orkenniet.core.extentions.collect
import kz.orkenniet.databinding.ActivityAuthBinding
import kz.orkenniet.tabbar.presentation.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthActivity : AppCompatActivity(R.layout.activity_auth) {

    private val binding: ActivityAuthBinding by viewBinding(ActivityAuthBinding::bind)
    private val viewModel: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        collectViewModel()
        setupView()
    }

    private fun setupView() = with(binding) {
        viewPager.adapter = AuthPagerAdapter(this@AuthActivity)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                AuthPagerAdapter.LOGIN_FRAGMENT_POSITION -> tab.text = "Login"
                AuthPagerAdapter.REGISTRATION_FRAGMENT_POSITION -> tab.text = "registration"
            }
        }.attach()
    }

    private fun collectViewModel() {
        viewModel.isLoggedInFlow.collect(this) { isLoggedIn ->
            if (isLoggedIn) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}