package kz.orkenniet.auth.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import kz.orkenniet.R
import kz.orkenniet.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity(R.layout.activity_auth) {

    private val binding: ActivityAuthBinding by viewBinding(ActivityAuthBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
    }

    private fun setupView() = with(binding) {
        viewPager.adapter = AuthPagerAdapter(this@AuthActivity)
        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            when (position) {
                AuthPagerAdapter.LOGIN_FRAGMENT_POSITION -> tab.text = "Login"
                AuthPagerAdapter.REGISTRATION_FRAGMENT_POSITION -> tab.text = "registration"
            }
        }.attach()
    }
}