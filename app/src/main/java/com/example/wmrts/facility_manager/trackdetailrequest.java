package com.example.wmrts.facility_manager;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wmrts.Admin.activate_deactivate;
import com.example.wmrts.Logout;
import com.example.wmrts.R;
import com.example.wmrts.about;
import com.example.wmrts.contactus;

import com.example.wmrts.register;
import com.example.wmrts.request_sender.request_sender_requests;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class trackdetailrequest extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    Uri path;
    Bundle bundle1;
    String path1;
    Button viewreport,unreject;
    private URL url = null;
    TextView tvid,tvname,tvwuid,tvbuilding,tvoffice, techphone,priority,additional,messagedetails,quantity,tvdevice,department,status,imageview;
    int position;
    ImageView image;
    private String fileName;
    Button viewdocument;
    Button activate,deactivate;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailrequest10);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.trace);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

viewdocument= findViewById(R.id.viewdocumnet);
        unreject= findViewById(R.id.unreject);
        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        bundle1 = getIntent().getExtras();
        path1=bundle1.getString("path");
        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(trackdetailrequest.this);

        userinfo();

        //Initializing Views
        tvid = findViewById(R.id.lname);
        tvname = findViewById(R.id.name);
        tvwuid = findViewById(R.id.wuid);
        tvbuilding = findViewById(R.id.phone);
        tvoffice = findViewById(R.id.officenno);
        department = findViewById(R.id.technicianname);

        tvbuilding = findViewById(R.id.phone);
        tvdevice = findViewById(R.id.device);
        quantity = findViewById(R.id.quantity);
        messagedetails = findViewById(R.id.mdetails);
        techphone = findViewById(R.id.technicianphone);
        additional = findViewById(R.id.additional);

     //   priority = findViewById(R.id.priority);


 // imageview = findViewById(R.id.imageView);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");
        TextView  assigned_date = findViewById(R.id.assigned_date);
        assigned_date.setText("Assigned date: "+  track_maintenance_activity.requestArrayList.get(position).getassigned_date());
        tvid.setText("ID: "+track_maintenance_activity.requestArrayList.get(position).getId());
        tvwuid.setText("University ID: "+track_maintenance_activity.requestArrayList.get(position).getWuid());
        tvname.setText("Name: "+track_maintenance_activity.requestArrayList.get(position).getname());
        tvbuilding.setText("Building no: "+track_maintenance_activity.requestArrayList.get(position).getbuildingno());
        tvoffice.setText("Office no: "+track_maintenance_activity.requestArrayList.get(position).getofficeno());
        quantity.setText("Mobile number: "+track_maintenance_activity.requestArrayList.get(position).getphone());
        department.setText("Technician name: "+track_maintenance_activity.requestArrayList.get(position).gettechname());
        techphone.setText("Technician phone: "+track_maintenance_activity.requestArrayList.get(position).gettechphone());
        messagedetails.setText("Maintenance details: "+track_maintenance_activity.requestArrayList.get(position).getadditionalmessage());

        additional.setText("Maintenance details: "+track_maintenance_activity.requestArrayList.get(position).getcheckboxrequests());
   //   priority .setText("Priority: "+listmaintenancerequest.requestArrayList.get(position).getpriority());

        tvdevice.setText("Device: "+track_maintenance_activity.requestArrayList.get(position).getthing_to_fix());
      //  imageview .setText("Department: "+listmaintenancerequest.requestArrayList.get(position).getimagepath());
path1=track_maintenance_activity.requestArrayList.get(position).getdocument_path();

        TextView fa_id = findViewById(R.id.fa_id);
        TextView faphone = findViewById(R.id.fa_phone);

        fa_id.setText("Facility manager id: "+track_maintenance_activity.requestArrayList.get(position).getpriority());
        faphone.setText("Facility manager phone: "+track_maintenance_activity.requestArrayList.get(position).getfa_phone());

        String image_url = track_maintenance_activity.requestArrayList.get(position).getimagepath();
        int loader = R.drawable.circle;

        // Imageview to show
      image = (ImageView) findViewById(R.id.imageView);

      if(image_url.equals("")){


      }
      else {
          Picasso.with(trackdetailrequest.this).load(image_url).into(image);
      }

        viewreport=findViewById(R.id.report);
        viewreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                retrieve00();




            }
        });



        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        unreject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Set the message show for the Alert time
                builder.setMessage("Do you want to Accept this request ?");

                // Set Alert Title
                builder.setTitle("Are you sure");

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);

                // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // When the user click yes button then app will close
                    deleteData();
                });
                // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // If user click no then dialog box is canceled.
                    dialog.cancel();
                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();















            }
        });




        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                image.setScaleType(ImageView.ScaleType.FIT_XY);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
                getSupportActionBar().hide();
            }
        });


