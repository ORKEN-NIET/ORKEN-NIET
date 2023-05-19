package kz.orkenniet.tabbar.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kz.orkenniet.R
import kz.orkenniet.databinding.ActivityMainBinding
import kz.orkenniet.home.presentation.HomeFragment
import kz.orkenniet.library.presentation.LibraryFragment
import kz.orkenniet.profile.presentation.ProfileFragment
import kz.orkenniet.rating.presentation.RatingFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.navigation.setOnNavigationItemSelectedListener(navListener)
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            HomeFragment()
        ).commit()
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment = when (item.itemId) {
            R.id.glavnaya -> HomeFragment()
            R.id.biblioteka -> LibraryFragment()
            R.id.citaty -> RatingFragment()
            R.id.profil -> ProfileFragment()
            else -> null
        }
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            selectedFragment!!
        ).commit()
        true
    }
}
