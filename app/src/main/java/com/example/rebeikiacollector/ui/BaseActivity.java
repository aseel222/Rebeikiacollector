package com.example.rebeikiacollector.ui;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.repository.local.PreferencesManager;
import com.example.rebeikiacollector.utiles.Language;

import java.util.Locale;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String language = new PreferencesManager(this).getLanguage();
        changeLanguage(Language.valueOf(language));

    }

    @Override
    protected void onStart() {
        super.onStart();
        setupClicks();
    }

    private void setupClicks() {
        ImageView back = findViewById(R.id.iv_back);
        if (back != null){
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    public void logd(String msg){
        Log.d("classTag" ,msg );
    }

    public void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void changeLanguage(Language selectedLanguage) {

        Configuration config = getResources().getConfiguration();

        if (selectedLanguage == Language.ar) {
            Locale ar = new Locale("ar");
            Locale.setDefault(ar);
            config.setLocale(ar);
            config.setLayoutDirection(ar);
            new PreferencesManager(this).saveLanguage(Language.ar);
        } else if (selectedLanguage == Language.en) {
            Locale locale = Locale.ENGLISH;
            Locale.setDefault(locale);
            config.setLocale(locale);
            config.setLayoutDirection(locale);

            new PreferencesManager(this).saveLanguage(Language.en);
        }
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

}
