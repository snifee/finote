package com.example.aplikasita.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferences {

    public static final String KEY_DB_KEY = "dbkey";
    public static final String KEY_PASSWORD = "password";
    public static final String CURRENT_PASSWORD = "user_password";


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

    public static void setSharedPreferenceTemporaryPassword(Context context,String tempPassword){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(CURRENT_PASSWORD,tempPassword);
        editor.apply();
    }

    public static void deleteSharedPreferenceTemporaryPassword(Context context){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.remove(CURRENT_PASSWORD);
        editor.apply();
    }

    public static String getSharedPreferenceTemporaryPassword(Context context) {
        return getSharedPreferences(context).getString(CURRENT_PASSWORD,null);
    }


    public static boolean isPasswordCorrect(String password, Context context){
        String correctPassword = getSharedPreferencePassword(context);

        return password.equals(correctPassword);
    }
}
