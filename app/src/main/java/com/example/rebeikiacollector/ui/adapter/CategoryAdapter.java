package com.example.rebeikiacollector.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.model.CategoryModel;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewHolder> {
    private List<CategoryModel> items;
    private Context context;

    public void setOnbuttonclicklistner(OnItemClickListner onbuttonclicklistner) {
        this.onbuttonclicklistner = onbuttonclicklistner;
    }

    OnItemClickListner onbuttonclicklistner;

    public CategoryAdapter(List<CategoryModel> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @NonNull
    @Override
    public CategoryAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categoryhome_item, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryAdapter.viewHolder  holder, final int position) {
        final CategoryModel item = items.get(position);
        holder.image.setImageResource(item.getImg());
        holder.name.setText(item.getName());
       if(onbuttonclicklistner!=null){
           holder.name.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   onbuttonclicklistner.onitemclick(position,item);

               }
           });
       }

        }







    @Override
    public int getItemCount() {

        return items.size();
    }


    class viewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        Button name;


        public viewHolder(View view) {
            super(view);
          image = view.findViewById(R.id.category_img);
          name=view.findViewById(R.id.category_btn);


        }
    }
    public interface OnItemClickListner{
        void onitemclick(int pos,  CategoryModel model);
    }

}
