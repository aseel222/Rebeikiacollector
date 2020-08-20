package com.example.rebeikiacollector.ui.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.model.CompletedRequestsItem;
import com.example.rebeikiacollector.model.ReceivedOrderItem;
import com.squareup.picasso.Picasso;

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
        holder.type.setText(item.getId());
        holder.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                View view = LayoutInflater.from(context).inflate(R.layout.details_dialog, null);
                ImageView usericon = view.findViewById(R.id.userimg);
                Picasso.get().load(item.getUserImage()).into(usericon);
                TextView type = view.findViewById(R.id.typedetailstxt);
                TextView quantity = view.findViewById(R.id.quantitydetailstxt);
                TextView date = view.findViewById(R.id.createdatdetailstxt);
                TextView point = view.findViewById(R.id.requestpointdetailstxt);

                type.setText(getArrayTypes(item.getReceivedOrder()));
                quantity.setText(getArrayQuantities(item.getReceivedOrder()));


                date.setText(item.getCreatedAt());
                point.setText(item.getRequestPoint() + "");
                builder.setView(view);
                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });


    }

    private String getArrayQuantities(List<ReceivedOrderItem> receivedOrder) {
        StringBuilder s = new StringBuilder("");
        for (ReceivedOrderItem item : receivedOrder)
            s.append(item.getQuantity()).append(", ");
        s.delete(s.length()-2 , s.length()-1);
        return s.toString();
    }

    private String getArrayTypes(List<ReceivedOrderItem> receivedOrder) {
        StringBuilder s = new StringBuilder("");
        for (ReceivedOrderItem item : receivedOrder)
            s.append(item.getType()).append(", ");
        s.delete(s.length()-2 , s.length()-1);
        return s.toString();
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
        Button details;

        public viewHolder(@NonNull View itemView) {

            super(itemView);
            username = itemView.findViewById(R.id.usernametxt);
            location = itemView.findViewById(R.id.locationtxt);
            type = itemView.findViewById(R.id.typetxt);
            status = itemView.findViewById(R.id.staustxt);
            date = itemView.findViewById(R.id.datetxt);
            details = itemView.findViewById(R.id.detailsbtn);

        }
    }
}
