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
import android.widget.EditText;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestHeaders;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.lexicoolapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.Headers;

public class SearchFragment extends Fragment {

    // API Information
    public static final String SEARCH_URL = "https://wordsapiv1.p.rapidapi.com/words/";
    public static final String RANDOM_KEY = "1d252f1833mshff04d2c04b23255p1ae2b6jsnd3a066caaa16";
    public static final String RANDOM_HOST = "wordsapiv1.p.rapidapi.com";

    private static final String TAG = "SearchFragment";
    private TextView tvSearchDef;
    private EditText etSearch;
    private Button btnSearch;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvSearchDef = view.findViewById(R.id.tvSearchDef);
        etSearch = view.findViewById(R.id.etSearch);
        btnSearch = view.findViewById(R.id.btnSearch);


        btnSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(TAG, "Search button clicked");
                String word = etSearch.getText().toString();
                getWordDef(word);
            }
        });
    }

    private void getWordDef(String word) {

        // API Client
        AsyncHttpClient client = new AsyncHttpClient();
        RequestHeaders headers = new RequestHeaders();
        RequestParams params = new RequestParams();
        headers.put("x-rapidapi-key", RANDOM_KEY);
        headers.put("x-rapidapi-host", RANDOM_HOST);

        client.get(SEARCH_URL + word, headers, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                Log.d(TAG, "API Success");
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("results");
                    JSONObject results2 = results.getJSONObject(0);
                    updateDefinition(word, results2);
                } catch (JSONException e) {
                    Log.e(TAG, "Json Exception", e);
                    e.printStackTrace();
                    tvSearchDef.setText("Definition not found");
                }
            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Log.d(TAG, "API Failure: " + i);
                tvSearchDef.setText("Word not found");
            }
        });
    }

    private void updateDefinition(String word, JSONObject results2) {
        try {
            String definition = results2.getString("definition");
            Log.d(TAG, "Definition: " + definition);
            tvSearchDef.setText(definition);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}