package com.example.rebeikiacollector.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.viewModel.ActiveRequestsViewModel;

public class SpecialActiveRequestsActivity extends BaseActivity {
    private ActiveRequestsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_active_requests);
        viewModel = new ViewModelProvider(this).get(ActiveRequestsViewModel.class);
        observeData();
    }

    private void observeData() {

    }
}