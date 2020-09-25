package com.appoolooft.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class Sharedpref {
    SharedPreferences mySharedPref;
    public Sharedpref(Context context){

        mySharedPref = context.getSharedPreferences("filename",Context.MODE_PRIVATE);


    }
    // this method will sabe the Night Mode state : True or false
    public void  setNightMode(Boolean state){
        SharedPreferences.Editor editor =mySharedPref.edit();
        editor.putBoolean("NightMode",state);
        editor.commit();

    }
    //this method will load the Night State
    public boolean loadNightModeState(){
        Boolean state = mySharedPref.getBoolean("NightMode",false);
        return state;
    }
}
