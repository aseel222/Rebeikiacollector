package com.example.rebeikiacollector.repository.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.rebeikiacollector.utiles.Language;

public class PreferencesManager {

    String LANGUAGE_KEY = "LANGUAGE_KEY";
    public SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    public PreferencesManager(Context _context) {
        this._context = _context;
        pref = _context.getSharedPreferences("pref_file",Context.MODE_PRIVATE);

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
