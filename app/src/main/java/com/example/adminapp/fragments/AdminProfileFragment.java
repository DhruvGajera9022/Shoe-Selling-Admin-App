package com.example.adminapp.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;
import com.example.adminapp.adapters.AdminProfileDataAdapter;
import com.example.adminapp.models.AdminProfileDataModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AdminProfileFragment extends Fragment {
    FirebaseFirestore firestore;
    FirebaseAuth mAuth;
    ProgressDialog progressDialog;

    RecyclerView recyclerView;
    AdminProfileDataAdapter adapter;
    ArrayList<AdminProfileDataModel> list;

    public AdminProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_profile, container, false);

        firestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        recyclerView = view.findViewById(R.id.userDataRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        list = new ArrayList<>();
        adapter = new AdminProfileDataAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();

        fetchUserData();

        return view;
    }

    private void fetchUserData() {
        firestore.collection("Users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                                AdminProfileDataModel profileDataModel = documentSnapshot.toObject(AdminProfileDataModel.class);
                                list.add(profileDataModel);
                                adapter.notifyItemInserted(list.size() - 1);
                            }
                        } else {
                            Log.e("AdminProfileFragment", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
}
