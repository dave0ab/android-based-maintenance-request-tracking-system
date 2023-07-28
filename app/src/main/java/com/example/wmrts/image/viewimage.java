package com.example.wmrts.image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.wmrts.R;
import com.squareup.picasso.Picasso;

public class viewimage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewimage);

        String image_url = "http://192.168.43.228:80//wumrts/client/upload/";
        int loader = R.drawable.circle;

        // Imageview to show
        ImageView image = (ImageView) findViewById(R.id.image);
        Picasso.with(viewimage.this).load(image_url).into(image);
        // Image url



    }
}