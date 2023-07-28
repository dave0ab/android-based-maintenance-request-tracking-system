package com.example.wmrts.maintenance_manager.technician;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wmrts.Admin.technician.expertsearch;
import com.example.wmrts.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter3 extends ArrayAdapter<expertsearch> {

    Context context;
    List<expertsearch> arrayListExpert;


    public MyAdapter3(@NonNull Context context, ArrayList<expertsearch> arrayListExpert) {
        super(context, R.layout.custom_list_item, arrayListExpert);

        this.context = context;
        this.arrayListExpert = arrayListExpert;

    }



    @NonNull
    @Override @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list__for_technician,null,true);

        TextView tvID = view.findViewById(R.id.txt_id1);
       TextView tvName = view.findViewById(R.id.name1);
        TextView tvrole = view.findViewById(R.id.role1);
        TextView tvfac = view.findViewById(R.id.facility1);

        TextView ongoing = view.findViewById(R.id.ongoingjobs);

        tvID.setText(arrayListExpert.get(position).getId());
        tvName.setText(arrayListExpert.get(position).getfname());
        tvrole.setText(arrayListExpert.get(position).getrole());
        tvfac.setText(arrayListExpert.get(position).getfacility());
        ongoing.setText(arrayListExpert.get(position).getworkstatus());

        return view;
    }
}
