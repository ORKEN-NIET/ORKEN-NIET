package kz.orkenniet.library.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.FragmentBibliotekaBinding

class BibliotekaFragment : Fragment(R.layout.fragment_biblioteka) {

    private val binding:FragmentBibliotekaBinding by viewBinding(FragmentBibliotekaBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}