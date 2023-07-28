package com.example.wmrts.Admin.Admin;

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
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.wmrts.Admin.Activate_reject_user;
import com.example.wmrts.Admin.Admin_change_password;
import com.example.wmrts.Admin.activate_deactivate;
import com.example.wmrts.Admin.backup_restore;
import com.example.wmrts.Admin.choose_Admin;
import com.example.wmrts.Admin.createuseraccount;
import com.example.wmrts.Admin.list_log;
import com.example.wmrts.Admin.subadmin.MyAdapter1;
import com.example.wmrts.Admin.subadmin.adminsearch;
import com.example.wmrts.Logout;
import com.example.wmrts.R;
import com.example.wmrts.about;
import com.example.wmrts.contactus;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class detail_of_log extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    Uri path;
    Bundle bundle1;
    String path1;
    String id; String fname;String lname;String wuid;   String document_path ;String mobilenum;     String gender; String job_title;String status;    String impath  ;
    private Button btnDownload,request;
    private String filepath = "http://192.168.43.228:80//wumrts/table.docx";
    private URL url = null;
    public ProgressDialog progressDialog;
    private String fileName;
    //Declaring views
    private Button buttonChoose,restore;
    private Button buttonUpload;
TextView       tvfname,tvdata, tvemail,tvstatus ,tvdate;
    private EditText editText;

    public static final String UPLOAD_URL = "http://192.168.207.78:8021//auction/pdf.php";
    //Pdf request code
    private int PICK_PDF_REQUEST = 1;

    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;


    //Uri to store the image uri
    private Uri filePath;

    MyAdapter1 adapter2;
    adminsearch admin;
    public static ArrayList<adminsearch> adminArrayList = new ArrayList<>();


    TextView tvid,tvname,tvwuid,tvbuilding,tvoffice, techphone,priority,additional,messagedetails,quantity,tvdevice,department,imageview;
    int position;
    ImageView image;
    Button activate,deactivate,seen;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_of_log);
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
        navigationView.setNavigationItemSelectedListener(detail_of_log.this);


        userinfo();


        //Initializing Views
        tvid = findViewById(R.id.txt1);

        tvwuid= findViewById(R.id.wuid);
        tvdata = findViewById(R.id.logdata);
        tvdate = findViewById(R.id.logdate);


 // imageview = findViewById(R.id.imageView);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: "+ list_log.logArrayList.get(position).getId());
        tvwuid.setText("Wuid: "+list_log.logArrayList.get(position).getwuid());
        tvdata.setText("Log Data: "+list_log.logArrayList.get(position).getlogdata());
        tvdate.setText("Log Date: "+list_log.logArrayList.get(position).getlogdate());

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {

                retrieveclientData15(detail_of_log.this);

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
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.change_password) {

            startActivity(new Intent(getApplicationContext(),Admin_change_password.class));

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
                            Picasso.with(detail_of_log.this).load(impath).into(image);
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
                Toast.makeText(detail_of_log.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(detail_of_log.this);
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

    public void retrieveclientData15(Context c){

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
                    //  Toast.makeText(choose_Admin.this, response , Toast.LENGTH_SHORT).show();
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
                Toast.makeText(detail_of_log.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(detail_of_log.this);
        requestQueue.add(request);
    }






}