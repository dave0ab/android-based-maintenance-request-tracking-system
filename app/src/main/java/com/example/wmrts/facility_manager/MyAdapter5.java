package com.example.wmrts.facility_manager;

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

public class MyAdapter5 extends ArrayAdapter<clientapprove> {
    Context context;
    List<clientapprove> arrayListClientapprove;


    public MyAdapter5(@NonNull Context context, List<clientapprove> arrayListClientapprove) {
        super(context, R.layout.custom_list_item, arrayListClientapprove);

        this.context = context;
        this.arrayListClientapprove = arrayListClientapprove;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.txt_name);

        tvID.setText(arrayListClientapprove.get(position).getId());
        tvName.setText(arrayListClientapprove.get(position).getName());

        return view;
    }
}
