package com.example.lexicoolapp.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lexicoolapp.R;

public class ProfileFragment extends Fragment {

    private ImageView ivProfile;
    private TextView tvUsername;
    private TextView tvCoins;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivProfile = view.findViewById(R.id.ivProfile);
        tvUsername = view.findViewById(R.id.tvUsername);
        tvCoins = view.findViewById(R.id.tvCoins);

    }
}