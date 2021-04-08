package com.example.lexicoolapp;

import android.app.Application;
import com.parse.Parse;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("EKv8YLxpiNEfq6WpzbKrMVycm2YmlZXlWefUsJmY")
                .clientKey("ovNW7VCUr0MtuabSL7kVN3Mdjm0bBj6kU2utsbJe")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
