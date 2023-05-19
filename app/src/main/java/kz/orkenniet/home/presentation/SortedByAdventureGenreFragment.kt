package kz.orkenniet.home.presentation

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.FragmentSortedByAdventureGenreBinding
import kz.orkenniet.home.adapter.SortedByGenreAdapter

class SortedByAdventureGenreFragment : Fragment(R.layout.fragment_sorted_by_adventure_genre) {
    private val binding: FragmentSortedByAdventureGenreBinding by viewBinding(
        FragmentSortedByAdventureGenreBinding::bind
    )
    private val recyclerAdapter: SortedByGenreAdapter = SortedByGenreAdapter()
    private val sortedBookViewModel: SortedBookViewModel = SortedBookViewModel()

    @Suppress("MagicNumber")

    private var bookList = sortedBookViewModel.getSortedBookList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclerView.apply {
                adapter = recyclerAdapter
                layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
            }
            llAdventureGenre.setBackgroundDrawable(resources.getDrawable(R.drawable.button_primary))
            llAdventureTxv.setTextColor(resources.getColor(R.color.white))
            llDetectiveGenre.setOnClickListener {
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.layout, SortedByDetectiveGenreFragment())
                    ?.commit()
            }

            llFairyTailsGenre.setOnClickListener {
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.layout, SortedByTailsGenreFragment())
                    ?.commit()
            }
        }

        recyclerAdapter.submitList(bookList)
    }
}
