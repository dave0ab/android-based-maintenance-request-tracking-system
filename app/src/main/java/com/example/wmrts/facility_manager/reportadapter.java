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

public class reportadapter extends ArrayAdapter<reportmodal> {
    Context context;
    List<reportmodal> arrayListreportapprove;


    public reportadapter(@NonNull Context context, List<reportmodal> arrayListreportapprove) {
        super(context, R.layout.custom_list_item, arrayListreportapprove);

        this.context = context;
        this.arrayListreportapprove = arrayListreportapprove;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listviewrequest1,null,true);

        TextView ID = view.findViewById(R.id.txt_id);
        TextView wuidID = view.findViewById(R.id.wuid);
        TextView tvdevice = view.findViewById(R.id.device);
        TextView tvpriority = view.findViewById(R.id.priority);
        TextView re = view.findViewById(R.id.request_id);












        wuidID .setEnabled(false);
        tvdevice.setEnabled(false);
        tvpriority.setEnabled(false);

        ID .setText(arrayListreportapprove.get(position).getId());
        wuidID .setText(arrayListreportapprove.get(position).gettech_wuid());
        tvdevice.setText(arrayListreportapprove.get(position).getreported_date());
        tvpriority .setText(arrayListreportapprove.get(position).getstatus());
        re.setText(arrayListreportapprove.get(position).getrequest_id());
        return view;
    }
}
