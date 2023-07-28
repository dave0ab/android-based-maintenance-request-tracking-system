package com.example.wmrts.facility_manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;

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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wmrts.Admin.Admin.MyAdapter2;
import com.example.wmrts.Admin.subadmin.MyAdapter1;
import com.example.wmrts.Logout;
import com.example.wmrts.MainActivity;
import com.example.wmrts.R;
import com.example.wmrts.about;
import com.example.wmrts.contactus;
import com.example.wmrts.Admin.choose_Admin;

import com.example.wmrts.maintenance_manager.technician.MyAdapter3;

import com.example.wmrts.request_sender.request_sender_requests;
import com.example.wmrts.selectmaintenance;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class track_maintenance_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    String id; String fname;String lname; String directoret;String wuid;    String mobilenum;     String gender; String job_title;String status;    String impath  ;


Button viewdocument;



    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    ListView listview;
Spinner task_status;
    requestadapter adapter;
    MyAdapter1 adapter2;
    MyAdapter2 adapter3;
    MyAdapter3 adapter4;

    public static ArrayList<requestmodal> requestArrayList = new ArrayList<>();


    Button search ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_maintenance);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.trace);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
task_status = findViewById(R.id.task_status);


        ArrayAdapter<CharSequence> adapter7=ArrayAdapter.createFromResource(this, R.array.task_status, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_item);
        task_status.setAdapter(adapter7);
