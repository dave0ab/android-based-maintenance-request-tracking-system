package com.example.wmrts.Admin;




import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
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
import com.example.wmrts.Admin.request_sender.MyAdapter;
import com.example.wmrts.Admin.request_sender.client;

import com.example.wmrts.Admin.technician.expertsearch;
import com.example.wmrts.Admin.Admin.MyAdapter2;
import com.example.wmrts.Admin.Admin.headsearch;
import com.example.wmrts.Admin.subadmin.MyAdapter1;
import com.example.wmrts.Admin.subadmin.adminsearch;
import com.example.wmrts.about;
import com.example.wmrts.contactus;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Activate_reject_user extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    ListView listView;
        MyAdapter adapter;
        MyAdapter1 adapter2;
        MyAdapter2 adapter3;
        com.example.wmrts.maintenance_manager.technician.MyAdapter3 adapter4;
        public static ArrayList<com.example.wmrts.Admin.request_sender.client> clientArrayList = new ArrayList<>();
        public static ArrayList<adminsearch> adminArrayList = new ArrayList<>();
        public static ArrayList<headsearch> headArrayList = new ArrayList<>();
        public static ArrayList<expertsearch> expertArrayList = new ArrayList<>();
        //public static ArrayList<head> headArrayList = new ArrayList<>();
        //public static ArrayList<expert> expertArrayList = new ArrayList<>();
EditText se ;
        Button search ;

   //     String urladmin = "http://192.168.43.228:80//wumrts/admin/retrieveadmin.php";
    //    String urlhead = "http://192.168.43.228:80//wumrts/admin/retrievehead.php";
    //    String urlexpert = "http://192.168.43.228:80//wumrts/admin/retrieveexpert.php";

        adminsearch admin;
        headsearch hd;
        expertsearch es;

        client client;
        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_deleteuser);

se = findViewById(R.id.username);
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

            navigationView.setNavigationItemSelectedListener(Activate_reject_user.this);



            userinfo();

            search = findViewById(R.id.delete);

            Spinner spinner = findViewById(R.id.userselect);

            ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.users2, android.R.layout.simple_spinner_item);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spinner.setAdapter(adapter1);


            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Spinner sp = (Spinner) findViewById(R.id.userselect);
                    String result = String.valueOf(sp.getSelectedItem());

                    String us = se.getText().toString();
                    switch (result) {
                        case "Admin":


                            retrieveadminData(us);

                            break;
                        case "Facility Manager":
                            retrieveheadData(us);
                            break;
                        case "Technician":
                            retrieveexpertData(us);
                            break;

                    }
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
                    String us = se.getText().toString();

                    CharSequence[] dialogItem = {"Activate user","Reject user"};
                    //   builder.setTitle(requestArrayList.get(position).getWuid());
                    builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {

                            switch (i) {

                                case 0:


                                    deleteData1(us);

                                    break;

                                case 1:

                                    deleteData(us);


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

                    retrieveclientData12(Activate_reject_user.this);

                }
            }, 0, 30000);

        }


    private void deleteData(final String id) {
      //  String url = getResources().getString(R.string.url1);
        String url = getResources().getString(R.string.url1);
        String urladmin = url+"admin/reject.php";
        StringRequest request = new StringRequest(Request.Method.POST, urladmin,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                      //   Toast.makeText(Activate_reject_user.this, response, Toast.LENGTH_SHORT).show();

                            Toast.makeText(Activate_reject_user.this, "User rejected Successfully", Toast.LENGTH_SHORT).show();




                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            //    Toast.makeText(Activate_reject_user.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();



                Spinner sp = (Spinner) findViewById(R.id.userselect);
                String result = String.valueOf(sp.getSelectedItem());

                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                String fname = preferences.getString("wuid", "");

                params.put("action",fname);

                params.put("usertype", result);
                params.put("id", id);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Activate_reject_user.this);
        requestQueue.add(request);


    }

    private void deleteData1(final String id) {
        String url = getResources().getString(R.string.url1);
        String urladmin = url+"admin/activate.php";
        StringRequest request = new StringRequest(Request.Method.POST, urladmin,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Activate_reject_user.this, response, Toast.LENGTH_SHORT).show();

                            Toast.makeText(Activate_reject_user.this, "User Activated Successfully", Toast.LENGTH_SHORT).show();



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Activate_reject_user.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                Spinner sp = (Spinner) findViewById(R.id.userselect);
                String result = String.valueOf(sp.getSelectedItem());


                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                String fname = preferences.getString("wuid", "");
                params.put("action",fname);


                params.put("usertype", result);
                params.put("id", id);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }



        public void retrieveadminData(String us){
            String url = getResources().getString(R.string.url1);
            String urladmin = url+"admin/retrieve_maintenance_manager.php";
            StringRequest request = new StringRequest(Request.Method.POST, urladmin,new Response.Listener<String>() {
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
                                String fname = object.getString("fname");
                                String lname = object.getString("lname");
                                String wuid= object.getString("wuid");
                                String phone= object.getString("phone");
                                String role="";

                                admin = new adminsearch(id,fname,lname,wuid,phone,role);
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
                    Toast.makeText(Activate_reject_user.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("wuid",us);

                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);




        }
        public void retrieveheadData(String us){
            String url = getResources().getString(R.string.url1);
            String urlhead = url+"admin/retrieve_facility_manager.php";
            StringRequest request = new StringRequest(Request.Method.POST, urlhead,new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    headArrayList.clear();
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

                                String loginstatus = "";
                                String role = "";
                                hd = new headsearch(id,fname,lname,wuid,mobilenum,loginstatus,role);
                                headArrayList.add(hd);
                                listView.setAdapter(adapter3);
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
                    Toast.makeText(Activate_reject_user.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("wuid",us);

                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);




        }
        public void retrieveexpertData(String us){
            String url = getResources().getString(R.string.url1);
            String urlexpert = url+"admin/retrieve_technician.php";
            StringRequest request = new StringRequest(Request.Method.POST, urlexpert,new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    expertArrayList.clear();
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
                                String facility = object.getString("facility");
                                String loginstatus = "";
                                String workstatus ="";
                                String role = "";




                                es = new expertsearch(id,fname,lname,wuid,mobilenum,facility,loginstatus,workstatus,role);
                                expertArrayList.add(es);
                                listView.setAdapter(adapter4);
                                adapter.notifyDataSetChanged();


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
                    Toast.makeText(Activate_reject_user.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            )
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("wuid",us);

                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);




        }
        public void retrieveclientData(){
            String url = getResources().getString(R.string.url1);
            String urlclient = url+"admin/retrieveclient.php";
            StringRequest request = new StringRequest(Request.Method.POST, urlclient,new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(Activate_reject_user.this, response, Toast.LENGTH_SHORT).show();
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

                                String job_title = object.getString("job_title");
                                String status = object.getString("status");
                                String impath = object.getString("imagepath");
                                client = new client(id,fname,lname,wuid,mobilenum,gender,job_title,status,impath);
                                clientArrayList.add(client);
                                listView.setAdapter(adapter);
                                adapter.notifyDataSetChanged();

                                clientArrayList.clear();
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
                    Toast.makeText(Activate_reject_user.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                            Picasso.with(Activate_reject_user.this).load(impath).into(image);
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
                Toast.makeText(Activate_reject_user.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(Activate_reject_user.this);
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
                Toast.makeText(c, error.getMessage(), Toast.LENGTH_SHORT).show();
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

        return true;
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
