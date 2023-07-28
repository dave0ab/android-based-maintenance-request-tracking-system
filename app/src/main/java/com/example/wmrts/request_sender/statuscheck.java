package com.example.wmrts.request_sender;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
import com.example.wmrts.about;
import com.example.wmrts.contactus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class statuscheck extends AppCompatActivity {
    public SharedPreferences preferences1;
    public SharedPreferences.Editor editor;

  public  String id;
    public     String fname;
    public   String lname;
    public   String wuid;
    public   String mobilenum;
    public  String gender;
    public  String job_title;
    public  String status;
    public   String impath  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statuscheck);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.trace);


        insertData();

    }


    void insertData() {

        retrieveclientData();
        String url = getResources().getString(R.string.url1);
        StringRequest request = new StringRequest(Request.Method.POST,  url+"request_sender/verify_approve.php",

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        String  g =response.toLowerCase(Locale.ROOT).trim();
                        if(g.equals("ok")){
                            // Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(statuscheck.this,choose_reqstsender.class);
                            SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                            String name1 = preferences.getString("wuid", "");


                            //Bundle bundle1 = getIntent().getExtras();
                            //String wu1 =bundle1.getString("wuid");
                            myIntent.putExtra("wuid", name1);
                           startActivity(myIntent);
                        }
                        else if(g.equals("failed")){
                            Toast.makeText(statuscheck.this, "Not approved yet", Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(statuscheck.this, unappproved.class);
                            Bundle bundle1 = getIntent().getExtras();
                            String wu1 =bundle1.getString("wuid");
                            myIntent.putExtra("wuid",  wu1);
                            startActivity(myIntent);
                        }
                        else {

                            Toast.makeText(statuscheck.this,  response, Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(statuscheck.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                Bundle bundle = getIntent().getExtras();

                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                String name1 = preferences.getString("wuid", "");
                if(name1!= null)
             {
               //  String wu =bundle.getString("wuid");
                    params.put("wuid",name1 );
             }










                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(statuscheck.this);
        requestQueue.add(request);



    }




    public void retrieveclientData(){

        preferences1 =getSharedPreferences("loginPrefs", Context.MODE_MULTI_PROCESS);

        editor = preferences1.edit();


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
                             wuid= object.getString("wuid");

                          gender = object.getString("phone");
                            impath = object.getString("imagepath");
            job_title = object.getString("job_title");
                          status = "";
                            editor.putString("fname",fname);
                            editor.putString("impath",impath);
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
                Toast.makeText(statuscheck.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                //            progressDialog.dismiss();
            }
        }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();


                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                String name = preferences.getString("Name", "");
                String name1 = preferences.getString("wuid", "");

            //    Bundle bundle1 = getIntent().getExtras();
              //  String wu1 =bundle1.getString("wuid");

                    params.put("wuid",name1);




                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(statuscheck.this);
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

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        insertData();
        finish();
    }
}