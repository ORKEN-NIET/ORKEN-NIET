package kz.orkenniet.library.presentation

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class LibraryPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    companion object {
        const val LIBRARY_FRAGMENT_COUNT = 3
        const val READING_FRAGMENT_POSITION = 0
        const val READ_FRAGMENT_POSITION = 1
        const val WANT_FRAGMENT_POSITION = 2
    }

    override fun getItemCount(): Int {
        return LIBRARY_FRAGMENT_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            READING_FRAGMENT_POSITION -> ReadingFragment()
            WANT_FRAGMENT_POSITION -> WantFragment()
            READ_FRAGMENT_POSITION -> ReadFragment()
            else -> throw IllegalArgumentException("Unknown auth position")
        }
    }
}
