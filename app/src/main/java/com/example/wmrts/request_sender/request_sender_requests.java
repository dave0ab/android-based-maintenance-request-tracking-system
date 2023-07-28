package com.example.wmrts.request_sender;

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
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
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
import com.example.wmrts.facility_manager.assigntechnician;
import com.example.wmrts.facility_manager.detailrequest1;
import com.example.wmrts.facility_manager.listmaintenancerequest;
import com.example.wmrts.facility_manager.requestadapter;
import com.example.wmrts.facility_manager.requestmodal;
import com.example.wmrts.Admin.Admin.MyAdapter2;
import com.example.wmrts.Admin.subadmin.MyAdapter1;

import com.example.wmrts.facility_manager.techniciandetails;
import com.example.wmrts.selectmaintenance;
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

public class request_sender_requests extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    String id; String fname;String lname;public String wuid123;    String mobilenum;     String gender; String job_title;String status;    String impath  ;
Spinner task_status;
    ListView listview;requestadapter adapter;  public static ArrayList<requestmodal> requestArrayList = new ArrayList<>();
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests1);


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

        navigationView.setNavigationItemSelectedListener(request_sender_requests.this);
task_status=findViewById(R.id.task_status);


      userinfo();
        String result = String.valueOf(task_status.getSelectedItem());
        retrieveclientData(result);

        task_status = findViewById(R.id.task_status);




        ArrayAdapter<CharSequence> adapter7=ArrayAdapter.createFromResource(this, R.array.task_status, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_item);
        task_status.setAdapter(adapter7);





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















        //retrieveclientData();

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);


        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button



        MyAdapter1 adapter2;
        MyAdapter2 adapter3;
        com.example.wmrts.maintenance_manager.technician.MyAdapter3 adapter4;

        Button search ;

        String urlclient1 = "http://192.168.43.228:80//wumrts/head/acdc1.php";





        adapter = new requestadapter(this, requestArrayList);
        listview = findViewById(R.id.listview);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(view.getContext());
                String result = String.valueOf(task_status.getSelectedItem());
if(result.equals("Not Assigned")) {
    CharSequence[] dialogItem = {"View Detail","Reject request"};
    builder.setTitle(requestArrayList.get(position).getWuid());
    builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int i) {

            switch (i) {

                case 0:

                    Intent myIntent1 = new Intent(getApplicationContext(), detailrequestrequest_sender.class);
                    myIntent1.putExtra("position", position);
                    myIntent1.putExtra("facility", requestArrayList.get(position).getfacility());
                    myIntent1.putExtra("id", requestArrayList.get(position).getId());
                    startActivity(myIntent1);

                    break;
                case 1:
                    assign7(position);

                    break;

            }
        }
    });
    builder.create().show();


}else {


    Intent myIntent1 = new Intent(getApplicationContext(), detailrequestrequest_sender.class);
    myIntent1.putExtra("position", position);
    myIntent1.putExtra("facility", requestArrayList.get(position).getfacility());
    myIntent1.putExtra("id", requestArrayList.get(position).getId());
    startActivity(myIntent1);
}
            }
        });




        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {

                retrieveclientData11(request_sender_requests.this);

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

    public void retrieveclientData(String g){

        String url= getResources().getString(R.string.url1);
        String urlrequest =url+ "request_sender/retrieve_request_for_request_sender.php";
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
                            String facility = object.getString("facility");
                            String technician = object.getString("technician");
                            String techname = object.getString("techname");
                            String techphone = object.getString("techphone");
                            String task_status1 = object.getString("task_status");
                            String assigned_time= object.getString("assigned_time");
                            String assigned_date = object.getString("assigned_date");
                            String requested_date = object.getString("requested_date");
                            String fa_phone = object.getString("fa_phone");
                            String oo =task_status1.toLowerCase(Locale.ROOT);
                            String we= g.toLowerCase(Locale.ROOT);
                            if(oo.equals(we))
                                if (we.equals(oo)) {

                                    String document_path = object.getString("document_path");
                                    requestmodal request = new requestmodal(id, wuid, name, buildingno, officeno, phone, quantity, checkboxrequests, priority, additionalmessage, impath, thing_to_fix
                                            , facility, technician, techname, techphone, task_status1, assigned_time, assigned_date, requested_date, document_path,fa_phone);
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
                Toast.makeText(request_sender_requests.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                String wuid = preferences.getString("wuid", "");
                    params.put("wuid",wuid);



                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(request_sender_requests.this);
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
            Intent myIntent = new Intent(request_sender_requests.this, request_sender_requests.class);

          request_sender_requests.this.startActivity(myIntent);

        }



        finish();
    }





    public void userinfo(){

        String url= getResources().getString(R.string.url);
        String urlclient = url+"request_sender/request_sender_data_retrive.php";

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
                            wuid123= object.getString("wuid");

                            gender = object.getString("phone");
                            impath = object.getString("imagepath");
                            job_title = object.getString("job_title");
                          //  status = object.getString("workstatus");

                            ImageView image = (ImageView) findViewById(R.id.menu_image2);
                            TextView tv =findViewById(R.id.navfname);
                            tv.setText(fname);
                            Picasso.with(request_sender_requests.this).load(impath).into(image);

                           // retrieveclientData(wuid123);



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
                Toast.makeText(request_sender_requests.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(request_sender_requests.this);
        requestQueue.add(request);
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





    public void assign7(int position) {
        String url = getResources().getString(R.string.url1);


        final ProgressDialog progressDialog = new ProgressDialog(request_sender_requests.this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, url +"request_sender/reject.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(request_sender_requests.this, "Rejected request", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        Intent myIntent = new Intent(request_sender_requests.this, choose_reqstsender.class);

                        request_sender_requests.this.startActivity(myIntent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(request_sender_requests.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                Intent intent = getIntent();

                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

                String fname = preferences.getString("wuid", "");

                params.put("action", fname);
                params.put("id",requestArrayList.get(position).getId());

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(request_sender_requests.this);
        requestQueue.add(request);


    }



}