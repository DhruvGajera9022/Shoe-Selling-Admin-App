package com.example.adminapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.adminapp.R;
import com.example.adminapp.models.OrderModel;

import java.util.List;

public class AdminOrderListAdapter extends RecyclerView.Adapter<AdminOrderListAdapter.ViewHolder> {

    Context context;
    List<OrderModel> list;

    public AdminOrderListAdapter(Context context, List<OrderModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_all_orders_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(holder.img.getContext())
                .load(list.get(position).getOrderProductImage())
                .error(R.drawable.image_icon)
                .into(holder.img);
        holder.name.setText(list.get(position).getOrderProductName());
        holder.price.setText(list.get(position).getOrderProductPrice());
        holder.size.setText("Size. "+list.get(position).getOrderProductSize());
        holder.date.setText(list.get(position).getCurrentOrderDate());
        holder.userId.setText(list.get(position).getCurrentUserId());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, size, date, userId;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.adminOrderProductItemName);
            price = itemView.findViewById(R.id.adminOrderProductItemPrice);
            size = itemView.findViewById(R.id.adminOrderProductItemSize);
            date = itemView.findViewById(R.id.adminOrderProductItemDate);
            userId = itemView.findViewById(R.id.adminOrderProductItemUserId);
            img = itemView.findViewById(R.id.adminOrderProductItemImage);

        }
    }

}
