package kz.orkenniet.library.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.FragmentBibliotekaBinding

class LibraryFragment : Fragment(R.layout.`fragment_library.xml`) {

    private val binding: FragmentBibliotekaBinding by viewBinding(FragmentBibliotekaBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}