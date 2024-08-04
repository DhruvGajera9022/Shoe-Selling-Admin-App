package com.example.adminapp.adapters;

import android.annotation.SuppressLint;
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
import com.example.adminapp.models.ProductModel;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class AdminProductCategoryAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>{

    Context context;
    ArrayList<ProductModel> datalist;
    FirebaseFirestore db;
    ProductModel model;

    public AdminProductCategoryAdapter(Context context, ArrayList<ProductModel> datalist) {
        this.context = context;
        this.datalist = datalist;
    }


    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_design,parent,false);
        return new ProductAdapter.MyViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(datalist.get(position).getName());
        holder.price.setText("Rs. "+datalist.get(position).getPrice());
        holder.rating.setText(datalist.get(position).getRating());
        Glide.with(holder.img.getContext())
                .load(datalist.get(position).getImgurl())
                .error(R.drawable.image_icon)
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,price,gender, rating;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtname);
            price = itemView.findViewById(R.id.txtprice);
            img = itemView.findViewById(R.id.img);
            gender = itemView.findViewById(R.id.txtgender);
            rating = itemView.findViewById(R.id.txtrating);

        }
    }

}
