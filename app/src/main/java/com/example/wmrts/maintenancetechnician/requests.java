package com.example.wmrts.maintenancetechnician;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.example.wmrts.facility_manager.detailrequest1;
import com.example.wmrts.facility_manager.detailrequest2;
import com.example.wmrts.facility_manager.listmaintenancerequest;
import com.example.wmrts.maintenance_manager.technician.MyAdapter3;

import com.example.wmrts.contactus;
import com.example.wmrts.facility_manager.requestadapter;
import com.example.wmrts.facility_manager.requestmodal;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class requests extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    String id; String fname;String lname;String wuid; String directoret;  String mobilenum;     String gender; String job_title;String status;    String impath  ;
Spinner task_status;
    ListView listview;requestadapter adapter;  public static ArrayList<requestmodal> requestArrayList = new ArrayList<>();
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.trace);

        task_status = findViewById(R.id.task_status);


        ArrayAdapter<CharSequence> adapter7=ArrayAdapter.createFromResource(this, R.array.task_status1, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_item);
        task_status.setAdapter(adapter7);

        userinfo();


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







        drawerLayout = findViewById(R.id.my_drawer_layout);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(requests.this);



       // retrieveclientData();

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);


        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button



        MyAdapter1 adapter2;
        MyAdapter2 adapter3;
        MyAdapter3 adapter4;

        Button search ;

        String urlclient1 = "http://192.168.43.228:80//wumrts/head/acdc1.php";





        adapter = new requestadapter(this, requestArrayList);
        listview = findViewById(R.id.listview);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String a  =         requestArrayList.get(position).getfacility();
                if(a.equalsIgnoreCase("ictd101")){

                    Intent myIntent1 = new Intent(getApplicationContext(), detailrequesttechnician1.class);
                    myIntent1.putExtra("position", position);
                    myIntent1.putExtra("rqst", requestArrayList.get(position).getId());
                    myIntent1.putExtra("path", requestArrayList.get(position).getdocument_path());

                    requests.this.startActivity(myIntent1);

                }else {

                    Intent myIntent1 = new Intent(getApplicationContext(), detailrequesttechnician.class);
                    myIntent1.putExtra("position", position);
                    myIntent1.putExtra("rqst", requestArrayList.get(position).getId());
                    myIntent1.putExtra("path", requestArrayList.get(position).getdocument_path());

                    requests.this.startActivity(myIntent1);

                }
















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

    public void retrieveclientData(String d){
        String url= getResources().getString(R.string.url1);
        String urlrequest =url+ "technician/retrieve_request_for_expert.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlrequest,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

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

                            String facility = object.getString("directoret");
                            String technician = object.getString("technician");
                            String techname = object.getString("techname");
                            String techphone = object.getString("techphone");
                            String task_status1 = object.getString("task_status");
                            String assigned_time= object.getString("assigned_time");
                            String assigned_date = object.getString("assigned_date");
                            String requested_date = object.getString("requested_date");
                            String document_path = object.getString("document_path");
                            String fa_phone = object.getString("fa_phone");
                            String result = String.valueOf(task_status.getSelectedItem());
    if (directoret.equals(facility)) {
        if (result.equals(task_status1)) {
            requestmodal request = new requestmodal(id, wuid, name, buildingno, officeno, phone, quantity, checkboxrequests, priority, additionalmessage, impath, thing_to_fix
                    , facility, technician, techname, techphone, task_status1, assigned_time, assigned_date, requested_date, document_path,fa_phone);
            requestArrayList.add(request);
            listview.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }

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
                Toast.makeText(requests.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                String wuid = preferences.getString("wuidexpert", "");


                    params.put("wuid",wuid);










                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(requests.this);
        requestQueue.add(request);



    }
    public void retrieveclientData1(){
        String url= getResources().getString(R.string.url1);
        String urlrequest =url+ "technician/retrieve_request_for_expert.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlrequest,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

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

                            String facility = object.getString("directoret");
                            String technician = object.getString("technician");
                            String techname = object.getString("techname");
                            String techphone = object.getString("techphone");
                            String task_status1 = object.getString("task_status");
                            String assigned_time= object.getString("assigned_time");
                            String assigned_date = object.getString("assigned_date");
                            String requested_date = object.getString("requested_date");
                            String document_path = object.getString("document_path");

                            String   fa_phone = object.getString("fa_phone");

                                    requestmodal request = new requestmodal(id, wuid, name, buildingno, officeno, phone, quantity, checkboxrequests, priority, additionalmessage, impath, thing_to_fix
                                            , facility, technician, techname, techphone, task_status1, assigned_time, assigned_date, requested_date, document_path,fa_phone);
                                    requestArrayList.add(request);
                                    listview.setAdapter(adapter);
                                    adapter.notifyDataSetChanged();





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
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY0", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    }}

                else if (result.equals("Assigned")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("00", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY1", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}


                else if (result.equals("Completed")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY2", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

                else if (result.equals("Reassigned")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("0000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY3", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

                else if (result.equals("Rejected")) {
                    if(requestArrayList.isEmpty()) {

                        requestmodal request = new requestmodal("00000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"
                                , "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "", "EMPTY", "EMPTY", "EMPTY4", "EMPTY");
                        requestArrayList.add(request);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(requests.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                String wuid = preferences.getString("wuidexpert", "");


                params.put("wuid",wuid);










                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(requests.this);
        requestQueue.add(request);



    }


    public void retrieveclientData111(String dii, String wuid123){
        String url= getResources().getString(R.string.url1);
        String urlrequest =url+ "technician/retrieve_request_for_expert.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlrequest,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

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

                            String facility = object.getString("directoret");
                            String technician = object.getString("technician");
                            String techname = object.getString("techname");
                            String techphone = object.getString("techphone");
                            String task_status1 = object.getString("task_status");
                            String assigned_time= object.getString("assigned_time");
                            String assigned_date = object.getString("assigned_date");
                            String requested_date = object.getString("requested_date");
                            String document_path = object.getString("document_path");
                            String fa_phone = object.getString("document_path");


                            String g =wuid123.toLowerCase(Locale.ROOT);
                            String h= wuid.toLowerCase(Locale.ROOT);
                                if(h.contains(g)){
                           // String result = String.valueOf(task_status.getSelectedItem());
                            if (directoret.equals(facility)) {
                                if (dii.equals(task_status1)) {


                                    requestmodal request = new requestmodal(id, wuid, name, buildingno, officeno, phone, quantity, checkboxrequests, priority, additionalmessage, impath, thing_to_fix
                                            , facility, technician, techname, techphone, task_status1, assigned_time, assigned_date, requested_date, document_path,fa_phone);
                                    requestArrayList.add(request);
                                    listview.setAdapter(adapter);
                                    adapter.notifyDataSetChanged();
                                }
                            }
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
                Toast.makeText(requests.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                String wuid = preferences.getString("wuidexpert", "");


                params.put("wuid",wuid);










                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(requests.this);
        requestQueue.add(request);



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
        String name = preferences.getString("Name", "");
        String name1 = preferences.getString("wuid", "");

        if (name.equalsIgnoreCase("mchead"))

        {
            Intent myIntent = new Intent(requests.this, requests.class);

          requests.this.startActivity(myIntent);

        }



        finish();
    }





    public void userinfo(){

        String url= getResources().getString(R.string.url);
        String urlclient = url+"technician/technician_data_retrive.php";

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
                          //  job_title = object.getString("job_title");
                            status = object.getString("workstatus");
                        //    String result1 = String.valueOf(task_status.getSelectedItem());
                      //      retrieveclientData(directoret);
                            ImageView image = (ImageView) findViewById(R.id.menu_image2);
                            TextView tv =findViewById(R.id.navfname);
                            tv.setText(fname);
                            Picasso.with(requests.this).load(impath).into(image);
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
                Toast.makeText(requests.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(requests.this);
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