package com.example.rebeikiacollector.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.repository.local.PreferencesManager;
import com.example.rebeikiacollector.utiles.InternetConnection;
import com.example.rebeikiacollector.utiles.Language;
import com.example.rebeikiacollector.utiles.Utiles;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeLanguage(Utiles.getAppLanguage(this));
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

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
