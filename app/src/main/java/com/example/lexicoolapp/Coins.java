package com.example.lexicoolapp;

import com.parse.ParseFile;
import com.parse.ParseUser;

public class Coins extends ParseUser {
    public static int COINS = 0;

    public static int getCoins(){return COINS; }

    public static void setCoins(int coins){
        COINS = coins;
    }
}
