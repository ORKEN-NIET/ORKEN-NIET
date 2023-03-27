package kz.orkenniet.profile.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import kz.orkenniet.R;

public class ProfilFragment extends Fragment {

    public ProfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        /**
         * мен бирденке истедим
         * */


        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        return view;
    }
}
