package kz.orkenniet.home.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.core.extentions.navigate
import kz.orkenniet.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
    }

    private fun setupNavigation() = with(binding) {
        llAdventureGenre.setOnClickListener {
            navigateToSortedBook("приключения")
        }
        llDetectiveGenre.setOnClickListener {
            navigateToSortedBook("детектив")
        }
        llFairyTailsGenre.setOnClickListener {
            navigateToSortedBook("сказки")
        }
    }

    private fun navigateToSortedBook(genre: String) {
        navigate(
            HomeFragmentDirections.actionHomeFragmentToSortedBookFragment(genre)
        )
    }
}

