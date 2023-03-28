package kz.orkenniet.tabbar.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kz.orkenniet.R
import kz.orkenniet.databinding.ActivityMainBinding
import kz.orkenniet.home.presentation.HomeFragment
import kz.orkenniet.library.presentation.LibraryFragment
import kz.orkenniet.profile.presentation.ProfileFragment
import kz.orkenniet.quotes.presentation.QuotesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        navListener
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: Fragment? = null
        when (item.itemId) {
            R.id.glavnaya -> selectedFragment = HomeFragment()
            R.id.biblioteka -> selectedFragment = LibraryFragment()
            R.id.citaty -> selectedFragment = QuotesFragment()
            R.id.profil -> selectedFragment = ProfileFragment()
        }
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container, selectedFragment!!
        ).commit()
        true
    }
}
