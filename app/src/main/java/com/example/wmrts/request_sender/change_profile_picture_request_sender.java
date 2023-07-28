package com.example.wmrts.request_sender;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import com.example.wmrts.MainActivity;
import com.example.wmrts.R;
import com.example.wmrts.about;
import com.example.wmrts.contactus;
import com.example.wmrts.register;
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

import javax.net.ssl.HttpsURLConnection;

public class change_profile_picture_request_sender extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Button UploadImageOnServerButton;
    ImageView GetImageFromGalleryButton1;
    String id; String fname;String lname;public String wuid123;    String mobilenum;     String gender; String job_title;String status;    String impath  ;
    Spinner task_status;
    TextView check1;
TextView check2;
    Bitmap FixBitmap;
    Bitmap FixBitmap1;

    String ImageTag = "image_tag" ;

    String ImageName = "image_data" ;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    ProgressDialog progressDialog ;

    ByteArrayOutputStream byteArrayOutputStream ;
    ByteArrayOutputStream byteArrayOutputStream1 ;
    byte[] byteArray ;
    byte[] byteArray1 ;
    String ConvertImage ;
    String ConvertImage1 ;
    String GetImageNameFromEditText;

    static HttpURLConnection httpURLConnection ;

    static URL url;

    static OutputStream outputStream;

    static BufferedWriter bufferedWriter ;

    static int RC ;

    static BufferedReader bufferedReader ;

    static StringBuilder stringBuilder;

    static boolean check = true;

    private int GALLERY = 1, GALLERY1 = 2, CAMERA = 3, CAMERA1 = 4;

    TextView back ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile_picture_request_sender);
