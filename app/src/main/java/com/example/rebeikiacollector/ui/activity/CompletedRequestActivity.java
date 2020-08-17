package com.example.rebeikiacollector.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.model.CompletedRequestsItem;
import com.example.rebeikiacollector.repository.local.PreferencesManager;
import com.example.rebeikiacollector.ui.adapter.ConfirmedRequestAdapter;
import com.example.rebeikiacollector.viewModel.ConfirmedRequestViewModel;

import java.util.ArrayList;

public class CompletedRequestActivity extends AppCompatActivity {
    ConfirmedRequestAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<CompletedRequestsItem> list;
    PreferencesManager pref;
    private ConfirmedRequestViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_request);
        pref = new PreferencesManager(this);
        viewModel = new ViewModelProvider(this).get(ConfirmedRequestViewModel.class);
        viewModel.getconfirmedrequest("Bearer "+pref.fetchtoken());
        observeData();

        recyclerView=findViewById(R.id.completedreqest_recyclerview);
        setupAdapter();



    }
    private void observeData() {


        viewModel.confirmedrequest.observe(this , response ->{
            adapter.setlist(response.getCompletedRequests());
        });
    }
    private void setupAdapter() {
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
        adapter = new ConfirmedRequestAdapter(new ArrayList<CompletedRequestsItem>(), this);
        recyclerView.setAdapter(adapter);

    }
}
