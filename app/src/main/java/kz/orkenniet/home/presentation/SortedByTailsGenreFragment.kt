package kz.orkenniet.home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.FragmentSortedByTailsGenreBinding
import kz.orkenniet.home.adapter.SortedByGenreAdapter

class SortedByTailsGenreFragment : Fragment(R.layout.fragment_sorted_by_tails_genre) {
    private val binding: FragmentSortedByTailsGenreBinding by viewBinding(
        FragmentSortedByTailsGenreBinding::bind
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
            llFairyTailsGenre.setBackgroundDrawable(resources.getDrawable(R.drawable.button_primary))
            llTailsTxv.setTextColor(resources.getColor(R.color.white))

            llDetectiveGenre.setOnClickListener {
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.layout, SortedByDetectiveGenreFragment())
                    ?.commit()
            }

            llAdventureGenre.setOnClickListener {
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.layout, SortedByAdventureGenreFragment())
                    ?.commit()
            }
        }
        recyclerAdapter.submitList(bookList)
    }
}
