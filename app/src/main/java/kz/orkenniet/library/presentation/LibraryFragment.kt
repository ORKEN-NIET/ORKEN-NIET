package kz.orkenniet.library.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import kz.orkenniet.R
import kz.orkenniet.databinding.FragmentLibraryBinding

class LibraryFragment : Fragment(R.layout.fragment_library) {

    private val binding: FragmentLibraryBinding by viewBinding(FragmentLibraryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.javaClass
        setupView()
    }

    private fun setupView() = with(binding) {
        viewPager.adapter = LibraryPagerAdapter(this@LibraryFragment)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                LibraryPagerAdapter.READ_FRAGMENT_POSITION -> tab.text = "Reading"
                LibraryPagerAdapter.READING_FRAGMENT_POSITION -> tab.text = "Want"
                LibraryPagerAdapter.WANT_FRAGMENT_POSITION -> tab.text = "Read"
            }
        }.attach()
    }
}
