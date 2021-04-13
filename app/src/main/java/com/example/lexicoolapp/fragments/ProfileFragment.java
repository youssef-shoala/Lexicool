package com.example.lexicoolapp.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lexicoolapp.Coins;
import com.example.lexicoolapp.LoginActivity;
import com.example.lexicoolapp.MainActivity;
import com.example.lexicoolapp.R;
import com.parse.ParseUser;

public class ProfileFragment extends Fragment {

    private ImageView ivProfile;
    private TextView tvUsername;
    private TextView tvCoins;
    ParseUser user;
    private Button btnLogout;


    public ProfileFragment() {
        // Required constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivProfile = view.findViewById(R.id.ivProfile);
        tvUsername = view.findViewById(R.id.tvUsername);
        tvCoins = view.findViewById(R.id.tvCoins);
        btnLogout = view.findViewById(R.id.btnLogout);

        user = ParseUser.getCurrentUser();
        tvUsername.setText(user.getUsername());
        tvCoins.setText(String.valueOf(Coins.getCoins()));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                goLoginActivity();
            }
        });
    }
    private void goLoginActivity() {
        Intent i = new Intent(getContext(), LoginActivity.class);
        startActivity(i);
    }
}
