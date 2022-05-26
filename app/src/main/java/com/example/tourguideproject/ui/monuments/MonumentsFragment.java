package com.example.tourguideproject.ui.monuments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tourguideproject.databinding.FragmentMonumentsBinding;

public class MonumentsFragment extends Fragment {

    private FragmentMonumentsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MonumentsViewModel monumentsViewModel =
                new ViewModelProvider(this).get(MonumentsViewModel.class);

        binding = FragmentMonumentsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMonuments;
        monumentsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}