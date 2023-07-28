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

public class MyAdapter4 extends ArrayAdapter<backupmodal> {

    Context context;
    List<backupmodal> arrayListbackupmodal;


    public MyAdapter4(@NonNull Context context, List<backupmodal> arrayListbackupmodal) {
        super(context, R.layout.back_list, arrayListbackupmodal);

        this.context = context;
        this.arrayListbackupmodal = arrayListbackupmodal;

    }


    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.back_list,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.name);
        TextView tvdate= view.findViewById(R.id.date);

        tvID.setText(arrayListbackupmodal.get(position).getId());
        tvName.setText(arrayListbackupmodal.get(position).getbackupname());
        tvdate.setText(arrayListbackupmodal.get(position).getbackupdate());
        return view;
    }
}
