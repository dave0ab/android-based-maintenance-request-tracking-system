package com.example.wmrts.maintenancetechnician;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wmrts.Logout;
import com.example.wmrts.R;
import com.example.wmrts.facility_manager.detailreport1;
import com.example.wmrts.facility_manager.listmaintenancerequest;
import com.example.wmrts.facility_manager.notreported;
import com.example.wmrts.facility_manager.select_reported_requests;
import com.example.wmrts.facility_manager.trackdetailrequest;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.security.KeyException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@RequiresApi(api = Build.VERSION_CODES.O)
public class qrscanner extends AppCompatActivity
{
    Bundle bundle1;
    String idd;
    public static String r1;
    public  static String sb;
    private String bd = null;
    Button btn_scan;
    EditText serial;
    public  static String g;
   String s;

    // private final String characterEncoding = "UTF-8";
    private final String cipherTransformation = "AES/CBC/PKCS5Padding";
    private final String aesEncryptionAlgorithm = "AES";
    private static final String FILE_NAME = "example.txt";
    // private static String Keyb ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        btn_scan =findViewById(R.id.scan);
        serial =findViewById(R.id.serial);
        btn_scan.setOnClickListener(v->
        {

            if(serial.getText().toString().equals("")) {

                Toast.makeText(qrscanner.this, "Please insert device serial number first", Toast.LENGTH_SHORT).show();

            }else{
                scanCode();
            }
        });




    }






    private void scanCode()
    {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);

        options.setOrientationLocked(true);
        options.      setBarcodeImageEnabled(true);
        barLaucher.launch(options);
    }

    ActivityResultLauncher<ScanOptions> barLaucher = registerForActivityResult(new ScanContract(), result->
    {
     String a= serial.getText().toString();
        r1 = result.getContents();

        retrieve00(a , r1);






    });





    public void retrieve00(String serial , String qrdata){
        String url= getResources().getString(R.string.url1);
        String urlrequest =url+ "technician/check_device.php";
        StringRequest request = new StringRequest(Request.Method.POST, urlrequest,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(select_reported_requests.this, response, Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(qrscanner.this);

                // Set the message show for the Alert time
                builder.setMessage(response);

                // Set Alert Title
                builder.setTitle("Device status result");

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);

                // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setPositiveButton("Cancel", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // When the user click yes button then app will close

                    //   startActivity(new Intent(getApplicationContext(), Logout.class));

                });

                builder.show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(qrscanner.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        ){ @Override
        protected Map<String, String> getParams() throws AuthFailureError {

            Map<String,String> params = new HashMap<String,String>();

            bundle1 = getIntent().getExtras();
            idd=bundle1.getString("client_id");
            params.put("wuid",idd);
            params.put("serial",serial.toLowerCase(Locale.ROOT));
            params.put("qrdata",qrdata.toLowerCase(Locale.ROOT));
            return params;
        }};


        RequestQueue requestQueue = Volley.newRequestQueue(qrscanner.this);
        requestQueue.add(request);



    }



















}

