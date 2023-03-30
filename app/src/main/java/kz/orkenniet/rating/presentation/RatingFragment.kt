package kz.orkenniet.rating.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.FragmentRatingBinding
import kz.orkenniet.rating.data.model.RatingItem
import kz.orkenniet.rating.domain.adapter.RatingAdapter

class RatingFragment : Fragment(R.layout.fragment_rating) {

    private val binding: FragmentRatingBinding by viewBinding(FragmentRatingBinding::bind)
    lateinit var recyclerAdapter: RatingAdapter
    var ratingList = arrayListOf<RatingItem>(
        RatingItem(R.drawable.share, "Aleke", "1000 прочитано страниц"),
        RatingItem(R.drawable.share, "Bake", "242 прочитано страниц"),
        RatingItem(R.drawable.share, "Sake", "250 прочитано страниц"),
        RatingItem(R.drawable.share, "Dake", "251 прочитано страниц"),
        RatingItem(R.drawable.share, "Cambak", "258 прочитано страниц")

    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)
        recyclerAdapter = RatingAdapter()
        binding.apply {
            recylcerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = recyclerAdapter
                setHasFixedSize(true)
            }
        }
        recyclerAdapter.submitList(ratingList)
    }
}
