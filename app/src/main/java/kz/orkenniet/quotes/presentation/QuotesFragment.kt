package kz.orkenniet.quotes.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.FragmentQuotesBinding

class QuotesFragment : Fragment(R.layout.fragment_quotes) {

    private val binding: FragmentQuotesBinding by viewBinding(FragmentQuotesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
<<<<<<< HEAD
        binding.root
=======
        binding.javaClass
>>>>>>> 7d8efb7 (quotes fragment jasadym)
    }
}
