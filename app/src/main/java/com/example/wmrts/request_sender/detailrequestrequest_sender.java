package com.example.wmrts.request_sender;

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
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
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
import com.example.wmrts.Logout;
import com.example.wmrts.R;
import com.example.wmrts.about;
import com.example.wmrts.construction_maintenances.construction_maintenances_request;
import com.example.wmrts.contactus;
import com.example.wmrts.facility_manager.listmaintenancerequest;
import com.example.wmrts.facility_manager.track_maintenance_activity;
import com.example.wmrts.selectmaintenance;
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

public class detailrequestrequest_sender extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    TextView tvid,tvname,tvwuid,tvbuilding,tvoffice, phone,techphone,priority,additional,messagedetails,quantity,tvdevice,department,status,imageview;
    int position1;
    ImageView image;
    private URL url = null; private String fileName;   String path1;
    Button activate,deactivate,report,viewdocumnet;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailrequest223);


        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);


        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);


        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(detailrequestrequest_sender.this);

userinfo();
        //Initializing Views
        tvid = findViewById(R.id.lname);
        tvname = findViewById(R.id.name);
        tvwuid = findViewById(R.id.wuid);
        tvbuilding = findViewById(R.id.phone);
        tvoffice = findViewById(R.id.officenno);
        department = findViewById(R.id.technicianname);
        techphone = findViewById(R.id.technicianphone);

        tvbuilding = findViewById(R.id.phone);
        phone = findViewById(R.id.phone1);
        tvdevice = findViewById(R.id.device);
        quantity = findViewById(R.id.quantity);
        messagedetails = findViewById(R.id.mdetails);
        additional = findViewById(R.id.additional);



 // imageview = findViewById(R.id.imageView);

        Intent intent =getIntent();
        position1 = intent.getExtras().getInt("position");


        TextView  assigned_date = findViewById(R.id.assigned_date);
        assigned_date.setText("Assigned date: "+  request_sender_requests.requestArrayList.get(position1).getassigned_date());

        tvid.setText("ID: "+  request_sender_requests.requestArrayList.get(position1).getId());
        tvwuid.setText("University ID: "+request_sender_requests .requestArrayList.get(position1).getWuid());
        tvname.setText("Name: "+request_sender_requests .requestArrayList.get(position1).getname());
        tvbuilding.setText("Building no: "+request_sender_requests .requestArrayList.get(position1).getbuildingno());
        tvoffice.setText("Office no: "+request_sender_requests .requestArrayList.get(position1).getofficeno());
        quantity.setText("quantity: "+request_sender_requests .requestArrayList.get(position1).getquantity());
        phone.setText("Phone: "+request_sender_requests .requestArrayList.get(position1).getphone());
        department.setText("Technician name "+request_sender_requests .requestArrayList.get(position1).gettechname());
        messagedetails.setText("Maintenance details: "+request_sender_requests .requestArrayList.get(position1).getadditionalmessage());
        department.setText("Technician name "+request_sender_requests .requestArrayList.get(position1).gettechname());
        techphone.setText("Technician phone: "+request_sender_requests .requestArrayList.get(position1).gettechphone());
        additional.setText("Maintenance details: "+request_sender_requests .requestArrayList.get(position1).getcheckboxrequests());
       // priority .setText("Priority: "+request_sender_requests .requestArrayList.get(position1).getpriority());
path1=request_sender_requests.requestArrayList.get(position1).getdocument_path();
        tvdevice.setText("Device: "+request_sender_requests .requestArrayList.get(position1).getthing_to_fix());
      //  imageview .setText("Department: "+listmaintenancerequest.requestArrayList.get(position).getimagepath());

        TextView fa_id = findViewById(R.id.fa_id);
        TextView faphone = findViewById(R.id.fa_phone);

        fa_id.setText("Facility manager id: "+ request_sender_requests.requestArrayList.get(position1).getpriority());
        faphone.setText("Facility manager phone: "+request_sender_requests.requestArrayList.get(position1).getfa_phone());


        String image_url = request_sender_requests.requestArrayList.get(position1).getimagepath();
        int loader = R.drawable.circle;

        // Imageview to show
      image = (ImageView) findViewById(R.id.imageView);

if(image_url.equals("")){}
else {
    Picasso.with(detailrequestrequest_sender.this).load(image_url).into(image);
}

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                image.setScaleType(ImageView.ScaleType.FIT_XY);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
                getSupportActionBar().hide();





            }
        });


