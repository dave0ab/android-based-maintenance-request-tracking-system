package com.example.wmrts.Admin;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
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
import com.example.wmrts.Admin.Admin.MyAdapter4;
import com.example.wmrts.Admin.Admin.backupmodal;
import com.example.wmrts.Admin.Admin.detail_of_backup;
import com.example.wmrts.Admin.Admin.headsearch;
import com.example.wmrts.Admin.request_sender.MyAdapter;
import com.example.wmrts.Admin.subadmin.MyAdapter1;
import com.example.wmrts.Admin.subadmin.adminsearch;
import com.example.wmrts.Admin.technician.expertsearch;
import com.example.wmrts.Logout;
import com.example.wmrts.R;
import com.example.wmrts.about;
import com.example.wmrts.contactus;
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

public class backup_restore extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    ListView listView;
    MyAdapter adapter;
    MyAdapter1 adapter2;
    MyAdapter4 adapter4;
    Spinner sp;

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public static ArrayList<com.example.wmrts.Admin.request_sender.client> clientArrayList = new ArrayList<>();
    public static ArrayList<adminsearch> adminArrayList = new ArrayList<>();
    public static ArrayList<headsearch> headArrayList = new ArrayList<>();
    public static ArrayList<backupmodal> backupmodalArrayList = new ArrayList<>();
    //public static ArrayList<head> headArrayList = new ArrayList<>();
    //public static ArrayList<expert> expertArrayList = new ArrayList<>();

    Button search,backup ;
   // String mess = getResources().getString(R.string.url);
   Context context;
  //  String url= context.getString(R.string.app_name);
   ///String url= Resources.getSystem().getString(R.string.url1);

    //Context mcontext=getApplicationContext();




    adminsearch admin;
    headsearch hd;
    expertsearch es;
    backupmodal ess;

    com.example.wmrts.Admin.request_sender.client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup_restore);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.trace);


        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        adapter4 = new MyAdapter4(backup_restore.this , backupmodalArrayList);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(backup_restore.this);



        userinfo();
        retrieveclientData22();

          backup=findViewById(R.id.backup_report);
        backup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(backup_restore.this);

                // Set the message show for the Alert time
                builder.setMessage("Do you want to backup the database ?");

                // Set Alert Title
                builder.setTitle("Are you sure");

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);

                // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // When the user click yes button then app will close

                    retrieveclientData();

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
        });



        listView = findViewById(R.id.myListView);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"View Data"};
                builder.setTitle(backupmodalArrayList.get(position).getbackupname());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        switch (i){

                            case 0:

                                Intent myIntent1 = new Intent(backup_restore.this, detail_of_backup.class);
                                myIntent1.putExtra("position", position);

                                myIntent1.putExtra("id", backupmodalArrayList.get(position).getId());
                                myIntent1.putExtra("path", backupmodalArrayList.get(position).getbackuppath());

                                startActivity(myIntent1);

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

                retrieveclientData12(backup_restore.this);

            }
        }, 0, 30000);


    }


    public void retrieveclientData(){


        String url= getResources().getString(R.string.url);
        String urlclient = url+"admin/backup_database.php";

        StringRequest request = new StringRequest(Request.Method.POST, urlclient,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                String a = response.toLowerCase(Locale.ROOT);
                if("succesfully backedup".equalsIgnoreCase(a)){
                    Toast.makeText(backup_restore.this, " You have successfully backed up the database ", Toast.LENGTH_SHORT).show();

                    Intent myIntent = new Intent(backup_restore.this, choose_Admin.class);
                    backup_restore.this.startActivity(myIntent);


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
            params.put("action",fname);
            return params;
        }
    };
    RequestQueue requestQueue = Volley.newRequestQueue(backup_restore.this);
        requestQueue.add(request);
}



    public void retrieveclientData22(){


        String url= getResources().getString(R.string.url);
        String urlclient = url+"admin/backup_retrive.php";

        StringRequest request = new StringRequest(Request.Method.POST, urlclient,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //    Toast.makeText(activate_deactivate.this, response, Toast.LENGTH_SHORT).show();
                backupmodalArrayList.clear();
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){


                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String fname = object.getString("backupname");
                            String lname = object.getString("backuppath");
                            String wuid= object.getString("datecreated");


                                ess = new backupmodal(id, fname, lname, wuid);
                            backupmodalArrayList.add(ess);
                                listView.setAdapter(adapter4);
                                adapter4.notifyDataSetChanged();


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
                //   Toast.makeText(activate_deactivate.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                //            progressDialog.dismiss();
            }
        }

        );


        RequestQueue requestQueue = Volley.newRequestQueue(backup_restore.this);
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
                            Picasso.with(backup_restore.this).load(impath).into(image);
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
        RequestQueue requestQueue = Volley.newRequestQueue(backup_restore.this);
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
