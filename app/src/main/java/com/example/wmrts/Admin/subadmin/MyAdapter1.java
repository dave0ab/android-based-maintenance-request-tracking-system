package com.example.wmrts.Admin.subadmin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wmrts.R;

import java.util.List;

public class MyAdapter1 extends ArrayAdapter<adminsearch> {

    Context context;
    List<adminsearch> arrayListAdmin;


    public MyAdapter1(@NonNull Context context, List<adminsearch> arrayListAdmin) {
        super(context, R.layout.custom_list_item, arrayListAdmin);

        this.context = context;
        this.arrayListAdmin = arrayListAdmin;

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list__for_account_search,null,true);

        TextView tvID = view.findViewById(R.id.txt_id1);
        TextView tvwuid= view.findViewById(R.id.wuid);
        TextView tvstatus = view.findViewById(R.id.status);
        TextView tvdate = view.findViewById(R.id.datecreated);
        TextView role = view.findViewById(R.id.role1);
        tvID.setText(arrayListAdmin.get(position).getId());
        tvwuid.setText(arrayListAdmin.get(position).getWuid());
        tvstatus.setText(arrayListAdmin.get(position).getstatus());
        tvdate.setText(arrayListAdmin.get(position).getdatecreated());
        role.setText(arrayListAdmin.get(position).getrole());
        return view;
    }
}
