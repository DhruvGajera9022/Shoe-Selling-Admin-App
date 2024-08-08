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
import com.example.adminapp.models.AdminProfileDataModel;

import java.util.ArrayList;
import java.util.List;

public class AdminProfileDataAdapter extends RecyclerView.Adapter<AdminProfileDataAdapter.ViewHolder> {
    Context context;
    ArrayList<AdminProfileDataModel> list;

    public AdminProfileDataAdapter(Context context, ArrayList<AdminProfileDataModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_profile_user_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(holder.imgProfile.getContext())
                .load(list.get(position).getProfileImage())
                .error(R.drawable.avatar)
                .into(holder.imgProfile);
        holder.txtFirstName.setText(list.get(position).getFirstName());
        holder.txtEmail.setText(list.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtFirstName,txtEmail;
        ImageView imgProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtFirstName = itemView.findViewById(R.id.txtAdminProfileFirstName);
            txtEmail = itemView.findViewById(R.id.txtAdminProfileEmail);
            imgProfile = itemView.findViewById(R.id.txtAdminProfileImage);

        }
    }
}
