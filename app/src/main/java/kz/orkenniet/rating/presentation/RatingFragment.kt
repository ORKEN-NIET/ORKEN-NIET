package kz.orkenniet.rating.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.FragmentRatingBinding
import kz.orkenniet.rating.data.model.RatingItem
import kz.orkenniet.rating.domain.adapter.RatingAdapter

class RatingFragment : Fragment(R.layout.fragment_rating) {

    private val binding: FragmentRatingBinding by viewBinding(FragmentRatingBinding::bind)
    private var recyclerAdapter: RatingAdapter = RatingAdapter()

    @Suppress("MagicNumber")

    private var ratingList = arrayListOf(
        RatingItem(R.drawable.firstperson, "Aleke", 1000),
        RatingItem(R.drawable.secondperson, "Bake", 242),
        RatingItem(R.drawable.thirdperson, "Sake", 250),
        RatingItem(R.drawable.fourthperson, "Dake", 251),
        RatingItem(R.drawable.fifthperson, "Cambak", 258)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)
        ratingList.sortByDescending {
            it.pages
        }
        binding.apply {
            recylcerView.apply {
                adapter = recyclerAdapter
            }
        }
        recyclerAdapter.submitList(ratingList)
    }
}
