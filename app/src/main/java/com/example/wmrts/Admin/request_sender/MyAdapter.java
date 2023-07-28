package com.example.wmrts.Admin.request_sender;

import android.annotation.SuppressLint;
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

public class MyAdapter extends ArrayAdapter<client> {

    Context context;
    List<client> arrayListClient;


    public MyAdapter(@NonNull Context context, List<client> arrayListClient) {
        super(context, R.layout.custom_list_item, arrayListClient);

        this.context = context;
        this.arrayListClient = arrayListClient;

    }


    @NonNull
    @Override
    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.acdc,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tvName = view.findViewById(R.id.fname);
        TextView tvwuid = view.findViewById(R.id.wuid);
        TextView status = view.findViewById(R.id.status);
        tvID.setText(arrayListClient.get(position).getId());
        tvName.setText(arrayListClient.get(position).getfname());
        tvwuid.setText(arrayListClient.get(position).getWuid());
        status.setText(arrayListClient.get(position).getstatus());


        return view;
    }
}
