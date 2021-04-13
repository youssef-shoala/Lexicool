package com.example.lexicoolapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestHeaders;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.lexicoolapp.Coins;
import com.example.lexicoolapp.R;
import com.parse.ParseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.Headers;

public class RandomFragment extends Fragment {

    // API Information
    public static final String RANDOM_URL = "https://wordsapiv1.p.rapidapi.com/words/?hasDetails=definitions&random=true";
    public static final String RANDOM_KEY = "1d252f1833mshff04d2c04b23255p1ae2b6jsnd3a066caaa16";
    public static final String RANDOM_HOST = "wordsapiv1.p.rapidapi.com";

    private static final String TAG = "RandomFragment";
    private TextView tvWord;
    private TextView tvDefinition;
    private Button btnRandom;

    public RandomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvWord = view.findViewById(R.id.tvWord);
        tvDefinition = view.findViewById(R.id.tvDefinition);
        btnRandom = view.findViewById(R.id.btnRandom);

        ParseUser user = ParseUser.getCurrentUser();


        btnRandom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(TAG, "New word button clicked");
                getRandomWord();
                Coins.setCoins((Coins.getCoins()+1));
            }
        });
    }


    private void getRandomWord() {

        // API Client
        AsyncHttpClient client = new AsyncHttpClient();
        RequestHeaders headers = new RequestHeaders();
        RequestParams params = new RequestParams();
        headers.put("x-rapidapi-key", RANDOM_KEY);
        headers.put("x-rapidapi-host", RANDOM_HOST);

        client.get(RANDOM_URL, headers, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                Log.d(TAG, "API Success");
                JSONObject jsonObject = json.jsonObject;
                try {

                    String word = jsonObject.getString("word");
                    Log.d(TAG,"Word: " + word);
                    JSONArray results = jsonObject.getJSONArray("results");
                    JSONObject results2 = results.getJSONObject(0);
                    updateDefinition(word, results2);
                } catch (JSONException e) {
                    Log.e(TAG, "Json Exception", e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Log.d(TAG, "API Failure: " + i);
            }
        });
    }

    private void updateDefinition(String word, JSONObject results2) {
        try {
            String definition = results2.getString("definition");
            Log.d(TAG, "Definition: " + definition);
            tvWord.setText(word);
            tvDefinition.setText(definition);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}