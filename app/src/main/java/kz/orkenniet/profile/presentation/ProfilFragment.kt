package kz.orkenniet.profile.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.FragmentLoginBinding
import kz.orkenniet.databinding.FragmentProfilBinding

class ProfilFragment : Fragment(R.layout.fragment_profil) {
    private val binding: FragmentProfilBinding by viewBinding(FragmentProfilBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}