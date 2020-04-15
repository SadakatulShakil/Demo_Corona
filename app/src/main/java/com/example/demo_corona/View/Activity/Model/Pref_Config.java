package com.example.demo_corona.View.Activity.Model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.demo_corona.R;

import static android.content.Context.*;

public class Pref_Config {

    private SharedPreferences sharedPreferences;
    private Context context;

    public Pref_Config(Context context) {
        this.context = context;

        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), MODE_PRIVATE);

    }

    public void writeLogInStatus(boolean status){
        SharedPreferences.Editor spEditor = sharedPreferences.edit();
        spEditor.putBoolean(context.getString(R.string.pref_login_status), status);
        spEditor.commit();

    }

    public boolean readLogInStatus()
    {
        return sharedPreferences.getBoolean(context.getString(R.string.pref_login_status), false);
    }

    public void writeName(String name){

        SharedPreferences.Editor spEditor = sharedPreferences.edit();
        spEditor.putString(context.getString(R.string.pref_user_name),name);
        spEditor.commit();
    }

    public String readName(){
        return sharedPreferences.getString(context.getString(R.string.pref_user_name), "User");
    }

    public void displayToast(String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
