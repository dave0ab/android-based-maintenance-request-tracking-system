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
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
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
import com.example.wmrts.dormitory_maintenances.dormitory_maintenance_request;
import com.google.android.material.navigation.NavigationView;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class generate_report extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    Uri path;
    String documentPath;
    reportadapter adapter;
    TextView textView;
    String currentDateTime;
    String startDate="", startDate12="";
    String path1;
    String id; String fname;String lname;String wuid;   String document_path ;String mobilenum;     String gender; String job_title;String status;    String impath  ;
    private Button btnDownload,request;
    private String filepath = "http://192.168.43.228:80//wumrts/table.docx";
    private URL url = null;
    public ProgressDialog progressDialog;
    private String fileName;
    //Declaring views
    private Button buttonChoose;
    private Button buttonUpload;
    public static ArrayList<reportmodal> reportArrayList = new ArrayList<>();
    private EditText editText;

    public static final String UPLOAD_URL = "http://192.168.207.78:8021//auction/pdf.php";
    //Pdf request code
    private int PICK_PDF_REQUEST = 1;

    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;


    //Uri to store the image uri
    private Uri filePath;




    TextView tvid,tvname,tvwuid,tvbuilding,tvoffice, techphone,priority,additional,messagedetails,quantity,tvdevice,department,imageview;
    int position;
    ImageView image;
    Button activate,deactivate,viewdocumnet,seen;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_report);
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
        navigationView.setNavigationItemSelectedListener(generate_report.this);
userinfo();








textView=findViewById(R.id.date_range_text_view);
Button select =findViewById(R.id.select_date_button);
select.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        selectDate();
    }
});

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button select1 =findViewById(R.id.select_date_button1);
        select1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate12();
            }
        });


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button geneerate =findViewById(R.id.generatereport);
        geneerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(startDate.equals("")||startDate12.equals("")){
    Toast.makeText(generate_report.this,"please insert date", Toast.LENGTH_SHORT).show();

}

else {
    generateReport(startDate, startDate12);
}
            }
        });

    }



    private void selectDate() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Update the date range TextView with the selected date range
                Calendar startCalendar = Calendar.getInstance();
                startCalendar.set(year, month, dayOfMonth);
                Calendar endCalendar = Calendar.getInstance();
                endCalendar.set(year, month, dayOfMonth + 6);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                startDate = dateFormat.format(startCalendar.getTime());
                String endDate = dateFormat.format(endCalendar.getTime());
                String dateRange = "Date Range: " + startDate + " to " + endDate;
                TextView dateRangeTextView = findViewById(R.id.date_range_text_view);
                dateRangeTextView.setText(dateRange);

                // Generate the report for the selected date range

            }
        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void selectDate12() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Update the date range TextView with the selected date range
                Calendar startCalendar = Calendar.getInstance();
                startCalendar.set(year, month, dayOfMonth);
                Calendar endCalendar = Calendar.getInstance();
                endCalendar.set(year, month, dayOfMonth + 6);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                startDate12 = dateFormat.format(startCalendar.getTime());
                String endDate = dateFormat.format(endCalendar.getTime());
                String dateRange = "Date Range: " + startDate + " to " + endDate;
                TextView dateRangeTextView = findViewById(R.id.date_range_text_view);
                dateRangeTextView.setText(dateRange);

                // Generate the report for the selected date range

            }
        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }




    private void generateReport(String startDate, String endDate) {
        // Generate the report URL

        String url1= getResources().getString(R.string.url);

        String url = "http://192.168.43.228:80/wumrts/facility_manager/generate_report.php?start_date=" + startDate + "&end_date=" + endDate;

        // Make a HTTP request to the PHP script
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Show the report data in a TextView or WebView

               String a = response.toLowerCase(Locale.ROOT);

                if("1".equalsIgnoreCase(a))
                {
                    Toast.makeText(generate_report.this, "No data found", Toast.LENGTH_SHORT).show();

                }else {
                    generatePdf(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        // Add the request to the request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    private void generatePdf(String editTextData ) {
        // Get the text from the EditText


        // Create a new document
        Document document = new Document();

        try {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1; // Note: January is 0
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);

            currentDateTime =String.valueOf(year + month +day+ hour  + minute + second) ;

            // Create a file output stream for the PDF file
            File file = new File(Environment.getExternalStorageDirectory() + "/" + "Download/"+currentDateTime+".pdf");
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            // Create a PDF writer
            PdfWriter.getInstance(document, fileOutputStream);

            // Open the document
            document.open();

            // Add the text from the EditText to the document
            document.add(new Paragraph(editTextData));

            // Close the document
            document.close();

            // Show a message indicating the PDF file was generated successfully
            Toast.makeText(this, "PDF file generated successfully", Toast.LENGTH_SHORT).show();
            btnView();
        } catch (Exception e) {
            e.printStackTrace();
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
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.home) {

            startActivity(new Intent(getApplicationContext(),facilitymanagerchoose.class));
        }
        if (id == R.id.generate) {

            startActivity(new Intent(getApplicationContext(),generate_report.class));
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
        String urlclient = url+"facility_manager/FM_data_retrive.php";

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
                            Picasso.with(generate_report.this).load(impath).into(image);
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
                Toast.makeText(generate_report.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(generate_report.this);
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

    public void retrieveclientData11(Context c){

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
                        int a = 0;
                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);

                            id = object.getString("id");
                            a = Integer.parseInt(id);
                        }
                        editor = preferences1.edit();
                        preferences1 =getSharedPreferences("abcd", Context.MODE_PRIVATE);
                        String requestid = preferences1.getString("requestid", "");

                        if(requestid.equals("")){
                            requestid = "0";

                            editor.putString("requestid","0");
                        }
                        int reid = Integer.parseInt(requestid);
                        if (a>reid){
                            createNotificationChannel1(c);
                        }
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


    public void  btnView() {



        File file = new File(Environment.getExternalStorageDirectory() + "/" + "Download/"+currentDateTime+".pdf");
        Uri uri = FileProvider.getUriForFile(generate_report.this, "com.example.wumrts.provider", file);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(uri, "application/pdf");
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(i);

    }



}