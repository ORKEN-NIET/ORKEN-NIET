package kz.orkenniet.quotes.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.FragmentCitatyBinding

class CitatyFragment : Fragment(R.layout.fragment_citaty) {

    private val binding: FragmentCitatyBinding by viewBinding(FragmentCitatyBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root
    }
}
