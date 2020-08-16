package com.example.rebeikiacollector.repository.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.rebeikiacollector.utiles.Language;

public class PreferencesManager {

    String LANGUAGE_KEY = "LANGUAGE_KEY";
    public SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    String USER_TOKEN  = "Some token From Server";


    public PreferencesManager(Context _context) {
        this._context = _context;
        pref = _context.getSharedPreferences("pref_file",Context.MODE_PRIVATE);

    }
    public void savetoken( String token) {
        editor=pref.edit();
        editor.putString(USER_TOKEN , token);
        editor.apply();
    }
    public String fetchtoken(){
        return pref.getString(USER_TOKEN,null);
    }

    public boolean islogin(){
        if(pref.contains(USER_TOKEN)){
            return true;
        }
        return false;
    }
    public void signout(){
        pref.edit().remove(USER_TOKEN).apply();
    }


    public  void saveLanguage(Language language) {
        editor=pref.edit();
        editor.putString(LANGUAGE_KEY , language.toString());
        editor.apply();
    }
    public String getLanguage(){
        return pref.getString(LANGUAGE_KEY,null);
    }

}
