package com.example.rebeikiacollector.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.adapter.CategoryAdapter;
import com.example.rebeikiacollector.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CategoryAdapter adapter;
    List<CategoryModel>list;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        imglist();
        recyclerView=findViewById(R.id.home_recyclerview);

        adapter=new CategoryAdapter(list,context);
        adapter.setOnbuttonclicklistner(new CategoryAdapter.OnItemClickListner() {
            @Override
            public void onitemclick(int pos, CategoryModel model) {
                if(pos==0){
                    Intent i=new Intent(HomeActivity.this,CompletedRequestActivity.class);
                    startActivity(i);

                }
                else if(pos==1){
                    Intent i=new Intent(HomeActivity.this,PendingRequestActivity.class);
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
        list.add(new CategoryModel("Completed Requests",R.drawable.ic_asset1));
        list.add(new CategoryModel("Pending Requests",R.drawable.ic_asset_6));




    }
}
