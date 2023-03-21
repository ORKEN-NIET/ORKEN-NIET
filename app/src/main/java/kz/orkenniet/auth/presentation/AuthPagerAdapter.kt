package kz.orkenniet.auth.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kz.orkenniet.auth.presentation.login.LoginFragment
import kz.orkenniet.auth.presentation.registration.RegistrationFragment

class AuthPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    companion object {
        const val AUTH_FRAGMENT_COUNT = 2
        const val LOGIN_FRAGMENT_POSITION = 0
        const val REGISTRATION_FRAGMENT_POSITION = 1
    }

    override fun getItemCount(): Int {
        return AUTH_FRAGMENT_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            LOGIN_FRAGMENT_POSITION -> LoginFragment()
            REGISTRATION_FRAGMENT_POSITION -> RegistrationFragment()
            else -> throw IllegalArgumentException("Unknown auth position")
        }
    }
}