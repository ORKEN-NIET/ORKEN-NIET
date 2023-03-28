package kz.orkenniet.admin.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kz.orkenniet.R
import kz.orkenniet.databinding.ActivityAdminMainBinding
import kz.orkenniet.home.presentation.HomeFragment
import kz.orkenniet.library.presentation.LibraryFragment
import kz.orkenniet.profile.presentation.ProfileFragment
import kz.orkenniet.quotes.presentation.QuotesFragment

class AdminMainActivity : AppCompatActivity(R.layout.activity_admin_main) {

    private val binding: ActivityAdminMainBinding by viewBinding(ActivityAdminMainBinding::bind)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.navigation.setOnNavigationItemSelectedListener(navListener)
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            HomeFragment()
        ).commit()
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
            R.id.fragment_container,
            selectedFragment!!
        ).commit()
        true
    }
}