userinfo();
        retrieveclientData1();


        task_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection here
                String result = String.valueOf(task_status.getSelectedItem());
                userinfo();
                retrieveclientData(result);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });









        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(track_maintenance_activity.this);





        listview = findViewById(R.id.myListView);


        adapter = new requestadapter(this, requestArrayList);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {


                Intent myIntent = new Intent(track_maintenance_activity.this, trackdetailrequest.class);
                myIntent.putExtra("path", requestArrayList.get(position).getdocument_path());
                myIntent.putExtra("rqst", requestArrayList.get(position).getId());
                myIntent.putExtra("position",position);


          startActivity(myIntent);

            }

        });







        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {

                retrieveclientData1(track_maintenance_activity.this);

            }
        }, 0, 30000);




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);


        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        // with id and take its object
        MenuItem searchViewItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);

        // attach setOnQueryTextListener
        // to search view defined above
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // Override onQueryTextSubmit method which is call when submit query is searched
            @Override
            public boolean onQueryTextSubmit(String query) {
                // If the list contains the search query than filter the adapter
                // using the filter method with the query as its argument
                String result = String.valueOf(task_status.getSelectedItem());
                userinfo();
                retrieveclientData111(result,query);


                return false;
            }

            // This method is overridden to filter the adapter according
            // to a search query when the user is typing search
            @Override
            public boolean onQueryTextChange(String newText) {

                String result = String.valueOf(task_status.getSelectedItem());
                userinfo();
                retrieveclientData111(result,newText);


                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        int id = item.getItemId();
        if (id == R.id.about) {
            startActivity(new Intent(getApplicationContext(), about.class));

        } else if (id == R.id.contactus) {
            startActivity(new Intent(getApplicationContext(), contactus.class));

        } else if (id == R.id.logout) {

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);

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

        return super.onOptionsItemSelected(item);
    }



    public void userinfo(){

        String url= getResources().getString(R.string.url);
        String urlclient = url+"facility_manager/FM_data_retrive.php";

        StringRequest request = new StringRequest(Request.Method.POST, urlclient,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
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
                            directoret = object.getString("directoret");
                            ImageView image = (ImageView) findViewById(R.id.menu_image2);
                            TextView tv =findViewById(R.id.navfname);
                            tv.setText(fname);
                            Picasso.with(track_maintenance_activity.this).load(impath).into(image);


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
                Toast.makeText(track_maintenance_activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(track_maintenance_activity.this);
        requestQueue.add(request);
    }


    public void retrieveclientData(String status){
        String url= getResources().getString(R.string.url1);
        String urlrequest = url+"facility_manager/track_request.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlrequest,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //      Toast.makeText(listmaintenancerequest.this, response, Toast.LENGTH_SHORT).show();

                requestArrayList.clear();
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){


                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String wuid = object.getString("wuid");
                            String name = object.getString("name");
                            String buildingno = object.getString("buildingno");
                            String officeno= object.getString("officeno");
                            String phone = object.getString("phone");
                            String quantity = object.getString("quantity");
                            String checkboxrequests = object.getString("checkboxrequests");
                            String priority = object.getString("priority");
                            String additionalmessage= object.getString("additionalmessage");
                            String impath = object.getString("imagepath");
                            String thing_to_fix = object.getString("thing_to_fix");

                            String facility = object.getString("facility");
                            String technician = object.getString("technician");
                            String techname= object.getString("techname");
                            String techphone= object.getString("techphone");
                            String task_status = object.getString("task_status");
                            String assigned_time= object.getString("assigned_time");
                            String assigned_date = object.getString("assigned_date");
                            String requested_date = object.getString("requested_date");
                            String document_path = object.getString("document_path");
                            String fa_phone = object.getString("fa_phone");


                            if(facility.equals(directoret))
                                if (directoret.equals(facility)) {

                            if(task_status.equals(status))
                                if (status.equals(task_status)) {
                                    requestmodal request = new requestmodal(id, wuid, name, buildingno, officeno, phone, quantity, checkboxrequests, priority, additionalmessage, impath, thing_to_fix
                                            , facility, technician, techname, techphone, task_status, assigned_time, assigned_date, requested_date, document_path,fa_phone);
                                    requestArrayList.add(request);
                                    listview.setAdapter(adapter);
                                    adapter.notifyDataSetChanged();

                                }}
                        }

                    }

                }
                catch (JSONException e){
                    e.printStackTrace();
                }
                String result = String.valueOf(task_status.getSelectedItem());
                if (result.equals("Select task status")) {
                    if(requestArrayList.isEmpty()){

                        requestmodal request = new requestmodal("0", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    }}

                else if (result.equals("Not Assigned")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("00", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

                else if (result.equals("Assigned")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}


                else if (result.equals("Completed")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("0000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

                else if (result.equals("Reassigned")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("00000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

                else if (result.equals("Rejected")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("000000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(track_maintenance_activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                //            progressDialog.dismiss();
            }
        }

        );


        RequestQueue requestQueue = Volley.newRequestQueue(track_maintenance_activity.this);
        requestQueue.add(request);




    }
    public void retrieveclientData1(){
        String url= getResources().getString(R.string.url1);
        String urlrequest = url+"facility_manager/track_request.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlrequest,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //      Toast.makeText(listmaintenancerequest.this, response, Toast.LENGTH_SHORT).show();

                requestArrayList.clear();
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){


                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String wuid = object.getString("wuid");
                            String name = object.getString("name");
                            String buildingno = object.getString("buildingno");
                            String officeno= object.getString("officeno");
                            String phone = object.getString("phone");
                            String quantity = object.getString("quantity");
                            String checkboxrequests = object.getString("checkboxrequests");
                            String priority = object.getString("priority");
                            String additionalmessage= object.getString("additionalmessage");
                            String impath = object.getString("imagepath");
                            String thing_to_fix = object.getString("thing_to_fix");

                            String facility = object.getString("facility");
                            String technician = object.getString("technician");
                            String techname= object.getString("techname");
                            String techphone= object.getString("techphone");
                            String task_status = object.getString("task_status");
                            String assigned_time= object.getString("assigned_time");
                            String assigned_date = object.getString("assigned_date");
                            String requested_date = object.getString("requested_date");
                            String document_path = object.getString("document_path");
                            String fa_phone = object.getString("fa_phone");

                            if(facility.equals(directoret))
                                if (directoret.equals(facility)) {


                                            requestmodal request = new requestmodal(id, wuid, name, buildingno, officeno, phone, quantity, checkboxrequests, priority, additionalmessage, impath, thing_to_fix
                                                    , facility, technician, techname, techphone, task_status, assigned_time, assigned_date, requested_date, document_path,fa_phone);
                                            requestArrayList.add(request);
                                            listview.setAdapter(adapter);
                                            adapter.notifyDataSetChanged();

                                        }
                        }

                    }

                }
                catch (JSONException e){
                    e.printStackTrace();
                }
                String result = String.valueOf(task_status.getSelectedItem());
                if (result.equals("Select task status")) {
                    if(requestArrayList.isEmpty()){

                        requestmodal request = new requestmodal("0", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    }}

                else if (result.equals("Not Assigned")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("00", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

                else if (result.equals("Assigned")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}


                else if (result.equals("Completed")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("0000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

                else if (result.equals("Reassigned")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("00000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

                else if (result.equals("Rejected")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("000000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(track_maintenance_activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                //            progressDialog.dismiss();
            }
        }

        );


        RequestQueue requestQueue = Volley.newRequestQueue(track_maintenance_activity.this);
        requestQueue.add(request);




    }
    public void retrieveclientData111(String status, String wuid123){
        String url= getResources().getString(R.string.url1);
        String urlrequest = url+"facility_manager/track_request.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlrequest,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //      Toast.makeText(listmaintenancerequest.this, response, Toast.LENGTH_SHORT).show();

                requestArrayList.clear();
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){


                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String wuid = object.getString("wuid");
                            String name = object.getString("name");
                            String buildingno = object.getString("buildingno");
                            String officeno= object.getString("officeno");
                            String phone = object.getString("phone");
                            String quantity = object.getString("quantity");
                            String checkboxrequests = object.getString("checkboxrequests");
                            String priority = object.getString("priority");
                            String additionalmessage= object.getString("additionalmessage");
                            String impath = object.getString("imagepath");
                            String thing_to_fix = object.getString("thing_to_fix");

                            String facility = object.getString("facility");
                            String technician = object.getString("technician");
                            String techname= object.getString("techname");
                            String techphone= object.getString("techphone");
                            String task_status = object.getString("task_status");
                            String assigned_time= object.getString("assigned_time");
                            String assigned_date = object.getString("assigned_date");
                            String requested_date = object.getString("requested_date");
                            String document_path = object.getString("document_path");
                            String fa_phone = object.getString("fa_phone");
                            String g =wuid123.toLowerCase(Locale.ROOT);
                            String h= wuid.toLowerCase(Locale.ROOT);
                            if(h.contains(g)){
                            if(facility.equals(directoret))
                                if (directoret.equals(facility)) {

                                    if(task_status.equals(status))
                                        if (status.equals(task_status)) {
                                            requestmodal request = new requestmodal(id, wuid, name, buildingno, officeno, phone, quantity, checkboxrequests, priority, additionalmessage, impath, thing_to_fix
                                                    , facility, technician, techname, techphone, task_status, assigned_time, assigned_date, requested_date, document_path,fa_phone);
                                            requestArrayList.add(request);
                                            listview.setAdapter(adapter);
                                            adapter.notifyDataSetChanged();

                                        }}
                        }}

                    }

                }
                catch (JSONException e){
                    e.printStackTrace();
                }

                String result = String.valueOf(task_status.getSelectedItem());
                if (result.equals("Select task status")) {
                    if(requestArrayList.isEmpty()){

                        requestmodal request = new requestmodal("0", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    }}

                else if (result.equals("Not Assigned")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("00", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

                else if (result.equals("Assigned")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("00", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}


                else if (result.equals("Completed")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

                else if (result.equals("Reassigned")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

                else if (result.equals("Rejected")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(track_maintenance_activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                //            progressDialog.dismiss();
            }
        }

        );


        RequestQueue requestQueue = Volley.newRequestQueue(track_maintenance_activity.this);
        requestQueue.add(request);




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