package com.example.tourguideproject.ui.museum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tourguideproject.databinding.FragmentMuseumBinding;

public class MuseumFragment extends Fragment {

    private FragmentMuseumBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MuseumViewModel museumViewModel =
                new ViewModelProvider(this).get(MuseumViewModel.class);

        binding = FragmentMuseumBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMuseum;
        museumViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}