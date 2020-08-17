package com.example.rebeikiacollector.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.model.ActiveRequestsItem;
import com.example.rebeikiacollector.model.CategoryModel;
import com.example.rebeikiacollector.model.OrderItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ActiveRequestsAdapter extends RecyclerView.Adapter<ActiveRequestsAdapter.viewHolder> {
    private List<ActiveRequestsItem> items;
    private Context context;

    public void setOnbuttonclicklistner(OnItemClickListner onbuttonclicklistner) {
        this.onbuttonclicklistner = onbuttonclicklistner;
    }

    OnItemClickListner onbuttonclicklistner;


    public void setAddressclicklistner(OnAddressListner onAddressListner) {
        this.onAddressListner = onAddressListner;
    }

    OnAddressListner onAddressListner;

    public ActiveRequestsAdapter(List<ActiveRequestsItem> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @NonNull
    @Override
    public ActiveRequestsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.active_request_item, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ActiveRequestsAdapter.viewHolder holder, final int position) {
        final ActiveRequestsItem item = items.get(position);
         holder.name.setText(item.getUserName());
        Picasso.get().load(item.getUserImage()).into(holder.imageView);
        if (item.getOrder() != null) {
            setAdapter(item.getOrder() , holder);
        }

        holder.address.setOnClickListener(view ->{
            onAddressListner.onitemclick(item);
        });

        holder.confrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onbuttonclicklistner.onitemclick(position , item);
            }
        });
    }

    private void setAdapter(List<OrderItem> order, viewHolder holder) {
        ActiveRequestOrderItemAdapter adapter = new ActiveRequestOrderItemAdapter(order , context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(adapter);
    }

    public void setlist(List<ActiveRequestsItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return items.size();
    }


    class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        RecyclerView recyclerView;
        ImageView address;
        Button confrim;

        public viewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.civ_image);
            name = view.findViewById(R.id.tv_name);
            recyclerView = view.findViewById(R.id.rv_list);
            address = view.findViewById(R.id.iv_address);
            confrim = view.findViewById(R.id.btn_confirm);
        }
    }

    public interface OnItemClickListner {
        void onitemclick(int pos, ActiveRequestsItem model);
    }

    public interface OnAddressListner {
        void onitemclick(ActiveRequestsItem model);
    }

}
