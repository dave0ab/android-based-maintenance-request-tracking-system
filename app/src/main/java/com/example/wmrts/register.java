package com.example.wmrts;




import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;

import android.text.InputFilter;
import android.util.Base64;
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

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.wmrts.maintenancetechnician.tech_change_password;

import org.apache.commons.lang3.RandomStringUtils;

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

public class register extends AppCompatActivity {

    Button GetImageFromGalleryButton, UploadImageOnServerButton;
ImageView GetImageFromGalleryButton1;

    TextView check1; TextView check2;
    EditText imageName;

    Bitmap FixBitmap;
    Bitmap FixBitmap1;
    String pname ="name";
    String username ="username";

    String mobile = "mobile" ;

    String password = "password" ;
    String ImageTag = "image_tag" ;

    String ImageName = "image_data" ;

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
        setContentView(R.layout.activity_registration);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.trace);



        check1=findViewById(R.id.check);
        check2 =findViewById(R.id.pic);
        check1.setText("n");
        check2.setText("n");
        Spinner  spinner =findViewById(R.id.gender);
        Spinner  spinner1 =findViewById(R.id.technician);




        ArrayAdapter<CharSequence> adapter7=ArrayAdapter.createFromResource(this, R.array.department, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter7);




        GetImageFromGalleryButton = (Button)findViewById(R.id.upload);
        GetImageFromGalleryButton1 = findViewById(R.id.pp);
        UploadImageOnServerButton = (Button)findViewById(R.id.signup);

    //    ShowSelectedImage = (ImageView)findViewById(R.id.imageView);
               back=findViewById(R.id.AlreadyHavesignin);


        byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream1 = new ByteArrayOutputStream();
        GetImageFromGalleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showPictureDialog();


            }
        });

        GetImageFromGalleryButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showPictureDialog1();


            }
        });





