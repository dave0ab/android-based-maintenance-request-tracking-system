package com.example.wmrts.facility_manager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.wmrts.R;

import java.util.List;

public class requestadapter extends ArrayAdapter<requestmodal> {
    Context context;
    List<requestmodal> arrayListrequestapprove;


    public requestadapter(@NonNull Context context, List<requestmodal> arrayListrequestapprove) {
        super(context, R.layout.custom_list_item, arrayListrequestapprove);

        this.context = context;
        this.arrayListrequestapprove = arrayListrequestapprove;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listviewrequest,null,true);

        TextView ID = view.findViewById(R.id.txt_id);
        TextView wuidID = view.findViewById(R.id.wuid);
        TextView tvdevice = view.findViewById(R.id.device);
        TextView tvpriority = view.findViewById(R.id.priority);

        wuidID .setEnabled(false);
        tvdevice.setEnabled(false);
        tvpriority.setEnabled(false);

        ID .setText(arrayListrequestapprove.get(position).getId());
        wuidID .setText(arrayListrequestapprove.get(position).getWuid());
        tvdevice.setText(arrayListrequestapprove.get(position).getthing_to_fix());
        tvpriority .setText(arrayListrequestapprove.get(position).getrequested_date());

        return view;
    }
}
