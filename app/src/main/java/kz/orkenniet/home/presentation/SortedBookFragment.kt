package kz.orkenniet.home.presentation

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.core.extentions.collect
import kz.orkenniet.core.extentions.showToast
import kz.orkenniet.databinding.FragmentSortedBooksBinding
import kz.orkenniet.home.presentation.adapter.SortedByGenreAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SortedBookFragment : Fragment(R.layout.fragment_sorted_books) {

    private val args: SortedBookFragmentArgs by navArgs()
    private val viewModel: SortedBookViewModel by viewModel {
        parametersOf(args.genre)
    }
    private val binding: FragmentSortedBooksBinding by viewBinding(FragmentSortedBooksBinding::bind)
    private val recyclerAdapter = SortedByGenreAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewBinding()
        collectViewModel()
    }

    private fun setupViewBinding() = with(binding) {
        detectiveGenreTextView.setOnClickListener {
            viewModel.getSortedBooks("детектив")
        }
        adventureGenreTextView.setOnClickListener {
            viewModel.getSortedBooks("приключения")
        }
        fairyTailGenreTextView.setOnClickListener {
            viewModel.getSortedBooks("сказки")
        }
        recyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
        }
    }

    private fun collectViewModel() = with(viewModel) {
        sortedBookList.collect(viewLifecycleOwner, recyclerAdapter::submitList)
        error.collect(viewLifecycleOwner) { message ->
            showToast(message)
        }
        loading.collect(viewLifecycleOwner) {
            binding.layoutLoading.loadingLayout.isVisible = it
        }
        selectedGenre.collect(viewLifecycleOwner) { genre ->
            binding.detectiveGenreTextView.setBackgroundResource(R.drawable.rounded_button)
            binding.adventureGenreTextView.setBackgroundResource(R.drawable.rounded_button)
            binding.fairyTailGenreTextView.setBackgroundResource(R.drawable.rounded_button)
            binding.detectiveGenreTextView.setTextColor(resources.getColor(R.color.blue))
            binding.adventureGenreTextView.setTextColor(resources.getColor(R.color.blue))
            binding.fairyTailGenreTextView.setTextColor(resources.getColor(R.color.blue))
            when (genre) {
                "детектив" -> {
                    binding.detectiveGenreTextView.apply {
                        setTextColor(resources.getColor(R.color.white))
                        setBackgroundResource(R.drawable.rounded_button_biblioteka)
                    }
                }
                "приключения" -> {
                    binding.adventureGenreTextView.apply {
                        setTextColor(resources.getColor(R.color.white))
                        setBackgroundResource(R.drawable.rounded_button_biblioteka)
                    }
                }
                "сказки" -> {
                    binding.fairyTailGenreTextView.apply {
                        setTextColor(resources.getColor(R.color.white))
                        setBackgroundResource(R.drawable.rounded_button_biblioteka)
                    }
                }
            }
        }
    }
}