report=findViewById(R.id.report);
report.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        Bundle bundle1 = getIntent().getExtras();
        String id =bundle1.getString("id");
        String facility =bundle1.getString("facility");
        Intent myIntent1 = new Intent(getApplicationContext(),request_sender_report.class);

        myIntent1.putExtra("facility", facility );
        myIntent1.putExtra("id", id );
        startActivity(myIntent1);
    }
});

        viewdocumnet=findViewById(R.id.view_document);
        viewdocumnet.setOnClickListener(new View.OnClickListener() {
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







        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {

                retrieveclientData11(detailrequestrequest_sender.this);

            }
        }, 0, 30000);





    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();
        if (id == R.id.report) {

            startActivity(new Intent(getApplicationContext(), request_sender_completed_requests.class));
        }
        else if (id == R.id.home) {

            startActivity(new Intent(getApplicationContext(), choose_reqstsender.class));
        }
        if (id == R.id.viewrequest10) {

            startActivity(new Intent(getApplicationContext(), request_sender_requests.class));
        }else if(id == R.id.requestneeds){

            startActivity(new Intent(getApplicationContext(), selectmaintenance.class));
        }

        else if(id == R.id.change_picture) {

            startActivity(new Intent(getApplicationContext(), change_profile_picture_request_sender.class));

        }
        else if(id == R.id.change_password) {

            startActivity(new Intent(getApplicationContext(), Rs_change_password.class));

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
    public void onBackPressed() {
        super.onBackPressed();

        SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
        String name = preferences.getString("Name", "");
        String name1 = preferences.getString("wuid", "");

        if (name.equalsIgnoreCase("mchead"))

        {
            Intent myIntent = new Intent(detailrequestrequest_sender.this, detailrequestrequest_sender.class);

            detailrequestrequest_sender.this.startActivity(myIntent);

        }



        finish();
    }




    public void userinfo(){

        String url= getResources().getString(R.string.url);
        String urlclient = url+"request_sender/request_sender_data_retrive.php";

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
                            job_title = object.getString("job_title");
                            status = "workstatus";

                            ImageView image = (ImageView) findViewById(R.id.menu_image2);
                            TextView tv =findViewById(R.id.navfname);
                            tv.setText(fname);
                            Picasso.with(detailrequestrequest_sender.this).load(impath).into(image);
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
                Toast.makeText(detailrequestrequest_sender.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(detailrequestrequest_sender.this);
        requestQueue.add(request);
    }











    @SuppressLint("ServiceCast")
    void createNotificationChannel1(Context c){
        String CHANNEL_ID="MYCHANNEL";
        NotificationChannel notificationChannel= null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(CHANNEL_ID,"name", NotificationManager.IMPORTANCE_HIGH);
        }
        Notification notification= null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            notification = new Notification.Builder(c,CHANNEL_ID)
                    .setContentText( "We have assigned maintenance technician for you he will contact you thanks for your patience")

                    .setContentTitle( "Assigned technician ")
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


    public void retrieveclientData11(Context c){

        String url= getResources().getString(R.string.url1);
        String urlrequest = url+"request_sender/retrieve_request11.php";
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


                        int i =jsonArray.length()-1;
                        JSONObject object = jsonArray.getJSONObject(i);
                        String      id = object.getString("id");
                        String    techname = object.getString("techname");
                        int   a = Integer.parseInt(id);
                        editor = preferences1.edit();
                        preferences1 =getSharedPreferences("abcd", Context.MODE_PRIVATE);
                        String requestid = preferences1.getString("requestid", "");
                        String techn1 = preferences1.getString("techname", "");
                        if(requestid.equals("")){
                            requestid = "0";
                            techn1 = "0";
                            editor.putString("requestid","0");
                        }
                        int reid = Integer.parseInt(requestid);


                        if(techname.equals("Not Assigned")){


                        }else {
                            //  Toast.makeText(selectmaintenance.this, String.valueOf(reid), Toast.LENGTH_SHORT).show();

                            if (a>reid) {

                                if (reid == a) {

                                } else {
                                    if (techn1.equals("Not Assigned")) {

                                    } else if(!techn1.equals("Not Assigned")){


                                        createNotificationChannel1(c);

                                    }
                                }


                            }
                            editor.putString("requestid", id);
                            editor.putString("techname", techname);
                            editor.apply();

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
                //      Toast.makeText(c, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        Uri uri = FileProvider.getUriForFile(detailrequestrequest_sender.this, "com.example.wumrts.provider", file);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(uri, "application/msword");
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(i);

    }


}