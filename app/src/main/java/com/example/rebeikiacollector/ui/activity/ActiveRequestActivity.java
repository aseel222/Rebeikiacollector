package com.example.rebeikiacollector.ui.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.databinding.ActivityActiveRequestBinding;
import com.example.rebeikiacollector.model.ActiveRequestsItem;
import com.example.rebeikiacollector.model.ConfirmOrderRequest;
import com.example.rebeikiacollector.repository.local.PreferencesManager;
import com.example.rebeikiacollector.ui.adapter.ActiveRequestsAdapter;
import com.example.rebeikiacollector.viewModel.ActiveRequestsViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Locale;

public class ActiveRequestActivity extends BaseActivity {

    private ActivityActiveRequestBinding binding;
    private ActiveRequestsViewModel viewModel;
    private PreferencesManager preferencesManager;
    private ActiveRequestsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_active_request);
        viewModel = new ViewModelProvider(this).get(ActiveRequestsViewModel.class);
        preferencesManager = new PreferencesManager(this);
        viewModel.getActiveRequests("Bearer " + preferencesManager.fetchtoken());
        setAdapter();
        observeData();
    }

    private void setAdapter() {
        adapter = new ActiveRequestsAdapter(new ArrayList<>(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.activerequestRecyclerview.setLayoutManager(linearLayoutManager);
        binding.activerequestRecyclerview.setAdapter(adapter);

        adapter.setOnbuttonclicklistner((pos, model) -> {
            ConfirmOrderRequest request = new ConfirmOrderRequest();
            request.setId(model.getId());
            request.setReceivedOrders(model.getOrder());
            viewModel.confirmRequest("Bearer "+preferencesManager.fetchtoken() , request);
        });

        adapter.setAddressclicklistner((model) ->{
            if (model.getLocation().getCoordinates().size() == 2) {
                showMapDialog(model.getLocation().getCoordinates().get(0) , model.getLocation().getCoordinates().get(1));
            }
        });


    }

    private void observeData() {

        viewModel.activeRequestResponse.observe(this, response -> {
            adapter.setlist(response.getActiveRequests());
        });

        viewModel.confirmRequestResponse.observe(this , baseResponse -> {
            Toast.makeText(this, R.string.request_confirmed, Toast.LENGTH_SHORT).show();
        });

        viewModel.getMsgRes().observe(this , res-> {
            Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        });

        viewModel.isLoading().observe(this , loading ->{
            if (loading){
                binding.loading.setVisibility(View.VISIBLE);
            }else {
                binding.loading.setVisibility(View.GONE);
            }


        });
    }

    private void showMapDialog(Double lat, Double lang) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();
        View mView = inflater.inflate(R.layout.show_address_dialog, null);

        MapView mapview = mView.findViewById(R.id.mapView);

        builder.setView(mView);
        AlertDialog alertDialog = builder.create();

        MapsInitializer.initialize(this);
        mapview.onCreate(alertDialog.onSaveInstanceState());
        mapview.onResume();

        mapview.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                LatLng location = new LatLng(lat, lang);
                CameraPosition cameraPosition = new CameraPosition.Builder().target(location).zoom(10f).build();
                googleMap.addMarker(new MarkerOptions().position(location));
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
    }
}
