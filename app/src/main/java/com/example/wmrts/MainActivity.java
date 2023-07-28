package com.example.wmrts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wmrts.Admin.choose_Admin;
import com.example.wmrts.request_sender.statuscheck;
import com.example.wmrts.maintenancetechnician.choosetechician;
import com.example.wmrts.facility_manager.facilitymanagerchoose;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button login;
    TextView signup,forgetpassword;
    EditText ed1 ,ed2,ed123 ;
    static String role = null;
    public String  ed11;
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.trace);








        preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
        String name = preferences.getString("Name", "");
        String name1 = preferences.getString("wuid", "");
        if (name.equalsIgnoreCase("admin"))

        {Intent myIntent = new Intent(MainActivity.this, choose_Admin.class);

            MainActivity.this.startActivity(myIntent);

        }else if (name.equalsIgnoreCase("mchead"))

        {
            Intent myIntent = new Intent(MainActivity.this, facilitymanagerchoose.class);

            MainActivity.this.startActivity(myIntent);

        }
        else if (name.equalsIgnoreCase("mcexpert"))

        {
            Intent myIntent = new Intent(MainActivity.this, choosetechician.class);





            myIntent.putExtra("wuid", name1);

            MainActivity.this.startActivity(myIntent);

        }
        else if (name.equalsIgnoreCase("client"))

        {

            Intent myIntent = new Intent(MainActivity.this, statuscheck.class);

            ed1 = findViewById(R.id.wuid);

            ed11= ed1.getText().toString();

            myIntent.putExtra("wuid", name1);

            MainActivity.this.startActivity(myIntent);


        }



        ed123 = findViewById(R.id.wuid);

        login = findViewById(R.id.login1);
       signup =findViewById(R.id.signup);
        forgetpassword =findViewById(R.id.forgotpassword);


        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, forget_password.class);
                MainActivity.this.startActivity(myIntent);

            }
        });








        signup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(MainActivity.this, register.class);


        MainActivity.this.startActivity(myIntent);
    }
});


       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               ed1 = findViewById(R.id.wuid);
               ed2 = findViewById(R.id.pass);
               String ed11 = ed1.getText().toString();
               String ed22 = ed2.getText().toString();
               if (ed11.equals("") ) {
                   ed1.setError("This field is required");
                   Toast.makeText(MainActivity.this, "Insert id", Toast.LENGTH_SHORT).show();

               } else if (ed22.equals("")) {
                   ed2.setError("This field is required");
                   Toast.makeText(MainActivity.this, "Insert password", Toast.LENGTH_SHORT).show();
               } else

               {
                   insertData();


               retrieveData();
           }


           }
       });
    }

    private void insertData() {



            StringRequest request = new StringRequest(Request.Method.POST,  "http://192.168.43.228:80//wumrts/login.php",

                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

String  g =response.toLowerCase(Locale.ROOT).trim();



                            String  y =response.toLowerCase(Locale.ROOT);

                            preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

                           editor = preferences.edit();


                            if(g.equals("maintenance_manager")){



                                editor.putString("Name","admin");
                                editor.apply();

                                Intent myIntent = new Intent(MainActivity.this, choose_Admin.class);
                                Toast.makeText(MainActivity.this, "Logged", Toast.LENGTH_SHORT).show();
                            MainActivity.this.startActivity(myIntent);
                            } else if(g.equals("mchead")){
                                editor.putString("Name","mchead");
                                editor.apply();
                                Intent myIntent = new Intent(MainActivity.this, facilitymanagerchoose.class);
                                Toast.makeText(MainActivity.this, "Logged", Toast.LENGTH_SHORT).show();
                                MainActivity.this.startActivity(myIntent);

                            }
                            else if(g.equals("mcexpert")){
                                ed1 = findViewById(R.id.wuid);

                                ed11= ed1.getText().toString();
                                editor.putString("Name","mcexpert");
                                editor.putString("wuidexpert",ed11);
                                editor.apply();

                                Intent myIntent = new Intent(MainActivity.this, choosetechician.class);
                                Toast.makeText(MainActivity.this, "Logged", Toast.LENGTH_SHORT).show();
                                myIntent.putExtra("wuid", ed11);
                                MainActivity.this.startActivity(myIntent);
                            }
                            else if(g.equals("client")){

                                editor.putString("Name","client");
                                editor.apply();
                                Intent myIntent = new Intent(MainActivity.this, statuscheck.class);
                                Toast.makeText(MainActivity.this, "Logged", Toast.LENGTH_SHORT).show();

                                String keyIdentifer  = null;
                                ed1 = findViewById(R.id.wuid);

                               ed11= ed1.getText().toString();

                                myIntent.putExtra("wuid", ed11);


                                editor.putString("wuid",ed11);
                                editor.apply();
                                retrieveData();

                                MainActivity.this.startActivity(myIntent);
                            }
                            else{

                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);



                                builder.setMessage(response);


                                AlertDialog alertDialog = builder.create();
                                builder.setNegativeButton("OK", (DialogInterface.OnClickListener) (dialog, which) -> {
                                    // If user click no then dialog box is canceled.
                                    dialog.cancel();
                                });
                                builder.show();
                                // Show the Alert Dialog box
                      //        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();

                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();


                    ed1 = findViewById(R.id.wuid);
                    ed2 = findViewById(R.id.pass);
                    String  ed11= ed1.getText().toString();
                    String  ed22= ed2.getText().toString();

                    params.put("wuid",ed11);
                    params.put("password",ed22);


                    preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

                    editor = preferences.edit();


                    editor.putString("wuid",ed11);
                    editor.apply();
                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            requestQueue.add(request);



        }




    public void retrieveData(){

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.43.228:80//wumrts/login.php",new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){


                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);
                            String name = object.getString("name");
                            preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                            editor = preferences.edit();
                            editor.putString("fullname",name);
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
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                //            progressDialog.dismiss();
            }
        }

        );


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);




    }







    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }





}