package com.winter.github.douban.main.view.ui.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winter.github.douban.R;
import com.winter.github.douban.databinding.MovieBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private MovieBinding binding;

    public MovieFragment() {
        // Required empty public constructor
   }

    public static MovieFragment newInstance() {
        MovieFragment movieFragment = new MovieFragment();

        return movieFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);
        return binding.getRoot();
    }

}
