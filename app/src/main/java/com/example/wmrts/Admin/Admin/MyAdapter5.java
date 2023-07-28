package com.example.wmrts.Admin.Admin;

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

public class MyAdapter5 extends ArrayAdapter<logmodal> {

    Context context;
    List<logmodal> arrayListlogmodal;


    public MyAdapter5(@NonNull Context context, List<logmodal> arrayListlogmodal) {
        super(context, R.layout.back_list, arrayListlogmodal);

        this.context = context;
        this.arrayListlogmodal = arrayListlogmodal;

    }


    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.back_list,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.name);
        TextView tvdate= view.findViewById(R.id.date);

        tvID.setText(arrayListlogmodal.get(position).getId());
        tvName.setText(arrayListlogmodal.get(position).getwuid());
        tvdate.setText(arrayListlogmodal.get(position).getlogdate());
        return view;
    }
}
