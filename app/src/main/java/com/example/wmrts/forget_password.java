package com.example.wmrts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wmrts.Admin.Admin_change_password;

import java.util.HashMap;
import java.util.Map;

public class forget_password extends AppCompatActivity {
    EditText wuid;
    EditText email;
    ProgressDialog progressDialog ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.trace);

        email = findViewById(R.id.email);

        Button forget = findViewById(R.id.forget);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = email.getText().toString();

if (em.equals("")||!em.contains("@")){

    email.setError("This field is required");
    Toast.makeText(forget_password.this, "Email address", Toast.LENGTH_SHORT).show();

     }else
{

    progressDialog = ProgressDialog.show(forget_password.this,"Please wait a moment","Please Wait",false,false);

    insertData();


}


            }
        });









    }


    void insertData() {

        String url= getResources().getString(R.string.url1);
        String urlrequest =url+ "forget_password/forgot_password.php";
     //   wuid.getText().toString();
        email.getText().toString();

        StringRequest request = new StringRequest(Request.Method.POST,  urlrequest,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        AlertDialog.Builder builder = new AlertDialog.Builder(forget_password.this);



                        builder.setMessage(response);


                        AlertDialog alertDialog = builder.create();
                        builder.setNegativeButton("OK", (DialogInterface.OnClickListener) (dialog, which) -> {
                            // If user click no then dialog box is canceled.
                            dialog.cancel();
                        });
                        builder.show();
                        // Show the Alert Dialog box



                        try {
                            Thread.sleep(15000); // 15 seconds in milliseconds

                            progressDialog.dismiss();
                        } catch (InterruptedException e) {
                            // Handle the exception
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(forget_password.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
               // params.put("wuid", wuid.getText().toString());

                params.put("email", email.getText().toString());





                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(forget_password.this);
        requestQueue.add(request);

    }

}

