package com.example.wmrts.Admin;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
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
import com.example.wmrts.facility_manager.change_profile_picture_facility;
import com.example.wmrts.facility_manager.fa_change_password;
import com.example.wmrts.facility_manager.facilitymanagerchoose;
import com.example.wmrts.facility_manager.listmaintenancerequest;
import com.example.wmrts.facility_manager.select_reported_requests;
import com.example.wmrts.facility_manager.track_maintenance_activity;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class DetailActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{


    TextView tvid,tvname,tvwuid,tvcontact,tvgender,department,status,imageview;
    int position;
    ImageView image;
    Button activate,deactivate;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.trace);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);


        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(DetailActivity.this);



        userinfo();

        //Initializing Views
        tvid = findViewById(R.id.lname);
        tvname = findViewById(R.id.txtname);
        tvwuid = findViewById(R.id.wuid);
        tvcontact = findViewById(R.id.txcontact);
        tvgender = findViewById(R.id.gender);
        department = findViewById(R.id.technician);
        status = findViewById(R.id.status);
      //  imageview = findViewById(R.id.imageView)

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: "+ activate_deactivate.clientArrayList.get(position).getId());
        tvname.setText("Name: "+activate_deactivate.clientArrayList.get(position).getfname());
        tvwuid.setText("University ID: "+activate_deactivate.clientArrayList.get(position).getWuid());
        tvcontact.setText("Contact: "+activate_deactivate.clientArrayList.get(position).getmobilnum());
        tvgender.setText("Gender: "+activate_deactivate.clientArrayList.get(position).getgender());
        department.setText("Department: "+activate_deactivate.clientArrayList.get(position).getjob_title());
        status .setText("Status: "+activate_deactivate.clientArrayList.get(position).getstatus());
//   imageview .setText("Department: "+activate_deactivate.clientArrayList.get(position).getimpath());



        String image_url = activate_deactivate.clientArrayList.get(position).getimpath();
        int loader = R.drawable.circle;

        // Imageview to show
        image = (ImageView) findViewById(R.id.imageView);
        Picasso.with(DetailActivity.this).load(image_url).into(image);
activate=findViewById(R.id.approve);

        deactivate=findViewById(R.id.disapprove);
activate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        btn_activate();
    }
});

        deactivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_deactivate();
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






        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {

                retrieveclientData1(DetailActivity.this);

            }
        }, 0, 30000);




    }

    public void btn_activate() {



        tvid = findViewById(R.id.lname);


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();
        String url = getResources().getString(R.string.url1);
        StringRequest request = new StringRequest(Request.Method.POST,url+"request_sender/activate.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(DetailActivity.this, "Activated", Toast.LENGTH_SHORT).show();

                        finish();
                        progressDialog.dismiss();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(DetailActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                String fname = preferences.getString("wuid", "");
                params.put("action",fname);


                params.put("wuid",activate_deactivate.clientArrayList.get(position).getWuid());

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(DetailActivity.this);
        requestQueue.add(request);





    }






    public void btn_deactivate() {



        tvid = findViewById(R.id.lname);


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();
        String url = getResources().getString(R.string.url1);
        StringRequest request = new StringRequest(Request.Method.POST,url+"request_sender/deactivate.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(DetailActivity.this, "Deactivated", Toast.LENGTH_SHORT).show();

                        finish();
                        progressDialog.dismiss();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(DetailActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                String fname = preferences.getString("wuid", "");
                params.put("action",fname);


                params.put("wuid",activate_deactivate.clientArrayList.get(position).getWuid());

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(DetailActivity.this);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.home) {

            startActivity(new Intent(getApplicationContext(), facilitymanagerchoose.class));
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
                            if(impath.equals("")) {}
                            else{
                                Picasso.with(DetailActivity.this).load(impath).into(image);
                            }
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
                Toast.makeText(DetailActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(DetailActivity.this);
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

                            if(requestid.equals("")){
                                editor = preferences1.edit();
                                requestid = "0";
                                editor.putString("requestid","0");
                            }

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





}
