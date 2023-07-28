package com.example.wmrts.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wmrts.Logout;
import com.example.wmrts.R;

import com.example.wmrts.Admin.request_sender.MyAdapter;
import com.example.wmrts.Admin.request_sender.client;
import com.example.wmrts.Admin.technician.expertsearch;
import com.example.wmrts.Admin.Admin.MyAdapter2;
import com.example.wmrts.Admin.Admin.headsearch;
import com.example.wmrts.Admin.subadmin.MyAdapter1;
import com.example.wmrts.Admin.subadmin.adminsearch;
import com.example.wmrts.about;
import com.example.wmrts.contactus;
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
import java.util.Timer;
import java.util.TimerTask;

public class activate_deactivate extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    ListView listView;
    MyAdapter adapter;
    MyAdapter1 adapter2;
    MyAdapter2 adapter3;
    Spinner sp;
    com.example.wmrts.maintenance_manager.technician.MyAdapter3 adapter4;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public static ArrayList<com.example.wmrts.Admin.request_sender.client> clientArrayList = new ArrayList<>();
    public static ArrayList<adminsearch> adminArrayList = new ArrayList<>();
    public static ArrayList<headsearch> headArrayList = new ArrayList<>();
    public static ArrayList<expertsearch> expertArrayList = new ArrayList<>();
    //public static ArrayList<head> headArrayList = new ArrayList<>();
    //public static ArrayList<expert> expertArrayList = new ArrayList<>();

    Button search ;
   // String mess = getResources().getString(R.string.url);
   Context context;
  //  String url= context.getString(R.string.app_name);
   ///String url= Resources.getSystem().getString(R.string.url1);

    //Context mcontext=getApplicationContext();




    adminsearch admin;
    headsearch hd;
    expertsearch es;

    com.example.wmrts.Admin.request_sender.client client;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate_deactivate);

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

        navigationView.setNavigationItemSelectedListener(activate_deactivate.this);



        userinfo();


        //retrieveclientData();





        Spinner spinner3 = findViewById(R.id.status);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.status, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner3.setAdapter(adapter5);

     sp= (Spinner) findViewById(R.id.status);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection here
                String result = String.valueOf(sp.getSelectedItem());


                        retrieveclientData(result);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });





        adapter = new MyAdapter(this, clientArrayList);
        adapter2 = new MyAdapter1(this , adminArrayList);
        adapter3 = new MyAdapter2(this , headArrayList);
        adapter4 = new com.example.wmrts.maintenance_manager.technician.MyAdapter3(this , expertArrayList);


        listView = findViewById(R.id.myListView);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"View Data"};
                builder.setTitle(clientArrayList.get(position).getfname());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        switch (i){

                            case 0:

                               startActivity(new Intent(getApplicationContext(), DetailActivity.class)
                                          .putExtra("position",position));

                                break;

                            case 1:
                                //       startActivity(new Intent(getApplicationContext(),Edit_Activity.class)
                                //        .putExtra("position",position));


                                break;

                            case 2:

                                //    deleteData(clientArrayList.get(position).getId());
                                //     Intent myIntent = new Intent(MainActivity.this, MainActivity.class);

                                ///       startActivity(myIntent);

                                break;


                        }



                    }
                });


                builder.create().show();


            }

        });


        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {

                retrieveclientData12(activate_deactivate.this);

            }
        }, 0, 30000);


    }


    public void retrieveclientData(String task_status){


        String url= getResources().getString(R.string.url);
        String urlclient = url+"facility_manager/acdc.php";

        StringRequest request = new StringRequest(Request.Method.POST, urlclient,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            //    Toast.makeText(activate_deactivate.this, response, Toast.LENGTH_SHORT).show();
                clientArrayList.clear();
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){


                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String fname = object.getString("fname");
                            String lname = object.getString("lname");
                            String wuid= object.getString("wuid");
                            String mobilenum= object.getString("mobilenum");
                            String gender = object.getString("gender");
                            String status = object.getString("status");
                            String job_title = object.getString("job_title");

                            String impath = object.getString("imagepath");


                         String a =   task_status.toLowerCase(Locale.ROOT);
                            String b = status.toLowerCase(Locale.ROOT);


                            if(b.equals(a)){

                                    client = new client(id, fname, lname, wuid, mobilenum, gender, job_title, status, impath);
                                    clientArrayList.add(client);
                                    listView.setAdapter(adapter);
                                    adapter.notifyDataSetChanged();
                                }

                        }

                    }

                }
                catch (JSONException e){
                    e.printStackTrace();
                }



                String result = String.valueOf(sp.getSelectedItem());

                if (result.equals("Status")) {
                    if(clientArrayList.isEmpty()){

                        client = new client("0", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        clientArrayList.add(client);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    }}

                else if (result.equals("Allowed")) {
                    if(clientArrayList.isEmpty()) {

                        client = new client("00", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        clientArrayList.add(client);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

                else if (result.equals("Not Allowed")) {
                    if(clientArrayList.isEmpty()) {

                        client = new client("000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        clientArrayList.add(client);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             //   Toast.makeText(activate_deactivate.this, error.getMessage(), Toast.LENGTH_SHORT).show();
    //            progressDialog.dismiss();
            }
        }

        );


        RequestQueue requestQueue = Volley.newRequestQueue(activate_deactivate.this);
        requestQueue.add(request);




    }

    public void retrieveclientData133(String task_status, String wdu123){


        String url= getResources().getString(R.string.url);
        String urlclient = url+"facility_manager/acdc.php";

        StringRequest request = new StringRequest(Request.Method.POST, urlclient,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //    Toast.makeText(activate_deactivate.this, response, Toast.LENGTH_SHORT).show();
                clientArrayList.clear();
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){


                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String fname = object.getString("fname");
                            String lname = object.getString("lname");
                            String wuid= object.getString("wuid");
                            String mobilenum= object.getString("mobilenum");
                            String gender = object.getString("gender");
                            String status = object.getString("status");
                            String job_title = object.getString("job_title");

                            String impath = object.getString("imagepath");

                   String c =wuid.toLowerCase(Locale.ROOT);
                   String d = wdu123.toLowerCase(Locale.ROOT);
                            String a =   task_status.toLowerCase(Locale.ROOT);
                            String b = status.toLowerCase(Locale.ROOT);


                            if(b.equals(a)){
                                if(c.contains(d)){
                                client = new client(id, fname, lname, wuid, mobilenum, gender, job_title, status, impath);
                                clientArrayList.add(client);
                                listView.setAdapter(adapter);
                                adapter.notifyDataSetChanged();
                            }}

                        }

                    }

                }
                catch (JSONException e){
                    e.printStackTrace();
                }



                String result = String.valueOf(sp.getSelectedItem());

                if (result.equals("Status")) {
                    if(clientArrayList.isEmpty()){

                        client = new client("0", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        clientArrayList.add(client);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    }}

                else if (result.equals("Allowed")) {
                    if(clientArrayList.isEmpty()) {

                        client = new client("00", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        clientArrayList.add(client);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

                else if (result.equals("Not Allowed")) {
                    if(clientArrayList.isEmpty()) {

                        client = new client("000", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                        clientArrayList.add(client);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //   Toast.makeText(activate_deactivate.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                //            progressDialog.dismiss();
            }
        }

        );


        RequestQueue requestQueue = Volley.newRequestQueue(activate_deactivate.this);
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
                            Picasso.with(activate_deactivate.this).load(impath).into(image);
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
        RequestQueue requestQueue = Volley.newRequestQueue(activate_deactivate.this);
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
                    .setContentText( "You have new login request from user")

                    .setContentTitle( "Login request ")
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

    public void retrieveclientData12(Context c){

        String url= getResources().getString(R.string.url1);
        String urlrequest = url+"admin/retrieve_request1.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlrequest,new Response.Listener<String>() {

            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onResponse(String response) {
                try{

                    SharedPreferences preferences1 = null;
                    SharedPreferences.Editor   editor;

                    JSONObject jsonObject = new JSONObject(response);

                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    preferences1 =getSharedPreferences("abcd", Context.MODE_PRIVATE);
                    //  Toast.makeText(choose_maintenance_manager.this, response , Toast.LENGTH_SHORT).show();
                    editor = preferences1.edit();
                    if(sucess.equals("1")){
                        String requestid;

                        int ab =  jsonArray.length()-1;
                        JSONObject object = jsonArray.getJSONObject(ab);

                        String id = object.getString("id");
                        int a = Integer.parseInt(id);

                        requestid = preferences1.getString("userid", "");


                        if(requestid.equals("")){

                            requestid = "0";
                            editor.putString("userid","0");
                        }
                        int reid = Integer.parseInt(requestid);
                        if (a>reid){

                            createNotificationChannel1(c);

                        }


                        editor.putString("userid",id);
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
                String result = String.valueOf(sp.getSelectedItem());
                userinfo();
           retrieveclientData133(result,query);

                return false;
            }

            // This method is overridden to filter the adapter according
            // to a search query when the user is typing search
            @Override
            public boolean onQueryTextChange(String newText) {


                String result = String.valueOf(sp.getSelectedItem());
                userinfo();
                retrieveclientData133(result,newText);

                        return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        else if (id == R.id.about) {
            startActivity(new Intent(getApplicationContext(), about.class));

        }
        else if (id == R.id.contactus) {
            startActivity(new Intent(getApplicationContext(), contactus.class));

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

        }

        return super.onOptionsItemSelected(item);
    }







}
