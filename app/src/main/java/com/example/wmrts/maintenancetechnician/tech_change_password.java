package com.example.wmrts.maintenancetechnician;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
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
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class tech_change_password extends AppCompatActivity {
Button  btn;
    Button UploadImageOnServerButton;
    String id; String fname;String lname;String wuid;    String mobilenum;     String gender; String job_title;String status;    String impath  ;
    EditText oldpass;
    EditText newpass;
    EditText confirmpass;
    ImageView GetImageFromGalleryButton;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    EditText imageName;

    Bitmap FixBitmap;

    String ImageTag = "image_tag" ;

    String ImageName = "image_data" ;

    ProgressDialog progressDialog ;

    ByteArrayOutputStream byteArrayOutputStream ;

    byte[] byteArray ;

    String ConvertImage ;

    String GetImageNameFromEditText;

    HttpURLConnection httpURLConnection ;

    URL url;

    OutputStream outputStream;

    BufferedWriter bufferedWriter ;

    int RC ;

    BufferedReader bufferedReader ;

    StringBuilder stringBuilder;
    String G;
    boolean check = true;

    private int GALLERY = 1, CAMERA = 2;
    String randonString;
    TextView tvb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_change_password);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);


        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        userinfo();


        UploadImageOnServerButton = (Button) findViewById(R.id.change);



        UploadImageOnServerButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {


                oldpass= findViewById(R.id.old_password);
                newpass = findViewById(R.id.new_password);
                confirmpass = findViewById(R.id.confirm_password);

                if (oldpass.getText().toString().equals(newpass.getText().toString())){
                    Toast.makeText(tech_change_password.this, "Old password and new password must not be the same", Toast.LENGTH_SHORT).show();
                }


                else if (!confirmpass.getText().toString().equals(newpass.getText().toString())){
                    Toast.makeText(tech_change_password.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                }

else if(confirmpass.getText().toString().equals("") || newpass.getText().toString().equals("") || confirmpass.getText().toString().length()<=7 || newpass.getText().toString().length()<=7) {
        Toast.makeText(tech_change_password.this, "create strong password", Toast.LENGTH_SHORT).show();
    } else if(confirmpass.getText().toString().equals(newpass.getText().toString())) {
        insertData();
    }


            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

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
            int id = item.getItemId();

            if (id == R.id.logout) {
                startActivity(new Intent(getApplicationContext(), Logout.class));

            }
            if (id == R.id.about) {
                startActivity(new Intent(getApplicationContext(), about.class));

            }
            if (id == R.id.contactus) {
                startActivity(new Intent(getApplicationContext(), contactus.class));

            }
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


        return super.onOptionsItemSelected(item);
    }


    void insertData() {

        String url= getResources().getString(R.string.url1);
        String urlrequest =url+ "technician/change_password.php";
        oldpass.getText().toString();
        newpass.getText().toString();
        confirmpass.getText().toString();
        StringRequest request = new StringRequest(Request.Method.POST,  urlrequest,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(tech_change_password.this, response, Toast.LENGTH_SHORT).show();
                        if(response.equalsIgnoreCase("Password Changed")){
                            Toast.makeText(tech_change_password.this, "Password Changed", Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Toast.makeText(tech_change_password.this, response, Toast.LENGTH_SHORT).show();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(tech_change_password.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                params.put("wuid", wuid);
                params.put("oldpassword", oldpass.getText().toString());
                params.put("newpassword", newpass.getText().toString());





                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(tech_change_password.this);
        requestQueue.add(request);

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

                            ImageView image = (ImageView) findViewById(R.id.menu_image2);
                            TextView tv =findViewById(R.id.navfname);
                            tv.setText(fname);
                            Picasso.with(tech_change_password.this).load(impath).into(image);


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
                Toast.makeText(tech_change_password.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(tech_change_password.this);
        requestQueue.add(request);
    }





}