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
    var ratingList = arrayListOf<RatingItem>()
    var recyclerAdapter: RatingAdapter = RatingAdapter(ratingList)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)
        var ratingFirst = RatingItem(R.drawable.share, "Данияр", "1000 прочитано страниц")
        var ratingSecond = RatingItem(R.drawable.share, "Данияр", "250 прочитано страниц")
        var ratingThird = RatingItem(R.drawable.share, "Данияр", "250 прочитано страниц")
        var ratingFourth = RatingItem(R.drawable.share, "Данияр", "250 прочитано страниц")
        var ratingFifth = RatingItem(R.drawable.share, "Данияр", "250 прочитано страниц")
        ratingList.add(ratingFirst)
        ratingList.add(ratingSecond)
        ratingList.add(ratingThird)
        ratingList.add(ratingFourth)
        ratingList.add(ratingFifth)
        binding.recylcerView.adapter = recyclerAdapter
        binding.recylcerView.layoutManager = LinearLayoutManager(context)
        binding.recylcerView.setHasFixedSize(true)
    }
}
