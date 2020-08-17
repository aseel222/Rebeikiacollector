package com.example.rebeikiacollector.ui;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.databinding.ActivityMenuBinding;
import com.example.rebeikiacollector.repository.local.PreferencesManager;
import com.example.rebeikiacollector.ui.activity.BaseActivity;
import com.example.rebeikiacollector.ui.activity.LoginActivity;
import com.example.rebeikiacollector.ui.activity.SplashActivity;
import com.example.rebeikiacollector.utiles.Constants;
import com.example.rebeikiacollector.utiles.Language;
import com.example.rebeikiacollector.utiles.Utiles;
import com.example.rebeikiacollector.viewModel.MenuViewModel;
import com.squareup.picasso.Picasso;

public class MenuActivity extends BaseActivity {

    private ActivityMenuBinding binding;
    private MenuViewModel viewModel;
    PreferencesManager pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_menu);
        binding.setClickHandler(new MenuClickHandler());
        viewModel = new ViewModelProvider(this).get(MenuViewModel.class);
        pref = new PreferencesManager(this);
        setupLanguage();
        viewModel.getProfileData("Bearer "+pref.fetchtoken());
        observeData();

    }

    private void observeData() {
        viewModel.profileResponse.observe(this , profileResponse -> {
            binding.tvName.setText(profileResponse.getName());
            Picasso.get().load(profileResponse.getImage()).into(binding.profileImage);
            binding.tvTotalPoints.setText(profileResponse.getRole());
        });

        viewModel.logoutResponse.observe(this , baseResponse -> {
            Intent i = new Intent(MenuActivity.this, LoginActivity.class);
            finishAffinity();
            startActivity(i);
        });
    }

    private void setupLanguage() {
        Language appLanguage = Utiles.getAppLanguage(this);
        binding.toggle.setChecked(appLanguage.toString().equals("en"));
        binding.toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    changeLanguage(Language.en);
                    pref.saveLanguage(Language.en);

                } else {
                    changeLanguage(Language.ar);
                    pref.saveLanguage(Language.ar);
                }
                Intent intent = new Intent(MenuActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });
    }
    public class MenuClickHandler{
        public void onLogoutClick() {
            viewModel.logOut("Bearer "+pref.fetchtoken());
        }
    }
}