package com.example.aplikasita.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferences {

    static final String KEY_DB_KEY = "dbkey";
    static final String KEY_PASSWORD = "password";


    private static SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences("database",Context.MODE_PRIVATE);
    }

    public static void setSharedPreferenceDBKey(Context context, String username){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_DB_KEY,username);
        editor.apply();
    }

    public static void setSharedPreferencePassword(Context context,String password){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_PASSWORD,password);
        editor.apply();
    }

    public static String getSharedPreferenceDBKey(Context context) {
        return getSharedPreferences(context).getString(KEY_DB_KEY,null);
    }

    public static String getSharedPreferencePassword(Context context) {
        return getSharedPreferences(context).getString(KEY_PASSWORD,null);
    }

    public static boolean isPasswordCorrect(String password, Context context){
        String correctPassword = getSharedPreferencePassword(context);

        return password.equals(correctPassword);
    }
}
