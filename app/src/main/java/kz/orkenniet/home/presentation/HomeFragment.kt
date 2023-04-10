package kz.orkenniet.home.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.llAdventureGenre.setOnClickListener{
            val transition = this.fragmentManager?.beginTransaction()
                ?.replace(R.id.layout,SortedByAdventureGenreFragment())
                ?.commit()
        }
        binding.llDetectiveGenre.setOnClickListener{
            val transition = this.fragmentManager?.beginTransaction()
                ?.replace(R.id.layout,SortedByDetectiveGenreFragment())
                ?.commit()
        }
        binding.llFairyTailsGenre.setOnClickListener{
            val transition = this.fragmentManager?.beginTransaction()
                ?.replace(R.id.layout,SortedByTailsGenreFragment())
                ?.commit()
        }
    }
}
