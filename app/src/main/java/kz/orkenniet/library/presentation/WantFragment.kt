package kz.orkenniet.library.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.FragmentWantBinding

class WantFragment : Fragment(R.layout.fragment_want) {

    private val binding: FragmentWantBinding by viewBinding(FragmentWantBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.javaClass
    }
}
