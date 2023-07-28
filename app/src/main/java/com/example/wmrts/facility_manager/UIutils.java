package com.example.wmrts.facility_manager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class UIutils {

    private Activity mActivity;

    public UIutils(Activity activity){
        mActivity = activity;
    }

    public void showPhoto(Uri photoUri){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(photoUri, "image/.jpg");
        mActivity.startActivity(intent);
    }

}

