userinfo();


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.trace);







        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);


        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(change_profile_picture_request_sender.this);


        check1=findViewById(R.id.check);

        check1.setText("n");







        GetImageFromGalleryButton1 = findViewById(R.id.pp);
        UploadImageOnServerButton = (Button)findViewById(R.id.signup);



        byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream1 = new ByteArrayOutputStream();


        GetImageFromGalleryButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showPictureDialog1();


            }
        });






        UploadImageOnServerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //   EditText    oldpass= findViewById(R.id.old_password);





                    check1 = findViewById(R.id.check);
                    check2 = findViewById(R.id.pic);
                    String ch = check2.getText().toString();

                    if (ch.equals("n")) {

                        Toast.makeText(change_profile_picture_request_sender.this, "Insert image", Toast.LENGTH_LONG).show();
                    } else {


                            UploadImageToServer();
                            Intent myIntent = new Intent(change_profile_picture_request_sender.this, MainActivity.class);

                            change_profile_picture_request_sender.this.startActivity(myIntent);



                    }
                }







        });

        if (ContextCompat.checkSelfPermission(change_profile_picture_request_sender.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
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

    private void showPictureDialog1(){
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
                                choosePhotoFromGallary1();
                                break;
                            case 1:
                                takePhotoFromCamera1();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }
    public void choosePhotoFromGallary1() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY1);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }
    private void takePhotoFromCamera1() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode,data );
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }


        if (requestCode == GALLERY) {
            if (data != null) {




                Uri contentURI = data.getData();
                try {

                    check1 =findViewById(R.id.check);


                    if(check1.getText().toString().equals("n")) {
                        FixBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                        ImageView ii =findViewById(R.id.imgid);
                        ii.setImageBitmap(FixBitmap);
                    }
                    // String path = saveImage(bitmap);
                    //Toast.makeText(MainActivity.this, "Image Saved!", Toast.LENGTH_SHORT).show();
                    //    ShowSelectedImage.setImageBitmap(FixBitmap);
                    UploadImageOnServerButton.setVisibility(View.VISIBLE);

                    check1.setText(FixBitmap.toString());

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(change_profile_picture_request_sender.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        }
        else if (requestCode == GALLERY1) {

            if (data != null) {




                Uri contentURI = data.getData();
                try {



                    check2 =findViewById(R.id.pic);

                    if(check2.getText().toString().equals("n")) {


                        FixBitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);

                        ImageView image = (ImageView) findViewById(R.id.pp);
                        image.setImageBitmap(FixBitmap1);






                    }

                    // String path = saveImage(bitmap);
                    //Toast.makeText(MainActivity.this, "Image Saved!", Toast.LENGTH_SHORT).show();
                    //    ShowSelectedImage.setImageBitmap(FixBitmap);
                    UploadImageOnServerButton.setVisibility(View.VISIBLE);

                    check2.setText(FixBitmap1.toString());


                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(change_profile_picture_request_sender.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        }   else if (requestCode == CAMERA) {

            if (data != null) {




                Uri contentURI = data.getData();


                check2 =findViewById(R.id.pic);

                if(check2.getText().toString().equals("n")) {

                    FixBitmap = (Bitmap) data.getExtras().get("data");
                    //     FixBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                }

                // String path = saveImage(bitmap);
                //Toast.makeText(MainActivity.this, "Image Saved!", Toast.LENGTH_SHORT).show();
                //    ShowSelectedImage.setImageBitmap(FixBitmap);
                UploadImageOnServerButton.setVisibility(View.VISIBLE);

                check1.setText(FixBitmap.toString());


            }}
        else if (requestCode == CAMERA1) {

            if (data != null) {




                Uri contentURI = data.getData();


                check2 =findViewById(R.id.pic);

                if(check2.getText().toString().equals("n")) {

                    FixBitmap1 = (Bitmap) data.getExtras().get("data");
                    //     FixBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                }

                // String path = saveImage(bitmap);
                //Toast.makeText(MainActivity.this, "Image Saved!", Toast.LENGTH_SHORT).show();
                //    ShowSelectedImage.setImageBitmap(FixBitmap);
                UploadImageOnServerButton.setVisibility(View.VISIBLE);

                check1.setText(FixBitmap1.toString());


            }}













    }


    public void UploadImageToServer(){



        check1 =findViewById(R.id.check);

        check2 =findViewById(R.id.pic);

        if(check1.getText().toString().trim()!="n") {
            FixBitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
        }
        if(check2.getText().toString().trim()!="n") {
            FixBitmap1.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream1);

        }

        if(check1.getText().toString().trim().equals("n")) {
            //  FixBitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
        }
        if(check2.getText().toString().trim().equals("n")) {
            //     FixBitmap1.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);

        }















        byteArray = byteArrayOutputStream.toByteArray();
        byteArray1 = byteArrayOutputStream1.toByteArray();
        ConvertImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
        ConvertImage1 = Base64.encodeToString(byteArray1, Base64.DEFAULT);

        class AsyncTaskUploadClass extends AsyncTask<Void,Void,String> {

            @Override
            protected void onPreExecute() {

                super.onPreExecute();

                progressDialog = ProgressDialog.show(change_profile_picture_request_sender.this,"Image is Uploading","Please Wait",false,false);
            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);

                progressDialog.dismiss();

                Toast.makeText(change_profile_picture_request_sender.this,string1,Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(Void... params) {


                String randonString = RandomStringUtils.randomAlphanumeric(16);
                String randonString1 = RandomStringUtils.randomAlphanumeric(16);
                register.ImageProcessClass imageProcessClass = new register.ImageProcessClass();

                HashMap<String,String> HashMapParams = new HashMap<String,String>();
                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

                String fname = preferences.getString("wuid", "");
                HashMapParams.put("wuid", fname);
                HashMapParams.put(ImageTag, randonString);
                HashMapParams.put("image_tag1", randonString1);
                HashMapParams.put(ImageName, ConvertImage);
                HashMapParams.put(ImageName, ConvertImage);
                HashMapParams.put("image_data1", ConvertImage1);
                String url= getResources().getString(R.string.url1);
                String FinalData = imageProcessClass.ImageHttpRequest(url+"request_sender/change_profile_picture.php", HashMapParams);

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


    public static class ImageProcessClass{

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

                Toast.makeText(change_profile_picture_request_sender.this, "Unable to use Camera..Please Allow us to use Camera", Toast.LENGTH_LONG).show();

            }
        }
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
                            Picasso.with(change_profile_picture_request_sender.this).load(impath).into(image);

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
                Toast.makeText(change_profile_picture_request_sender.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(change_profile_picture_request_sender.this);
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


}