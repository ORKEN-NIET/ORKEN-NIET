package com.example.experience.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.experience.R;

public class BibliotekaFragment extends Fragment {

    public BibliotekaFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_biblioteka, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout l_book = view.findViewById(R.id.l_book);
        TextView txt_reading = view.findViewById(R.id.txt_reading);
        TextView txt_want = view.findViewById(R.id.txt_want);
        TextView txt_read = view.findViewById(R.id.txt_read);
        l_book.setBackgroundResource(R.drawable.book_rounded);
        txt_reading.setBackgroundResource(R.drawable.rounded_button_biblioteka);
        F_ReadingFragment readingFragment = new F_ReadingFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_biblioteka_container, readingFragment);
        transaction.commit();
        txt_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_reading.setBackgroundResource(R.drawable.rounded_button_biblioteka);
                txt_reading.setTextColor(ContextCompat.getColor(getContext(),R.color.white));
                txt_read.setTextColor(ContextCompat.getColor(getContext(),R.color.blue));
                txt_want.setTextColor(ContextCompat.getColor(getContext(),R.color.blue));
                txt_read.setBackgroundResource(R.drawable.book_rounded);
                txt_want.setBackgroundResource(R.drawable.book_rounded);
                F_ReadingFragment readingFragment = new F_ReadingFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_biblioteka_container, readingFragment);
                transaction.commit();
            }
        });
        txt_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                F_ReadFragment readFragment = new F_ReadFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_biblioteka_container, readFragment);
                transaction.commit();
                txt_read.setBackgroundResource(R.drawable.rounded_button_biblioteka);
                txt_read.setTextColor(ContextCompat.getColor(getContext(),R.color.white));
                txt_reading.setTextColor(ContextCompat.getColor(getContext(),R.color.blue));
                txt_want.setTextColor(ContextCompat.getColor(getContext(),R.color.blue));
                txt_reading.setBackgroundResource(R.drawable.book_rounded);
                txt_want.setBackgroundResource(R.drawable.book_rounded);
            }
        });
        txt_want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                F_WantFragment wantFragment = new F_WantFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_biblioteka_container, wantFragment);
                transaction.commit();
                txt_want.setBackgroundResource(R.drawable.rounded_button_biblioteka);
                txt_want.setTextColor(ContextCompat.getColor(getContext(),R.color.white));
                txt_read.setTextColor(ContextCompat.getColor(getContext(),R.color.blue));
                txt_reading.setTextColor(ContextCompat.getColor(getContext(),R.color.blue));
                txt_read.setBackgroundResource(R.drawable.book_rounded);
                txt_reading.setBackgroundResource(R.drawable.book_rounded);
            }
        });
        return view;
    }
}
