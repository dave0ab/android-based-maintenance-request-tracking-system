package com.example.wmrts.ictmaintenances;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

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
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.example.wmrts.about;
import com.example.wmrts.contactus;
import com.example.wmrts.register;
import com.example.wmrts.request_sender.Rs_change_password;
import com.example.wmrts.request_sender.change_profile_picture_request_sender;
import com.example.wmrts.request_sender.choose_reqstsender;
import com.example.wmrts.request_sender.request_sender_completed_requests;
import com.example.wmrts.request_sender.request_sender_requests;
import com.example.wmrts.request_sender.statuscheck;
import com.example.wmrts.selectmaintenance;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.net.ssl.HttpsURLConnection;

public class network extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button GetImageFromGalleryButton, UploadImageOnServerButton;


    String id; String fname;String lname;String wuid;    String mobilenum;     String gender; String job_title;String status;    String impath  ;
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
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);


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

        navigationView.setNavigationItemSelectedListener(network.this);
        userinfo();




        tvb =findViewById(R.id.imgbox);
        tvb.setText("n");

        GetImageFromGalleryButton = (Button)findViewById(R.id.upload);

        UploadImageOnServerButton = (Button)findViewById(R.id.request);

        //    ShowSelectedImage = (ImageView)findViewById(R.id.imageView);



        byteArrayOutputStream = new ByteArrayOutputStream();

        GetImageFromGalleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showPictureDialog();


            }
        });


        UploadImageOnServerButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {



                    UploadImageToServer();
                Intent myIntent = new Intent(network.this, statuscheck.class);
                network.this.startActivity(myIntent);

            }
        });

        if (ContextCompat.checkSelfPermission(network.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.CAMERA},
                        5);
            }
        }


    }

    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Photo Gallery",
                "Camera" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }
    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    FixBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    // String path = saveImage(bitmap);
                    tvb =findViewById(R.id.imgbox);
                    tvb.setText(FixBitmap.toString());
                    ImageView ii =findViewById(R.id.imgid);
                    ii.setImageBitmap(FixBitmap);
                    //Toast.makeText(MainActivity.this, "Image Saved!", Toast.LENGTH_SHORT).show();
                    //    ShowSelectedImage.setImageBitmap(FixBitmap);
                    UploadImageOnServerButton.setVisibility(View.VISIBLE);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(network.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            FixBitmap = (Bitmap) data.getExtras().get("data");
            tvb =findViewById(R.id.imgbox);
            tvb.setText(FixBitmap.toString());
            ImageView ii =findViewById(R.id.imgid);
            ii.setImageBitmap(FixBitmap);
            // ShowSelectedImage.setImageBitmap(FixBitmap);

            UploadImageOnServerButton.setVisibility(View.VISIBLE);
            //  saveImage(thumbnail);
            //Toast.makeText(ShadiRegistrationPart5.this, "Image Saved!", Toast.LENGTH_SHORT).show();
        }
    }


    public void UploadImageToServer(){

        String a =tvb.getText().toString();


        if (a.equals("n")){

        } else {
            FixBitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            ImageView ii =findViewById(R.id.imgid);
            ii.setImageBitmap(FixBitmap);
        }

        byteArray = byteArrayOutputStream.toByteArray();

        ConvertImage = Base64.encodeToString(byteArray, Base64.DEFAULT);

        class AsyncTaskUploadClass extends AsyncTask<Void,Void,String> {

            @Override
            protected void onPreExecute() {

                super.onPreExecute();

                progressDialog = ProgressDialog.show(network.this,"Image is Uploading","Please Wait",false,false);
            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);

                progressDialog.dismiss();

                Toast.makeText(network.this,string1,Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(Void... params) {


                randonString = RandomStringUtils.randomAlphanumeric(16);
                network.ImageProcessClass imageProcessClass = new network.ImageProcessClass();

                HashMap<String,String> HashMapParams = new HashMap<String,String>();
                CheckBox checkboxpchardware1 , checkinstallpowergeez1,checkinstallantivirus1 ,checkinstallsoftware1 ,checkpcformat1, checkinstallmsoffice1 ;
                checkboxpchardware1=findViewById(R.id.check1);
                checkinstallpowergeez1=findViewById(R.id.check2);






                String c1="",c2 = "",c3="",c4="",c5="",c6="";
                if(checkboxpchardware1.isChecked()){c1=checkboxpchardware1.getText().toString();}
                if(checkinstallpowergeez1.isChecked()){c2=checkinstallpowergeez1.getText().toString();}



                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

                String wuid = preferences.getString("wuid", "");

                EditText buildingno = findViewById(R.id.edbuildingno);
                EditText offficeno = findViewById(R.id.edoffice);
                EditText pcmodel = findViewById(R.id.edpcmodel);
                EditText quantity = findViewById(R.id.edquantity);
                EditText additional = findViewById(R.id.edmessage);



                HashMapParams.put("wuid", wuid);
                HashMapParams.put("buildingno", buildingno.getText().toString());

                HashMapParams.put("officeno",offficeno .getText().toString());

                HashMapParams.put("pcmodel","");

                HashMapParams.put("quantity" ,"");
                HashMapParams.put("directoret", "Ict Directoret");
                HashMapParams.put("checkbox1" , c1);
                HashMapParams.put("checkbox2" , c2);
                HashMapParams.put("checkbox3" , c3);
                HashMapParams.put("checkbox4" , c4);
                HashMapParams.put("checkbox5" , c5);
                HashMapParams.put("checkbox6" , c6);




                HashMapParams.put("additionalmessage",additional.getText().toString());
                HashMapParams.put("phone" ,mobilenum);
                HashMapParams.put("device" ,"Network");

                HashMapParams.put(ImageTag, randonString);

                HashMapParams.put(ImageName, ConvertImage);

                HashMapParams.put(ImageName, ConvertImage);



                String FinalData = imageProcessClass.ImageHttpRequest("http://192.168.43.228:80/wumrts/request/request.php", HashMapParams);

                return FinalData;
            }
        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();
        AsyncTaskUploadClassOBJ.execute();
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


    public class ImageProcessClass{

        public String ImageHttpRequest(String requestURL,HashMap<String, String> PData) {

            StringBuilder stringBuilder = new StringBuilder();

            try {
                url = new URL(requestURL);

                httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setReadTimeout(20000);

                httpURLConnection.setConnectTimeout(20000);

                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoInput(true);

                httpURLConnection.setDoOutput(true);

                outputStream = httpURLConnection.getOutputStream();

                bufferedWriter = new BufferedWriter(

                        new OutputStreamWriter(outputStream, "UTF-8"));

                bufferedWriter.write(bufferedWriterDataFN(PData));

                bufferedWriter.flush();

                bufferedWriter.close();

                outputStream.close();

                RC = httpURLConnection.getResponseCode();

                if (RC == HttpsURLConnection.HTTP_OK) {

                    bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                    stringBuilder = new StringBuilder();

                    String RC2;

                    while ((RC2 = bufferedReader.readLine()) != null){

                        stringBuilder.append(RC2);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        private String bufferedWriterDataFN(HashMap<String, String> HashMapParams) throws UnsupportedEncodingException {

            stringBuilder = new StringBuilder();

            for (Map.Entry<String, String> KEY : HashMapParams.entrySet()) {
                if (check)
                    check = false;
                else
                    stringBuilder.append("&");

                stringBuilder.append(URLEncoder.encode(KEY.getKey(), "UTF-8"));

                stringBuilder.append("=");

                stringBuilder.append(URLEncoder.encode(KEY.getValue(), "UTF-8"));
            }

            return stringBuilder.toString();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 5) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Now user should be able to use camera

            }
            else {

                Toast.makeText(network.this, "Unable to use Camera..Please Allow us to use Camera", Toast.LENGTH_LONG).show();

            }
        }
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
                            wuid= object.getString("wuid");

                            mobilenum = object.getString("phone");
                            impath = object.getString("imagepath");
                            job_title = object.getString("job_title");
                            status = "";
                            ImageView image = (ImageView) findViewById(R.id.menu_image2);
                            TextView tv =findViewById(R.id.navfname);
                            tv.setText(fname);
                            Picasso.with(network.this).load(impath).into(image);


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
                Toast.makeText(network.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(network.this);
        requestQueue.add(request);
    }

}