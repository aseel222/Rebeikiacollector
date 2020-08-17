package com.example.rebeikiacollector.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.model.CompletedRequestsItem;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public class ConfirmedRequestAdapter extends RecyclerView.Adapter<ConfirmedRequestAdapter.viewHolder> {

    private List<CompletedRequestsItem> result;
    private Context context;

    public ConfirmedRequestAdapter(List<CompletedRequestsItem> result, Context context) {
        this.result = result;
        this.context = context;
    }


    @NonNull
    @Override
    public ConfirmedRequestAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.completedrequest_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmedRequestAdapter.viewHolder holder, int position) {
        final CompletedRequestsItem item = result.get(position);
        Calendar calendar = Calendar.getInstance();
        String currentdate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
        holder.date.setText(currentdate);
        holder.username.setText(item.getUserName());
        if (item.getStatus() != null) {
            holder.status.setText(item.getStatus());
        }
        holder.type.setText(item.getReceivedOrder().get(0).getType());


    }

    public void setlist(List<CompletedRequestsItem> result) {
        this.result = result;

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView username, location, type, status, date;

        public viewHolder(@NonNull View itemView) {

            super(itemView);
            username = itemView.findViewById(R.id.usernametxt);
            location = itemView.findViewById(R.id.locationtxt);
            type = itemView.findViewById(R.id.typetxt);
            status = itemView.findViewById(R.id.staustxt);
            date = itemView.findViewById(R.id.datetxt);
        }
    }
}
