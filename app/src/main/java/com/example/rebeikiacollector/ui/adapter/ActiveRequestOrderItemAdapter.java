package com.example.rebeikiacollector.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.model.ActiveRequestsItem;
import com.example.rebeikiacollector.model.OrderItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ActiveRequestOrderItemAdapter extends RecyclerView.Adapter<ActiveRequestOrderItemAdapter.viewHolder> {
    private List<OrderItem> items;
    private Context context;


    public ActiveRequestOrderItemAdapter(List<OrderItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ActiveRequestOrderItemAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_item, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ActiveRequestOrderItemAdapter.viewHolder holder, final int position) {
        final OrderItem item = items.get(position);
        holder.name.setText(item.getType());
        holder.number.setText(item.getQuantity()+"");

    }

    public void setlist(List<OrderItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return items.size();
    }


    class viewHolder extends RecyclerView.ViewHolder {
        TextView name , number;

        public viewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.tv_name);
            number = view.findViewById(R.id.tv_number);
        }
    }


}
