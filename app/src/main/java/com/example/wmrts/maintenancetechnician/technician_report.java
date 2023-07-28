package com.example.wmrts.maintenancetechnician;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

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
import com.example.wmrts.facility_manager.requestmodal;
import com.example.wmrts.request_sender.request_sender_report;
import com.example.wmrts.request_sender.request_sender_requests;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wmrts.R;
import com.example.wmrts.selectmaintenance;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class technician_report extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    ArrayList<requestmodal> requestArrayList = new ArrayList<>();
    Uri path;
    String id; String fname;String lname;String wuid;    String mobilenum;     String gender; String job_title;String status;    String impath  ;
    private Button btnDownload,request;
    private String filepath = "http://192.168.43.228:80//wumrts/request_sender/report_form.docx";
    private URL url = null;
    public ProgressDialog progressDialog;
    private String fileName;
    //Declaring views
    private Button buttonChoose;
    private Button buttonUpload;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private EditText editText;
    TextView tg;
    public static final String UPLOAD_URL = "http://192.168.207.78:8021//auction/pdf.php";
    //Pdf request code
    private int PICK_PDF_REQUEST = 1;

    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;


    //Uri to store the image uri
    private Uri filePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technician_report);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.trace);


        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        tg=findViewById(R.id.imgbox);
        tg.setText("n");
        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);


        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(technician_report.this);


        userinfo();
        btnDownload
                = findViewById(R.id.downloadpdf);
        request = findViewById(R.id.request);
        // btnView = findViewById(R.id.btnView);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        URL u = null;
                        try {
                            u = new URL("http://192.168.43.228:80//wumrts/request_sender/report_form.docx");
                            fileName = u.getPath();
                            fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
                            File file = new File(Environment.getExternalStorageDirectory() + "/" + "Download/"+  fileName);
                            if(file.exists()){
                                btnView();

                            }else{
                                url = new URL(filepath);
                                DownloadFiles();
                                fileName = u.getPath();
                                fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
                                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url + ""));
                                request.setTitle(fileName);
                                request.setMimeType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                                request.allowScanningByMediaScanner();
                                request.setAllowedOverMetered(true);
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                                dm.enqueue(request);
                                btnView();
                            }

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        buttonUpload = (Button) findViewById(R.id.uploaddoc);


        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tg.setText("set");
                Intent intent = new Intent();
                intent.setType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select WORD"), 1);

            }
        });


        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tg =findViewById(R.id.imgbox);
                String f=  tg.getText().toString();
                if(f.equalsIgnoreCase("n")){
                    Toast.makeText(technician_report.this, "Upload report document please", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent();
                intent.setType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select WORD"), 1);
                insertData();
                (new Upload1(technician_report.this, path)).execute();
            }}
        });

    }
    public void DownloadFiles(){

        try {

            URL u = new URL("http://192.168.43.228:80//wumrts/request_sender/report_form.docx");
            InputStream is = u.openStream();

            DataInputStream dis = new DataInputStream(is);
            byte[] buffer = new byte[1024];
            int length;
            fileName = u.getPath();
            fileName = fileName.substring(fileName.lastIndexOf('/') + 1);




            FileOutputStream fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory() + "/" + "Download/"+  fileName));

            while ((length = dis.read(buffer))>0) {
                fos.write(buffer, 0, length);
            }

        } catch (MalformedURLException mue) {
            Log.e("SYNC getUpdate", "malformed url error", mue);
        } catch (IOException ioe) {
            Log.e("SYNC getUpdate", "io error", ioe);
        } catch (SecurityException se) {
            Log.e("SYNC getUpdate", "security error", se);
        }
    }
    public void  btnView() {

        try {

            url = new URL(filepath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        fileName = url.getPath();
        fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
        //
        File file = new File(Environment.getExternalStorageDirectory() + "/" + "Download/"+  fileName);
        Uri uri = FileProvider.getUriForFile(technician_report.this, "com.example.wumrts.provider", file);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(uri, "application/msword");
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(i);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent result) {
        super.onActivityResult(requestCode, resultCode, result);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                path = result.getData();


            }
        }
    }
    void insertData() {

        EditText buildingno= findViewById(R.id.edbuildingno);
        EditText additionalmessage= findViewById(R.id.edmessage);
        EditText officenum= findViewById(R.id.edoffice);
        EditText quantitiy= findViewById(R.id.edquantity);
        Spinner spinner = findViewById(R.id.maintenance_type);


        StringRequest request = new StringRequest(Request.Method.POST,  "http://192.168.43.228:80/wumrts/technician/upload_report.php",

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(technician_report.this, response, Toast.LENGTH_SHORT).show();
                        if(response.equalsIgnoreCase("Data Inserted")){


                            Toast.makeText(technician_report.this, "Successfully Reported", Toast.LENGTH_SHORT).show();
                            Intent myIntent1 = new Intent(technician_report.this, choosetechician.class);
                                                      startActivity(myIntent1);
                        }
                        else{
                            Intent myIntent1 = new Intent(technician_report.this, choosetechician.class);
                            startActivity(myIntent1);
                            Toast.makeText(technician_report.this, response, Toast.LENGTH_LONG).show();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(technician_report.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                String wuid = preferences.getString("wuid", "");
                Bundle bundle1 = getIntent().getExtras();
                String id =bundle1.getString("id");
                String facility =bundle1.getString("facility");
                params.put("name",fname);
                params.put("request_id",id);
                params.put("tech_wuid",wuid);
                params.put("message",additionalmessage.getText().toString());
                params.put("facility", facility);


                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(technician_report.this);
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
                            //  job_title = object.getString("facility");
                            status = object.getString("workstatus");

                            ImageView image = (ImageView) findViewById(R.id.menu_image2);
                            TextView tv =findViewById(R.id.navfname);
                            tv.setText(fname);
                            Picasso.with(technician_report.this).load(impath).into(image);
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
                Toast.makeText(technician_report.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(technician_report.this);
        requestQueue.add(request);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {



        int id = item.getItemId();

        if (id == R.id.assigned_requests) {

            startActivity(new Intent(getApplicationContext(), requests.class));
        }


        if (id == R.id.home) {

            startActivity(new Intent(getApplicationContext(), choosetechician.class));
        }


        if (id == R.id.reported_requests) {

            startActivity(new Intent(getApplicationContext(), select_reported_requests1.class));
        }
        if (id == R.id.change_picture) {

            startActivity(new Intent(getApplicationContext(), change_profile_picture_technician.class));
        }
        if (id == R.id.change_password) {

            startActivity(new Intent(getApplicationContext(), tech_change_password.class));
        }
        if (id == R.id.report_finished) {

            startActivity(new Intent(getApplicationContext(), select_report_maintenance_requests.class));

        }
        if (id == R.id.logout) {

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
                    .setContentText( "New maintenance request assigned for you please contact the client")

                    .setContentTitle( "New maintenance")
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






    public void retrieveclientData16(Context c){

        String url= getResources().getString(R.string.url1);
        String urlrequest = url+"technician/retrieve_request1.php";
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
                        String    techname1 = object.getString("techname");
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



                        //   Toast.makeText(desktoprepair.this, String.valueOf(reid), Toast.LENGTH_SHORT).show();

                        if (a>reid) {

                            if (reid == a) {

                            } else {
                                if (techn1.equals("Not Assigned")) {

                                } else {

                                    createNotificationChannel1(c);

                                }
                            }

                        }
                        editor.putString("requestid", id);
                        editor.putString("techname", techname1);
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




}




class Upload1 extends AsyncTask<Void, Void, Void> {
    private ProgressDialog pd;
    private Context c;
    private Uri path;

    public Upload1(Context c, Uri path) {
        this.c = c;
        this.path = path;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = ProgressDialog.show(c, "Uploading", "Please Wait");
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        pd.dismiss();
    }

    @Override
    protected Void doInBackground(Void... params) {
        String url_path = "http://192.168.43.228:80/wumrts/technician/upload_report_document_file.php";
        HttpURLConnection conn = null;

        int maxBufferSize = 2048;
        try {
            URL url = new URL(url_path);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setChunkedStreamingMode(2048);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "undefined");

            OutputStream outputStream = conn.getOutputStream();
            InputStream inputStream = c.getContentResolver().openInputStream(path);

            int bytesAvailable = inputStream.available();
            int bufferSize = Math.min(bytesAvailable, maxBufferSize);
            byte[] buffer = new byte[bufferSize];

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer, 0, bufferSize)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                Log.i("result", line);
            }




            reader.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }


    public void UploadImageToServer(){




        class AsyncTaskUploadClass extends AsyncTask<Void,Void,String> {

            @Override
            protected void onPreExecute() {

                super.onPreExecute();


            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);



            }

            @Override
            protected String doInBackground(Void... params) {

                String url_path = "http://192.168.43.228:80/wumrts/request_sender/UploadToServer.php";
                HttpURLConnection conn = null;

                int maxBufferSize = 2048;
                try {
                    URL url = new URL(url_path);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setUseCaches(false);
                    conn.setDoInput(true);
                    conn.setChunkedStreamingMode(2048);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Connection", "Keep-Alive");
                    conn.setRequestProperty("Content-Type", "undefined");

                    OutputStream outputStream = conn.getOutputStream();
                    InputStream inputStream = c.getContentResolver().openInputStream(path);

                    int bytesAvailable = inputStream.available();
                    int bufferSize = Math.min(bytesAvailable, maxBufferSize);
                    byte[] buffer = new byte[bufferSize];

                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer, 0, bufferSize)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    outputStream.flush();
                    inputStream.close();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(
                            conn.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        Log.i("result", line);
                    }
                    reader.close();
                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    if (conn != null) {
                        conn.disconnect();
                    }
                }
                return null;
            }
        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();
        AsyncTaskUploadClassOBJ.execute();












    }



}






