package com.example.wmrts.maintenancetechnician;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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
import com.example.wmrts.contactus;
import com.example.wmrts.facility_manager.detailreport1;
import com.example.wmrts.facility_manager.detailrequest;
import com.example.wmrts.facility_manager.listmaintenancerequest;
import com.example.wmrts.facility_manager.notreported;
import com.example.wmrts.facility_manager.track_maintenance_activity;
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

public class detailrequesttechnician extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    TextView tvid,tvname,phone,tvwuid,tvbuilding,tvoffice, priority,additional,messagedetails,quantity,tvdevice,department,status,imageview;
    int position1;
    ImageView image;
    Button view_document;
    Button activate,deactivate;
    private String fileName;
    private View viewreport;
    Button send_report;
    String path1;
    private URL url = null;
    private String filepath = "http://192.168.43.228:80//wumrts/table.docx";
    Bundle bundle1;
    @SuppressLint({"MissingInflatedId", "SuspiciousIndentation"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailrequest56);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.trace);
        bundle1 = getIntent().getExtras();
        path1=bundle1.getString("path");

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        view_document = findViewById(R.id.view_document);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

userinfo();

send_report=findViewById(R.id.send_report);

        //Initializing Views
        tvid = findViewById(R.id.lname);
        tvname = findViewById(R.id.name);
        tvwuid = findViewById(R.id.wuid);
        tvbuilding = findViewById(R.id.phone);
        tvoffice = findViewById(R.id.officenno);
        department = findViewById(R.id.technicianname);

        tvbuilding = findViewById(R.id.phone);
        phone = findViewById(R.id.phone1);
        tvdevice = findViewById(R.id.device);
        quantity = findViewById(R.id.quantity);
        messagedetails = findViewById(R.id.mdetails);
        additional = findViewById(R.id.additional);
        priority = findViewById(R.id.technicianphone);


 // imageview = findViewById(R.id.imageView);
        Intent intent =getIntent();
        position1 = intent.getExtras().getInt("position");

        tvid.setText("ID: "+  requests.requestArrayList.get(position1).getId());
        tvwuid.setText("University ID: "+requests .requestArrayList.get(position1).getWuid());
        tvname.setText("Name: "+requests .requestArrayList.get(position1).getname());
        tvbuilding.setText("Building no: "+requests .requestArrayList.get(position1).getbuildingno());
        tvoffice.setText("Office no: "+requests .requestArrayList.get(position1).getofficeno());
        quantity.setText("Quantity: "+requests .requestArrayList.get(position1).getquantity());
        phone.setText("Phone: "+requests .requestArrayList.get(position1).getphone());
        department.setText("Technician name: "+requests .requestArrayList.get(position1).gettechname());
        messagedetails.setText("Maintenance details: "+requests .requestArrayList.get(position1).getadditionalmessage());
        TextView  assigned_date = findViewById(R.id.assigned_date);
        assigned_date.setText("Assigned date: "+  requests.requestArrayList.get(position1).getassigned_date());
        additional.setText("Maintenance details: "+requests .requestArrayList.get(position1).getcheckboxrequests());
        priority .setText("Technician phone: "+requests .requestArrayList.get(position1).gettechphone());

        tvdevice.setText("Device: "+requests .requestArrayList.get(position1).getthing_to_fix());
      //  imageview .setText("Department: "+listmaintenancerequest.requestArrayList.get(position).getimagepath());

        TextView fa_id = findViewById(R.id.fa_id);
        TextView faphone = findViewById(R.id.fa_phone);

        fa_id.setText("Facility manager id: "+ requests.requestArrayList.get(position1).getpriority());
        faphone.setText("Facility manager phone: "+requests.requestArrayList.get(position1).getfa_phone());

        String image_url = requests .requestArrayList.get(position1).getimagepath();
        int loader = R.drawable.circle;

        // Imageview to show
      image = (ImageView) findViewById(R.id.imageView);
      if(!image_url.equals(""))
 Picasso.with(detailrequesttechnician.this).load(image_url).into(image);



        viewreport=findViewById(R.id.report);

        viewreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                retrieve00();




            }
        });



        send_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent1 = new Intent(detailrequesttechnician.this, technician_report.class);
                myIntent1.putExtra("position", position1);
                myIntent1.putExtra("facility", requests.requestArrayList.get(position1).getfacility());
                myIntent1.putExtra("id",requests.requestArrayList.get(position1).getId());
                detailrequesttechnician.this.startActivity(myIntent1);




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

        view_document.setOnClickListener(new View.OnClickListener() {
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
        Uri uri = FileProvider.getUriForFile(detailrequesttechnician.this, "com.example.wumrts.provider", file);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(uri, "application/msword");
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(i);

    }


    public void btn_activate() {



        tvid = findViewById(R.id.lname);


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST," http://192.168.43.228:80//wumrts/client/activate.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(detailrequesttechnician.this, "Activated", Toast.LENGTH_SHORT).show();

                        finish();
                        progressDialog.dismiss();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(detailrequesttechnician.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("id", listmaintenancerequest.requestArrayList.get(position1).getId());

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(detailrequesttechnician.this);
        requestQueue.add(request);


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
            Intent myIntent = new Intent(detailrequesttechnician.this, detailrequesttechnician.class);

            detailrequesttechnician.this.startActivity(myIntent);

        }



        finish();
    }




    public void userinfo(){

        String url= getResources().getString(R.string.url);
        String urlclient = url+"technician/technician_data_retrive.php";

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
                            job_title = "";
                            status = object.getString("workstatus");

                            ImageView image = (ImageView) findViewById(R.id.menu_image2);
                            TextView tv =findViewById(R.id.navfname);
                            tv.setText(fname);
                            Picasso.with(detailrequesttechnician.this).load(impath).into(image);
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
                Toast.makeText(detailrequesttechnician.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(detailrequesttechnician.this);
        requestQueue.add(request);
    }



    public void retrieve00(){
        String url= getResources().getString(R.string.url1);
        String urlrequest =url+ "technician/retrieve_reported_request1.php";
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
                            detailrequesttechnician.this.startActivity(myIntent12);

                        }
                        else{

                            Intent  myIntent12 = new Intent(getApplicationContext(), detailreport3.class);

                            myIntent12.putExtra("request_id", requests.requestArrayList.get(position1).getId());

                            detailrequesttechnician.this.startActivity(myIntent12);






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
                Toast.makeText(detailrequesttechnician.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        ){ @Override
        protected Map<String, String> getParams() throws AuthFailureError {

            Map<String,String> params = new HashMap<String,String>();
            SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);


            String fname = preferences.getString("wuid", "");
            bundle1 = getIntent().getExtras();
            String id1 =bundle1.getString("rqst");
            params.put("rid",id1);
            params.put("wuid",fname);
            return params;
        }};


        RequestQueue requestQueue = Volley.newRequestQueue(detailrequesttechnician.this);
        requestQueue.add(request);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {



        int id = item.getItemId();

        if (id == R.id.assigned_requests) {

            startActivity(new Intent(getApplicationContext(), requests.class));
        }


        if (id == R.id.home) {

            startActivity(new Intent(getApplicationContext(), choosetechician.class));
        }


        if (id == R.id.reported_requests) {

            startActivity(new Intent(getApplicationContext(), select_reported_requests1.class));
        }
        if (id == R.id.change_picture) {

            startActivity(new Intent(getApplicationContext(), change_profile_picture_technician.class));
        }
        if (id == R.id.change_password) {

            startActivity(new Intent(getApplicationContext(), tech_change_password.class));
        }
        if (id == R.id.report_finished) {

            startActivity(new Intent(getApplicationContext(), select_report_maintenance_requests.class));

        }
        if (id == R.id.logout) {

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

}