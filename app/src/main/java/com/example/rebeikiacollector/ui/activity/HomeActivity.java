package com.example.rebeikiacollector.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.repository.local.PreferencesManager;
import com.example.rebeikiacollector.ui.MenuActivity;
import com.example.rebeikiacollector.ui.adapter.CategoryAdapter;
import com.example.rebeikiacollector.model.CategoryModel;
import com.example.rebeikiacollector.viewModel.ConfirmedRequestViewModel;
import com.example.rebeikiacollector.viewModel.MenuViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {
    RecyclerView recyclerView;
    CategoryAdapter adapter;
    List<CategoryModel>list;
    Context context=this;
    PreferencesManager pref;
    private MenuViewModel viewModel;
    TextView totalreqeststxt;
    int normal,special,total=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        pref = new PreferencesManager(this);
        viewModel = new ViewModelProvider(this).get(MenuViewModel.class);
        viewModel.getProfileData("Bearer "+pref.fetchtoken());
        totalreqeststxt=findViewById(R.id.totalpointtxt);
        observeData();
        final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        imglist();
        recyclerView=findViewById(R.id.home_recyclerview);

        findViewById(R.id.iv_menu).setOnClickListener( view ->{
            startActivity(new Intent(HomeActivity.this , MenuActivity.class));
        });
        adapter=new CategoryAdapter(list,context);
        adapter.setOnbuttonclicklistner(new CategoryAdapter.OnItemClickListner() {
            @Override
            public void onitemclick(int pos, CategoryModel model) {
                if(pos==0){
                    Intent i=new Intent(HomeActivity.this, CompletedRequestActivity.class);
                    startActivity(i);

                }
                else if(pos==1){
                    Intent i=new Intent(HomeActivity.this, PendingRequestActivity.class);
                    startActivity(i);

                }
                else if(pos==2){
                    Intent i=new Intent(HomeActivity.this, ActiveRequestActivity.class);
                    startActivity(i);

                }
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnScrollListener(new CenterScrollListener());
    }
    public  void imglist(){
        list=new ArrayList<>();
        list.add(new CategoryModel("Confirmed Requests",R.drawable.ic_asset1));
        list.add(new CategoryModel("Confirmed Special Requests",R.drawable.ic_asset_6));
        list.add(new CategoryModel("Active Requests",R.drawable.ic_asset_4));





    }
    private void observeData() {


        viewModel.profileResponse.observe(this , response ->{
            normal=response.getCompletedRequests();
            special=response.getCompletedSpecialRequests();
            total=normal+special;
            totalreqeststxt.setText(Integer.toString(total));


        });
    }
}
