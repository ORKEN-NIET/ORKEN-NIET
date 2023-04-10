package kz.orkenniet.home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.FragmentSortedByGenreBinding
import kz.orkenniet.home.adapter.SortedByGenreAdapter

class SortedByDetectiveGenreFragment : Fragment(R.layout.fragment_sorted_by_genre) {

    private val binding: FragmentSortedByGenreBinding by viewBinding(FragmentSortedByGenreBinding::bind)
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
            llDetectiveGenre.setBackgroundDrawable(resources.getDrawable(R.drawable.button_primary))
            llDetectiveTxv.setTextColor(resources.getColor(R.color.white))
            llFairyTailsGenre.setOnClickListener {
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.layout, SortedByTailsGenreFragment())
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
