package kz.orkenniet.admin.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.AdminFragmentProfilBinding

class AdminProfileFragment : Fragment(R.layout.admin_fragment_profil) {

    private val binding: AdminFragmentProfilBinding by viewBinding(AdminFragmentProfilBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editTextEmail
    }
}
