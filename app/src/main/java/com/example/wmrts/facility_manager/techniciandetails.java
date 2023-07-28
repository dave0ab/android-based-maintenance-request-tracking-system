package com.example.wmrts.facility_manager;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
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
import com.example.wmrts.Admin.Admin.MyAdapter2;
import com.example.wmrts.Admin.Admin.headsearch;
import com.example.wmrts.Admin.request_sender.MyAdapter;
import com.example.wmrts.Admin.request_sender.client;
import com.example.wmrts.Admin.subadmin.MyAdapter1;
import com.example.wmrts.Admin.subadmin.adminsearch;

import com.example.wmrts.Admin.technician.expertsearch;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class techniciandetails extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    String id; String fname;String lname; String directoret;String wuid;    String mobilenum;     String gender; String job_title;String status;    String impath  ;




    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    ListView listView;
    MyAdapter adapter;
    MyAdapter1 adapter2;
    MyAdapter2 adapter3;
    com.example.wmrts.maintenance_manager.technician.MyAdapter3 adapter4;
   EditText time;
    SimpleDateFormat dateFormat;
    final Calendar myCalendar = Calendar.getInstance();
    public static ArrayList<expertsearch> expertArrayList = new ArrayList<>();
    //public static ArrayList<head> headArrayList = new ArrayList<>();
    //public static ArrayList<expert> expertArrayList = new ArrayList<>();

Button search ;

adminsearch admin;
headsearch hd;
expertsearch es;

    client client;
        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail_technician);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setIcon(R.drawable.trace);
            drawerLayout = findViewById(R.id.my_drawer_layout);
            actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

            userinfo11();
            // pass the Open and Close toggle for the drawer layout listener
            // to toggle the button
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();

            // to make the Navigation drawer icon always appear on the action bar
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(techniciandetails.this);









            userinfo();

            retrieveexpertData();













            time = (EditText) findViewById(R.id.BirthDate);
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, month);
                    myCalendar.set(Calendar.DAY_OF_MONTH, day);
                    updateLabel();
                }
            };

            time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    new DatePickerDialog(techniciandetails.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

                }
            });

Button assign =findViewById(R.id.assign);
assign.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        String dateString1 = "2022-05-23";
        String dateString2 = "2022-05-24";

        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date date = new Date();
       // String current = dateFormat.format(date);
        String tt = time.getText().toString();

        DateTimeFormatter formatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
        }
        LocalDate currentDate = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            currentDate = LocalDate.now();
        }
        String dateString = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            dateString = currentDate.format(formatter);
        }
        try {

            EditText ed = findViewById(R.id.BirthDate);
            String ed1 = ed.getText().toString();
            if (ed1.equals("")){
                Toast.makeText(techniciandetails.this, "ENTER DATE", Toast.LENGTH_SHORT).show();

            }
            else{
            Date date1 = dateFormat.parse(dateString);
            Date date2 = dateFormat.parse(tt);
                Date currentDate11 = new Date();



                long differenceInMillis = date2.getTime() - currentDate11.getTime();
                long differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInMillis);


                int result = date1.compareTo(date2);

            if (result > 0) {
                Toast.makeText(techniciandetails.this, "ENTER VALID DATE", Toast.LENGTH_SHORT).show();

            }
            else if(differenceInDays > 5){



                Toast.makeText(techniciandetails.this, "ENTER DATE LESS THAN 7 DAYS", Toast.LENGTH_SHORT).show();


            }




            else {
                    assign7();
                }



            }
        } catch (ParseException e) {
            // Handle the exception
        }












    }
});

            adapter4 = new com.example.wmrts.maintenance_manager.technician.MyAdapter3(this , expertArrayList);



            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {

                    retrieveclientData1(techniciandetails.this);

                }
            }, 0, 30000);




        }

    private void updateLabel() {
        time = (EditText) findViewById(R.id.BirthDate);
        String myFormat = "yy/MM/dd";
        dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        time.setText(dateFormat.format(myCalendar.getTime()));
    }
    public void retrieveexpertData(){
        String url = getResources().getString(R.string.url1);
        String urlexpert = url+"facility_manager/retrieve_technician.php";
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
                            String workstatus = object.getString("workingstatus");
                            String imagepath = object.getString("imagepath");
                            String role = "ll";

                            TextView fname1 =findViewById(R.id.fname);
                            fname1.setText("First Name: "+ fname);
                            TextView lname1 =findViewById(R.id.lname);lname1.setText("Last Name: "+ lname);
                            TextView wuid1 =findViewById(R.id.wuid);wuid1.setText("University Id: "+ wuid);
                            TextView phone1 =findViewById(R.id.phone);phone1.setText("Phone: "+ mobilenum);
                            TextView facility1 =findViewById(R.id.facility);facility1.setText("Facility: "+ facility);
                            TextView workstatus1 =findViewById(R.id.workstatus);workstatus1.setText("Work Status: "+ workstatus);
                            TextView role1 =findViewById(R.id.role);role1.setText("Role: "+ role);
                            ImageView image = (ImageView) findViewById(R.id.imageView);
                            Picasso.with(techniciandetails.this).load(imagepath).into(image);


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
                Toast.makeText(techniciandetails.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }}   ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

                Bundle bundle1 = getIntent().getExtras();
                String wu1 =bundle1.getString("wuid");
                String name =bundle1.getString("name");
                String phone =bundle1.getString("phone");

                params.put("wuid",wu1);




                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
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




    public void userinfo(){

        String url= getResources().getString(R.string.url);
        String urlexpert =  url+"admin/retrieve_technician.php";


        StringRequest request = new StringRequest(Request.Method.POST, urlexpert,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String id; String fname;String lname;String wuid;    String mobilenum;    String job_title;String status;    String impath  ;
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
                            Picasso.with(techniciandetails.this).load(impath).into(image);
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
                Toast.makeText(techniciandetails.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(techniciandetails.this);
        requestQueue.add(request);
    }






    public void assign7() {
        String url = getResources().getString(R.string.url1);


        final ProgressDialog progressDialog = new ProgressDialog(techniciandetails.this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, url +"facility_manager/assign_technician.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(techniciandetails.this, "Successfully assigned technician", Toast.LENGTH_SHORT).show();
                        Toast.makeText(techniciandetails.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(techniciandetails.this, listmaintenancerequest.class));
                        finish();
                        progressDialog.dismiss();
                        Intent myIntent = new Intent(techniciandetails.this, listmaintenancerequest.class);

                        techniciandetails.this.startActivity(myIntent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(techniciandetails.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                Intent intent = getIntent();
                int position = intent.getExtras().getInt("position");
                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

                String fname = preferences.getString("wuid", "");


                Bundle bundle1 = getIntent().getExtras();
                String wu1 =bundle1.getString("wuid");
                String name =bundle1.getString("name");
                String phone =bundle1.getString("phone");

                String rq =bundle1.getString("request_id");
                params.put("action", fname);
                params.put("id",rq);
                params.put("wuid", wu1);
                params.put("name", name);
                params.put("phone", phone);
                params.put("faphone", mobilenum);
                params.put("assdate", time.getText().toString());

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(techniciandetails.this);
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



    public void userinfo11(){

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

                            mobilenum = object.getString("phone");
                            impath = object.getString("imagepath");
                            directoret = object.getString("directoret");
                            ImageView image = (ImageView) findViewById(R.id.menu_image2);
                            TextView tv =findViewById(R.id.navfname);
                            tv.setText(fname);
                            Picasso.with(techniciandetails.this).load(impath).into(image);

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
                Toast.makeText(techniciandetails.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(techniciandetails.this);
        requestQueue.add(request);
    }



}
