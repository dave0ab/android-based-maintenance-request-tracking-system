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
import com.example.wmrts.R;
import com.example.wmrts.about;
import com.example.wmrts.contactus;
import com.example.wmrts.maintenancetechnician.requests;
import com.example.wmrts.maintenancetechnician.select_report_maintenance_requests;
import com.example.wmrts.maintenancetechnician.tech_change_password;
import com.example.wmrts.maintenancetechnician.technician_report;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class select_reported_requests extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    String id; String fname;String lname;String wuid; String directoret1;  String mobilenum;     String gender; String job_title;String status;    String impath  ;
Spinner report_status,reportedBy,reassign_status;
    ListView listview;reportadapter adapter;  public static ArrayList<reportmodal> reportArrayList = new ArrayList<>();
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_reported_requests);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.trace);



        report_status = findViewById(R.id.report_status);
        reassign_status = findViewById(R.id.reassign_status);
        reportedBy = findViewById(R.id.reported_by);


        ArrayAdapter<CharSequence> adapter7=ArrayAdapter.createFromResource(this, R.array.report_status, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_item);
        report_status.setAdapter(adapter7);


        ArrayAdapter<CharSequence> adapter9=ArrayAdapter.createFromResource(this, R.array.reassigned_status, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_item);
        reassign_status.setAdapter(adapter9);

        ArrayAdapter<CharSequence> adapter8=ArrayAdapter.createFromResource(this, R.array.report_personel, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_item);
        reportedBy.setAdapter(adapter8);





        reassign_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection here
                String result = String.valueOf(report_status.getSelectedItem());
                String result1 = String.valueOf(reportedBy.getSelectedItem());
                String resul2 = String.valueOf(reassign_status.getSelectedItem());
                userinfo();
                retrieveclientData(result,result1,resul2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });










        report_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection here
                String result = String.valueOf(report_status.getSelectedItem());
                String result1 = String.valueOf(reportedBy.getSelectedItem());
                String result2 = String.valueOf(reassign_status.getSelectedItem());
                userinfo();
                retrieveclientData(result,result1,result2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        reportedBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection here
                String result = String.valueOf(report_status.getSelectedItem());
                String result1 = String.valueOf(reportedBy.getSelectedItem());
                String result2 = String.valueOf(reassign_status.getSelectedItem());
                userinfo();
                retrieveclientData(result,result1,result2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });






        userinfo();



        drawerLayout = findViewById(R.id.my_drawer_layout);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(select_reported_requests.this);



        // retrieveclientData();

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);


        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button



        MyAdapter1 adapter2;
        MyAdapter2 adapter3;
        com.example.wmrts.maintenance_manager.technician.MyAdapter3 adapter4;

        Button search ;

        String urlclient1 = "http://192.168.43.228:80//wumrts/head/acdc1.php";





        adapter = new reportadapter(this, reportArrayList);
        listview = findViewById(R.id.listview);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"View Report"};
                builder.setTitle(reportArrayList.get(position).gettech_wuid());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        switch (i){

                            case 0:

                                Intent myIntent1 = new Intent(select_reported_requests.this, detailreport2.class);
                                myIntent1.putExtra("position", position);
                                myIntent1.putExtra("facility", reportArrayList.get(position).getdirectoret());
                                myIntent1.putExtra("id", reportArrayList.get(position).getId());
                                myIntent1.putExtra("path", reportArrayList.get(position).getdocumentPath());
                                select_reported_requests.this.startActivity(myIntent1);



                                break;


                        }

                    }
                });
                builder.create().show();


            }

        });




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);

        // Initialise menu item search bar
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
                String result = String.valueOf(report_status.getSelectedItem());
                String result1 = String.valueOf(reportedBy.getSelectedItem());
                userinfo();
                retrieveclientData111(result,result1,query);


                return false;
            }

            // This method is overridden to filter the adapter according
            // to a search query when the user is typing search
            @Override
            public boolean onQueryTextChange(String newText) {

                String result = String.valueOf(report_status.getSelectedItem());
                String result1 = String.valueOf(reportedBy.getSelectedItem());
                userinfo();
                retrieveclientData111(result,result1,newText);


                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
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

    public void retrieveclientData( String d,String f,String g0){
        String url= getResources().getString(R.string.url1);
        String urlrequest =url+ "facility_manager/retrieve_reported_request.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlrequest,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(select_reported_requests.this, response, Toast.LENGTH_SHORT).show();

                reportArrayList.clear();
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){


                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String request_id = object.getString("request_id");
                            String tech_wuid = object.getString("tech_wuid");
                            String sender_wuid = object.getString("sender_wuid");
                            String message = object.getString("message");
                            String directoret= object.getString("directorate");
                            String documentPath = object.getString("document_path");
                            String reported_date = object.getString("reported_date");
                            String status = object.getString("status");
                            String restatus = object.getString("reassign_status");
String ac = restatus.toLowerCase(Locale.ROOT);
String bn = g0.toLowerCase(Locale.ROOT);
                            if(ac.equals(bn)){
                            if ("technician".equalsIgnoreCase(f)) {


                                if (directoret1.equals(directoret))
                                    if (directoret.equals(directoret1)) {

                                        if (d.equals(status))
                                            if (status.equals(d)) {

                                                if (d.equals(status))
                                                    if (status.equals(d)) {

                                                        if(tech_wuid.equals("")){
                                                            continue;
                                                        }else{
                                                        reportmodal request = new reportmodal(id, request_id, tech_wuid, message, directoret, documentPath, reported_date, status);
                                                        reportArrayList.add(request);
                                                        listview.setAdapter(adapter);
                                                        adapter.notifyDataSetChanged();}

                                                    }
                                            }
                                            }

                                    }if ("request sender".equalsIgnoreCase(f)){

                                if (directoret.equals(directoret1)) {

                                    if (d.equals(status))
                                        if (status.equals(d)) {

                                            if (d.equals(status))
                                                if (status.equals(d)) {
                                                    if(sender_wuid.equals("")){
                                                        continue;
                                                    }else {
                                                        reportmodal request = new reportmodal(id, request_id, sender_wuid, message, directoret, documentPath, reported_date, status);
                                                        reportArrayList.add(request);
                                                        listview.setAdapter(adapter);
                                                        adapter.notifyDataSetChanged();
                                                    }
                                                }}}}

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
                Toast.makeText(select_reported_requests.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        ){ @Override
        protected Map<String, String> getParams() throws AuthFailureError {

            Map<String,String> params = new HashMap<String,String>();
            SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

            String fname = preferences.getString("wuid", "");
            params.put("wuid",fname);
            return params;
        }};


        RequestQueue requestQueue = Volley.newRequestQueue(select_reported_requests.this);
        requestQueue.add(request);



    }

    public void retrieveclientData111( String d,String f,String wuid123){
        String url= getResources().getString(R.string.url1);
        String urlrequest =url+ "facility_manager/retrieve_reported_request.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlrequest,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(select_reported_requests.this, response, Toast.LENGTH_SHORT).show();

                reportArrayList.clear();
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){


                        for(int i=0;i<jsonArray.length();i++) {

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String request_id = object.getString("request_id");
                            String tech_wuid = object.getString("tech_wuid");
                            String sender_wuid = object.getString("sender_wuid");
                            String message = object.getString("message");
                            String directoret = object.getString("directorate");
                            String documentPath = object.getString("document_path");
                            String reported_date = object.getString("reported_date");
                            String status = object.getString("status");




                            if ("technician".equalsIgnoreCase(f)) {

                                String g =wuid123.toLowerCase(Locale.ROOT);
                                String h= tech_wuid.toLowerCase(Locale.ROOT);
                                if(h.contains(g)){

                                if (directoret1.equals(directoret))
                                    if (directoret.equals(directoret1)) {

                                        if (d.equals(status))
                                            if (status.equals(d)) {

                                                if (d.equals(status))
                                                    if (status.equals(d)) {

                                                        if (tech_wuid.equals("")) {
                                                            continue;
                                                        } else {
                                                            reportmodal request = new reportmodal(id, request_id, tech_wuid, message, directoret, documentPath, reported_date, status);
                                                            reportArrayList.add(request);
                                                            listview.setAdapter(adapter);
                                                            adapter.notifyDataSetChanged();
                                                        }

                                                    }
                                            }
                                    }

                            }
                        }

                            if ("request sender".equalsIgnoreCase(f)){

                                String g =wuid123.toLowerCase(Locale.ROOT);
                                String h= sender_wuid.toLowerCase(Locale.ROOT);
                                if(h.contains(g)){
                                if (directoret.equals(directoret1)) {

                                    if (d.equals(status))
                                        if (status.equals(d)) {

                                            if (d.equals(status))
                                                if (status.equals(d)) {
                                                    if(sender_wuid.equals("")){
                                                        continue;
                                                    }else {
                                                        reportmodal request = new reportmodal(id, request_id, sender_wuid, message, directoret, documentPath, reported_date, status);
                                                        reportArrayList.add(request);
                                                        listview.setAdapter(adapter);
                                                        adapter.notifyDataSetChanged();
                                                    }
                                                }}}

                            }}

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
                Toast.makeText(select_reported_requests.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        ){ @Override
        protected Map<String, String> getParams() throws AuthFailureError {

            Map<String,String> params = new HashMap<String,String>();
            SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

            String fname = preferences.getString("wuid", "");
            params.put("wuid",fname);
            return params;
        }};


        RequestQueue requestQueue = Volley.newRequestQueue(select_reported_requests.this);
        requestQueue.add(request);



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
                            directoret1 = object.getString("directoret");
                          String   directoret1 = object.getString("directoret");
                            ImageView image = (ImageView) findViewById(R.id.menu_image2);
                            TextView tv =findViewById(R.id.navfname);
                            tv.setText(fname);
                            Picasso.with(select_reported_requests.this).load(impath).into(image);

                          //  retrieveclientData(directoret1);
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
                Toast.makeText(select_reported_requests.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(select_reported_requests.this);
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




}