package com.example.wmrts.Admin.Admin;

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

public class MyAdapter2 extends ArrayAdapter<headsearch> {

    Context context;
    List<headsearch> arrayListHead;


    public MyAdapter2(@NonNull Context context, List<headsearch> arrayListHead) {
        super(context, R.layout.custom_list_item, arrayListHead);

        this.context = context;
        this.arrayListHead = arrayListHead;

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.txt_name);

        tvID.setText(arrayListHead.get(position).getId());
        tvName.setText(arrayListHead.get(position).getfname());

        return view;
    }
}
