package com.example.rebeikiacollector.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.model.CompletedRequestsItem;
import com.example.rebeikiacollector.model.CompletedSpecialRequestsItem;
import com.example.rebeikiacollector.repository.local.PreferencesManager;
import com.example.rebeikiacollector.ui.adapter.ConfirmedRequestAdapter;
import com.example.rebeikiacollector.ui.adapter.ConfirmedSpecialRequestAdapter;
import com.example.rebeikiacollector.viewModel.ConfirmSpecialViewModel;
import com.example.rebeikiacollector.viewModel.ConfirmedRequestViewModel;

import java.util.ArrayList;

public class PendingRequestActivity extends BaseActivity {
    ConfirmedSpecialRequestAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<CompletedSpecialRequestsItem> list;
    PreferencesManager pref;
    private ConfirmSpecialViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_request);
        pref = new PreferencesManager(this);
        viewModel = new ViewModelProvider(this).get(ConfirmSpecialViewModel.class);
        viewModel.confirmspecialrequest("Bearer "+pref.fetchtoken());
        observeData();
        recyclerView=findViewById(R.id.confirmedspecial_recyclerview);
        setupAdapter();
    }
    private void observeData() {


        viewModel.confirmspecial.observe(this , response ->{
            adapter.setlist(response.getCompletedSpecialRequests());
        });
    }
    private void setupAdapter() {
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
        adapter = new ConfirmedSpecialRequestAdapter(new ArrayList<CompletedSpecialRequestsItem>(), this);
        recyclerView.setAdapter(adapter);

    }
}
