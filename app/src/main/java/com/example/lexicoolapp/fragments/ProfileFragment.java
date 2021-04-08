package com.example.lexicoolapp.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lexicoolapp.R;

public class ProfileFragment extends AppCompatActivity {

    private ImageView ivProfile;
    private TextView tvUsername;
    private TextView tvCoins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_fragment);

        ivProfile = findViewById(R.id.ivProfile);
        tvUsername = findViewById(R.id.tvUsername);
        tvCoins = findViewById(R.id.tvCoins);
    }
}