package com.example.sharedprefrences;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    SharedPreferences sharedPreferences;

    public UserManager(Context context){
        sharedPreferences = context.getSharedPreferences("app_data",Context.MODE_PRIVATE);

    }

    public void save_data(String name,String family,String gender){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",name);
        editor.putString("family",family);
        editor.putString("gender",gender);
        editor.apply();
    }

    public String getName(){
        return sharedPreferences.getString("name","");
    }
    public String getFamily(){
        return sharedPreferences.getString("family","");
    }
    public String getGender(){
        return sharedPreferences.getString("gender","");
    }

}