viewdocument= findViewById(R.id.view_document);
        viewdocument.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                new Thread(new Runnable() {
                    public void run() {
                        URL u = null;
                        try {

                            u = new URL(path1);
                            fileName = u.getPath();
                            fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
                            File file = new File(Environment.getExternalStorageDirectory() + "/" + "Download/"+  fileName);
                            if(file.exists()){
                                btnView();

                            }else{
                                url = new URL(path1);
                                DownloadFiles();
                                fileName = u.getPath();
                                fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
                                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url + ""));
                                request.setTitle(fileName);
                                request.setMimeType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                                request.allowScanningByMediaScanner();
                                request.setAllowedOverMetered(true);
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                                dm.enqueue(request);
                                btnView();
                            }

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

        });

        if (ContextCompat.checkSelfPermission(trackdetailrequest.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        7);
            }
        }

        if (ContextCompat.checkSelfPermission(trackdetailrequest.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                        8);
            }
        }
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {

                retrieveclientData1(trackdetailrequest.this);

            }
        }, 0, 30000);




    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.about) {
            startActivity(new Intent(getApplicationContext(), about.class));

        }
        else if (id == R.id.contactus) {
            startActivity(new Intent(getApplicationContext(), contactus.class));

        }
        else if (id == R.id.logout) {


            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            // Set the message show for the Alert time
            builder.setMessage("Do you want to logout ?");

            // Set Alert Title
            builder.setTitle("Are you sure");

            // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
            builder.setCancelable(false);

            // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
            builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                // When the user click yes button then app will close
                startActivity(new Intent(getApplicationContext(), Logout.class));
            });
            // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
            builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                // If user click no then dialog box is canceled.
                dialog.cancel();
            });

            // Create the Alert dialog
            AlertDialog alertDialog = builder.create();
            // Show the Alert Dialog box
            alertDialog.show();

        }

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.home) {

            startActivity(new Intent(getApplicationContext(),facilitymanagerchoose.class));
        }
        if (id == R.id.view_maintenance) {

            startActivity(new Intent(getApplicationContext(), listmaintenancerequest.class));
        }
        if (id == R.id.view_report) {

            startActivity(new Intent(getApplicationContext(), select_reported_requests.class));
        }
        if (id == R.id.track) {

            startActivity(new Intent(getApplicationContext(), track_maintenance_activity.class));
        }
        if (id == R.id.change_password) {

            startActivity(new Intent(getApplicationContext(), fa_change_password.class));
        }
        else if (id == R.id.change_picture) {

            startActivity(new Intent(getApplicationContext(), change_profile_picture_facility.class));
        }

        else if(id == R.id.logout){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            // Set the message show for the Alert time
            builder.setMessage("Do you want to logout ?");

            // Set Alert Title
            builder.setTitle("Are you sure");

            // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
            builder.setCancelable(false);

            // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
            builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                // When the user click yes button then app will close

                startActivity(new Intent(getApplicationContext(), Logout.class));

            });


            // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
            builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                // If user click no then dialog box is canceled.
                dialog.cancel();
            });

            // Create the Alert dialog
            AlertDialog alertDialog = builder.create();
            // Show the Alert Dialog box
            alertDialog.show();
        }


        DrawerLayout drawer = findViewById(R.id.my_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        return false;
    }





    public void userinfo(){

        String url= getResources().getString(R.string.url);
        String urlclient = url+"facility_manager/FM_data_retrive.php";

        StringRequest request = new StringRequest(Request.Method.POST, urlclient,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String id; String fname;String lname;String wuid;    String mobilenum;     String gender; String job_title;String status;    String impath  ;
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){


                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);

                            id = object.getString("id");
                            fname = object.getString("fname");
                            lname = object.getString("lname");
                            wuid= object.getString("wuid");

                            gender = object.getString("phone");
                            impath = object.getString("imagepath");

                            ImageView image = (ImageView) findViewById(R.id.menu_image2);
                            TextView tv =findViewById(R.id.navfname);
                            tv.setText(fname);
                            Picasso.with(trackdetailrequest.this).load(impath).into(image);
                        }
                    }
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(trackdetailrequest.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                //            progressDialog.dismiss();
            }
        }        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

                String fname = preferences.getString("wuid", "");
                params.put("wuid",fname);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(trackdetailrequest.this);
        requestQueue.add(request);
    }

    @SuppressLint("ServiceCast")
    void createNotificationChannel1(Context c){
        String CHANNEL_ID="MYCHANNEL";
        NotificationChannel notificationChannel= null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(CHANNEL_ID,"name", NotificationManager.IMPORTANCE_LOW);
        }
        Notification notification= null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            notification = new Notification.Builder(c,CHANNEL_ID)
                    .setContentText( "You have new maintenance request")
                    .setContentTitle( "New maintenance request ")
                    .setChannelId(CHANNEL_ID)
                    .setSmallIcon(R.drawable.logo_foreground)
                    .build();
            try
            {

                Context context=c;
                Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
                v.vibrate(500);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        NotificationManager notificationManager=(NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(notificationChannel);

        }
        notificationManager.notify(1,notification);
    }

    public void retrieveclientData1(Context c){

        String url= getResources().getString(R.string.url1);
        String urlrequest = url+"facility_manager/retrieve_request1.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlrequest,new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try{
                    SharedPreferences preferences1;
                    SharedPreferences.Editor   editor;
                    preferences1 = getSharedPreferences("abcd", Context.MODE_PRIVATE);
                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){

                        String id = null;
                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);

                            id = object.getString("id");
                            int a = Integer.parseInt(id);
                            preferences1 =getSharedPreferences("abcd", Context.MODE_PRIVATE);
                            String requestid = preferences1.getString("requestid", "");

                            int reid = Integer.parseInt(requestid);

                            if (a>reid){
                                createNotificationChannel1(c);
                            }
                        }

                        editor = preferences1.edit();

                        editor.putString("requestid",id);
                        editor.apply();
                    }





                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(c, error.getMessage(), Toast.LENGTH_SHORT).show();
                //            progressDialog.dismiss();
            }
        }

        );

        RequestQueue requestQueue = Volley.newRequestQueue(c);
        requestQueue.add(request);
    }



    public void DownloadFiles(){

        try {

            URL u = new URL(path1);
            InputStream is = u.openStream();

            DataInputStream dis = new DataInputStream(is);
            byte[] buffer = new byte[1024];
            int length;
            fileName = u.getPath();
            fileName = fileName.substring(fileName.lastIndexOf('/') + 1);




            FileOutputStream fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory() + "/" + "Download/"+  fileName));

            while ((length = dis.read(buffer))>0) {
                fos.write(buffer, 0, length);
              //  downloadDOCX(path1);
            }

        } catch (MalformedURLException mue) {
            Log.e("SYNC getUpdate", "malformed url error", mue);
        } catch (IOException ioe) {
            Log.e("SYNC getUpdate", "io error", ioe);
        } catch (SecurityException se) {
            Log.e("SYNC getUpdate", "security error", se);
        }


    }


    public void  btnView() {

        try {

            url = new URL(path1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        fileName = url.getPath();
        fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
        //
        File file = new File(Environment.getExternalStorageDirectory() + "/" + "Download/"+  fileName);
        Uri uri = FileProvider.getUriForFile(trackdetailrequest.this, "com.example.wumrts.provider", file);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(uri, "application/msword");
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(i);

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 7) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, do whatever you want to do with the external storage
            } else {
                // Permission denied, handle the error
            }



        }



        if (requestCode == 8) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, do whatever you want to do with the external storage
            } else {
                // Permission denied, handle the error
            }

            }
        }

    public void retrieve00(){
        String url= getResources().getString(R.string.url1);
        String urlrequest =url+ "facility_manager/retrieve_reported_request1.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlrequest,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(select_reported_requests.this, response, Toast.LENGTH_SHORT).show();


                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){
                        String sstat = jsonObject.getString("stat");
                        if(sstat.equals("00")) {
                            Intent  myIntent12 = new Intent(getApplicationContext(), notreported.class);
                            trackdetailrequest.this.startActivity(myIntent12);

                        }
                        else{

                            Intent  myIntent12 = new Intent(getApplicationContext(),detailreport1.class);

                            myIntent12.putExtra("request_id", listmaintenancerequest.requestArrayList.get(position).getId());

                            trackdetailrequest.this.startActivity(myIntent12);






                        }

                    }

                }
                catch (JSONException e){
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(trackdetailrequest.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        ){ @Override
        protected Map<String, String> getParams() throws AuthFailureError {

            Map<String,String> params = new HashMap<String,String>();
            SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

            bundle1 = getIntent().getExtras();
            String id1 =bundle1.getString("rqst");
            params.put("rid",id1);
            return params;
        }};


        RequestQueue requestQueue = Volley.newRequestQueue(trackdetailrequest.this);
        requestQueue.add(request);



    }



    private void deleteData() {
        String url = getResources().getString(R.string.url1);
        StringRequest request = new StringRequest(Request.Method.POST, url+"facility_manager/unreject_report.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(trackdetailrequest.this, response, Toast.LENGTH_SHORT).show();
                        if(response.equals("seen")){
                            Toast.makeText(trackdetailrequest.this, "Request accepted(unrejected)", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            //     Toast.makeText(Activate_reject_user.this, "Failed", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(trackdetailrequest.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                bundle1 = getIntent().getExtras();
                String id =bundle1.getString("id");


                SharedPreferences preferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

                String fname = preferences.getString("wuid", "");
                params.put("action", fname);
                params.put("id",track_maintenance_activity.requestArrayList.get(position).getId());
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }




}