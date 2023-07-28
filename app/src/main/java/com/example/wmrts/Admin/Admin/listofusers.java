package com.example.wmrts.Admin.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
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
import com.example.wmrts.Logout;
import com.example.wmrts.R;
import com.example.wmrts.Admin.activate_deactivate;

import com.example.wmrts.Admin.Admin_change_password;
import com.example.wmrts.Admin.Activate_reject_user;
import com.example.wmrts.Admin.request_sender.MyAdapter;
import com.example.wmrts.Admin.request_sender.client;

import com.example.wmrts.Admin.technician.expertsearch;
import com.example.wmrts.Admin.subadmin.MyAdapter1;
import com.example.wmrts.Admin.subadmin.adminsearch;
import com.example.wmrts.facility_manager.detailreport2;
import com.example.wmrts.facility_manager.select_reported_requests;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class listofusers extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    ListView listView;
    MyAdapter adapter;
    MyAdapter1 adapter2;
    adminsearch admin;
    com.example.wmrts.maintenance_manager.technician.MyAdapter3 adapter4;

    public static ArrayList<adminsearch> adminArrayList = new ArrayList<>();

    //public static ArrayList<head> headArrayList = new ArrayList<>();
    //public static ArrayList<expert> expertArrayList = new ArrayList<>();







        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_listofusers);

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

            navigationView.setNavigationItemSelectedListener(listofusers.this);



            userinfo();
            retrieveheadData();







            adapter2 = new MyAdapter1(this , adminArrayList);

            listView = findViewById(R.id.myListView);




            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    ProgressDialog progressDialog = new ProgressDialog(view.getContext());



                            CharSequence[] dialogItem = {"View user"};


                            builder.setTitle(adminArrayList.get(position).getWuid());
                            builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    switch (i){
                                        case 0:
                               //

                                            Intent myIntent1 = new Intent(listofusers.this, detail_of_user.class);
                                            myIntent1.putExtra("position", position);

                                            myIntent1.putExtra("id", adminArrayList.get(position).getId());

                                            startActivity(myIntent1);


                                            break;}}});



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
                retrieveheadData1(query);


                return false;
            }

            // This method is overridden to filter the adapter according
            // to a search query when the user is typing search
            @Override
            public boolean onQueryTextChange(String newText) {

                retrieveheadData1(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logout) {
            startActivity(new Intent(getApplicationContext(), Logout.class));
            return true;
        }


        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.change_password) {

            startActivity(new Intent(getApplicationContext(),Admin_change_password.class));

        }

        else if (id == R.id.logout) {

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
            android.app.AlertDialog alertDialog = builder.create();
            // Show the Alert Dialog box
            alertDialog.show();
            return true;
        }

        else if (id == R.id.create_account){
            startActivity(new Intent(getApplicationContext(), com.example.wmrts.Admin.createuseraccount.class));

        }
        else if (id == R.id.log){
            startActivity(new Intent(getApplicationContext(), com.example.wmrts.Admin.list_log.class));

        }
        else if (id == R.id.backuprestore){
            startActivity(new Intent(getApplicationContext(), com.example.wmrts.Admin.backup_restore.class));

        }
        else if (id == R.id.home){
            startActivity(new Intent(getApplicationContext(), com.example.wmrts.Admin.choose_Admin.class));

        }
        else if (id == R.id.change_picture){
            startActivity(new Intent(getApplicationContext(), com.example.wmrts.Admin.change_profile_picture_admin.class));

        }
        else if (id == R.id.listofusers){
            startActivity(new Intent(getApplicationContext(), com.example.wmrts.Admin.Admin.listofusers.class));

        }
        else if (id == R.id.approve_login){
            startActivity(new Intent(getApplicationContext(),activate_deactivate.class));

        }
        else if (id == R.id.reject){
            startActivity(new Intent(getApplicationContext(), Activate_reject_user.class));

        }
        else if (id == R.id.report){

        }






        DrawerLayout drawer = findViewById(R.id.my_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return false;
    }




    public void retrieveheadData(){
        String url = getResources().getString(R.string.url1);
        String urlhead = url+"admin/retrieve_account.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlhead,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                adminArrayList.clear();
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){


                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String wuid = object.getString("wuid");
                            String role = object.getString("role");
                            String email= object.getString("email");
                            String status= object.getString("status");
                            String datecreated= object.getString("datecreated");

                            admin = new adminsearch(id,wuid,role,email,status,datecreated);
                            adminArrayList.add(admin);
                            listView.setAdapter(adapter2);
                            adapter2.notifyDataSetChanged();


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
                Toast.makeText(listofusers.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);




    }



    public void retrieveheadData1(String wuid123){
        String url = getResources().getString(R.string.url1);
        String urlhead = url+"admin/retrieve_account.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlhead,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                adminArrayList.clear();
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){


                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String wuid = object.getString("wuid");
                            String role = object.getString("role");
                            String email= object.getString("email");
                            String status= object.getString("status");
                            String datecreated= object.getString("datecreated");
                            String g =wuid123.toLowerCase(Locale.ROOT);
                            String h= wuid.toLowerCase(Locale.ROOT);
                            if(h.contains(g)) {
                                admin = new adminsearch(id, wuid, role, email, status, datecreated);
                                adminArrayList.add(admin);
                                listView.setAdapter(adapter2);
                                adapter2.notifyDataSetChanged();
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
                Toast.makeText(listofusers.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);




    }



    public void userinfo(){

        String url= getResources().getString(R.string.url);
        String urlclient = url+"admin/MM_data_retrive.php";

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
                            Picasso.with(listofusers.this).load(impath).into(image);
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
                //     Toast.makeText(activate_deactivate.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(listofusers.this);
        requestQueue.add(request);
    }


}