back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(register.this, MainActivity.class);

        register.this.startActivity(myIntent);
    }
});





        UploadImageOnServerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

         //   EditText    oldpass= findViewById(R.id.old_password);
                EditText     newpass = findViewById(R.id.password);
                EditText     confirmpass = findViewById(R.id.confirm_password);

                if (!confirmpass.getText().toString().equals(newpass.getText().toString())){
                    Toast.makeText(register.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                }else {



                    String ch = check1.getText().toString();
                    String ch2 = check2.getText().toString();
                    if (ch.equals("n")) {

                        Toast.makeText(register.this, "Insert image", Toast.LENGTH_LONG).show();
                    } else {

                        EditText name1 = findViewById(R.id.fname);
                        EditText lname1 = findViewById(R.id.lname);
                        EditText username1 = findViewById(R.id.username);
                        EditText mobile1 = findViewById(R.id.mobile);
                        EditText email = findViewById(R.id.email);
                        Spinner job = findViewById(R.id.technician);
                        String job1 = String.valueOf(job.getSelectedItem());
                        EditText password1 = findViewById(R.id.password);
                        String n = name1.getText().toString();
                        String un = username1.getText().toString();
                        String mn = mobile1.getText().toString();
                        String pass = password1.getText().toString();
                        String emailcontain = email.getText().toString();
                        Spinner sp1 = (Spinner) findViewById(R.id.technician);
                        String result1 = String.valueOf(sp1.getSelectedItem());

                        if (name1.getText().toString().equals("")){

                            name1.setError("This field is required");
                            Toast.makeText(register.this, "Fill missing fields", Toast.LENGTH_SHORT).show();
                        }
                        else if( lname1.getText().toString().equals("") ){

                            lname1.setError("This field is required");
                            Toast.makeText(register.this, "Fill missing fields", Toast.LENGTH_SHORT).show();
                        }

                        else if( username1.getText().toString().equals("") ){

                            username1.setError("This field is required");
                            Toast.makeText(register.this, "Fill missing fields", Toast.LENGTH_SHORT).show();
                        }

                        else if(  pass.equals("") ){
                            password1.setError("This field is required");
                            Toast.makeText(register.this, "Fill missing fields", Toast.LENGTH_SHORT).show();
                        }
                        else if( pass.length()<8)

                        {
                            password1.setError("This field is required");
                            Toast.makeText(register.this, "Enter at least 8 character long password", Toast.LENGTH_SHORT).show();

                        }



                        else if( mobile1.getText().toString().equals(""))

                        {
                            mobile1.setError("This field is required");
                            Toast.makeText(register.this, "Fill missing fields", Toast.LENGTH_SHORT).show();

                        }
                        else if( mobile1.getText().toString().length()<9)

                        {
                            mobile1.setError("This field is required");
                            Toast.makeText(register.this, "Enter valid phone number", Toast.LENGTH_SHORT).show();

                        }
                        else if( email.getText().toString().equals(""))

                        {
                            email.setError("This field is required");
                            Toast.makeText(register.this, "Enter Email Address", Toast.LENGTH_SHORT).show();

                        }


                        else  if (!emailcontain.contains("@")) {


                                Toast.makeText(register.this, "Enter valid email address", Toast.LENGTH_SHORT).show();


                            }
                        else  if (!emailcontain.contains(".com")) {


                            Toast.makeText(register.this, "Enter valid email address", Toast.LENGTH_SHORT).show();


                        }
                        else if (job1.equals("Select job")) {

                                    Toast.makeText(register.this, "Select job", Toast.LENGTH_SHORT).show();

                                } else {

                                    UploadImageToServer();
                                    Intent myIntent = new Intent(register.this, MainActivity.class);

                                    register.this.startActivity(myIntent);
                                }


                    }
            }




            }


        });

        if (ContextCompat.checkSelfPermission(register.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
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
                    Toast.makeText(register.this, "Failed!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(register.this, "Failed!", Toast.LENGTH_SHORT).show();
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

                progressDialog = ProgressDialog.show(register.this,"Image is Uploading","Please Wait",false,false);
            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);

                progressDialog.dismiss();

                Toast.makeText(register.this,string1,Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(Void... params) {


                String randonString = RandomStringUtils.randomAlphanumeric(16);
                String randonString1 = RandomStringUtils.randomAlphanumeric(16);
                ImageProcessClass imageProcessClass = new ImageProcessClass();

                HashMap<String,String> HashMapParams = new HashMap<String,String>();



                EditText name1 = findViewById(R.id.fname);
                EditText lname = findViewById(R.id.lname);
                EditText email = findViewById(R.id.email);
                EditText username1 = findViewById(R.id.username);
                EditText mobile1 = findViewById(R.id.mobile);
                EditText password1 = findViewById(R.id.password);
                String n =name1.getText().toString();
                String un =username1.getText().toString();
                String mn =mobile1.getText().toString();


                String pass =password1.getText().toString();
                Spinner sp = (Spinner) findViewById(R.id.gender);

                Spinner sp1 = (Spinner) findViewById(R.id.technician);
                String result1 = String.valueOf(sp1.getSelectedItem());
                HashMapParams.put(pname, n);
                HashMapParams.put("lname", lname.getText().toString());
                HashMapParams.put("wuid", un);

                HashMapParams.put(mobile, "+251"+mn);
                HashMapParams.put("email", email.getText().toString());
                HashMapParams.put(password, pass);

                HashMapParams.put(ImageTag, randonString);
                HashMapParams.put("image_tag1", randonString1);
                HashMapParams.put(ImageName, ConvertImage);
                HashMapParams.put("job_title", result1);

                RadioGroup radioGroup = (RadioGroup) findViewById
                        (R.id.radid);
                   int selectedId = radioGroup.getCheckedRadioButtonId();
                                                              // find the radiobutton by returned id
                RadioButton radioButton = (RadioButton) findViewById (selectedId);


                String result = String.valueOf(radioButton.getText());





                HashMapParams.put("gender", result);
                HashMapParams.put(ImageName, ConvertImage);
                HashMapParams.put("image_data1", ConvertImage1);
                String url= getResources().getString(R.string.url1);
                String FinalData = imageProcessClass.ImageHttpRequest(url+"request_sender/request_sender_register.php", HashMapParams);

                return FinalData;
            }
        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();
        AsyncTaskUploadClassOBJ.execute();
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

                Toast.makeText(register.this, "Unable to use Camera..Please Allow us to use Camera", Toast.LENGTH_LONG).show();

            }
        }
    }


}
